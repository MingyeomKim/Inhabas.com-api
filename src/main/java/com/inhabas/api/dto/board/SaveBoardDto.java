package com.inhabas.api.dto.board;

import com.inhabas.api.domain.board.Category;
<<<<<<< HEAD
import com.inhabas.api.domain.board.NormalBoard;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter @Setter
@NoArgsConstructor
public class SaveBoardDto {
    @NotBlank(message = "제목을 입력하세요.")
    @Size(max = 100, message = "제목은 최대 100자입니다.")
    private String title;

    @NotBlank(message = "본문을 입력하세요.")
    private String contents;

    @NotNull(message = "카테고리를 선택하세요.")
    private Integer categoryId;

    public NormalBoard toEntity(Category category) {
        return new NormalBoard(title, contents, category);
    }

=======
import com.inhabas.api.domain.member.Member;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SaveBoardDto {
    private String title;
    private String contents;
    private Category category;

    public SaveBoardDto(String title, String contents, Category category) {
        this.title = title;
        this.contents = contents;
        this.category = category;
    }
>>>>>>> 95bba374aca8108b079368a039f13ab0d611ac42
}
