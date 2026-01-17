package com.edutech.progressive.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.edutech.progressive.config.DatabaseConnectionManager;
import com.edutech.progressive.entity.Match;

public class MatchDAOImpl implements MatchDAO{

 @Override
    public int addMatch(Match match) { return -1; }

    @Override
    public Match getMatchById(int matchId) { return null; }

    @Override
    public void updateMatch(Match match) { }

    @Override
    public void deleteMatch(int matchId) { }

    @Override
    public List<Match> getAllMatches() { return new ArrayList<>(); }
}
