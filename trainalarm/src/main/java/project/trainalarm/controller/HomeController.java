package project.trainalarm.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import project.trainalarm.api.ApiService;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.LocalTime;

@Controller
@RequiredArgsConstructor
@Slf4j
public class HomeController {

    private final ApiService apiService;

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping(value = "/sse", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseBody
    public Flux<String> streamEvents(@RequestParam("stationName") String stationName) {
        log.info("stationName: {}", stationName);
//        return Flux.interval(Duration.ofSeconds(1)).map(sequence -> "data: " + apiService.getSubwayInfo().getRealtimeArrivalList().size() + "\n\n");
        return Flux.interval(Duration.ofSeconds(1))
                .map(sequence -> "data: " + LocalTime.now().toString() + "\n\n");
    }
}
