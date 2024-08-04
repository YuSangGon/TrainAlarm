package project.trainalarm.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class SubwayArvlInfoDto {

    // 열차번호(현재운행하고 있는 호선별 열차번호)
    private Long btrainNo;

    // 지하철역명
    private String statnNm;

    //상하행선구분
    //0 : 상행/내선  1 : 하행/외선
    private Integer updnLine;

    // 열차도착예정시간 (단위:초)
    // 도착예정시간이 짧을 수록 먼저 오고 있는 열차임.
    private Integer barvlDt;

    // 열차종류 : 급행/ITX
    private String btrainSttus;

    // 도착지방면
    // ex. 성수행(목적지역) - 구로디지털단지방면(다음역)
    private String trainLineNm;

    // 첫번째도착메세지 (도착, 출발 , 진입 등)
    private String arvlMsg2;

    // 두번째도착메세지 (종합운동장 도착, 12분 후 (광명사거리) 등)
    private String arvlMsg3;

    // 도착코드
    // 0:진입, 1:도착, 2:출발, 3:전역출발, 4:전역진입, 5:전역도착, 99:운행중
    private Integer arvlCd;

    // 막차여부
    // 1:막차, 0:아님
    private Integer lstcarAt;

}
