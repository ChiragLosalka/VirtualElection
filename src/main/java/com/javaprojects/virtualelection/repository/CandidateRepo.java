package com.javaprojects.virtualelection.repository;

import com.javaprojects.virtualelection.model.Candidate;
import org.springframework.data.repository.CrudRepository;

public interface CandidateRepo extends CrudRepository<Candidate, String> {
}
