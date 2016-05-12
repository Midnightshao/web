package com.springmvc.web.forum_a.control;

import com.springmvc.web.cookie.CookieTake;
import com.springmvc.web.forum.entity.JForum;
import com.springmvc.web.forum.server.JForumServer;
import com.springmvc.web.forum_a.entity.Forum_a;
import com.springmvc.web.forum_a.server.Forum_aServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by guanghaoshao on 16/1/2.
 */
@Controller
public class Forum_aControl {
    private String id;
    @Autowired
    Forum_aServer server;


    @RequestMapping("/Forum_a/query/{id}")
    public String query_forum(@PathVariable("id") String id,ModelMap modelMap,HttpServletRequest request){

        CookieTake.cookie(modelMap,request);

        List list=server.QueryForumFenYe(Integer.valueOf(id));

        Forum_a forum_a=(Forum_a)list.get(0);
        modelMap.put("query_content",list);
        modelMap.put("query_title",forum_a.getTitle());
        System.out.print(forum_a.getTitle()+"    ");
        this.id=id;
        modelMap.put("query_id",Integer.valueOf(id));
        System.out.print("aaaaaabbbbbbbbbb");
        return "forum_a";
    };
    @ResponseBody
    @RequestMapping(value = "/Forum_a/add.do",method = RequestMethod.POST)
    public String add_forum(String contents,String rid_id,HttpServletRequest request) throws InterruptedException {

        System.out.println("---------------------------------------------");
        System.out.println(rid_id);
        System.out.println(contents);
        System.out.println("---------------------------------------------");

        Forum_a forum_a=new Forum_a();
        forum_a.setRid_id(Integer.valueOf(rid_id));
        forum_a.setContent(contents);
        forum_a.setPerson_id(Integer.valueOf(request.getSession().getAttribute("id").toString()));
        server.addForum_a(forum_a);

        Thread.sleep(1500);

        return "redirect:/Forum_a/query/"+id;
    };
}
