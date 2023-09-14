package com.project.Service;

import java.util.List;

import com.project.Dao.BugDAO;
import com.project.Exception.BugNotFoundException;
import com.project.Exception.BugServiceException;
import com.project.bean.Bug;

public class BugServiceImpl implements BugService {
	 private BugDAO bugDAO;

	    public BugServiceImpl(BugDAO bugDAO) {
	        this.bugDAO = bugDAO;
	    }

	@Override
	public Bug getBugById(int bugId) throws BugServiceException {
		try {
            Bug bug = bugDAO.getBugById(bugId);
            if (bug == null) {
                throw new BugNotFoundException(bugId);
            }
            return bug;
        } catch (Exception e) {
          
            throw new BugServiceException();
        }
	}

	@Override
	public List<Bug> getAllBugs() throws BugServiceException {
		 try {
	            return bugDAO.getAllBugs();
	        } catch (Exception e) {
	            // Handle exceptions or log errors as needed
	            e.printStackTrace();
	            throw new BugServiceException();
	        }
	}

	@Override
	public boolean addBug(Bug bug) throws BugServiceException {
		try {
            // You can add validation logic here before calling the DAO
            // For example, check if the bug description is not empty
            if (bug.getDescription() != null && !bug.getDescription().isEmpty()) {
                return bugDAO.addBug(bug);
            } else {
                throw new BugServiceException();
            }
        } catch (Exception e) {
            // Handle exceptions or log errors as needed
            e.printStackTrace();
            throw new BugServiceException();
        }
	}

	@Override
	public boolean updateBug(Bug bug) throws BugServiceException {
		 try {
	            // You can add validation logic here before calling the DAO
	            // For example, check if the bug description is not empty
	            if (bug.getDescription() != null && !bug.getDescription().isEmpty()) {
	                return bugDAO.updateBug(bug);
	            } else {
	                throw new BugServiceException();
	            }
	        } catch (Exception e) {
	            // Handle exceptions or log errors as needed
	            e.printStackTrace();
	            throw new BugServiceException();
	        }
	}

	@Override
	public boolean deleteBug(int bugId) throws BugServiceException {
		try {
            // You can add additional logic here, such as checking if the bug is associated with any projects
            return bugDAO.deleteBug(bugId);
        } catch (Exception e) {
            // Handle exceptions or log errors as needed
            e.printStackTrace();
            throw new BugServiceException();
        }
	}

}
