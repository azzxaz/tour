package com.tour.domain.tour.service;

import com.tour.api.v1.dto.TourV1;
import com.tour.domain.tour.repository.TourServiceRepository;
import com.tour.domain.tour.repository.dto.TourDetail;
import com.tour.domain.tour.repository.dto.TourProgramInfo;
import com.tour.domain.tour.repository.dto.TourThemeList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TourService {
    private final TourServiceRepository tourServiceRepository;

    public List<TourThemeList> getThemeList(String serviceAreaName) {
        return tourServiceRepository.getThemeList(serviceAreaName);
    }

    public TourProgramInfo getProgramInfo(String programTitle) {
        return tourServiceRepository.getProgramInfo(programTitle);
    }

    public List<TourDetail> getProgramDetailKeywordList() {
        return tourServiceRepository.getProgramDetailKeywordList();
    }

    public void insertTheme(TourV1 tourV1) {
        tourServiceRepository.insertTheme(tourV1);
    }

    public void updateTheme(TourV1 tourV1) {
        tourServiceRepository.updateTheme(tourV1);
    }
}
