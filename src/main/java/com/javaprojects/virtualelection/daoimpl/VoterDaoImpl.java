package com.javaprojects.virtualelection.daoimpl;

import com.javaprojects.virtualelection.dao.VoterDao;
import com.javaprojects.virtualelection.model.Constituency;
import com.javaprojects.virtualelection.model.Voter;
import com.javaprojects.virtualelection.repository.ConstituencyRepo;
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

    @Override
    public String getVoterId(String aadhaarId){
        List<Voter> list = votingRepo.findByAadhaarId(aadhaarId);
        if(list.size() == 0) return "";
        return list.get(0).getVoterId();
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
}
