package com.example.eeprojecttrue.Repository;

import com.example.eeprojecttrue.Entity.Customer;
import com.example.eeprojecttrue.Entity.Moment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MomentRepository extends CrudRepository<Moment,Integer> {
    Moment findById(int id);
    List<Moment> findByDate(String date);
    List<Moment> findAll();
    List<Moment> findByCustomerId(int customer_id);
    @Query(value = "select e from Moment e ORDER BY e.date desc")
    List<Moment> findBySortDate();

}