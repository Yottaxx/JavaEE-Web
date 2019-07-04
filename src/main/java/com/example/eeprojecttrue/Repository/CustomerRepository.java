package com.example.eeprojecttrue.Repository;

import com.example.eeprojecttrue.Entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,Integer> {
    List<Customer> findByName(String name);
    Customer findByEmail(String email);
    Customer findById(int id);
    List<Customer> findAll(); 
    

}
