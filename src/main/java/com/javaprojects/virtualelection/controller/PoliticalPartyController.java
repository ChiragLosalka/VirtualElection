package com.javaprojects.virtualelection.controller;

import com.javaprojects.virtualelection.repository.PoliticalPartyRepo;
import com.javaprojects.virtualelection.service.PoliticalPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("politicalpartycontroller")
public class PoliticalPartyController {

    @Autowired
    PoliticalPartyRepo politicalPartyRepo;

    @Autowired
    PoliticalPartyService politicalPartyService;

    @RequestMapping("registerparty/{partyName}")
    public String registerPoliticalParty(@PathVariable String partyName) {
        return politicalPartyService.registerPoliticalParty(partyName);
    }
}
