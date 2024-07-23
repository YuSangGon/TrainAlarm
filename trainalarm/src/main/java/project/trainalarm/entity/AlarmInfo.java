package project.trainalarm.entity;

import jakarta.persistence.*;
import lombok.*;
import project.trainalarm.dto.AlarmInfoDto;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Entity
@Table(name = "ALARM_INFO")
public class AlarmInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ALARM_INFO_NO")
    private Long alarmInfoNo;

    @Column(name = "TARGET_ALARM")
    private String targetAlarm;

    @Column(name = "ALARM_PERIOD")
    private Integer alarmPeriod;

    @Column(name = "FREQUENCY_TYPE")
    private String frequencyType;

    @Column(name = "FREQUENCY_INFO")
    private String frequencyInfo;

    @Column(name = "HOLIDAY_YN")
    private Boolean holidayYn;

    @OneToMany
    @JoinColumn(name = "ALARM_INFO_NO")
    private List<TrainRoute> trainRoutes = new ArrayList<>();

    public AlarmInfo dtoToEntity(AlarmInfoDto dto) {
        return AlarmInfo.builder()
                .targetAlarm(dto.getTargetAlarm())
                .alarmPeriod(dto.getAlarmPeriod())
                .frequencyType(dto.getFrequencyType())
                .frequencyInfo(dto.getFrequencyInfo())
                .holidayYn(dto.getHolidayYn())
                .build();
    }

}

