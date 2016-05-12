package com.springmvc.web.starter.control;

import com.springmvc.web.admin.entity.Contact;

import com.springmvc.web.cookie.Image;
import com.springmvc.web.starter.server.StarterServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


/**
 * Created by guanghaoshao on 15/11/23.
 */
@Controller
public class StarterControl{

    @Autowired
    StarterServer loginServer;

    @RequestMapping(value = "/starter",method = RequestMethod.GET)
    public String adminwelcome(HttpServletRequest servlet,ModelMap modelMap){
        modelMap.put("String","houtai_shouye");
//        System.out.println(loginServer.LoginList());
        if(servlet.getSession().getAttribute("shao")!=null){
            modelMap.put("Stu",loginServer.LoginList());
        }else {
            return "redirect:/login";
        }
        return "starter";
    }
    @RequestMapping(value = "/starter/add",method = RequestMethod.POST)
    public String addstarter(HttpServletRequest servlet,String title,String content,MultipartFile file) throws UnsupportedEncodingException {
        System.out.println(title);
        String s1= URLEncoder.encode(title,"utf8");
        System.out.println(s1);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(content);
        System.out.println();

        Contact contact=new Contact();
        ServletContext servletContext=servlet.getSession().getServletContext();
            if(title==null){
                return "redirect:/starter";
            }else if(content==null){
                return "redirect:/starter";
            }else if(file==null){
                return "redirect:/starter";
            }
            if(!file.isEmpty()){
                contact.setImg_type(file.getOriginalFilename());
                System.out.println(servletContext.getRealPath("img"));
                File file1=new File(servletContext.getRealPath("img"),file.getOriginalFilename());
                try {
                    file.transferTo(file1);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        contact.setTitle(title);
        contact.setContent(content);
        loginServer.addContent(contact);

        return "redirect:/starter";
    }
    @RequestMapping(value = "/starter/delete/{delete}",method = RequestMethod.GET)
        public String delete(@PathVariable("delete") String delete,HttpServletRequest servlet){
//            System.out.println(delete);

            loginServer.deleteContent(Integer.valueOf(delete),servlet.getSession().getServletContext().getRealPath("img"));
             return "redirect:/starter";
        }
//    @RequestMapping(value = "/starter/houtai_picture",method = RequestMethod.GET)
//     public String title_picture(ModelMap modelMap){
//
//        modelMap.put("String","houtai_picture");
//
////        return "redirect:/starter";
//        return "starter";
//    };



    @RequestMapping(value = "/houtai_starter",method = RequestMethod.GET)
    public String start(){
        return "redirect:/starter";
    }
    @RequestMapping(value = "/houtai_onput",method = RequestMethod.GET)
    public String onput(){
        return "redirect:houtai_content";
    }

}
