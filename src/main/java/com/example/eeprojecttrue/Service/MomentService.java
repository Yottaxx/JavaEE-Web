package com.example.eeprojecttrue.Service;

import com.example.eeprojecttrue.Entity.Moment;
import com.example.eeprojecttrue.Repository.MomentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MomentService {

    @Autowired
    private  MomentRepository momentRepository;

    public Moment findById(int id)
    {
        return momentRepository.findById(id);
    }
    public List<Moment> findByDate(String date){
        return momentRepository.findByDate(date);
    }
    public List<Moment> findAll()
    {
        return momentRepository.findAll();
    }
    public List<Moment> findByCustomerId(int customer_id)
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

    public List<Moment> GetByDate()
    {
        return momentRepository.findBySortDate();
    }


    public List<Moment> GetByDate(int nums,int pages)
    {

        Pageable pageable =  new PageRequest(pages,nums, Sort.Direction.DESC,"date");
        Page<Moment> page = momentRepository.findAll(pageable);
        List<Moment> list=page.getContent();
        return list;
    }
//    public List<Moment> findByDateStartsWith(Date date)
//    {
//        return momentRepository.findByDateStartsWith(date);
//    }
}
