package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DataController {

//    @GetMapping("/")
//    public String home(){
//        return "home";
//    }

    @GetMapping("/public")
    public String publicPage(){
        return "public";
    }

    @GetMapping("/private")
    public String privatePage(){
        return "private";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}