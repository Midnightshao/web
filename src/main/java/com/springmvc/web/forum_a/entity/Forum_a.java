package com.springmvc.web.forum_a.entity;

import com.springmvc.web.forum.entity.JForum;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by guanghaoshao on 16/1/2.
 */
@Entity
@Table(name = "JForum_a")
public class Forum_a implements Serializable{
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private String  id;
    private JForum jforum;
    @Column(name="title")
    private String title;
    @Column(name="content")
    private String content;
    @Column(name="img_type")
    private String img_type;
    @Column(name="rid_id")
    private int rid_id;
    @Column(name="person_id")
    private int person_id;

    public Forum_a(){

    }
    public Forum_a(String title, String content, String img_type,int rid_id) {
        this.title = title;
        this.content = content;
        this.img_type = img_type;
        this.rid_id=rid_id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rid_id",referencedColumnName = "id")

    public JForum getJforum() {
        return jforum;
    }
    public void setJforum(JForum jforum) {
        this.jforum = jforum;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
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
    public int getRid_id() {
        return rid_id;
    }
    public void setRid_id(int rid_id) {
        this.rid_id = rid_id;
    }
    public int getPerson_id() {
        return person_id;
    }
    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }
}
