package com.tour.api.v1.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class KeywordV1 {
    @ApiModelProperty(notes = "키워드")
    private String keyword;

    @ApiModelProperty(notes = "키워드 조회 개수")
    private long count;
}
