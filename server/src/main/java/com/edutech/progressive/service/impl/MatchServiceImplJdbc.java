package com.edutech.progressive.service.impl;

<<<<<<< HEAD
public class MatchServiceImplJdbc  {
=======
import java.sql.SQLException;
import java.util.List;

import com.edutech.progressive.dao.MatchDAO;
import com.edutech.progressive.dao.MatchDAOImpl;
import com.edutech.progressive.entity.Match;
import com.edutech.progressive.service.MatchService;

public class MatchServiceImplJdbc  implements MatchService{

 private final MatchDAO matchDAO;

    public MatchServiceImplJdbc() {
    this.matchDAO = new MatchDAOImpl();
}

    public MatchServiceImplJdbc(MatchDAO matchDAO) {
        this.matchDAO = matchDAO;
    }

    @Override
    public List<Match> getAllMatches() throws SQLException {
        return matchDAO.getAllMatches();
    }

    @Override
    public Match getMatchById(int matchId) throws SQLException {
        return matchDAO.getMatchById(matchId);
    }

    @Override
    public Integer addMatch(Match match) throws SQLException {
        return matchDAO.addMatch(match);
    }

    @Override
    public void updateMatch(Match match) throws SQLException {
        matchDAO.updateMatch(match);
    }

    @Override
    public void deleteMatch(int matchId) throws SQLException {
        matchDAO.deleteMatch(matchId);
    }
>>>>>>> 796021ca5a16653a2609e2762566a4cc182be9f4

}