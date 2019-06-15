package com.javaprojects.virtualelection.service;

public interface VoterService {
    public String getVoterId(String aadhaarId);
    public String registerVoter(String aadhaarId, String firstName, String lastName, String constituencyName);
}
