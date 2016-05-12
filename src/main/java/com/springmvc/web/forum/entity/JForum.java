package com.springmvc.web.forum.entity;

import com.springmvc.web.admin.entity.Admin;
import com.springmvc.web.forum_a.entity.Forum_a;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by guanghaoshao on 15/12/24.
 */
@Entity
@Table(name="JForum")
public class JForum implements Serializable{
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;
    @Column(name="title")
    private String title;
    @Column(name="content")
    private String content;
    @Column(name="image_type")
    private String image_type;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "jforum")

    private Set<Forum_a> forum_a =new HashSet(0);

    @ManyToOne(cascade = CascadeType.ALL,optional = false)
    @JoinColumn(name = "rid_id",referencedColumnName = "id")
    private Admin admin;

    public JForum() {
    }

    public JForum(String image_type, String content, String title) {
        this.image_type = image_type;
        this.content = content;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getImage_type() {
        return image_type;
    }

    public void setImage_type(String image_type) {
        this.image_type = image_type;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Set getForum_a() {
        return forum_a;
    }

    public void setForum_a(Set forum_a) {
        this.forum_a = forum_a;
    }
}
