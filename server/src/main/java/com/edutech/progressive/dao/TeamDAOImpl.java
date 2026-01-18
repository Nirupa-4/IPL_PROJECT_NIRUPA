package com.edutech.progressive.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.config.DatabaseConnectionManager;
import com.edutech.progressive.entity.Team;

public class TeamDAOImpl implements TeamDAO{




 @Override
    public int addTeam(Team t) throws SQLException {
        String sql = "INSERT INTO team (team_name, location, owner_name, establishment_year) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, t.getTeamName());
            ps.setString(2, t.getLocation());
            ps.setString(3, t.getOwnerName());
            ps.setInt(4, t.getEstablishmentYear());

            int affected = ps.executeUpdate();
            if (affected == 0) throw new SQLException("Inserting team failed, no rows affected.");

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) return rs.getInt(1);
                throw new SQLException("Inserting team failed, no ID obtained.");
            }
        }
    }

    @Override
    public Team getTeamById(int teamId) throws SQLException {
        String sql = "SELECT team_id, team_name, location, owner_name, establishment_year FROM team WHERE team_id = ?";
        try (Connection conn = DatabaseConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, teamId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return mapRow(rs);
                return null;
            }
        }
    }

    @Override
    public void updateTeam(Team t) throws SQLException {
        String sql = "UPDATE team SET team_name=?, location=?, owner_name=?, establishment_year=? WHERE team_id=?";
        try (Connection conn = DatabaseConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, t.getTeamName());
            ps.setString(2, t.getLocation());
            ps.setString(3, t.getOwnerName());
            ps.setInt(4, t.getEstablishmentYear());
            ps.setInt(5, t.getTeamId());
            ps.executeUpdate();
        }
    }

    @Override
    public void deleteTeam(int teamId) throws SQLException {
        String sql = "DELETE FROM team WHERE team_id = ?";
        try (Connection conn = DatabaseConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, teamId);
            ps.executeUpdate();
        }
    }

    @Override
    public List<Team> getAllTeams() throws SQLException {
        String sql = "SELECT team_id, team_name, location, owner_name, establishment_year FROM team";
        List<Team> list = new ArrayList<>();
        try (Connection conn = DatabaseConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) list.add(mapRow(rs));
        }
        return list;
    }

    private Team mapRow(ResultSet rs) throws SQLException {
        Team t = new Team();
        t.setTeamId(rs.getInt("team_id"));
        t.setTeamName(rs.getString("team_name"));
        t.setLocation(rs.getString("location"));
        t.setOwnerName(rs.getString("owner_name"));
        t.setEstablishmentYear(rs.getInt("establishment_year"));
        return t;
    }





}
