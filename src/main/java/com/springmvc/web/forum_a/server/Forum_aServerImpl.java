package com.springmvc.web.forum_a.server;

import com.springmvc.web.forum_a.dao.Forum_aDaoImpl;
import com.springmvc.web.forum_a.entity.Forum_a;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by guanghaoshao son 16/1/2.
 */
@Service
public class Forum_aServerImpl  implements Forum_aServer{

    @Autowired
    Forum_aDaoImpl dao;
    @Override
    public List QueryForumFenYe(Integer first_title) {

        dao.QueryForumFenYe(first_title);

        return dao.QueryForumFenYe(first_title);
    }

    @Override
    public List QueryForumFenYe() {
        //查询
        return dao.ListQeryForumFenYe();
    }

    @Override
    public void addForum_a(Forum_a forum_a) {
        dao.addForuma(forum_a);
    }


}
