package com.tour.api.v1.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TourProgramV1 {
    @ApiModelProperty(notes = "키워드")
    private String keyword;

    @ApiModelProperty(notes = "프로그램정보")
    private TourProgramInfoV1 programs;
}
