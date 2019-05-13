package com.tour.repository.dto;

import com.tour.domain.tour.repository.dto.TourDetail;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TourDetailTest {

    TourDetail tourDetail;

    @Before
    public void setUp() {
        tourDetail = new TourDetail();
    }

    @Test
    public void 프로그램_상세소개_문자개수_조회() {
        String keyword = "문화";
        String detailString = "스쳐지나가는 여행이 아닌 몸과 마음으로 체험하는 문화 지리산의 태고적 자연생태, 인문지리, 역사문화를 알아가는 지리산생명 찾기 여행입니다.";
        tourDetail.setProgramDetail(detailString);
        Assert.assertEquals(1, tourDetail.findKeywordCount(keyword));
    }
}
