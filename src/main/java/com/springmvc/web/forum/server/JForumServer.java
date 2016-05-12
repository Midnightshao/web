package com.springmvc.web.forum.server;

import com.springmvc.web.forum.entity.JForum;

import java.util.List;

/**
 * Created by guanghaoshao on 15/12/24.
 */
public interface JForumServer {
    public List queryForum();
    public void addForum(JForum jForum,String username);
    public List QueryForumFenYe(Integer first_title,Integer last_title);
    public void deleteForum();
    public void Update();
}
