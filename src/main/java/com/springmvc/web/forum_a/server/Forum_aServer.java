package com.springmvc.web.forum_a.server;

import com.springmvc.web.forum_a.entity.Forum_a;

import java.util.List;

/**
 * Created by guanghaoshao on 16/1/2.
 */
public interface Forum_aServer {
    public List QueryForumFenYe(Integer first_title);
    public List QueryForumFenYe();
    public void addForum_a(Forum_a forum_a);
}
