package project.trainalarm.dto;

import java.util.List;

public record ApiResponseDto(
        Status errorMessage,
        List<ArrivalInfo> realtimeArrivalList
) {
    public record Status(
            Integer status,
            String code,
            String message,
            String link,
            String developerMessage,
            Integer total
    ) {
    }

    public record ArrivalInfo(
            String subwayId,
            String updnLine,
            String trainLineNm,
            String statnFid,
            String statnTid,
            String statnId,
            String statnNm,
            String trnsitCo,
            String ordkey,
            String subwayList,
            String statnList,
            String btrainSttus,
            String barvlDt,
            String btrainNo,
            String bstatnId,
            String bstatnNm,
            String recptnDt,
            String arvlMsg2,
            String arvlMsg3,
            String arvlCd,
            String lstcarAt
    ) {
    }
}
