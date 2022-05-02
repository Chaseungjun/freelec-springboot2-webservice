package com.simple.asw.service.posts;

import com.simple.asw.domain.posts.Posts;
import com.simple.asw.domain.posts.PostsRepository;
import com.simple.asw.dto.posts.PostsListResponseDto;
import com.simple.asw.dto.posts.PostsResponseDto;
import com.simple.asw.dto.posts.PostsSaveRequestDto;
import com.simple.asw.dto.posts.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class PostsService {

    private final PostsRepository postsRepository;

    public Long save(PostsSaveRequestDto requestDto){

        Posts savedPosts = postsRepository.save(requestDto.toEntity());
        return postsRepository.save(savedPosts).getId();
    }

    public PostsResponseDto findById(Long id){
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id : " + id));
        return new PostsResponseDto(posts);
    }

    public Long update(@PathVariable Long id, PostsUpdateRequestDto updateRequestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id : " + id));
        posts.update(updateRequestDto.getTitle(), updateRequestDto.getContent());
        return id;
    }
    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream().map(posts -> new PostsListResponseDto(posts)).collect(Collectors.toList());
    }

    public void delete(Long id){
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id : " + id));
        postsRepository.delete(posts);
    }
}
