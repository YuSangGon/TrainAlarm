package project.trainalarm.dto;

import lombok.Data;

@Data
public class ApiStatusDto {
    private Integer status;
    private String code;
    private String message;
    private String link;
    private String developerMessage;
    private Integer total;
}
