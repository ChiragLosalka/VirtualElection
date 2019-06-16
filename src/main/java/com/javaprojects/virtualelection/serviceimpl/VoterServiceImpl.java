package com.javaprojects.virtualelection.serviceimpl;

import com.javaprojects.virtualelection.daoimpl.VoterDaoImpl;
import com.javaprojects.virtualelection.model.Candidate;
import com.javaprojects.virtualelection.model.Voter;
import com.javaprojects.virtualelection.repository.CandidateRepo;
import com.javaprojects.virtualelection.repository.PoliticalPartyRepo;
import com.javaprojects.virtualelection.service.VoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoterServiceImpl implements VoterService {
    @Autowired
    VoterDaoImpl voterDao;
    @Autowired
    CandidateRepo candidateRepo;
    @Autowired
    PoliticalPartyRepo politicalPartyRepo;

    @Override
    public String registerVoter(String aadhaarId, String firstName, String lastName, String constituencyName) {
        Voter voter = new Voter();
        voter.setAadhaarId(aadhaarId);
        voter.setFirstName(firstName);
        voter.setLastName(lastName);
        voter.setHasVoted(false);
        return voterDao.registerVoter(voter, constituencyName, aadhaarId);
    }

    @Override
    public String castVote(String voterId, String partyName) {
        Voter voter = voterDao.getByVoterId(voterId);
        if(voter == null) return "Voter Not Registered with this Voter ID";
        if(voter.isHasVoted()) return "You have already voted, See you after 5 years";
        return voterDao.castVote(voter, partyName);
    }

}
