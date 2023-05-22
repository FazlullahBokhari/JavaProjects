package com.blog.service.impl;

import com.blog.entities.Comment;
import com.blog.entities.Post;
import com.blog.payload.CommentDto;
import com.blog.repository.CommentRepository;
import com.blog.repository.PostRepository;
import com.blog.service.CommentService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private PostRepository postRepository;



    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }


    @Override
    public CommentDto createComment(long postId, CommentDto commentDto) {
        System.out.println(postId+"====================================================================");
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new EntityNotFoundException("No record found")
        );

        Comment comment = mapToEntity(commentDto);
        comment.setPost(post);
        Comment savedComment = commentRepository.save(comment);
        CommentDto dto = mapToDto(savedComment);

        return dto;
    }

    private CommentDto mapToDto(Comment comment){
        CommentDto dto = new CommentDto();


        dto.setId(comment.getId());
        dto.setName(comment.getName());
        dto.setEmail(comment.getEmail());
        dto.setBody(comment.getBody());

        return dto;
    }

    private Comment mapToEntity(CommentDto commentDto){
        Comment comment = new Comment();


        comment.setName(commentDto.getName());
        comment.setEmail(commentDto.getEmail());
        comment.setBody(commentDto.getBody());


        return comment;
    }
}
