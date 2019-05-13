package com.tour.infra.mybatis.repository;

import com.tour.api.v1.dto.TourV1;
import com.tour.domain.tour.repository.dto.TourDetail;
import com.tour.domain.tour.repository.dto.TourProgramInfo;
import com.tour.domain.tour.repository.dto.TourThemeList;
import com.tour.infra.mybatis.mapper.TourMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class TourQueryRepository {
    private final TourMapper tourMapper;

    public List<TourThemeList> getThemeList(String serviceAreaName) {
        return tourMapper.getThemeList(serviceAreaName);
    }

    public TourProgramInfo getProgramInfo(String programTitle) {
        return tourMapper.getProgramInfo(programTitle);
    }

    public List<TourDetail> getProgramDetailKeywordList() {
        return tourMapper.getProgramDetailKeywordList();
    }

    public void insertTheme(TourV1 tourV1) {
        tourMapper.insertTheme(tourV1);
    }

    public void updateTheme(TourV1 tourV1) {
        tourMapper.updateTheme(tourV1);
    }
}
