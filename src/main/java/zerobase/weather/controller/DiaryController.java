package zerobase.weather.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import zerobase.weather.domain.Diary;
import zerobase.weather.service.DiaryService;

import java.time.LocalDate;
import java.util.List;

@RestController
@Tag(name = "Diary Controller", description = "날씨 일기 API Document")
public class DiaryController {
    private final DiaryService diaryService;

    public DiaryController (DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    @PostMapping("/create/diary")
    @Operation(summary = "일기 텍스트와 날짜를 이용해서 DB에 일기 저장")
    void createDiary(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @Parameter(description = "날씨 일기를 저장할 날짜", example = "2020-02-02") LocalDate date,
            @RequestBody @Schema(description = "일기 텍스트", example = "일기 내용") String text
    ) {
        diaryService.createDiary(date, text);
    }


    @GetMapping("/read/diary")
    @Operation(summary = "선택한 날짜의 모든 일기 데이터를 가져옵니다")
    List<Diary> readDiary(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @Parameter(description = "일기를 조회할 날짜", example = "2020-02-02") LocalDate date
    ) {
        return diaryService.readDiary(date);
    }

    @GetMapping("/read/diaries")
    @Operation(summary = "선택한 기간중의 모든 일기 데이터를 가져옵니다")
    List<Diary> readDiaries(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @Parameter(description = "조회할 기간의 첫째날", example = "2020-02-02") LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @Parameter(description = "조회할 기간의 마지막날", example = "2020-02-02") LocalDate endDate
    ) {
        return diaryService.readDiaries(startDate, endDate);
    }

    @PutMapping("/update/diary")
    @Operation(summary = "일기 텍스트와 날짜를 이용해서 DB에 해당 날짜의 첫번째 일기 수정")
    void updateDiary(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @Parameter(description = "날씨 일기를 수정할 날짜", example = "2020-02-02") LocalDate date,
            @RequestBody String text
    ) {
        diaryService.updateDiary(date, text);
    }

    @DeleteMapping("/delete/diary")
    @Operation(summary = "선택한 날짜의 모든 일기 삭제")
    void deleteDiary(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @Parameter(description = "날씨 일기를 삭제할 날짜", example = "2020-02-02") LocalDate date
    ) {
        diaryService.deleteDiary(date);
    }
}
