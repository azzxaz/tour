package com.tour.domain.tour.repository;

import com.tour.api.v1.dto.TourV1;
import com.tour.domain.tour.repository.dto.TourDetail;
import com.tour.domain.tour.repository.dto.TourProgramInfo;
import com.tour.domain.tour.repository.dto.TourThemeList;
import com.tour.infra.mybatis.repository.TourQueryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class TourServiceRepositoryImpl implements TourServiceRepository {

    private final TourQueryRepository tourQueryRepository;

    @Override
    public List<TourThemeList> getThemeList(String serviceAreaName) {
        return tourQueryRepository.getThemeList(serviceAreaName);
    }

    @Override
    public TourProgramInfo getProgramInfo(String programTitle) {
        return tourQueryRepository.getProgramInfo(programTitle);
    }

    @Override
    public List<TourDetail> getProgramDetailKeywordList() {
        return tourQueryRepository.getProgramDetailKeywordList();
    }

    @Override
    public void insertTheme(TourV1 tourV1) {
        tourQueryRepository.insertTheme(tourV1);
    }

    @Override
    public void updateTheme(TourV1 tourV1) {
        tourQueryRepository.updateTheme(tourV1);
    }
}
