package com.javaprojects.virtualelection.repository;
import com.javaprojects.virtualelection.model.Voter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface VotingRepo extends CrudRepository <Voter, String> {
    @Query("select v from Voter v where v.aadhaarId = ?1")
    List<Voter> findByAadhaarId(String aadhaarId);
}
