package com.javaprojects.virtualelection.dao;

import com.javaprojects.virtualelection.model.Candidate;

public interface CandidateDao {
    public String registerCandidate(String partyName, String constituencyName, Candidate candidate);
}
