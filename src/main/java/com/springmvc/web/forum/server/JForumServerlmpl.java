package com.springmvc.web.forum.server;

import com.springmvc.web.forum.dao.JForumDao;
import com.springmvc.web.forum.entity.JForum;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by guanghaoshao on 15/12/24.
 */
@Service
public class JForumServerlmpl implements JForumServer{

    @Autowired
    JForumDao dao;
    @Override
    public List queryForum() {

        return dao.queryForum();
    }

    @Override
    public void addForum(JForum jForum,String username) {
        dao.addForum(jForum,username);
    }

    @Override
    public List QueryForumFenYe(Integer first_title, Integer last_title) {

        return dao.QueryForumFenYe(first_title,last_title);
    }

    @Override
    public void deleteForum() {

    }

    @Override
    public void Update() {

    }
}
