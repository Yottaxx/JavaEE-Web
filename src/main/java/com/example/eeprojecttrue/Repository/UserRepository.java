package com.example.eeprojecttrue.Repository;

import com.example.eeprojecttrue.Entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Integer> {
    List<User> findByName(String name);
    User findById(int id);
    List<User> findAll();


}
