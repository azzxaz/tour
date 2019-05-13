package com.tour.service;

import com.tour.api.v1.dto.TourV1;
import com.tour.domain.tour.repository.TourServiceRepository;
import com.tour.domain.tour.repository.dto.TourProgramInfo;
import com.tour.domain.tour.repository.dto.TourThemeList;
import com.tour.domain.tour.service.TourService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TourServiceTest {

    @Autowired
    private TourService tourService;

    @Autowired
    private TourServiceRepository tourServiceRepository;

    private TourV1 tourV1 = getTourV1();

    @Before
    public void setup() {
        tourServiceRepository.insertTheme(tourV1);

        tourV1.setProgramNo(1);
        tourV1.setProgramTitle("seoul tour");
        tourV1.setServiceArea("seoul");
        tourServiceRepository.updateTheme(tourV1);
    }

    @Test
    public void 테마_조회() {
        List<TourThemeList> tourThemeLists = tourService.getThemeList(tourV1.getServiceArea());
        assertThat(tourThemeLists).isNotNull();
        assertThat(tourThemeLists.size()).isEqualTo(1);
    }

    @Test
    public void 프로그램_조회() {
        tourV1.setProgramTitle("title");
        TourProgramInfo tourProgramInfo = tourService.getProgramInfo(tourV1.getProgramTitle());
        assertThat(tourProgramInfo).isNotNull();
        assertThat(tourProgramInfo.getCount()).isGreaterThan(1);
    }

    public TourV1 getTourV1() {
        TourV1 tourV1 = new TourV1();
        tourV1.setProgramName("test program");
        tourV1.setServiceArea("test service area");
        tourV1.setProgramTitle("test title");
        tourV1.setTheme("test theme");
        tourV1.setProgramDetail("test program detail");
        return tourV1;
    }
}
