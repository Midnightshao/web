package com.springmvc.web.houtai_content.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by guanghaoshao on 15/12/15.
 */
@Controller
public class ContentControl {

    @RequestMapping(value = "/houtai_content",method = RequestMethod.GET)
    public String onput(ModelMap modelMap){
        modelMap.put("String","houtai_content1");
        return "starter";
    };
}
