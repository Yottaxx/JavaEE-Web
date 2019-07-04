package com.example.eeprojecttrue.Entity;

import javax.persistence.*;
<<<<<<< HEAD
import java.util.List;
=======
>>>>>>> ad5ddffab0f25a2405bdfcab5902afeea4d01260

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

<<<<<<< HEAD
    @OneToMany(mappedBy = "customer",cascade=CascadeType.ALL,fetch = FetchType.LAZY)//People是关系的维护端，当删除 people，会级联删除
    // address
    private List<Moment> moments;//地址

//    //****************************************李丽添
//    //这里的mappedBy是指的要关联的属性，这里的likeGoods也就是顾客收藏的商品和商品类中收藏商品的顾客关联
//    @ManyToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
//    @JoinTable(name = "customer_goods", joinColumns = { @JoinColumn(name = "like_customer_id") }, inverseJoinColumns = {@JoinColumn(name = "like_goods_id") })
//    private List<Goods> likeGoods;
//  //****************************************
    
    public List<Moment> getMoments() {
        return moments;
    }

    public void setMoments(List<Moment> moments) {
        this.moments = moments;
    }
=======

>>>>>>> ad5ddffab0f25a2405bdfcab5902afeea4d01260

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
<<<<<<< HEAD

//  //****************************************
//	public List<Goods> getLikeGoods() {
//		return likeGoods;
//	}
//
//	public void setLikeGoods(List<Goods> likeGoods) {
//		this.likeGoods = likeGoods;
//	}
//	//****************************************
    
=======
>>>>>>> ad5ddffab0f25a2405bdfcab5902afeea4d01260
}
