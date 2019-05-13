package com.tour.domain.tour.repository.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TourInfo {
    @ApiModelProperty(notes = "번호")
    private long programNo;

    @ApiModelProperty(notes = "프로그램명")
    private String programName;

    @ApiModelProperty(notes = "테마별 분류")
    private String theme;

    @ApiModelProperty(notes = "서비스 지역")
    private String serviceArea;

    @ApiModelProperty(notes = "프로그램 소개")
    private String programTitle;

    @ApiModelProperty(notes = "프로그램 상세 소개")
    private String programDetail;
}
