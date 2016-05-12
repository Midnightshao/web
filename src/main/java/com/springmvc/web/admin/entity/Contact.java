package com.springmvc.web.admin.entity;

import javax.persistence.*;

/**
 * Created by guanghaoshao on 15/12/14.
 */
@Entity
@Table(name="content")
public class Contact implements java.io.Serializable{
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="title")
    private String title;
    @Column(name="content")
    private String content;
    @Column(name="img_type")
    private String img_type;

    public Contact() {
    }

    public Contact(int id, String title, String content, String img_type) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.img_type = img_type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImg_type() {
        return img_type;
    }

    public void setImg_type(String img_type) {
        this.img_type = img_type;
    }
}
