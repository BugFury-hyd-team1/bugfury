package com.project.Dao;

import java.util.List;

import com.project.bean.Bug;

public interface BugDAO {
    Bug getBugById(int bugId);
    List<Bug> getAllBugs();
    boolean addBug(Bug bug);
    boolean updateBug(Bug bug);
    boolean deleteBug(int bugId);
}
