package com.javatraining.jooleprojectteam2.Controller;

import com.javatraining.jooleprojectteam2.Service.ProjectProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project/{id}/products")
public class ProjectProductController {
    @Autowired
    private ProjectProductService projectProductService;


}
