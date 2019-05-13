package com.tour.api.v1.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
public class ApiResponse {
    @ApiModelProperty(notes = "상태값")
    private final String status;

    @ApiModelProperty(notes = "상태메시지")
    private final String message;

    @Builder(builderMethodName = "of", buildMethodName = "create")
    public ApiResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }
}
