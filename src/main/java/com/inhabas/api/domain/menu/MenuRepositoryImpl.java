package com.inhabas.api.domain.menu;


import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import static com.inhabas.api.domain.menu.QMenu.menu;

@RequiredArgsConstructor
public class MenuRepositoryImpl implements MenuRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public Optional<MenuType> findMenuTypeByMenuId(Integer id){
        return Optional.ofNullable(queryFactory.select(menu.type)
                .from(menu)
                .where(menu.id.eq(id))
                .fetchOne());
    }
}
