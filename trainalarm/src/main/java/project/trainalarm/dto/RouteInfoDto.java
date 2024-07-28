package project.trainalarm.dto;

import lombok.Builder;
import lombok.Data;
import project.trainalarm.entity.AlarmInfo;
import project.trainalarm.entity.RouteInfo;

import java.time.LocalDate;

@Data
@Builder
public class RouteInfoDto {

    private Long routeNo;

    private String subwayName;

    private Integer subwayLine;

    private Integer subwayOrder;

    private LocalDate arlExpTime;

    public RouteInfoDto entityToDto(RouteInfo routeInfo) {
        return RouteInfoDto.builder()
                .routeNo(routeInfo.getRouteNo())
                .subwayName(routeInfo.getSubwayName())
                .subwayLine(routeInfo.getSubwayLine())
                .subwayOrder(routeInfo.getRouteOrder())
                .arlExpTime(routeInfo.getArlExpTime())
                .build();
    }
}
