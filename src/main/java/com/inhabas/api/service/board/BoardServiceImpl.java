package com.inhabas.api.service.board;

import com.inhabas.api.domain.board.NormalBoard;
import com.inhabas.api.domain.board.NormalBoardRepository;
import com.inhabas.api.domain.member.Member;
import com.inhabas.api.domain.member.MemberRepository;
import com.inhabas.api.domain.menu.Menu;
import com.inhabas.api.domain.menu.MenuRepository;
import com.inhabas.api.dto.board.BoardDto;

import com.inhabas.api.dto.board.SaveBoardDto;
import com.inhabas.api.dto.board.UpdateBoardDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final NormalBoardRepository boardRepository;
    private final MenuRepository menuRepository;
    private final MemberRepository memberRepository;

    @Override
    public Integer write(Integer userId, SaveBoardDto saveBoardDto) {
        Menu menu = menuRepository.getById(saveBoardDto.getMenuId());
        Member writer = memberRepository.getById(userId);
        NormalBoard normalBoard = new NormalBoard(saveBoardDto.getTitle(), saveBoardDto.getContents())
                .inMenu(menu)
                .writtenBy(writer);
        return boardRepository.save(normalBoard).getId();
    }

    @Override
    public Integer update(Integer userId, UpdateBoardDto updateBoardDto) {
        Member writer = memberRepository.getById(userId);
        NormalBoard entity = new NormalBoard(updateBoardDto.getId(), updateBoardDto.getTitle(), updateBoardDto.getContents())
                .writtenBy(writer);
        return boardRepository.save(entity).getId();
    }

    @Override
    public void delete(Integer id) {
        boardRepository.deleteById(id);
    }

    @Override
    public BoardDto getBoard(Integer id) {
        return boardRepository.findDtoById(id)
                .orElseThrow(() -> new EntityNotFoundException("게시글을 찾을 수 없습니다."));
    }

    @Override
    public Page<BoardDto> getBoardList(Integer menuId, Pageable pageable) {
            return boardRepository.findAllByMenuId(menuId, pageable);
    }
}
