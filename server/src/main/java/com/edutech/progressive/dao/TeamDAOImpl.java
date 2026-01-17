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
    public int addTeam(Team team) { return -1; }

    @Override
    public Team getTeamById(int teamId) { return null; }

    @Override
    public void updateTeam(Team team) { }

    @Override
    public void deleteTeam(int teamId) { }

    @Override
    public List<Team> getAllTeams() { return new ArrayList<>(); }




}
