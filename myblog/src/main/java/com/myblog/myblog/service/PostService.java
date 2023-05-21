package com.myblog.myblog.service;

import com.myblog.myblog.payload.PostDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PostService {

    List<PostDto> getAllPosts();

    PostDto createPost(PostDto postDto);

    PostDto getPostById(long id);

    PostDto updatePost(PostDto postDto, long id);

    void deletePostById(long id);
}
