package com.javaprojects.virtualelection.repository;

import com.javaprojects.virtualelection.model.PoliticalParty;
import org.springframework.data.repository.CrudRepository;

public interface PoliticalPartyRepo extends CrudRepository<PoliticalParty, String> {
}
