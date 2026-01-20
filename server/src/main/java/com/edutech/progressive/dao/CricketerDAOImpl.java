package com.edutech.progressive.dao;

<<<<<<< HEAD
public class CricketerDAOImpl {
=======
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.config.DatabaseConnectionManager;
import com.edutech.progressive.entity.Cricketer;

public class CricketerDAOImpl implements CricketerDAO {


  @Override
    public int addCricketer(Cricketer c) throws SQLException {
        String sql = "INSERT INTO cricketer (team_id, cricketer_name, age, nationality, experience, role, total_runs, total_wickets) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, c.getTeamId());
            ps.setString(2, c.getCricketerName());
            ps.setInt(3, c.getAge());
            ps.setString(4, c.getNationality());
            ps.setInt(5, c.getExperience());
            ps.setString(6, c.getRole());
            ps.setInt(7, c.getTotalRuns());
            ps.setInt(8, c.getTotalWickets());

            int affected = ps.executeUpdate();
            if (affected == 0) throw new SQLException("Inserting cricketer failed, no rows affected.");

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) return rs.getInt(1);
                throw new SQLException("Inserting cricketer failed, no ID obtained.");
            }
        }
    }

    @Override
    public Cricketer getCricketerById(int cricketerId) throws SQLException {
        String sql = "SELECT cricketer_id, team_id, cricketer_name, age, nationality, experience, role, total_runs, total_wickets " +
                     "FROM cricketer WHERE cricketer_id = ?";
        // explicit try-catch-finally to satisfy Day 3 requirement
        Connection conn = null; PreparedStatement ps = null; ResultSet rs = null;
        try {
            conn = DatabaseConnectionManager.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, cricketerId);
            rs = ps.executeQuery();
            if (rs.next()) return mapRow(rs);
            return null;
        } catch (SQLException e) {
            System.err.println("getCricketerById failed: " + e.getMessage());
            throw e;
        } finally {
            closeQuietly(rs); closeQuietly(ps); closeQuietly(conn);
        }
    }

    @Override
    public void updateCricketer(Cricketer c) throws SQLException {
        String sql = "UPDATE cricketer SET team_id=?, cricketer_name=?, age=?, nationality=?, experience=?, role=?, total_runs=?, total_wickets=? " +
                     "WHERE cricketer_id=?";
        try (Connection conn = DatabaseConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, c.getTeamId());
            ps.setString(2, c.getCricketerName());
            ps.setInt(3, c.getAge());
            ps.setString(4, c.getNationality());
            ps.setInt(5, c.getExperience());
            ps.setString(6, c.getRole());
            ps.setInt(7, c.getTotalRuns());
            ps.setInt(8, c.getTotalWickets());
            ps.setInt(9, c.getCricketerId());
            ps.executeUpdate();
        }
    }

    @Override
    public void deleteCricketer(int cricketerId) throws SQLException {
        String sql = "DELETE FROM cricketer WHERE cricketer_id = ?";
        try (Connection conn = DatabaseConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, cricketerId);
            ps.executeUpdate();
        }
    }

    @Override
    public List<Cricketer> getAllCricketers() throws SQLException {
        String sql = "SELECT cricketer_id, team_id, cricketer_name, age, nationality, experience, role, total_runs, total_wickets FROM cricketer";
        List<Cricketer> list = new ArrayList<>();
        try (Connection conn = DatabaseConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) list.add(mapRow(rs));
        }
        return list;
    }

    private Cricketer mapRow(ResultSet rs) throws SQLException {
        Cricketer c = new Cricketer();
        c.setCricketerId(rs.getInt("cricketer_id"));
        c.setTeamId(rs.getInt("team_id"));
        c.setCricketerName(rs.getString("cricketer_name"));
        c.setAge(rs.getInt("age"));
        c.setNationality(rs.getString("nationality"));
        c.setExperience(rs.getInt("experience"));
        c.setRole(rs.getString("role"));
        c.setTotalRuns(rs.getInt("total_runs"));
        c.setTotalWickets(rs.getInt("total_wickets"));
        return c;
    }

    private void closeQuietly(AutoCloseable a) {
        if (a == null) return;
        try { a.close(); } catch (Exception ignored) {}
    }

>>>>>>> 796021ca5a16653a2609e2762566a4cc182be9f4

}
