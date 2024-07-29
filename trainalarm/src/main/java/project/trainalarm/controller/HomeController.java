package project.trainalarm.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import project.trainalarm.api.ApiService;
import project.trainalarm.dto.ApiResponseDto;

@RestController
@RequiredArgsConstructor
@Slf4j
public class HomeController {

    private final ApiService apiService;

    @GetMapping("/")
    public String home() {
        ApiResponseDto result = apiService.getSubwayInfo();
        if (result == null) log.error("No response received or response body is empty");

        return "ok";
    }

}
