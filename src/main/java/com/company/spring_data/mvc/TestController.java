package com.company.spring_data.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class TestController {
    @RequestMapping(method = RequestMethod.GET, value = "/test")
    public ModelAndView getTestMethod(){
        return new ModelAndView("test");
    }
}
