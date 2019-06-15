package com.javaprojects.virtualelection.serviceimpl;

import com.javaprojects.virtualelection.dao.ConstituencyDao;
import com.javaprojects.virtualelection.model.Constituency;
import com.javaprojects.virtualelection.service.ConstituencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConstituencyServiceImpl implements ConstituencyService {
    @Autowired
    ConstituencyDao constituencyDao;

    @Override
    public String registerConstituency(String constituencyName, String state) {
        Constituency constituency = new Constituency();
        constituency.setConstituencyName(constituencyName);
        constituency.setState(state);
        constituency.setCountingCompleted(false);
        return constituencyDao.registerConstituency(constituency);
    }
}
