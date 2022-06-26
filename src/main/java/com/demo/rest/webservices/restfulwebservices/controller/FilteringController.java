package com.demo.rest.webservices.restfulwebservices.controller;

import com.demo.rest.webservices.restfulwebservices.dto.DemoFilter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
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

    @GetMapping("/filtering-dynamic")
    public MappingJacksonValue getDynamicFilter() {

        DemoFilter demoFilterBean = new DemoFilter("value1", "value2", "value3");

        SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");

        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("DemoFilter", simpleBeanPropertyFilter);

        MappingJacksonValue mapping = new MappingJacksonValue(demoFilterBean);
        mapping.setFilters(filterProvider);

        return mapping;
    }

    @GetMapping("/filtering-list-dynamic")
    public MappingJacksonValue getDynamicFilterList() {
        List<DemoFilter> beanList =  Arrays.asList(new DemoFilter("value1", "value2", "value3"),new DemoFilter("value11", "value22", "value33"));

        SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field3");

        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("DemoFilter", simpleBeanPropertyFilter);

        MappingJacksonValue mapping = new MappingJacksonValue(beanList);
        mapping.setFilters(filterProvider);


        return mapping;
    }

}
