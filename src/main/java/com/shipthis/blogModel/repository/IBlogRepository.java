package com.shipthis.blogModel.repository;

import com.shipthis.blogModel.model.BlogModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepository extends JpaRepository<BlogModel,Integer> {
}
