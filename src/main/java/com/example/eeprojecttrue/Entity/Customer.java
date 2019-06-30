package com.example.eeprojecttrue.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Customer")
public class Customer {
 @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String email;
    private String password;
    private String role="user";


//    public Customer(String name, String email, String password) {
//        this.name = name;
//        this.email = email;
//        this.password = password;
//    }

    @OneToMany(mappedBy = "customer",cascade=CascadeType.ALL,fetch = FetchType.LAZY)//People是关系的维护端，当删除 people，会级联删除
    // address
    private List<Moment> moments;//地址

    public List<Moment> getMoments() {
        return moments;
    }

    public void setMoments(List<Moment> moments) {
        this.moments = moments;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
