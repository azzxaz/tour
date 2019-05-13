package com.tour.domain.tour.repository.dto;

import lombok.Data;

import java.util.Arrays;

@Data
public class TourDetail {

    private String programDetail = "";

    public String getProgramDetail() {
        return this.programDetail == null ? "" : this.programDetail;
    }

    private String[] getSplit() {
        return this.getProgramDetail().split(" ");
    }

    public long findKeywordCount(String keyword) {
        return Arrays.stream(getSplit()).filter(str -> keyword.equals(str)).count();
    }
}
