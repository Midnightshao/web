package com.springmvc.web.houtai_admin.control;

import com.springmvc.web.houtai_admin.server.AdminServer;
import com.springmvc.web.houtai_admin.server.AdminServerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by guanghaoshao on 16/1/11.
 */
@Controller
public class AdminControl {
    @Autowired
    AdminServer adminServer;


    @RequestMapping(value = "/houtai_admins",method = RequestMethod.GET)
    public String onput(ModelMap modelMap){
        modelMap.put("String","houtai_admin");
        modelMap.put("admin_list",adminServer.QueryAdmin());

        return "starter";
    };
    @RequestMapping(value = "/houtai_admin/delete",method = RequestMethod.POST)
    public String delete(ModelMap modelMap,String id){
        modelMap.put("String","houtai_admin");
        System.out.println("----------------------------------------------------------------------");
        adminServer.removeAdmin(Integer.valueOf(id));
        return "redirect:/houtai_admins";
    };
}
