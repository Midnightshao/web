package com.springmvc.web.houtai_picture.dao;

import com.springmvc.web.admin.entity.Admin;
import com.springmvc.web.admin.entity.Contact;
import com.springmvc.web.houtai_picture.entity.HoutaiPictureEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.stereotype.Repository;

import javax.transaction.TransactionManager;
import java.io.File;
import java.util.List;

/**
 * Created by guanghaoshao on 16/3/22.
 */
@Repository
public class PictureDaoImpl implements PictureDao{
    @Autowired
    public SessionFactory sessionfactory;
    @Autowired
    public HibernateTransactionManager transactionManagers;
    @Override
    public void add_picture(HoutaiPictureEntity houtaiPictureEntity) {
        System.out.println("添加1111111");
        Session session= sessionfactory.openSession();
        System.out.println(houtaiPictureEntity.getImg_picture());
        session.save(houtaiPictureEntity);
    }

    @Override
    public List query_picture() {
       return sessionfactory.openSession().createQuery("from HoutaiPictureEntity").list();
    }

    @Override
    public void delete_picture(Integer integer,String dataAdress) {

        Session session=sessionfactory.openSession();

        Transaction transaction=session.beginTransaction();

        HoutaiPictureEntity admin=(HoutaiPictureEntity)session.load(HoutaiPictureEntity.class, integer);

        System.out.println(admin.getImg_picture());

        delete(admin.getImg_picture(), dataAdress);

        session.delete(admin);

        transaction.commit();

        }
    public void delete(String Img_name,String data_address){
        File file1=new File(data_address,Img_name);
        if(file1.exists()){
            file1.delete();
            System.out.println("删除文件");
        }
    }
}
