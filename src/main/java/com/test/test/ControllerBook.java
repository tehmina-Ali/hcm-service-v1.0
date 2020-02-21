package com.test.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ControllerBook {

    @Autowired
    ServiceBookMap serviceBookMap;

    @RequestMapping("/test")
    public String getMessage() throws IOException {
        return serviceBookMap.testApp();
    }
}
