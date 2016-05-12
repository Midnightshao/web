package com.springmvc.web.person.control;

import com.springmvc.web.cookie.CookieTake;
import com.springmvc.web.person.entity.Person;
import com.springmvc.web.person.server.PersonServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.spi.http.HttpContext;
import java.io.File;
import java.io.IOException;

/**
 * Created by guanghaoshao on 16/1/15.
 */
@Controller
public class PersonControl {



    @Autowired
    private PersonServer personServer;


    private String person="";

    @RequestMapping("/person")

        public String queryPerson(ModelMap modelMap,HttpServletRequest request) {

            CookieTake.cookie(modelMap, request);

            String st[]={"person1","person2","person3"};

            for(int i=0;i<st.length;i++){
                if(st[i]==person){
                    modelMap.put(person,"active");
                }else {
                    modelMap.put(st[i],"");
                }
            }

            Person persons=personServer.Person_query((Integer) request.getSession().getAttribute("id"));

            System.out.println(persons.getImg_type());
            if(persons.getImg_type()!=null){
                modelMap.put("picture_img",persons.getImg_type());
            }else {
                modelMap.put("picture_img","chuyin1.jpg");
            }

            modelMap.put("person_name",persons.getName());
            modelMap.put("person_age",persons.getAge());
            modelMap.put("person_city",persons.getCity());
            modelMap.put("person_content",persons.getContent());
            modelMap.put("person_img_type",persons.getImg_type());

            modelMap.put("person",person);

            return "person";
        }
    @RequestMapping("/person/peronzone")
    public String PersonZone(ModelMap modelMap,HttpServletRequest request){

        person="person1";

        return "redirect:/person";
    }
    @RequestMapping("/person/publishing")
    public String PersonPublishing(ModelMap modelMap,HttpServletRequest request){

        person="person2";

        return "redirect:/person";
    }
    @RequestMapping("/person/other")
    public String PersonOther(ModelMap modelMap,HttpServletRequest request){

        person="person3";

        return "redirect:/person";
    }

    @RequestMapping("/person/add_person")

    public String PersonAdd(HttpServletRequest request,HttpServletRequest servletContext,String name,String content,String age,String city,MultipartFile file){

        int id= Integer.valueOf((Integer) request.getSession().getAttribute("id"));

        Person persons=new Person();
        persons.setName(name);
        persons.setContent(content);
        persons.setAge(Integer.valueOf(age));
        persons.setCity(city);

        if(!file.isEmpty()) {
            System.out.println(file.getOriginalFilename());
            System.out.println("-----------------------------");
            persons.setImg_type(request.getSession().getAttribute("username").toString()+"_picture.jpg");
            System.out.println(servletContext.getSession().getServletContext().getRealPath("img_person"));
            File file1 = new File(servletContext.getSession().getServletContext().getRealPath("img_person"),request.getSession().getAttribute("username").toString()+"_picture");
            try {
                file.transferTo(file1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        personServer.Person_update(id,persons);

        person="person1";

        return "redirect:/person";
    }
}
