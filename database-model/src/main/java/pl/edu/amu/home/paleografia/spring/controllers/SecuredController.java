package pl.edu.amu.home.paleografia.spring.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/security")
public class SecuredController {

    @RequestMapping({"/hello"})
    public String hello() {
        return "Hello World";
    }

}
