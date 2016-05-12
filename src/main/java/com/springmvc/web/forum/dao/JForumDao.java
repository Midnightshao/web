package com.springmvc.web.forum.dao;

import com.springmvc.web.forum.entity.JForum;

import java.util.List;

/**
 * Created by guanghaoshao on 15/12/24.
 */
public interface JForumDao {
    public List queryForum();
    public void addForum(JForum jForum,String username);
    public void deleteForum();
    public List QueryForumFenYe(Integer first_title,Integer last_title);
    public void Update();
}
