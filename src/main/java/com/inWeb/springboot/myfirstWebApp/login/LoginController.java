package com.inWeb.springboot.myfirstWebApp.login;


import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {
    private AuthenticationService authenticationService;

    public LoginController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    //GET,POST
    @RequestMapping(value="login",method = RequestMethod.GET )

    public String gotoLoginPage() {
        return "login";
    }

    @RequestMapping(value="login",method = RequestMethod.POST)

    public String gotoWelcomePagePage(@RequestParam String name,
                                      @RequestParam String password, ModelMap model) {


        if(authenticationService.authenticate(name, password)) {

            model.put("name", name);


            return "welcome";
        }
        model.put("errormessage","invalid credentials!plese try again.");

        return "login";
    }
}




