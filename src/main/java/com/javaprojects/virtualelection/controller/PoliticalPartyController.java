package com.javaprojects.virtualelection.controller;

import com.javaprojects.virtualelection.model.PoliticalParty;
import com.javaprojects.virtualelection.repository.ConstituencyRepo;
import com.javaprojects.virtualelection.repository.PoliticalPartyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("politicalpartycontroller")
public class PoliticalPartyController {

    @Autowired
    PoliticalPartyRepo politicalPartyRepo;

    @RequestMapping("registerparty/{partyName}")
    public String registerPoliticalParty(@PathVariable String partyName) {
        PoliticalParty politicalParty = new PoliticalParty();
        politicalParty.setPartyName(partyName);
        politicalParty.setPartySymbol("file path for the symbol image");
        try {
            politicalPartyRepo.save(politicalParty);
        }catch (Exception e) {
            return "Registration Failed with message: " + e.getMessage();
        }
        return "Registration Successfull";
    }
}
