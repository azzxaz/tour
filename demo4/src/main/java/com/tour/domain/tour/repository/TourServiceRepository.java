package com.tour.domain.tour.repository;

import com.tour.api.v1.dto.TourV1;
import com.tour.domain.tour.repository.dto.*;

import java.util.List;

public interface TourServiceRepository {
    List<TourThemeList> getThemeList(String serviceAreaName);
    TourProgramInfo getProgramInfo(String programTitle);
    List<TourDetail> getProgramDetailKeywordList();
    void insertTheme(TourV1 tourV1);
    void updateTheme(TourV1 tourV1);
}
