package com.javaprojects.virtualelection.daoimpl;

import com.javaprojects.virtualelection.dao.PoliticalPartyDao;
import com.javaprojects.virtualelection.model.PoliticalParty;
import com.javaprojects.virtualelection.repository.PoliticalPartyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PoliticalPartyDaoImpl implements PoliticalPartyDao {
    @Autowired
    PoliticalPartyRepo politicalPartyRepo;
    @Override
    public String registerPoliticalParty(PoliticalParty politicalParty) {
        try {
            politicalPartyRepo.save(politicalParty);
        }catch (Exception e) {
            return "Registration Failed with message: " + e.getMessage();
        }
        return "Registration Successfull";
    }
}