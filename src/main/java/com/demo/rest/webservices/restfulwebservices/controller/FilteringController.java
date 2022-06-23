package com.demo.rest.webservices.restfulwebservices.controller;

import com.demo.rest.webservices.restfulwebservices.dto.DemoFilter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public DemoFilter getFilter() {
        return new DemoFilter("value1", "value2", "value3");
    }

    @GetMapping("/filtering-list")
    public List<DemoFilter> getFilterList() {
        return Arrays.asList(new DemoFilter("value1", "value2", "value3"),new DemoFilter("value11", "value22", "value33"));
    }

}
