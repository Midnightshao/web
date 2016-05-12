package com.springmvc.web.person.entity;

/**
 * Created by guanghaoshao on 16/1/16.
 */

import com.springmvc.web.admin.entity.Admin;
import com.springmvc.web.forum.entity.JForum;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="person")
public class Person implements Serializable{
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private int  id;

    @Column(name="name")
    private String name;

    @Column(name="img_type")
    private String img_type;

    @Column(name="city")
    private String city;

    @Column(name="content")
    private String content;

    @Column(name="age")
    private int age;

    public Person(){

    }

    public Person(String name, String img_type, String city, String content, int age, Admin admin) {
        this.name = name;
        this.img_type = img_type;
        this.city = city;
        this.content = content;
        this.age = age;
        this.admin = admin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "rid_id",referencedColumnName = "id")


    private Admin admin;

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getImg_type() {
        return img_type;
    }

    public void setImg_type(String img_type) {
        this.img_type = img_type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
