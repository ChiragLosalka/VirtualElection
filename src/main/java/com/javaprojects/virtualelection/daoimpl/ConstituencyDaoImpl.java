package com.javaprojects.virtualelection.daoimpl;

import com.javaprojects.virtualelection.dao.ConstituencyDao;
import com.javaprojects.virtualelection.model.Constituency;
import com.javaprojects.virtualelection.repository.ConstituencyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ConstituencyDaoImpl implements ConstituencyDao {

    @Autowired
    ConstituencyRepo constituencyRepo;

    @Override
    public String registerConstituency(Constituency constituency) {
        try {
            constituencyRepo.save(constituency);
        }catch(Exception e) {
            e.printStackTrace();
            return "Registration Failed";
        }
        return "constituency registered successfully";
    }
}
