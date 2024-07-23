package project.trainalarm.entity;

import jakarta.persistence.*;
import lombok.*;
import project.trainalarm.dto.TrainRouteDto;

import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Entity
@Table(name = "TRAIN_ROUTE")
public class TrainRoute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRAIN_NO")
    private Long trainNo;

    @ManyToOne
    @JoinColumn(name = "ALARM_INFO_NO")
    private AlarmInfo alarmInfo;

    @Column(name = "TRAIN_NAME")
    private String trainName;

    @Column(name = "TRAIN_LINE")
    private Integer trainLine;

    @Column(name = "TRAIN_ORDER")
    private Integer trainOrder;

    @Column(name = "TRAIN_TIME")
    private LocalDate trainTime;

    public TrainRoute dtoToEntity(TrainRouteDto dto) {
        return TrainRoute.builder()
                .trainName(dto.getTrainName())
                .trainLine(dto.getTrainLine())
                .trainOrder(dto.getTrainOrder())
                .trainTime(dto.getTrainTime())
                .build();
    }

}
