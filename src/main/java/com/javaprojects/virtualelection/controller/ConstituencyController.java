package com.javaprojects.virtualelection.controller;

import com.javaprojects.virtualelection.model.Constituency;
import com.javaprojects.virtualelection.repository.ConstituencyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("constituencycontroller")
public class ConstituencyController {
    @Autowired
    ConstituencyRepo constituencyRepo;

    @RequestMapping("/registerconstituency/{constituencyName}/{state}")
    public String registerConstituency(@PathVariable String constituencyName, @PathVariable String state) {
        Constituency constituency = new Constituency();
        constituency.setConstituencyName(constituencyName);
        constituency.setState(state);
        constituency.setCountingCompleted(false);
        try {
            constituencyRepo.save(constituency);
        }catch(Exception e) {
            e.printStackTrace();
            return "Registration Failed";
        }
        return "constituency registered successfully";
    }


}
