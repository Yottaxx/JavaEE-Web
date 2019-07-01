package com.example.eeprojecttrue.Entity;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.IOException;
import java.util.Date;
import java.util.List;

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
    private int awesome=0;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name=" logo", columnDefinition="longblob", nullable=true)
    private byte[] Logo;

    public int getAwesome() {
        return awesome;
    }

    public void setAwesome(int awesome) {
        this.awesome = awesome;
    }

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


    @OneToMany(mappedBy = "moment",cascade=CascadeType.ALL,fetch = FetchType.LAZY)//People是关系的维护端，当删除 people，会级联删除
    // address
    private List<Comment> comments;//地址

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
