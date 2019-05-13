package com.tour.api.v1.dto.response;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.tour.api.v1.dto.TourThemeV1;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
public class ApiThemeResponse {
    @ApiModelProperty(notes = "상태값")
    private final String status;

    @ApiModelProperty(notes = "상태메시지")
    private final String message;

    @JsonUnwrapped
    @ApiModelProperty(notes = "프로그램정보")
    private TourThemeV1 tourThemeV1;

    @Builder(builderMethodName = "of", buildMethodName = "create")
    public ApiThemeResponse(String status, String message, TourThemeV1 tourThemeV1) {
        this.status = status;
        this.message = message;
        this.tourThemeV1 = tourThemeV1;
    }
}
