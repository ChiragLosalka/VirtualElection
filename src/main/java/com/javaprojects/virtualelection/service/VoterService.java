package com.javaprojects.virtualelection.service;

public interface VoterService {
    String registerVoter(String aadhaarId, String firstName, String lastName, String constituencyName);
    String castVote(String voterId, String partyName);
}
