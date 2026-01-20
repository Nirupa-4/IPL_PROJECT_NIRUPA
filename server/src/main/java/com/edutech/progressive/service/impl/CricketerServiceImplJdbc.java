package com.edutech.progressive.service.impl;

<<<<<<< HEAD
public class CricketerServiceImplJdbc  {
=======
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.edutech.progressive.dao.CricketerDAO;
import com.edutech.progressive.dao.CricketerDAOImpl;
import com.edutech.progressive.entity.Cricketer;
import com.edutech.progressive.service.CricketerService;

public class CricketerServiceImplJdbc implements CricketerService {

  

private final CricketerDAO cricketerDAO;
    
 public CricketerServiceImplJdbc() {
        this.cricketerDAO = new CricketerDAOImpl();
    }

    public CricketerServiceImplJdbc(CricketerDAO cricketerDAO) {
        this.cricketerDAO = cricketerDAO;
    }

    @Override
    public List<Cricketer> getAllCricketers() throws SQLException {
        return cricketerDAO.getAllCricketers();
    }

    @Override
    public Integer addCricketer(Cricketer cricketer) throws SQLException {
        return cricketerDAO.addCricketer(cricketer);
    }

    @Override
    public List<Cricketer> getAllCricketersSortedByExperience() throws SQLException {
        List<Cricketer> list = new ArrayList<>(cricketerDAO.getAllCricketers());
        Collections.sort(list);
        return list;
    }

    @Override
    public void updateCricketer(Cricketer cricketer) throws SQLException {
        cricketerDAO.updateCricketer(cricketer);
    }

    @Override
    public void deleteCricketer(int cricketerId) throws SQLException {
        cricketerDAO.deleteCricketer(cricketerId);
    }

    @Override
    public Cricketer getCricketerById(int cricketerId) throws SQLException {
        return cricketerDAO.getCricketerById(cricketerId);
    }
>>>>>>> 796021ca5a16653a2609e2762566a4cc182be9f4

}