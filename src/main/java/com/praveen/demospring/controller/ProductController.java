package com.praveen.demospring.controller;


import com.praveen.demospring.model.Product;
import com.praveen.demospring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService service;

    @RequestMapping(value = "/product" , produces = {"application/xml"} /* It will produce only XML format */)
    public List<Product> getProducts(){
        return service.getProducts();
    }


    // @PathVariable : it replaces the variable with the actual variable in the method
    // both name should be same here it is "prodId" it should be passed in "{}"
    @RequestMapping("/product/{prodId}")
    public Product getProductById(@PathVariable int prodId){
        return service.getProductById(prodId);
    }

    @PostMapping(value = "/product" , consumes = {"application/json"} /* Iy will accept only Json format */)
    public void addProduct(@RequestBody Product prod ){
        System.out.println(prod);
        service.addProduct(prod);
    }

    //@RequestBody : it converts the json data to java object
    //@ResponseBody : it converts the java object to json data
    @PutMapping("/product")
    public void updateProduct(@RequestBody Product prod){
        service.updateProduct(prod);
    }

    @DeleteMapping("/product/{prodId}")
    public  void deleteProduct(@PathVariable int prodId){
        service.deleteProduct(prodId);
    }

}

//| Annotation        | Purpose                             | Typical Use         |
//| ----------------- | ----------------------------------- | ------------------- |
//| `@RestController` | Defines a REST API controller       | On controller class |
//| `@RequestMapping` | Maps request paths (all HTTP types) | On class/method     |
//| `@GetMapping`     | Handles HTTP GET requests           | Fetch data          |
//| `@PostMapping`    | Handles HTTP POST requests          | Create new resource |
//| `@PutMapping`     | Handles HTTP PUT requests           | Update resource     |
//| `@DeleteMapping`  | Handles HTTP DELETE requests        | Delete resource     |
