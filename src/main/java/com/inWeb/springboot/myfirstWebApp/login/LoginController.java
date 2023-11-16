package com.inWeb.springboot.myfirstWebApp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    //name=kanish
    //model
    @RequestMapping("login")
    @ResponseBody
    public String gotoLoginPage(@RequestParam String name, ModelMap model) {
        model.put("name",name);

        System.out.println("Request Param is " +name);
        return "login";
    }

}
