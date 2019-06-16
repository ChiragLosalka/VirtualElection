package com.javaprojects.virtualelection.dao;

import com.javaprojects.virtualelection.model.Voter;

public interface VoterDao {
    String getVoterId(String aadhaarId);
    Voter getByVoterId(String voterId);
    String registerVoter(Voter voter, String constituencyName, String aadhaarId);
    String castVote(Voter voter, String partyName);

}
