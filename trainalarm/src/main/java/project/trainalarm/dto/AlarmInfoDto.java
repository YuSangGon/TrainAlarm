package project.trainalarm.dto;

import lombok.Builder;
import lombok.Data;
import project.trainalarm.entity.AlarmInfo;

@Data
@Builder
public class AlarmInfoDto {

    private Long alarmInfoNo;

    private String targetAlarm;

    private Integer alarmPeriod;

    private String frequencyType;

    private String frequencyInfo;

    private Boolean holidayYn;

    public AlarmInfoDto entityToDto(AlarmInfo alarmInfo) {
        return AlarmInfoDto.builder()
                .alarmInfoNo(alarmInfo.getAlarmInfoNo())
                .targetAlarm(alarmInfo.getTargetAlarm())
                .alarmPeriod(alarmInfo.getAlarmPeriod())
                .frequencyType(alarmInfo.getFrequencyType())
                .frequencyInfo(alarmInfo.getFrequencyInfo())
                .holidayYn(alarmInfo.getHolidayYn())
                .build();
    }
}
