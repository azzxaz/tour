package com.tour.api;

import com.tour.api.v1.converter.TourConverter;
import com.tour.api.v1.dto.ApiResponseV1;
import com.tour.api.v1.dto.TourProgramV1;
import com.tour.api.v1.dto.TourThemeV1;
import com.tour.api.v1.dto.TourV1;
import com.tour.api.v1.dto.response.ApiKeywordResponse;
import com.tour.api.v1.dto.response.ApiProgramResponse;
import com.tour.api.v1.dto.response.ApiResponse;
import com.tour.api.v1.dto.response.ApiThemeResponse;
import com.tour.domain.tour.service.TourService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/program")
@Api(value = "/program", description = "프로그램 정보 조회 및 수정", tags = {"프로그램 정보 조회 및 수정"})
public class TourController {

    private final TourService tourService;

    @GetMapping("/theme/{serviceAreaName}")
    @ApiOperation(value = "프로그램 정보 및 테마 리스트 조회", notes = "프로그램 정보 및 테마 리스트 조회")
    public ApiThemeResponse getThemeList(@PathVariable("serviceAreaName") String serviceAreaName) {
        TourThemeV1 tourThemeV1 = TourConverter.getTourTheme(tourService.getThemeList(serviceAreaName));
        return ApiResponseV1.tourTheme(tourThemeV1);
    }

    @GetMapping("/info/{programTitle}")
    @ApiOperation(value = "프로그램 소개 리스트 조회", notes = "프로그램 소개 리스트 조회")
    public ApiProgramResponse getProgramList(@PathVariable("programTitle") String programTitle) {
        TourProgramV1 tourProgramV1 = TourConverter.getTourProgramV1(programTitle, tourService.getProgramInfo(programTitle));
        return ApiResponseV1.tourProgram(tourProgramV1);
    }

    @GetMapping("/keyword-count/{keyword}")
    @ApiOperation(value = "프로그램 상세소개 문자개수 조회", notes = "프로그램 상세소개 문자개수 조회")
    public ApiKeywordResponse getProgramDetailKeywordCnt(@PathVariable("keyword") String keyword) {
        long findKeywordSum = tourService.getProgramDetailKeywordList()
                .stream()
                .filter(tourDetail -> Optional.ofNullable(tourDetail).isPresent())
                .map(tourDetail -> tourDetail.findKeywordCount(keyword))
                .filter(cnt -> cnt > 0)
                .mapToLong(l -> l)
                .sum();

        return ApiResponseV1.keyword(TourConverter.getKeywordV1(keyword, findKeywordSum));
    }

    @PostMapping("/theme")
    @ApiOperation(value = "프로그램 정보 및 테마 등록", notes = "프로그램 정보 및 테마 등록")
    public ApiResponse saveTheme(@RequestBody String themeJson) {
        TourV1 tourV1 = TourConverter.getTourInfo(themeJson);
        tourService.insertTheme(tourV1);
        return ApiResponseV1.success();
    }

    @PutMapping("/theme/{programNo}")
    @ApiOperation(value = "프로그램 정보 및 테마 수정", notes = "프로그램 정보 및 테마 수정")
    public ApiResponse updateTheme(@PathVariable("programNo") long programNo, @RequestBody String themeJson) {
        TourV1 tourV1 = TourConverter.getTourInfo(themeJson);
        tourV1.setProgramNo(programNo);
        if(!tourV1.isUseProgramNo()) {
            return ApiResponseV1.fail(ApiResponseV1.FAIL_PROGRAM_NO_OMITTED_MESSAGE);
        }

        if(!tourV1.isEssentialData()) {
            return ApiResponseV1.fail(ApiResponseV1.FAIL_SERVICE_AREA_OMITTED_MESSAGE);
        }

        tourService.updateTheme(tourV1);
        return ApiResponseV1.success();
    }
}
