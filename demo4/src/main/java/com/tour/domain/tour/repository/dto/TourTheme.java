package com.tour.domain.tour.repository.dto;

import lombok.Data;

import java.util.List;

@Data
public class TourTheme {
    private String region;
    private List<TourThemeList> programs;
}
