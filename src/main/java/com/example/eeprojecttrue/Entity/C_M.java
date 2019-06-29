package com.example.eeprojecttrue.Entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "C_M")
public class C_M  {
    @Id
    private Integer id;
    private String content;
    private Date date;
    private String title;
    private String name;

    public C_M(Customer customer,Moment moment)
    {
       this.id=moment.getId();
       this.content=moment.getContent();
       this.title=moment.getTitle();
       this.name=customer.getName();
       this.date=moment.getDate();
    }

    public Integer getId() {
        return id;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
