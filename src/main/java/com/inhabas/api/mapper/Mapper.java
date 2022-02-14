package com.inhabas.api.mapper;

import com.inhabas.api.domain.menu.MenuRepository;
import com.inhabas.api.domain.menu.MenuType;
import com.inhabas.api.service.board.BoardService;
import com.inhabas.api.service.board.ContestBoardServiceImpl;
import com.inhabas.api.service.board.NormalBoardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private ContestBoardServiceImpl contestBoardService;
    @Autowired
    private NormalBoardServiceImpl normalBoardService;

    public BoardService findBoardServiceByMenuId(Integer menuId){
        MenuType menuType = menuRepository.findMenuTypeByMenuId(menuId).get();
        switch(menuType){
            case CONTEST:
                return contestBoardService;
            default:
                return normalBoardService;
        }
    }

}
