package com.project.Dao;

import java.util.List;
import java.util.stream.Stream;

import com.project.bean.Team;
import com.project.bean.User;

public interface TeamDAO {
	Team getTeamById(int teamId);
    List<Team> getAllTeams();
    boolean addTeam(Team team);
    boolean updateTeam(Team team);
    boolean deleteTeam(int teamId);
    List<User> getTeamMembers(int teamId);
    boolean addTeamMember(int teamId, User user);
    boolean removeTeamMember(int teamId, User user);
}
