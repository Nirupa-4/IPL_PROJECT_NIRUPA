package com.edutech.progressive.service;

import com.edutech.progressive.entity.Cricketer;

<<<<<<< HEAD
=======
import java.sql.SQLException;
>>>>>>> 796021ca5a16653a2609e2762566a4cc182be9f4
import java.util.List;

public interface CricketerService {

<<<<<<< HEAD
    List<Cricketer> getAllCricketers();

    Integer addCricketer(Cricketer cricketer);

    List<Cricketer> getAllCricketersSortedByExperience();

    default void emptyArrayList() {
    }

    //Do not implement these methods in CricketerServiceImplArraylist.java class
    default void updateCricketer(Cricketer cricketer) {}

    default void deleteCricketer(int cricketerId) {}

    default Cricketer getCricketerById(int cricketerId) {
        return null;
    }

    //Do not implement these methods in CricketerServiceImplArraylist.java and CricketerServiceImplJdbc.java class
    default List<Cricketer> getCricketersByTeam(int teamId) {
        return null;
    }
=======
   
List<Cricketer> getAllCricketers() throws SQLException;
    Integer addCricketer(Cricketer cricketer) throws SQLException;
    List<Cricketer> getAllCricketersSortedByExperience() throws SQLException;

    default void emptyArrayList() { }
    default void updateCricketer(Cricketer cricketer) throws SQLException { }
    default void deleteCricketer(int cricketerId) throws SQLException { }
    default Cricketer getCricketerById(int cricketerId) throws SQLException { return null; }
    default List<Cricketer> getCricketersByTeam(int teamId) { return null; }
>>>>>>> 796021ca5a16653a2609e2762566a4cc182be9f4

}
