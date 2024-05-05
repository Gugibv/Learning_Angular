package com.grey.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/mobile")
public class MobileController {

    @GetMapping("/query")
    public String query(){
        return "mobile";
    }

    @GetMapping("/queryList")
    public List<String> queryList(){
        List<String> result = new ArrayList<>();
        for(int i=10000;i<10010;i++){

            result.add("phone num: "+ i);
        }

        return result;
    }
}