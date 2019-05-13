package com.tour.api.v1.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class TourV1 {
    @ApiModelProperty(notes = "번호")
    private long programNo;

    @ApiModelProperty(notes = "프로그램명")
    private String programName;

    @ApiModelProperty(notes = "테마")
    private String theme;

    @ApiModelProperty(notes = "지역코드")
    private String serviceCode;

    @ApiModelProperty(notes = "서비스 지역")
    private String serviceArea;

    @ApiModelProperty(notes = "프로그램 소개")
    private String programTitle;

    @ApiModelProperty(notes = "프로그램 상세 소개")
    private String programDetail;

    public boolean isUseProgramNo() {
        return this.programNo > 0;
    }

    public boolean isEssentialData() {
        return checkEssentialProgramNm() && checkEssentialServiceArea();
    }

    public boolean checkEssentialProgramNm() {
        return StringUtils.isNotEmpty(this.programName);
    }

    public boolean checkEssentialServiceArea() {
        return StringUtils.isNotEmpty(this.serviceArea);
    }
}
