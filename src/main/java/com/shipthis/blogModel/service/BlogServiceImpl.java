package com.shipthis.blogModel.service;

import com.shipthis.blogModel.model.BlogModel;
import com.shipthis.blogModel.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService{

    private IBlogRepository iBlogRepository;

    @Autowired
    public void setiBlogRepository(IBlogRepository iBlogRepository) {
        this.iBlogRepository = iBlogRepository;
    }

    @Override
    public void addBlog(BlogModel blogModel) {
        iBlogRepository.save(blogModel);
    }

    @Override
    public BlogModel editBlog(BlogModel blogModel) {
        return iBlogRepository.save(blogModel);
    }

    @Override
    public void deleteBlog(int blogId) {
        iBlogRepository.deleteById(blogId);
    }

    @Override
    public BlogModel getById(int blogId) {
        return iBlogRepository.findById(blogId).get();
    }

    @Override
    public List<BlogModel> getAllBlogs() {
        return iBlogRepository.findAll();
    }
}
