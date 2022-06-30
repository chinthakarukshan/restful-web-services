package com.demo.rest.webservices.restfulwebservices.controller;

import com.demo.rest.webservices.restfulwebservices.entity.Name;
import com.demo.rest.webservices.restfulwebservices.entity.PersonV1;
import com.demo.rest.webservices.restfulwebservices.entity.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

    @GetMapping("/v1/person")
    public PersonV1 getPersonV1() {
        return new PersonV1("Chinthaka Weerakkody");
    }

    @GetMapping("v2/person")
    public PersonV2 getPersonV2() {
        return new PersonV2(new Name("Chinthaka", "Weerakkody"));
    }

    @GetMapping(path = "person/param", params = "version=1")
    public PersonV1 getPersonParamV1() {
        return new PersonV1("Chinthaka Weerakkody");
    }

    @GetMapping(path = "person/param", params = "version=2")
    public PersonV2 getPersonParamV2() {
        return new PersonV2(new Name("Chinthaka", "Weerakkody"));
    }

    @GetMapping(path = "person/header", headers = "X-API-VERSION=1")
    public PersonV1 getPersonHeaderParamV1() {
        return new PersonV1("Chinthaka Weerakkody");
    }

    @GetMapping(path = "person/header", headers = "X-API-VERSION=2")
    public PersonV2 getPersonHeaderParamV2() {
        return new PersonV2(new Name("Chinthaka", "Weerakkody"));
    }
}
