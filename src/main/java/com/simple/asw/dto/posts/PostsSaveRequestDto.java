package com.simple.asw.dto.posts;

import com.simple.asw.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.ui.Model;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {

    private String title;
    private String content;
    private String author;

    private static ModelMapper modelMapper = new ModelMapper();

    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;

    }

    public Posts toEntity(){
       return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }

//    public Posts toEntity(){
//        return modelMapper.map(PostsSaveRequestDto.class, Posts.class);
//    }


}
