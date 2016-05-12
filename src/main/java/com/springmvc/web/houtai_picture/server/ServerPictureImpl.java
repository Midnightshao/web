package com.springmvc.web.houtai_picture.server;

import com.springmvc.web.houtai_picture.dao.PictureDao;
import com.springmvc.web.houtai_picture.entity.HoutaiPictureEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by guanghaoshao on 16/3/22.
 */
@Service
public class ServerPictureImpl implements ServerPicture{
    @Autowired
    private PictureDao pictureDao;

    @Transactional
    @Override
    public void add_picture(HoutaiPictureEntity houtaiPictureEntity) {
        pictureDao.add_picture(houtaiPictureEntity);
    }
    @Transactional
    @Override
    public List query_picture() {
        return pictureDao.query_picture();
    }

    @Transactional
    public void delete_picture(Integer integer,String dataAdress) {
        pictureDao.delete_picture(integer,dataAdress);
    }
}
