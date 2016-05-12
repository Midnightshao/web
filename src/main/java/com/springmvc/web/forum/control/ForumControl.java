package com.springmvc.web.forum.control;

import com.springmvc.web.cookie.CookieTake;
import com.springmvc.web.forum.entity.JForum;
import com.springmvc.web.forum.entity.biao;
import com.springmvc.web.forum.server.JForumServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by guanghaoshao on 15/12/24.
 */
@Controller
public class ForumControl
{
    private String fist;
    @Autowired
    JForumServer server;

    @RequestMapping("/ForumControl/{chaxun}")
    public String show_Forum(ModelMap modelMap,HttpServletRequest request,HttpServletResponse response,@PathVariable("chaxun") String fist,String second){
            //这要带着
            CookieTake.cookie(modelMap,request);

            this.fist=fist;

            int pagesize=5;

            int  First=Integer.valueOf(fist);
            //这个是总共到值
            int i=server.queryForum().size();

            if(i==0){
                i=1;
            }
            if(First==1 || First==0){
                modelMap.put("shangyiye","hidden");
            }else{
                modelMap.put("shangyiye","");
            }
            if(First*5>=i){
            modelMap.put("xiayiye","hidden");
                System.out.println("log......隐藏，隐藏");
            }else {
                modelMap.put("xiayiye","");
                System.out.println("log......不隐藏，不隐藏");
            }

            Float c=Float.valueOf(i)/pagesize;

            int ef= (int) Math.ceil(c);

            int startRow= (First-1) * pagesize;

            List list=new ArrayList();
            int last=0;
            int a=0;

            if(First<7){
                a=0;
                if(c<8){
                    last=ef;
                    modelMap.put("last","hidden");
                }else {
                    last=7;
                    modelMap.put("last","");
                }
                modelMap.put("first","hidden");
            }else if(First>=7 && First+7<=ef){
                a=First-3;
                last=First+2;
                modelMap.put("last","");
                modelMap.put("first","");
            }
            else if(First<=7 && First+7<=ef){
                a=0;
                last=7;
                modelMap.put("first","hidden");
                modelMap.put("last","");
            }else if(First>=7&& First+7>=ef){
                a=ef-7;
                last=ef;
                modelMap.put("first","");
                modelMap.put("last","hidden");
            }

            for(int q=a;q<last;q++){
                biao biao=new biao();
                biao.setTitle("/ForumControl/"+String.valueOf(q+1));
                biao.setAddress(String.valueOf(q+1));
                if(q+1==First){
                    biao.setChecked("active");
                }else {
                    biao.setChecked("");
                }
                list.add(biao);
            }
//            总页码
            modelMap.put("yema",ef);

            modelMap.put("server", server.QueryForumFenYe(startRow, pagesize));

            modelMap.put("fenye",list);

            modelMap.put("yeshu",fist);

           if(request.getSession().getAttribute("id")==null){
               modelMap.put("shuru","false");
           }else {
               modelMap.put("shuru","true");
           }
            return "forum";
    };
    @RequestMapping("/ForumControl/add")
    public String add_forum(String title,String content,HttpServletRequest request){
            if(request.getSession().getAttribute("id")==null){
                return "redirect:/ForumControl/1";
            }
            System.out.println(title);
            String userID=request.getSession().getAttribute("id").toString();
            JForum jForum=new JForum();
            jForum.setTitle(title);
            jForum.setContent(content);
            server.addForum(jForum, userID);

            return "redirect:/ForumControl/"+fist;
    };
}
