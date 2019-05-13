package com.tour.api.v1.converter;

import com.google.gson.Gson;
import com.tour.api.v1.dto.*;
import com.tour.domain.tour.repository.dto.TourProgramInfo;
import com.tour.domain.tour.repository.dto.TourThemeList;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

public class TourConverter {
    public static TourThemeV1 getTourTheme(List<TourThemeList> tourThemeLists) {
        if(CollectionUtils.isEmpty(tourThemeLists))
            return new TourThemeV1();

        TourThemeV1 tourThemeV1 = new TourThemeV1();
        tourThemeV1.setRegion(tourThemeLists.get(0).getServiceCode());
        tourThemeV1.setPrograms(new ArrayList(tourThemeLists));
        return tourThemeV1;
    }

    public static TourProgramV1 getTourProgramV1(String programTitle, TourProgramInfo tourProgramInfo) {
        TourProgramV1 tourProgramV1 = new TourProgramV1();
        tourProgramV1.setKeyword(programTitle);

        TourProgramInfoV1 tourProgramInfoV1 = new TourProgramInfoV1();
        tourProgramInfoV1.setCount(tourProgramInfo.getCount());
        tourProgramInfoV1.setRegion(tourProgramInfo.getRegion());

        tourProgramV1.setPrograms(tourProgramInfoV1);
        return tourProgramV1;
    }

    public static KeywordV1 getKeywordV1(String keyword, long findKeywordSum) {
        KeywordV1 keywordV1 = new KeywordV1();
        keywordV1.setCount(findKeywordSum);
        keywordV1.setKeyword(keyword);
        return keywordV1;
    }

    public static TourV1 getTourInfo(@RequestBody String themeJson) {
        Gson gson = new Gson();
        return gson.fromJson(themeJson, TourV1.class);
    }
}
