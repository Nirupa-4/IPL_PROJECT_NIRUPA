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
    public int addMatch(Match m) throws SQLException {
        String sql = "INSERT INTO matches (first_team_id, second_team_id, match_date, venue, result, status, winner_team_id) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, m.getFirstTeamId());
            ps.setInt(2, m.getSecondTeamId());
            ps.setDate(3, new java.sql.Date(m.getMatchDate().getTime()));
            ps.setString(4, m.getVenue());
            ps.setString(5, m.getResult());
            ps.setString(6, m.getStatus());
            if (m.getWinnerTeamId() == 0) ps.setNull(7, Types.INTEGER);
            else ps.setInt(7, m.getWinnerTeamId());

            int affected = ps.executeUpdate();
            if (affected == 0) throw new SQLException("Inserting match failed.");

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) return rs.getInt(1);
                throw new SQLException("Inserting match failed, no ID obtained.");
            }
        }
    }

    @Override
    public Match getMatchById(int matchId) throws SQLException {
        String sql = "SELECT match_id, first_team_id, second_team_id, match_date, venue, result, status, winner_team_id FROM matches WHERE match_id = ?";
        try (Connection conn = DatabaseConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, matchId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return mapRow(rs);
                return null;
            }
        }
    }

    @Override
    public void updateMatch(Match m) throws SQLException {
        String sql = "UPDATE matches SET first_team_id=?, second_team_id=?, match_date=?, venue=?, result=?, status=?, winner_team_id=? WHERE match_id=?";
        try (Connection conn = DatabaseConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, m.getFirstTeamId());
            ps.setInt(2, m.getSecondTeamId());
            ps.setDate(3, new java.sql.Date(m.getMatchDate().getTime()));
            ps.setString(4, m.getVenue());
            ps.setString(5, m.getResult());
            ps.setString(6, m.getStatus());
            if (m.getWinnerTeamId() == 0) ps.setNull(7, Types.INTEGER);
            else ps.setInt(7, m.getWinnerTeamId());
            ps.setInt(8, m.getMatchId());
            ps.executeUpdate();
        }
    }

    @Override
    public void deleteMatch(int matchId) throws SQLException {
        String sql = "DELETE FROM matches WHERE match_id = ?";
        try (Connection conn = DatabaseConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, matchId);
            ps.executeUpdate();
        }
    }

    @Override
    public List<Match> getAllMatches() throws SQLException {
        String sql = "SELECT match_id, first_team_id, second_team_id, match_date, venue, result, status, winner_team_id FROM matches";
        List<Match> list = new ArrayList<>();
        try (Connection conn = DatabaseConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) list.add(mapRow(rs));
        }
        return list;
    }

    private Match mapRow(ResultSet rs) throws SQLException {
        Match m = new Match();
        m.setMatchId(rs.getInt("match_id"));
        m.setFirstTeamId(rs.getInt("first_team_id"));
        m.setSecondTeamId(rs.getInt("second_team_id"));
        m.setMatchDate(new Date(rs.getDate("match_date").getTime()));
        m.setVenue(rs.getString("venue"));
        m.setResult(rs.getString("result"));
        m.setStatus(rs.getString("status"));
        int winner = rs.getInt("winner_team_id");
        if (rs.wasNull()) winner = 0;
        m.setWinnerTeamId(winner);
        return m;
    }

}
