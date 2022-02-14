package com.inhabas.api.service.board;

import com.inhabas.api.dto.board.ParentBoardDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardService <T1, T2, T3, T4 extends ParentBoardDto> {
    Integer write(T1 saveBoardDto);

    Integer update(T2 updateBoardDto);

    void delete(Integer boardId);

    T3 getBoard(Integer boardId);

    Page<T4> getBoardList(Integer menuId, Pageable pageable);

}
