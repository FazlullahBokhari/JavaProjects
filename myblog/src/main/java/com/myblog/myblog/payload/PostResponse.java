package com.myblog.myblog.payload;

import com.myblog.myblog.entity.Post;
import lombok.Data;

import java.util.List;

@Data
public class PostResponse {
    private List<Post> content;
    private int pageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean isLast;
}
