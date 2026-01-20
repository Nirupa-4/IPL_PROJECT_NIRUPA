package com.edutech.progressive.dao;

import com.edutech.progressive.entity.Match;

<<<<<<< HEAD
import java.util.List;

public interface MatchDAO {
    int addMatch(Match match);
    Match getMatchById(int matchId);
    void updateMatch(Match match);
    void deleteMatch(int matchId);
    List<Match> getAllMatches();
=======
import java.sql.SQLException;
import java.util.List;

public interface MatchDAO {
    int addMatch(Match match)throws SQLException;
    Match getMatchById(int matchId)throws SQLException;
    void updateMatch(Match match)throws SQLException;
    void deleteMatch(int matchId)throws SQLException;
    List<Match> getAllMatches()throws SQLException;
>>>>>>> 796021ca5a16653a2609e2762566a4cc182be9f4
}