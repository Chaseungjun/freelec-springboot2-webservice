package com.simple.asw.repository;

import com.simple.asw.domain.posts.Posts;
import com.simple.asw.domain.posts.PostsRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @Test
    @DisplayName("게시글_저장")
    void 게시글_저장() throws Exception {
        //given
        String title = "test";
        String content = "content test";

        //when
        Posts posts = Posts.builder()
                .title(title)
                .content(content)
                .author("aaa@aaa.aaa")
                .build();
        postsRepository.save(posts);

        //then
        assertEquals(posts.getTitle(), title);
        assertEquals(posts.getContent(), content);
    }



}