package com.tour.domain.tour;

import lombok.Getter;

import java.util.Arrays;

public enum TourDtoTypes {
    NONE("", "", false)
    , NO("01", "번호", false)
    , PROGRAM_NAME("02", "프로그램명", true)
    , THEME("03", "테마", false)
    , SERVICE_CODE("04", "지역코드", false)
    , SERVICE_AREA("05", "서비스 지역", true)
    , PROGRAM_TITLE("06", "프로그램 소개", false)
    , PROGRAM_DETAIL("07", "프로그램 상세 소개", false)
    ;

    @Getter
    private final String code;

    @Getter
    private final String codeName;

    @Getter
    private final boolean essential;

    TourDtoTypes(String code, String codeName, boolean essential) {
        this.code = code;
        this.codeName = codeName;
        this.essential = essential;
    }

    public static TourDtoTypes get(String code) {
        return Arrays.stream(values())
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElse(NONE);
    }
}
