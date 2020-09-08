package com.efreelearn.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.efreelearn.model.User;

@Controller
public class IndexController {
	
    @RequestMapping(value="/addUser", method = RequestMethod.GET)
    public String addUser(){
        return "addUser";
    }

}
