package project.trainalarm.api;

import com.sun.net.httpserver.HttpsServer;
import io.netty.handler.codec.http.HttpScheme;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import project.trainalarm.dto.ApiResponseDto;
import project.trainalarm.dto.SubwayArvlInfoDto;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
@Slf4j
@RequiredArgsConstructor
public class ApiService {

    @Value("${api.train.key}")
    private String apiKey;

    private static final String REQUEST_HOST = "swopenAPI.seoul.go.kr";
    private static final String REQUEST_PATH = "/api/subway/{KEY}/{TYPE}/realtimeStationArrival/ALL";
    private static final String TYPE = "json";

    private final WebClient webClient;

    public ApiResponseDto getSubwayInfo() {
        return webClient.get()
                .uri(
                        UriComponentsBuilder.newInstance()
                                .scheme(HttpScheme.HTTP.toString())
                                .host(REQUEST_HOST)
                                .path(REQUEST_PATH)
                                .build(apiKey, TYPE)
                                .toString()
                )
                .exchangeToMono(response -> {
                    if (response.statusCode().is3xxRedirection()) {
                        return response.headers().asHttpHeaders().getLocation() != null ?
                                webClient.get().uri(response.headers().asHttpHeaders().getLocation().toString())
                                        .retrieve()
                                        .bodyToMono(ApiResponseDto.class)
                                :
                                Mono.error(new RuntimeException("Redirection location is null"));
                    } else {
                        return response.bodyToMono(ApiResponseDto.class);
                    }
                })
                .onErrorResume(error -> {
                    log.error("Error: {}", error.getMessage());
                    return Mono.empty();
                })
                .block();
    }

}
