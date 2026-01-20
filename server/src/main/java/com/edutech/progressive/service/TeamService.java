package com.edutech.progressive.service;

import com.edutech.progressive.entity.Team;

<<<<<<< HEAD
=======
import java.sql.SQLException;
>>>>>>> 796021ca5a16653a2609e2762566a4cc182be9f4
import java.util.List;

public interface TeamService {

<<<<<<< HEAD
    List<Team> getAllTeams();

    int addTeam(Team team);

    List<Team> getAllTeamsSortedByName();

    default void emptyArrayList() {
    }

    //Do not implement these methods in TeamServiceImplArrayList.java class
    default Team getTeamById(int teamId) {
        return null;
    }

    default void updateTeam(Team team) {}

    default void deleteTeam(int teamId) {}
=======
 List<Team> getAllTeams() throws SQLException;
    int addTeam(Team team) throws SQLException;
    List<Team> getAllTeamsSortedByName() throws SQLException;

    default void emptyArrayList() { }
    default Team getTeamById(int teamId) throws SQLException { return null; }
    default void updateTeam(Team team) throws SQLException { }
    default void deleteTeam(int teamId) throws SQLException { }

>>>>>>> 796021ca5a16653a2609e2762566a4cc182be9f4

}
