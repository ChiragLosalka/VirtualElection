package com.javaprojects.virtualelection.controller;

import com.javaprojects.virtualelection.repository.ConstituencyRepo;
import com.javaprojects.virtualelection.repository.VotingRepo;
import com.javaprojects.virtualelection.service.VoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("votercontroller")
public class VotingController {
    @Autowired
    VotingRepo votingRepo;
    @Autowired
    ConstituencyRepo constituencyRepo;
    @Autowired
    VoterService voterService;

    @RequestMapping("/registervoter/{aadhaarId}/{firstName}/{lastName}/{constituencyName}")
    public String registerVoter(@PathVariable String aadhaarId, @PathVariable String firstName, @PathVariable String lastName, @PathVariable String constituencyName) {
        return voterService.registerVoter(aadhaarId, firstName, lastName, constituencyName);
    }
}