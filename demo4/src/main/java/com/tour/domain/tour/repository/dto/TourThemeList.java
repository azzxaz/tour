package com.tour.domain.tour.repository.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class TourThemeList {
    private String prgm_name;
    private String theme;
    @JsonIgnore
    private String serviceCode;
}
