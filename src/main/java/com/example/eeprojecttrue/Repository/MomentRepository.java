package com.example.eeprojecttrue.Repository;

import com.example.eeprojecttrue.Entity.Moment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    Page<Moment> findAll(Pageable pageable);
    Page<Moment> findByDateStartsWith(Date date, Pageable pageable);
    List<Moment> findByCustomerId(int customer_id);
    List<Moment> findByTag(String tag);
    Page<Moment> findByTag(String tag,Pageable pageable);
    Page<Moment> findByContentStartingWith(String string,Pageable pageable);
    @Query(value = "select e from Moment e ORDER BY e.date desc")
    List<Moment> findBySortDate(Pageable page);

    @Query(value = "select e from Moment e ORDER BY e.date desc")
    List<Moment> findBySortDate();


}