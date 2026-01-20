package com.edutech.progressive.service;

import com.edutech.progressive.entity.Match;

<<<<<<< HEAD
=======
import java.sql.SQLException;
>>>>>>> 796021ca5a16653a2609e2762566a4cc182be9f4
import java.util.List;

public interface MatchService {

<<<<<<< HEAD
    List<Match> getAllMatches();

    Match getMatchById(int matchId);

    Integer addMatch(Match match);

    void updateMatch(Match match);

    void deleteMatch(int matchId);

    //Do not implement these methods in MatchServiceImplJdbc.java class
    default List<Match> getAllMatchesByStatus(String status) {
        return null;
    }
=======
 
List<Match> getAllMatches() throws SQLException;
    Match getMatchById(int matchId) throws SQLException;
    Integer addMatch(Match match) throws SQLException;
    void updateMatch(Match match) throws SQLException;
    void deleteMatch(int matchId) throws SQLException;

    default List<Match> getAllMatchesByStatus(String status) { return null; }

>>>>>>> 796021ca5a16653a2609e2762566a4cc182be9f4
}
