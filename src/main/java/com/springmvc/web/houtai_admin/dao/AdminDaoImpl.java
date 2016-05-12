package com.springmvc.web.houtai_admin.dao;

import com.springmvc.web.admin.entity.Admin;
import com.springmvc.web.forum.entity.JForum;
import com.springmvc.web.forum_a.entity.Forum_a;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by guanghaoshao on 16/1/11.
 */
@Repository
public class AdminDaoImpl implements AdminDao{
    @Autowired
    SessionFactory sessionFactory;
    @Override
    public List QueryAdmin() {

        return sessionFactory.openSession().createQuery("from  Admin").list();
    }

    @Override
    public void addAdmin() {

    }

    @Override
    public void removeAdmin(Integer id) {
        Session session=sessionFactory.openSession();

        List list=session.createSQLQuery("select * FROM JForum WHERE rid_id="+id).addEntity(JForum.class).list();
        //查询出了JForum代码
        System.out.println("+log----------------------------------------------------------------------------------------------------------------");

        for(int i=0;i<list.size();i++){
            JForum jForum=(JForum)list.get(i);
            System.out.println(jForum.getId());
            System.out.println("+log_log----------------------------------------------------------------------------------------------------------------");

            List lists=session.createSQLQuery("select * FROM JForum_a WHERE rid_id="+jForum.getId()).addEntity(Forum_a.class).list();

            if(!lists.isEmpty()){
                session.createSQLQuery("DELETE FROM JForum_a WHERE  rid_id=" + jForum.getId()).addEntity(Forum_a.class).executeUpdate();
            }

        }
        //jforum
        if(!session.createSQLQuery("SELECT  * FROM  JForum WHERE rid_id="+id).list().isEmpty()){
            session.createSQLQuery("DELETE FROM JForum WHERE  rid_id="+id).executeUpdate();
        }

        if(!session.createSQLQuery("SELECT  * FROM  person where rid_id="+id).list().isEmpty()){
            session.createSQLQuery("DELETE FROM person where rid_id="+id).executeUpdate();
        }
        //admin
        session.createSQLQuery("DELETE  FROM admin WHERE  id="+id).executeUpdate();

        System.out.println("删除");
    }

    @Override
    public void updateAdmin() {

    }
}
