package com.springmvc.web.forum.dao;

import com.springmvc.web.admin.entity.Admin;
import com.springmvc.web.forum.entity.JForum;
import com.springmvc.web.forum_a.entity.Forum_a;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by guanghaoshao on 15/12/24.
 */
@Repository
public class JFormuDaoImpl implements JForumDao{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List queryForum() {

        Query query= sessionFactory.openSession().createQuery("from JForum");
//        query.setFirstResult(0);
//        query.setMaxResults(7);
        List list=query.list();
        return list;
    }

    public List QueryForumFenYe(Integer first_title,Integer last_title){

        Query query=sessionFactory.openSession().createQuery("from JForum");

        query.setFirstResult(first_title);

        query.setMaxResults(last_title);

        List list=query.list();

        return list;
    };
    @Override
    public void addForum(JForum jForum,String username) {

        JForum jForum1=new JForum();

        jForum1=jForum;

        Session session= sessionFactory.openSession();

        Admin admin=(Admin)session.load(Admin.class, Integer.valueOf(username));

        admin.getJforums().add(jForum);

        jForum1.setAdmin(admin);
        //保存了
        session.save(jForum1);


        Forum_a jForum_a=new Forum_a();
        jForum_a.setPerson_id(Integer.valueOf(username));
        jForum_a.setTitle(jForum1.getTitle());
        jForum_a.setContent(jForum1.getContent());
        jForum_a.setImg_type(jForum1.getImage_type());
        jForum_a.setRid_id(jForum.getId());



        session.save(jForum_a);
    }

    @Override
    public void deleteForum() {

    }

    @Override
    public void Update() {

    }
}
