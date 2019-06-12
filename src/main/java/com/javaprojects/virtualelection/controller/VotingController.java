package com.javaprojects.virtualelection.controller;

import com.javaprojects.virtualelection.model.Constituency;
import com.javaprojects.virtualelection.model.Voter;
import com.javaprojects.virtualelection.repository.ConstituencyRepo;
import com.javaprojects.virtualelection.repository.VotingRepo;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("votercontroller")
public class VotingController {
    @Autowired
    VotingRepo votingRepo;
    @Autowired
    ConstituencyRepo constituencyRepo;

    @RequestMapping("/")
    public String home() {
        return "Home";
    }

    @RequestMapping("/registervoter/{firstName}/{lastName}/{constituencyName}")
    public String registerVoter(@PathVariable String firstName, @PathVariable String lastName, @PathVariable String constituencyName) {

        Voter voter = new Voter();
        voter.setFirstName(firstName);
        voter.setLastName(lastName);
        voter.setHasVoted(false);
        try{
            Constituency constituency = constituencyRepo.findById(constituencyName).get();
            voter.setConstituencyName(constituency);
            votingRepo.save(voter);
        }catch(Exception e) {
            System.out.println("cause: " + e.getCause());
            System.out.println("message: " + e.getMessage());
            return "Registration Failed With Message: " + e.getMessage();
        }
        return "Voter Registered Successfully";
    }
}
