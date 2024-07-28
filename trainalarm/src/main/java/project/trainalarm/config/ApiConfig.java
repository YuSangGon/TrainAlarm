package project.trainalarm.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;
import project.trainalarm.dto.ApiResponseDto;
import reactor.core.publisher.Mono;

import java.util.List;

@Configuration
@Slf4j
public class ApiConfig {

    @Bean
    DefaultUriBuilderFactory builderFactory() {
        DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory();
        factory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.VALUES_ONLY);
        return factory;
    }

    @Bean
    WebClient webClient() {
        return WebClient.builder()
                .uriBuilderFactory(builderFactory())
                .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(16 * 1024 * 1024)) // 16MB로 설정
                //.filter(redirectFilter())
                .filter(logRequest())
                .filter(logResponse())
                .build();
    }

    private ExchangeFilterFunction logRequest() {
        return ExchangeFilterFunction.ofRequestProcessor(clientRequest -> {
            log.info("Request: {} {}", clientRequest.method(), clientRequest.url());
            return Mono.just(clientRequest);
        });
    }

    private ExchangeFilterFunction logResponse() {
        return ExchangeFilterFunction.ofResponseProcessor(clientResponse -> {
            log.info("Response status code: {}", clientResponse.statusCode());
            return Mono.just(clientResponse);
        });
    }

//    private ExchangeFilterFunction redirectFilter() {
//        return ExchangeFilterFunction.ofResponseProcessor(clientResponse -> {
//            if (clientResponse.statusCode().is3xxRedirection()) {
//                String redirectUri = clientResponse.headers().asHttpHeaders().getLocation().toString();
//                return WebClient.builder()
//                        .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(16 * 1024 * 1024))
//                        .build().get().uri(redirectUri)
//                        .exchangeToMono(response -> {
//                            System.out.println("Redirected Response status code: " + response.statusCode());
//                            return response.bodyToMono(ApiResponseDto.class)
//                                    .flatMap(body -> {
//                                        System.out.println("Redirected Response body: " + body);
//                                        return Mono.just(clientResponse.mutate().body(String.valueOf(body)).build());
//                                    });
//                        });
//            } else {
//                return Mono.just(clientResponse);
//            }
//        });
//    }
}
