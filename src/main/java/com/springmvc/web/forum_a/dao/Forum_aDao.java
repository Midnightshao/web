package com.springmvc.web.forum_a.dao;

import com.springmvc.web.forum_a.entity.Forum_a;

import java.util.List;

/**
 * Created by guanghaoshao on 16/1/2.
 */
public interface Forum_aDao {
    public List QueryForumFenYe(Integer first_title);
    public List ListQeryForumFenYe();
    public void addForuma(Forum_a forum_a);
}
