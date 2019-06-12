package com.javaprojects.virtualelection.controller;

import com.javaprojects.virtualelection.model.Candidate;
import com.javaprojects.virtualelection.model.Constituency;
import com.javaprojects.virtualelection.model.PoliticalParty;
import com.javaprojects.virtualelection.repository.CandidateRepo;
import com.javaprojects.virtualelection.repository.ConstituencyRepo;
import com.javaprojects.virtualelection.repository.PoliticalPartyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("candidatecontroller")
public class CandidateController {
    @Autowired
    ConstituencyRepo constituencyRepo;
    @Autowired
    PoliticalPartyRepo politicalPartyRepo;
    @Autowired
    CandidateRepo candidateRepo;

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("registercandidate/{firstName}/{lastName}/{constituencyName}/{partyName}")
    public String registerCandidate(@PathVariable String firstName, @PathVariable String lastName, @PathVariable String constituencyName, @PathVariable String partyName) {

        Candidate candidate = new Candidate();
        candidate.setFirstName(firstName);
        candidate.setLastName(lastName);
        try {
            PoliticalParty politicalParty = politicalPartyRepo.findById(partyName).get();
            Constituency constituency = constituencyRepo.findById(constituencyName).get();
            candidate.setPartyName(politicalParty);
            candidate.setConstituencyName(constituency);
        }catch(Exception e) {
            return "Registration Failed : " + e.getMessage();
        }
        candidateRepo.save(candidate);
        return "Registration Successfull";
    }
}
