package com.shipthis.blogModel.controllers;

import com.shipthis.blogModel.model.BlogModel;
import com.shipthis.blogModel.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("blog-api")
public class BlogController {

    private IBlogService blogService;

    @Autowired
    public void setBlogService(IBlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping("/addBlog")
    public ResponseEntity<Void> addBlog(@RequestBody BlogModel blogModel) {
        blogModel.setAddedAtDate(LocalDate.now());
        blogService.addBlog(blogModel);
        return ResponseEntity.status(HttpStatus.CREATED)
                .headers(httpHeaders -> httpHeaders.add("desc", "adding data for blog model"))
                .build();
    }

    @PostMapping("/editBlog/{blogId}")
    public ResponseEntity<BlogModel> editBlog(@RequestBody BlogModel blogModel, @PathVariable("blogId") int blogId) {
        blogModel.setBlogId(blogId);
        BlogModel blogModel1 = blogService.editBlog(blogModel);
        return ResponseEntity.ok(blogModel1);
    }

    @DeleteMapping("/deleteBlog/{blogId}")
    public ResponseEntity<Void> deleteBlog(@PathVariable("blogId") int blogId) {
        blogService.deleteBlog(blogId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getBlog/{blogId}")
    public ResponseEntity<BlogModel> getById(@PathVariable("blogId") int blogId) {
        BlogModel blogModel = blogService.getById(blogId);
        return ResponseEntity.ok().body(blogModel);
    }

    @GetMapping("/getAllBlogs")
    public ResponseEntity<List<BlogModel>> getAllBlogs() {
        return ResponseEntity.ok().body(blogService.getAllBlogs());
    }
}
