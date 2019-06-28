package com.example.eeprojecttrue.Service;

import com.example.eeprojecttrue.Entity.Moment;
import com.example.eeprojecttrue.Repository.MomentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MomentService {

    @Autowired
    private  MomentRepository momentRepository;

    List<Moment> findById(int id)
    {
        return momentRepository.findById(id);
    }
    List<Moment> findByDate(String date){
        return momentRepository.findByDate(date);
    }
    List<Moment> findAll()
    {
        return momentRepository.findAll();
    }
    List<Moment> findByCustomerId(int customer_id)
    {
        return momentRepository.findByCustomerId(customer_id);
    }


    public boolean Save(Moment moment)
    {
        if(!moment.getContent().isEmpty()) {
            momentRepository.save(moment);
            return true;
        }
        else
            return false;
    }
}
