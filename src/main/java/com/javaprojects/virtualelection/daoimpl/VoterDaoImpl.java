package com.javaprojects.virtualelection.daoimpl;

import com.javaprojects.virtualelection.dao.VoterDao;
import com.javaprojects.virtualelection.model.Candidate;
import com.javaprojects.virtualelection.model.Constituency;
import com.javaprojects.virtualelection.model.Voter;
import com.javaprojects.virtualelection.repository.CandidateRepo;
import com.javaprojects.virtualelection.repository.ConstituencyRepo;
import com.javaprojects.virtualelection.repository.PoliticalPartyRepo;
import com.javaprojects.virtualelection.repository.VotingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class VoterDaoImpl implements VoterDao {
    @Autowired
    VotingRepo votingRepo;
    @Autowired
    ConstituencyRepo constituencyRepo;
    @Autowired
    CandidateRepo candidateRepo;
    @Autowired
    PoliticalPartyRepo politicalPartyRepo;

    @Override
    public String getVoterId(String aadhaarId){
        List<Voter> list = votingRepo.findByAadhaarId(aadhaarId);
        if(list.size() == 0) return "";
        return list.get(0).getVoterId();
    }

    @Override
    public Voter getByVoterId(String voterId) {
        return votingRepo.findById(voterId).get();
    }

    @Override
    public String registerVoter(Voter voter, String constituencyName, String aadhaarId) {
        if(getVoterId(aadhaarId).length() != 0 || !getVoterId(aadhaarId).equals("")) {
            return "Voter with this Aadhaar Id exists";
        }
        try{
            Constituency constituency = constituencyRepo.findById(constituencyName).get();
            voter.setConstituencyName(constituency);
            votingRepo.save(voter);
        }catch(Exception e) {
            System.out.println("cause: " + e.getCause());
            System.out.println("message: " + e.getMessage());
            return "Registration Failed With Message: " + e.getMessage();
        }
        String generatedVoterId = getVoterId(aadhaarId);
        return "Voter Registered Successfully\nDear Voter,\n Your VoterId = " + generatedVoterId;
    }

    @Override
    public String castVote(Voter voter, String partyName) {
        String constituencyName = voter.getConstituencyName().getConstituencyName();

        List<Candidate> candidateList = candidateRepo.findByConsituencyNameAndPartyName(voter.getConstituencyName(), politicalPartyRepo.findById(partyName).get());
        if(candidateList.size() == 0)
            return "No Candidate exists for given Constituency Or Party";
        if(candidateList.size() > 1)
            return "Please Check! Multiple Candidates from " + constituencyName + " Constituency representing " + partyName;

        Candidate candidate = candidateList.get(0);
        candidate.setNoOfVotes(candidate.getNoOfVotes() + 1);
        try {
            candidateRepo.save(candidate);
        }catch(Exception e) {
            return "Failure: " + e.getMessage();
        }
        voter.setHasVoted(true);
        votingRepo.save(voter);
        return "Dear Voter, Your vote has been casted";
    }
}