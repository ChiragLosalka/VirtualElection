package com.javaprojects.virtualelection.controller;

import com.javaprojects.virtualelection.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("candidatecontroller")
public class CandidateController {
    @Autowired
    CandidateService candidateService;

    @RequestMapping("registercandidate/{firstName}/{lastName}/{constituencyName}/{partyName}")
    public String registerCandidate(@PathVariable String firstName, @PathVariable String lastName, @PathVariable String constituencyName, @PathVariable String partyName) {
        return candidateService.registerCandidate(firstName, lastName, constituencyName, partyName);
    }
}
