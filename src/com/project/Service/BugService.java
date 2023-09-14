package com.project.Service;

import java.util.List;

import com.project.Exception.BugServiceException;
import com.project.bean.Bug;

public interface BugService {
	 Bug getBugById(int bugId)throws BugServiceException;
	 List<Bug> getAllBugs()throws BugServiceException;
	 boolean addBug(Bug bug)throws BugServiceException;
	 boolean updateBug(Bug bug)throws BugServiceException;
	 boolean deleteBug(int bugId)throws BugServiceException;

}
