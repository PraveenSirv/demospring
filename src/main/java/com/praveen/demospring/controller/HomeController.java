package com.praveen.demospring.controller;

import com.praveen.demospring.model.Product;
import com.praveen.demospring.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    ProductRepo prepo;

    @RequestMapping("/")
    public String great(){
        return "Welcome to SpringWeb World";
    }

    @RequestMapping("/about")
    public String about(){
        return "About is empty for now";
    }

//    @RequestMapping("/home/product")
//    @ResponseBody // It will send data as data which is passed to return not a jsp page
//    public List<Product> getProducts(){
//        return prepo.findAll();
//    }


}
