package com.tour.api.v1.dto.response;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.tour.api.v1.dto.KeywordV1;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
public class ApiKeywordResponse {
    @ApiModelProperty(notes = "상태값")
    private final String status;

    @ApiModelProperty(notes = "상태메시지")
    private final String message;

    @JsonUnwrapped
    @ApiModelProperty(notes = "프로그램정보")
    private KeywordV1 keywordV1;

    @Builder(builderMethodName = "of", buildMethodName = "create")
    public ApiKeywordResponse(String status, String message, KeywordV1 keywordV1) {
        this.status = status;
        this.message = message;
        this.keywordV1 = keywordV1;
    }
}
