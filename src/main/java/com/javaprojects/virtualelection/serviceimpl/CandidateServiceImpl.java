package com.javaprojects.virtualelection.serviceimpl;

import com.javaprojects.virtualelection.dao.CandidateDao;
import com.javaprojects.virtualelection.model.Candidate;
import com.javaprojects.virtualelection.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateServiceImpl implements CandidateService {
    @Autowired
    CandidateDao candidateDao;

    @Override
    public String registerCandidate(String firstName, String lastName, String constituencyName, String partyName) {
        Candidate candidate = new Candidate();
        candidate.setFirstName(firstName);
        candidate.setLastName(lastName);
        return candidateDao.registerCandidate(partyName, constituencyName, candidate);
    }
}
