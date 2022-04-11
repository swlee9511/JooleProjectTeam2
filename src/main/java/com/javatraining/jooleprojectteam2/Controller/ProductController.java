package com.javatraining.jooleprojectteam2.Controller;

import com.javatraining.jooleprojectteam2.Entity.Product;
import com.javatraining.jooleprojectteam2.Entity.User;
import com.javatraining.jooleprojectteam2.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    // PostmanURL: localhost:8080/product/addProduct
    @PostMapping("/addProduct")
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        try {
            productService.create(product);
        } catch(Exception e) {
            return new ResponseEntity<>("{\"error\":\""+e.getMessage() + "\"}", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // PostmanURL: localhost:8080/product/findProduct?resourceId=X
    @GetMapping("/findProduct")
    public ResponseEntity<?> findProduct(@RequestParam(name="resourceId") int resourceId) {
        Product temp;
        try {
            temp = productService.find(resourceId);
        } catch(Exception e) {
            return new ResponseEntity<>("{\"error\":\""+e.getMessage() + "\"}", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(temp, HttpStatus.CREATED);
    }

    // PostmanURL: localhost:8080/product/updateProduct?resourceId=X
    // postman body will contain 'mechnicalDetail', 'brand', 'certification', 'modelYear'
    @PutMapping("/updateProduct")
    public ResponseEntity<?> updateProduct(@RequestBody Product product, @RequestParam(name="resourceId") int resourceId) {
        Product temp;
        try {
            temp = productService.find(resourceId);
            temp.setMechanicalDetail(product.getMechanicalDetail());
            temp.setBrand(product.getBrand());
            temp.setCertification(product.getCertification());
            temp.setModelYear(product.getModelYear());
            //temp.setLastUpdated(new Date());
            productService.update(temp);
        } catch(Exception e) {
            return new ResponseEntity<>("{\"error\":\""+e.getMessage() + "\"}", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(temp, HttpStatus.CREATED);
    }

    // PostmanURL: localhost:8080/product/deleteProduct?resourceId=X
    @DeleteMapping("/deleteProduct")
    public ResponseEntity<?> deleteProduct(@RequestParam(name="resourceId") int resourceId) {
        productService.delete(resourceId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
