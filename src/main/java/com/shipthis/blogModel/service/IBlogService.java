package com.shipthis.blogModel.service;

import com.shipthis.blogModel.model.BlogModel;

import java.util.List;

public interface IBlogService {
    void addBlog(BlogModel blogModel);
    BlogModel editBlog(BlogModel blogModel);
    void deleteBlog(int blogId);

    BlogModel getById(int blogId);
    List<BlogModel> getAllBlogs();
}
