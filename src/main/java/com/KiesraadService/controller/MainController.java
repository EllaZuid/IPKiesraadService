package com.KiesraadService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/council")
public class MainController {

    @Autowired
    public MainController(){

    }

    @GetMapping(path="/online")
    public String onlineCheck(){
        return "Im online!";
    }
}
