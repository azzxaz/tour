package com.tour.api.v1.dto.response;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.tour.api.v1.dto.TourProgramV1;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
public class ApiProgramResponse {
    @ApiModelProperty(notes = "상태값")
    private final String status;

    @ApiModelProperty(notes = "상태메시지")
    private final String message;

    @JsonUnwrapped
    @ApiModelProperty(notes = "프로그램정보")
    private TourProgramV1 tourProgramV1;

    @Builder(builderMethodName = "of", buildMethodName = "create")
    public ApiProgramResponse(String status, String message, TourProgramV1 tourProgramV1) {
        this.status = status;
        this.message = message;
        this.tourProgramV1 = tourProgramV1;
    }
}
