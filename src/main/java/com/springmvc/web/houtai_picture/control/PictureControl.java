package com.springmvc.web.houtai_picture.control;

import com.springmvc.web.houtai_picture.entity.HoutaiPictureEntity;
import com.springmvc.web.houtai_picture.server.ServerPicture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * Created by guanghaoshao on 15/12/15.
 */
@Controller
public class PictureControl {
    @Autowired
    private ServerPicture serverPicture;
    @RequestMapping(value = "/starter/houtai_picture",method = RequestMethod.GET)
    public String pictureControl(ModelMap modelMap){
        modelMap.put("serverPicture",serverPicture.query_picture());
        modelMap.put("String","houtai_picture");

        return "starter";
    };
    @RequestMapping(value = "/starter/houtai_picture/add",method = RequestMethod.POST)
    public String pictureAdd(HttpServletRequest servletContext,MultipartFile file){
        HoutaiPictureEntity houtaiPictureEntity=new HoutaiPictureEntity();

        if(!file.isEmpty()){
            System.out.println(file.getOriginalFilename());
            System.out.println("-----------------------------");
            houtaiPictureEntity.setImg_picture(file.getOriginalFilename());
            serverPicture.add_picture(houtaiPictureEntity);
            System.out.println(servletContext.getSession().getServletContext().getRealPath("img"));
            File file1=new File(servletContext.getSession().getServletContext().getRealPath("img"),file.getOriginalFilename());
            try {
                file.transferTo(file1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "redirect:/starter/houtai_picture";
    };
    @RequestMapping(value = "/starter/houtai_picture/{delete}",method = RequestMethod.GET)
    public String pictureDelete(@PathVariable("delete") String id_string,HttpServletRequest servletContext){

        serverPicture.delete_picture(Integer.valueOf(id_string),servletContext.getSession().getServletContext().getRealPath("img"));

        return "redirect:/starter/houtai_picture";
    };
}
