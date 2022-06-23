package com.demo.rest.webservices.restfulwebservices.controller;

import com.demo.rest.webservices.restfulwebservices.dto.DemoFilter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public DemoFilter getFilter() {
        return new DemoFilter("value1", "value2", "value3");
    }

}
