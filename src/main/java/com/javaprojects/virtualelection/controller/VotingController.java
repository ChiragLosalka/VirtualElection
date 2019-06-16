package com.javaprojects.virtualelection.controller;

import com.javaprojects.virtualelection.service.VoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("votercontroller")
public class VotingController {
    @Autowired
    VoterService voterService;

    @RequestMapping("/registervoter/{aadhaarId}/{firstName}/{lastName}/{constituencyName}")
    public String registerVoter(@PathVariable String aadhaarId, @PathVariable String firstName, @PathVariable String lastName, @PathVariable String constituencyName) {
        return voterService.registerVoter(aadhaarId, firstName, lastName, constituencyName);
    }

    @RequestMapping("/castvote/{voterId}/{partyName}")
    public String castVote(@PathVariable String voterId, @PathVariable String partyName) {
        return voterService.castVote(voterId, partyName);
    }


}