package com.edutech.progressive.dao;

import com.edutech.progressive.entity.Team;

<<<<<<< HEAD
import java.util.List;

public interface TeamDAO {
    int addTeam(Team team);
    Team getTeamById(int teamId);
    void updateTeam(Team team);
    void deleteTeam(int teamId) ;
    List<Team> getAllTeams();
=======
import java.sql.SQLException;
import java.util.List;

public interface TeamDAO {
    int addTeam(Team team)throws SQLException;
    Team getTeamById(int teamId)throws SQLException;
    void updateTeam(Team team)throws SQLException;
    void deleteTeam(int teamId)throws SQLException ;
    List<Team> getAllTeams()throws SQLException;
>>>>>>> 796021ca5a16653a2609e2762566a4cc182be9f4
}
