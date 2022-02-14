package com.inhabas.api.dto.board;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SaveBoardDto extends ParentBoardDto {
    @NotBlank(message = "제목을 입력하세요.")
    @Length(max = 100, message = "제목은 최대 100자입니다.")
    protected String title;

    @NotBlank(message = "본문을 입력하세요.")
    protected String contents;

    @NotNull
    protected Integer menuId;

    @NotNull(message = "로그인 후 이용해주세요.")
    protected Integer loginedUser;

    public SaveBoardDto(String title, String contents, Integer menuId, Integer loginedUser) {
        this.title = title;
        this.contents = contents;
        this.menuId = menuId;
        this.loginedUser = loginedUser;
    }
}
