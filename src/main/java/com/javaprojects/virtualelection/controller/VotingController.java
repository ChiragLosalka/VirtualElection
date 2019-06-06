package com.javaprojects.virtualelection.controller;

import com.javaprojects.virtualelection.model.Voter;
import com.javaprojects.virtualelection.repository.VotingRepo;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VotingController {
    @Autowired
    VotingRepo repo;

    @RequestMapping("/")
    public String home() {
        return "Home";
    }

    @RequestMapping("   ")
    public String registerVoter(@PathVariable String firstName, @PathVariable String lastName, @PathVariable String constituencyId) {
        String voterId = RandomStringUtils.randomAlphabetic(10);
//        Voter v = new Voter(voterId, firstName, lastName, constituencyId);
//        repo.save(v);
        return voterId;
    }
}
