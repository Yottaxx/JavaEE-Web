package com.hehe.Repository;

import com.hehe.Entity.user;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface userRepository extends CrudRepository<user,Integer> {
    user findByUserId(String userId);
    List<user> findAllByUserName(String userName);
    List<user> findAll();
}
