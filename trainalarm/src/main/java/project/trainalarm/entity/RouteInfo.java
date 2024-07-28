package project.trainalarm.entity;

import jakarta.persistence.*;
import lombok.*;
import project.trainalarm.dto.RouteInfoDto;

import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Entity
@Table(name = "ROUTE_INFO")
public class RouteInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROUTE_NO")
    private Long routeNo;

    @ManyToOne
    @JoinColumn(name = "ALARM_INFO_NO")
    private AlarmInfo alarmInfo;

    @Column(name = "SUBWAY_NAME")
    private String subwayName;

    @Column(name = "SUBWAY_LINE")
    private Integer subwayLine;

    @Column(name = "ROUTE_ORDER")
    private Integer routeOrder;

    @Column(name = "ARL_EXP_TIME")
    private LocalDate arlExpTime;

    public RouteInfo dtoToEntity(RouteInfoDto dto) {
        return RouteInfo.builder()
                .subwayName(dto.getSubwayName())
                .subwayLine(dto.getSubwayLine())
                .routeOrder(dto.getSubwayOrder())
                .arlExpTime(dto.getArlExpTime())
                .build();
    }

}
