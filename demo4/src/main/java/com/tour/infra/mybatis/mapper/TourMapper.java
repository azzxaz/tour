package com.tour.infra.mybatis.mapper;

import com.tour.domain.tour.repository.dto.*;
import com.tour.api.v1.dto.TourV1;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TourMapper {
    List<TourThemeList> getThemeList(String serviceAreaName);
    TourProgramInfo getProgramInfo(String programTitle);
    List<TourDetail> getProgramDetailKeywordList();
    void insertTheme(TourV1 tourV1);
    void updateTheme(TourV1 tourV1);
}
