package com.example.eeprojecttrue.Entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String content;
    private Integer Father_id;
    private Integer F_moment_id;
    private Integer Customer_id;
    private String Customer_name;
    private Date date;

    public Integer getF_moment_id() {
        return F_moment_id;
    }

    public void setF_moment_id(Integer f_moment_id) {
        F_moment_id = f_moment_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCustomer_name() {
        return Customer_name;
    }

    public void setCustomer_name(String customer_name) {
        Customer_name = customer_name;
    }

    public Integer getId() {
        return id;
    }

    public Integer getCustomer_id() {
        return Customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        Customer_id = customer_id;
    }

    public Integer getFather_id() {
        return Father_id;
    }

    public void setFather_id(Integer father_id) {
        Father_id = father_id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Moment getMoment() {
        return moment;
    }

    public void setMoment(Moment moment) {
        this.moment = moment;
    }

    @JoinColumn(name = "moment_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Moment moment;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "PARENT_ID")
    private Comment parent;
    // 子节点

    public Comment getParent() {
        return parent;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parent", fetch = FetchType.EAGER)
    private List<Comment> children;

    public void setParent(Comment parent) {
        this.parent = parent;
    }

    public void setChildren(List<Comment> children) {
        this.children = children;
    }

    public List<Comment> getChildren() {
        return children;
    }


}
