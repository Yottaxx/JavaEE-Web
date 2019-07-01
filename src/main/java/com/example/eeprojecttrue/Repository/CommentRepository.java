package com.example.eeprojecttrue.Repository;

import com.example.eeprojecttrue.Entity.Comment;
import com.example.eeprojecttrue.Entity.Customer;
import com.example.eeprojecttrue.Entity.Moment;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface CommentRepository extends CrudRepository<Comment,Integer> {
    Comment findById(int id);
    List<Comment> findAll();
    List<Comment> findByMoment_Id(int id);


}
