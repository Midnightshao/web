package com.springmvc.web.houtai_picture.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by guanghaoshao on 16/3/22.
 */
@Entity
@Table(name="title_picture")
public class HoutaiPictureEntity implements Serializable{
    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;

    @Column(name="img_picture")
    private String img_picture;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg_picture() {
        return img_picture;
    }

    public void setImg_picture(String img_picture) {
        this.img_picture = img_picture;
    }
}
