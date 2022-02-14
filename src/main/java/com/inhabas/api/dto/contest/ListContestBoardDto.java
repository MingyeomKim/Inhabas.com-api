package com.inhabas.api.dto.contest;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.inhabas.api.dto.board.ParentBoardDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class ListContestBoardDto extends ParentBoardDto {
    private String title;
    private String topic;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private LocalDate start;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private LocalDate deadline;
}
