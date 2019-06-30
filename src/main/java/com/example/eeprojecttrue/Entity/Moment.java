package com.example.eeprojecttrue.Entity;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.IOException;
import java.util.Date;

@Entity
@Table(name = "Moment")
public class Moment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String content;
    private Date date;
    private String title;
    private String tag;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name=" logo", columnDefinition="longblob", nullable=true)
    private byte[] Logo;

    public byte[] getLogo() {
        return Logo;
    }

    public void setLogo(MultipartFile multipartFile)
    {
        try {
            Logo=multipartFile.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @JoinColumn(name = "customer_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
