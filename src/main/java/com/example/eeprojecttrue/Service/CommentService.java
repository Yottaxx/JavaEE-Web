package com.example.eeprojecttrue.Service;

import com.example.eeprojecttrue.Entity.Comment;
import com.example.eeprojecttrue.Entity.Customer;
import com.example.eeprojecttrue.Entity.Moment;
import com.example.eeprojecttrue.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public Comment findById(int id)
    {
        return commentRepository.findById(id);
    }
    public List<Comment> findAll()
    {
        return commentRepository.findAll();
    }


    public boolean Save(Comment comment)
    {
        if(!comment.getContent().isEmpty()) {
            commentRepository.save(comment);
            return true;
        }
        else
            return false;
    }

    public List<Comment> Get(Moment moment)
    {
        return  commentRepository.findByMoment_Id(moment.getId());
    }

    public void addS_Coments(Comment father, Comment children)
    {
        Comment father1=findById(father.getId());
        List<Comment> comments=father1.getChildren();
        if(comments==null)
        {
            comments=new ArrayList<>();
            comments.add(children);
            father1.setChildren(comments);
        }
        else
            comments.add(children);
    }
//    public List<Moment> findByDateStartsWith(Date date)
//    {
//        return momentRepository.findByDateStartsWith(date);
//    }
}
