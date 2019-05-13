package com.tour.api.v1.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TourProgramInfoV1 {
    @ApiModelProperty(notes = "서비스지역")
    private String region;

    @ApiModelProperty(notes = "프로그램 지역정보 조회수")
    private long count;
}
