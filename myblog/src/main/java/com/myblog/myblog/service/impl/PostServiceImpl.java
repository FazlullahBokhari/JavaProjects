package com.myblog.myblog.service.impl;

import com.myblog.myblog.entity.Post;
import com.myblog.myblog.exception.ResourceNotFoundException;
import com.myblog.myblog.payload.PostDto;
import com.myblog.myblog.repository.PostRepository;
import com.myblog.myblog.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> posts = postRepository.findAll();

        return posts.stream().map(post->mapToDto(post)).collect(Collectors.toList());

    }

    PostDto mapToDto(Post post){
        PostDto dto = new PostDto();

        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setDescription(post.getDescription());
        dto.setContent(post.getContent());

        return dto;
    }

    Post mapToEntity(PostDto dto){
        Post post = new Post();
        post.setTitle(dto.getTitle());
        post.setDescription(dto.getDescription());
        post.setContent(dto.getContent());

        return post;
    }



    @Override
    public PostDto createPost(PostDto postDto) {

        Post post = mapToEntity(postDto);

        Post newPost = postRepository.save(post);

        PostDto dto = mapToDto(newPost);

        return dto;
    }

    @Override
    public PostDto getPostById(long id) {

        Post post = postRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Post", "Id", id)
        );
        return mapToDto(post);
    }

    @Override
    public PostDto updatePost(PostDto postDto, long id) {
        Post post = postRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Post", "Id", id)
        );
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        Post updatedPost = postRepository.save(post);

        return mapToDto(updatedPost);
    }

    @Override
    public void deletePostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Post", "Id", id)
        );
        postRepository.deleteById(id);
    }
}
