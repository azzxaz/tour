package com.tour.api.v1.dto;

import com.tour.api.v1.dto.response.*;

public class ApiResponseV1 {

    private final static String SUCCESS_STATUS = "200";
    private final static String FAIL_STATUS = "500";
    private final static String SUCCESS_MESSAGE = "success";

    public final static String FAIL_PROGRAM_NO_OMITTED_MESSAGE = "프로그램 번호가 잘못되었습니다. 다시한번 확인해주세요.";
    public final static String FAIL_SERVICE_AREA_OMITTED_MESSAGE = "필수 데이터가 누락되었습니다.[프로그램명, 서비스지역] 다시한번 확인해주세요.";

    public static ApiProgramResponse tourProgram(TourProgramV1 tourProgramV1) {
        return ApiProgramResponse.of().status(SUCCESS_STATUS).message(SUCCESS_MESSAGE).tourProgramV1(tourProgramV1).create();
    }

    public static ApiThemeResponse tourTheme(TourThemeV1 tourThemeV1) {
        return ApiThemeResponse.of().status(SUCCESS_STATUS).message(SUCCESS_MESSAGE).tourThemeV1(tourThemeV1).create();
    }

    public static ApiKeywordResponse keyword(KeywordV1 keywordV1) {
        return ApiKeywordResponse.of().status(SUCCESS_STATUS).message(SUCCESS_MESSAGE).keywordV1(keywordV1).create();
    }

    public static ApiResponse success() {
        return ApiResponse.of().status(SUCCESS_STATUS).message(SUCCESS_MESSAGE).create();
    }

    public static ApiResponse fail(String message) {
        return ApiResponse.of().status(FAIL_STATUS).message(message).create();
    }
}
