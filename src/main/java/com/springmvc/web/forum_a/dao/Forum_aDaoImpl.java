package com.springmvc.web.forum_a.dao;

import com.springmvc.web.forum_a.entity.Forum_a;
import com.springmvc.web.forum_a.server.Forum_aServer;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by guanghaoshao on 16/1/2.
 */
@Repository
public class Forum_aDaoImpl  implements Forum_aDao{
    @Autowired
    SessionFactory sessionFactory;
    @Override
    public List QueryForumFenYe(Integer first_title) {
        List list=new ArrayList();
        Query query=sessionFactory.openSession().createQuery("from Forum_a c where c.rid_id=:name");

        query.setString("name",String.valueOf(first_title));

        return query.list();
    }
    public   List ListQeryForumFenYe(){

        Query query=sessionFactory.openSession().createQuery("from Forum_a ");

        return query.list();
        }

    @Override
    public void addForuma(Forum_a forum_a) {
        sessionFactory.openSession().save(forum_a);
    }
}
