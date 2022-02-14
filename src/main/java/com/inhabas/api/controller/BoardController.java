package com.inhabas.api.controller;

import com.inhabas.api.dto.board.BoardDto;
import com.inhabas.api.dto.board.SaveBoardDto;
import com.inhabas.api.dto.board.UpdateBoardDto;
import com.inhabas.api.mapper.Mapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Slf4j
@Tag(name = "Board")
@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final Mapper mapper;

    @Operation(description = "게시글 조회")
    @GetMapping
    public Object getBoard(@RequestParam Integer menuId, @RequestParam Integer id) {
        return mapper.findBoardServiceByMenuId(menuId).getBoard(id);
    }

    @Operation(description = "모든 게시글 조회")
    @GetMapping("/all")
    public Page<Object> getBoardList(Pageable pageable, @RequestParam Integer menuId ) {
        return mapper.findBoardServiceByMenuId(menuId).getBoardList(menuId, pageable);
    }

    @Operation(description = "게시글 추가")
    @PostMapping
    public Integer addBoard(@Valid @RequestBody SaveBoardDto saveBoardDto) {
        return mapper.findBoardServiceByMenuId(saveBoardDto.getMenuId()).write(saveBoardDto);
    }

    @Operation(description = "게시글 수정")
    @PutMapping
    public Integer updateBoard(@Valid @RequestBody UpdateBoardDto updateBoardDto) {
        return mapper.findBoardServiceByMenuId(updateBoardDto.getMenuId()).update(updateBoardDto);
    }

    @Operation(description = "게시글 삭제")
    @DeleteMapping
    public void deleteBoard(@RequestParam Integer menuId, @RequestParam Integer id) {
        mapper.findBoardServiceByMenuId(menuId).delete(id);
    }
}
