package com.javatraining.jooleprojectteam2.Controller;

import com.javatraining.jooleprojectteam2.Entity.Product;
import com.javatraining.jooleprojectteam2.Entity.Project;
import com.javatraining.jooleprojectteam2.Entity.ProjectProduct;
import com.javatraining.jooleprojectteam2.Service.ProductService;
import com.javatraining.jooleprojectteam2.Service.ProjectProductService;
import com.javatraining.jooleprojectteam2.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/projectProduct")
public class ProjectProductController {
    @Autowired
    private ProjectProductService projectProductService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private ProductService  productService;

    // PostmanURL: localhost:8080/projectProduct/addProduct/X/InProject/X
    @PostMapping("/addProduct/{productId}/InProject/{projectId}")
    public ResponseEntity<?> addProductInProject(@PathVariable int productId, @PathVariable int projectId) {
        Project projectTemp;
        Product productTemp;
        try {
            projectTemp = projectService.findOne(projectId);
            productTemp = productService.find(productId);
            ProjectProduct temp = new ProjectProduct(projectTemp, productTemp);
            projectProductService.create(temp);
        } catch(Exception e) {
            return new ResponseEntity<>("{\"error\":\""+e.getMessage() + "\"}", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // PostmanURL: localhost:8080/projectProduct/find?projectProductId=X
    @GetMapping("/find")
    public ResponseEntity<?> findProjectProduct(@RequestParam(name="projectProductId") int projectProductId) {
        ProjectProduct temp;
        try {
            temp = projectProductService.find(projectProductId);
        } catch(Exception e) {
            return new ResponseEntity<>("{\"error\":\""+e.getMessage() + "\"}", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(temp, HttpStatus.CREATED);
    }

    // PostmanURL: localhost:8080/projectProduct/updateProjectProduct/?projectProductId=X&projectId=X&resourceId=X
    @PutMapping("/updateProjectProduct")
    public ResponseEntity<?> updateProduct(@RequestParam(name="projectProductId") int projectProductId,
                                           @RequestParam(name="projectId") int projectId,
                                           @RequestParam(name="resourceId") int resourceId) {
        Project projectTemp;
        Product productTemp;
        ProjectProduct temp;
        try {
            projectTemp = projectService.findOne(projectId);
            productTemp = productService.find(resourceId);
            temp = projectProductService.find(projectProductId);
            temp.setProject(projectTemp);
            temp.setProduct(productTemp);
            projectProductService.update(projectProductId, temp);
        } catch(Exception e) {
            return new ResponseEntity<>("{\"error\":\""+e.getMessage() + "\"}", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(temp, HttpStatus.CREATED);
    }

    // PostmanURL: localhost:8080/projectProduct/deleteProjectProduct?projectProductId=X
    @DeleteMapping("/deleteProjectProduct")
    public ResponseEntity<?> deleteProjectProduct(@RequestParam(name="projectProductId") int projectProductId) {
        ProjectProduct temp;
        try {
            temp = projectProductService.find(projectProductId);
            projectProductService.delete(temp);
        } catch(Exception e) {
            return new ResponseEntity<>("{\"error\":\""+e.getMessage() + "\"}", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // tried to create a function that will get all the products/projects that is linked to specific project/product
    /*@GetMapping("/findAllProductsInProject/{projectId}")
    public ResponseEntity<?> findAllProductsInProject(@PathVariable int projectId) {
        Project projectTemp;
        List<ProjectProduct> temp;
        try {
            projectTemp = projectService.findOne(projectId);
            temp = projectProductService.findAllProductsInProject(projectTemp);
        } catch(Exception e) {
            return new ResponseEntity<>("{\"error\":\""+e.getMessage() + "\"}", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(temp, HttpStatus.CREATED);
    }*/
}
