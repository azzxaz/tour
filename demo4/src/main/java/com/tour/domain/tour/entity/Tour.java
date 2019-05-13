package com.tour.domain.tour.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Clob;

@Entity
@Table(name="TOUR")
public class Tour {

    @Id
    @Column(name="PROGRAM_NO")
    private long programNo;

    @Column(name="PROGRAM_NAME")
    private String programName;

    @Column(name="THEME")
    private String theme;

    @Column(name="SERVICE_CODE")
    private String serviceCode;

    @Column(name="SERVICE_AREA")
    private String serviceArea;

    @Column(name="PROGRAM_TITLE")
    private String programTitle;

    @Column(name="PROGRAM_DETAIL")
    private Clob programDetail;
}
