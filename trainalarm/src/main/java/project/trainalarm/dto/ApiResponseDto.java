package project.trainalarm.dto;

import lombok.Data;

import java.util.List;

@Data
public class ApiResponseDto {
    private ApiStatusDto errorMessage;
    private List<SubwayArvlInfoDto> realtimeArrivalList;
}