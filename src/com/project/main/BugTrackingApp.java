package com.project.main;

import java.sql.SQLException;
import java.util.Scanner;
import com.project.Dao.*;
import com.project.Util.DBConnectionUtil;
import com.project.bean.Team;
import com.project.bean.User;

public class  BugTrackingApp
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		while (choice != 3) {
			System.out.println("*******Bug Tracking System*******");
			System.out.println("-------------------------------------");
			System.out.println();
			System.out.println("Enter your choice");
			System.out.println("   ------------  ");
			System.out.println("1 ---> Register");
			System.out.println("2 ---> update");
			choice = sc.nextInt();
			UserDAO userservices=null;
			TeamDAO teamdao = null;
			
			
			try {
				teamdao = new TeamDAOImpl(DBConnectionUtil.getConnection());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				
				userservices = new UserDAOImpl(DBConnectionUtil.getConnection());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			switch (choice) {
			case 1: {
				
				User newuser=new User(sc.nextInt(),sc.next(),sc.next(),sc.next());
				
				System.out.println("Enter Userid,username,email,usertype");
				
				
				userservices.addUser(newuser);
				break;

 
			}
			case 2: {
				System.out.println("update user");
			
				
				User updateduser=new User(sc.nextInt(),sc.next(),sc.next(),sc.next());
				
				System.out.println("Enter Userid,username,email,usertype");
				
				
				userservices.updateUser(updateduser);
				break;
			}
			case 3:
			{
				System.out.println("delete user");
				System.out.println("enter user id");
				int userid=sc.nextInt();
				userservices.deleteUser(userid);
				break;
			}
			case 4:
			{
				Team team=new Team();
				teamdao.addTeam( team);
				int teamid=sc.nextInt();
				teamdao.deleteTeam(teamid);
				
				
			}
			}

		}
		sc.close();
	}
}