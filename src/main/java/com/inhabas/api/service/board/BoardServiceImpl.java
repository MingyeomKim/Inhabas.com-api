package com.inhabas.api.service.board;

import com.inhabas.api.domain.board.BoardRepository;
import com.inhabas.api.domain.board.Category;
import com.inhabas.api.domain.board.NormalBoard;
import com.inhabas.api.domain.board.NormalBoardRepository;
import com.inhabas.api.dto.NormalBoardDto;
import com.inhabas.api.dto.board.SaveBoardDto;
import com.inhabas.api.dto.board.UpdateBoardDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@Transactional
public class BoardServiceImpl implements BoardService {

    private NormalBoardRepository boardRepository;

    @Autowired
    public BoardServiceImpl (NormalBoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

    @Override
    public NormalBoard write(SaveBoardDto saveBoardDto) {
        return boardRepository.save(saveBoardDto.toEntity()).getId();
    }

    @Override
    public NormalBoard update(UpdateBoardDto updateBoardDto) {
        if(DoesExistBoard(updateBoardDto.toEntity())){
            return boardRepository.save(updateBoardDto.toEntity()).getId();
        } else {
            return null; // 확인 필요
        }
    }

    private boolean DoesExistBoard(NormalBoard normalBoard){
        return boardRepository.findById(normalBoard.getId()).isPresent();
    }

    @Override
    public void delete(Integer id) {
        boardRepository.deleteById(id);
    }

    @Override
    public Optional<NormalBoard> getBoard(Integer id) {
        return boardRepository.findById(id);
    }

    @Override
    public List<NormalBoard> getBoardList(Category category) {
        return boardRepository.findAllByCategory(category);
    }
}
