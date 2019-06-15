package com.javaprojects.virtualelection.serviceimpl;

import com.javaprojects.virtualelection.daoimpl.VoterDaoImpl;
import com.javaprojects.virtualelection.model.Voter;
import com.javaprojects.virtualelection.service.VoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoterServiceImpl implements VoterService {
    @Autowired
    VoterDaoImpl voterDao;

    @Override
    public String getVoterId(String aadhaarId) {
        return voterDao.getVoterId(aadhaarId);
    }

    @Override
    public String registerVoter(String aadhaarId, String firstName, String lastName, String constituencyName) {
        Voter voter = new Voter();
        voter.setAadhaarId(aadhaarId);
        voter.setFirstName(firstName);
        voter.setLastName(lastName);
        voter.setHasVoted(false);
        return voterDao.registerVoter(voter, constituencyName, aadhaarId);
    }

}
