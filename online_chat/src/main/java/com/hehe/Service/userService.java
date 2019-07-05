package com.hehe.Service;
import com.hehe.Entity.user;
import com.hehe.Repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //这里是实现了数据库的查询功能

public class userService {
    @Autowired
    userRepository UserRepository;

    public boolean Save(user myUser)
    {
        this.UserRepository.save(myUser);
        return true;

    }

    public user findByUserId(String userId){ return this.UserRepository.findByUserId(userId); }

    public List<user> findAllByUserName(String userName)
    {
        return this.UserRepository.findAllByUserName(userName);
    }

    public List<user> findAll()
    {
        return this.UserRepository.findAll();
    }

}
