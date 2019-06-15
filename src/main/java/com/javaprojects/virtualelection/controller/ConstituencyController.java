package com.javaprojects.virtualelection.controller;

import com.javaprojects.virtualelection.service.ConstituencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("constituencycontroller")
public class ConstituencyController {
    @Autowired
    ConstituencyService constituencyService;

    @RequestMapping("/registerconstituency/{constituencyName}/{state}")
    public String registerConstituency(@PathVariable String constituencyName, @PathVariable String state) {
        return constituencyService.registerConstituency(constituencyName, state);
    }


}
