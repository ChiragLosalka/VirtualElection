package com.javaprojects.virtualelection.serviceimpl;

import com.javaprojects.virtualelection.dao.PoliticalPartyDao;
import com.javaprojects.virtualelection.model.PoliticalParty;
import com.javaprojects.virtualelection.service.PoliticalPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PoliticalPartyServiceImpl implements PoliticalPartyService {
    @Autowired
    PoliticalPartyDao politicalPartyDao;
    public String registerPoliticalParty(String partyName) {
        PoliticalParty politicalParty = new PoliticalParty();
        politicalParty.setPartyName(partyName);
        politicalParty.setPartySymbol("file path for the symbol image");
        return politicalPartyDao.registerPoliticalParty(politicalParty);
    }
}
