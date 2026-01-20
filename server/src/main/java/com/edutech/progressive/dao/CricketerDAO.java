package com.edutech.progressive.dao;

import com.edutech.progressive.entity.Cricketer;

<<<<<<< HEAD
import java.util.List;

public interface CricketerDAO {
    int addCricketer(Cricketer cricketer);
    Cricketer getCricketerById(int cricketerId);
    void updateCricketer (Cricketer cricketer);
    void deleteCricketer (int cricketerId);
    List<Cricketer> getAllCricketers();
=======
import java.sql.SQLException;
import java.util.List;

public interface CricketerDAO {
    int addCricketer(Cricketer cricketer)throws SQLException;
    Cricketer getCricketerById(int cricketerId) throws SQLException;
    void updateCricketer (Cricketer cricketer)throws SQLException;
    void deleteCricketer (int cricketerId)throws SQLException;
    List<Cricketer> getAllCricketers()throws SQLException;
>>>>>>> 796021ca5a16653a2609e2762566a4cc182be9f4
}