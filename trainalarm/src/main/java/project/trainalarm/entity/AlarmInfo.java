package project.trainalarm.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "ALARM_INFO")
public class AlarmInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long alarmInfoNo;

    @Column(name = "TARGET_ALARM")
    private String targetAlarm;

    @Column(name = "ALARM_PERIOD")
    private Integer alarmPeriod;
}
