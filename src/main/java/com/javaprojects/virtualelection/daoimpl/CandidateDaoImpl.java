package com.javaprojects.virtualelection.daoimpl;

import com.javaprojects.virtualelection.dao.CandidateDao;
import com.javaprojects.virtualelection.model.Candidate;
import com.javaprojects.virtualelection.model.Constituency;
import com.javaprojects.virtualelection.model.PoliticalParty;
import com.javaprojects.virtualelection.repository.CandidateRepo;
import com.javaprojects.virtualelection.repository.ConstituencyRepo;
import com.javaprojects.virtualelection.repository.PoliticalPartyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CandidateDaoImpl implements CandidateDao {
    @Autowired
    PoliticalPartyRepo politicalPartyRepo;
    @Autowired
    ConstituencyRepo constituencyRepo;
    @Autowired
    CandidateRepo candidateRepo;

    @Override
    public String registerCandidate(String partyName, String constituencyName, Candidate candidate) {

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
