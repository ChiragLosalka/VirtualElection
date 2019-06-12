package com.javaprojects.virtualelection.repository;

import com.javaprojects.virtualelection.model.Constituency;
import org.springframework.data.repository.CrudRepository;

public interface ConstituencyRepo extends CrudRepository<Constituency, String> {
}
