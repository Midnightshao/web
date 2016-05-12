package com.springmvc.web.houtai_picture.dao;

import com.springmvc.web.houtai_picture.entity.HoutaiPictureEntity;

import java.util.List;

/**
 * Created by guanghaoshao on 16/3/22.
 */
public interface PictureDao {
    public void add_picture(HoutaiPictureEntity houtaiPictureEntity);
    public List query_picture();
    public void delete_picture(Integer integer,String dataAdress);
}
