package com.javaprojects.virtualelection.repository;

import com.javaprojects.virtualelection.model.Candidate;
import com.javaprojects.virtualelection.model.Constituency;
import com.javaprojects.virtualelection.model.PoliticalParty;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CandidateRepo extends CrudRepository<Candidate, String> {
    @Query("From Candidate c where c.constituencyName = ?1 and c.partyName = ?2")
    List<Candidate> findByConsituencyNameAndPartyName(Constituency constituency, PoliticalParty politicalParty);
}
