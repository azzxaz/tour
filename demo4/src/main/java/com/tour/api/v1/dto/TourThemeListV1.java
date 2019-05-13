package com.tour.api.v1.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TourThemeListV1 {
    @ApiModelProperty(notes = "프로그램명")
    private String prgm_name;

    @ApiModelProperty(notes = "테마명")
    private String theme;
}
