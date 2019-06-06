package com.javaprojects.virtualelection.repository;
import com.javaprojects.virtualelection.model.Voter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;


public interface VotingRepo extends CrudRepository <Voter, String> {
}
