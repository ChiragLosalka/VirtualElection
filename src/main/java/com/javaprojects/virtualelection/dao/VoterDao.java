package com.javaprojects.virtualelection.dao;

import com.javaprojects.virtualelection.model.Voter;

public interface VoterDao {
    public String getVoterId(String aadhaarId);
    public String registerVoter(Voter voter, String constituencyName, String aadhaarId);
}
