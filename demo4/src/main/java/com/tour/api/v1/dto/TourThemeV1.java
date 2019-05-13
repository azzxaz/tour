package com.tour.api.v1.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class TourThemeV1 {
    @ApiModelProperty(notes = "지역정보 코드")
    private String region;

    @ApiModelProperty(notes = "프로그램 리스트 정보")
    private List<TourThemeListV1> programs;
}
