package com.springmvc.web.starter.dao;

import com.springmvc.web.admin.entity.Contact;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by guanghaoshao on 15/11/24.
 */
@Repository
public class StarterDaoImpl implements StarterDao {
    @Autowired
    public SessionFactory sessionfactory;

    @Override
    public List LoginList() {
        List list=new ArrayList();
        Query query=sessionfactory.openSession().createQuery("from Contact");
        list=query.list();
        System.out.println(list);
        if(list.isEmpty()){
            System.out.println(list);
            Query query1=sessionfactory.openSession().createSQLQuery("truncate content");
            query1.executeUpdate();

        }
        return list;
    }

    @Override
    public void addContent(Contact contact) {
        sessionfactory.openSession().save(contact);
    }

    @Override
    public void deleteContent(Integer id,String dete_address) {
        delete(id,dete_address);
        Query query=sessionfactory.openSession().createQuery("delete from Contact a where a.id="+id+"");
        query.executeUpdate();

    }
    public void delete(Integer id,String dete_address){
        Session session=sessionfactory.openSession();
        Contact contact= (Contact) session.load(Contact.class,id);
        System.out.println("这个是图片............."+contact.getImg_type());
        File file1=new File(dete_address,contact.getImg_type());

        if(file1.exists()){
            file1.delete();
            System.out.println("删除文件");
        }
    }
}
