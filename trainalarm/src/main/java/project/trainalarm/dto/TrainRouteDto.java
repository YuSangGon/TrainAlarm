package project.trainalarm.dto;

import lombok.Builder;
import lombok.Data;
import project.trainalarm.entity.AlarmInfo;
import project.trainalarm.entity.TrainRoute;

import java.time.LocalDate;

@Data
@Builder
public class TrainRouteDto {

    private Long trainNo;

    private AlarmInfo alarmInfo;

    private String trainName;

    private Integer trainLine;

    private Integer trainOrder;

    private LocalDate trainTime;

    public TrainRouteDto entityToDto(TrainRoute trainRoute) {
        return TrainRouteDto.builder()
                .trainNo(trainRoute.getTrainNo())
                .trainName(trainRoute.getTrainName())
                .trainLine(trainRoute.getTrainLine())
                .trainOrder(trainRoute.getTrainOrder())
                .trainTime(trainRoute.getTrainTime())
                .build();
    }
}
