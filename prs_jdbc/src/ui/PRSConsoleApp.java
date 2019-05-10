package ui;

import java.util.List;

import business.User;
import db.DAO;
import db.UserDB;

public class PRSConsoleApp {

	public static void main(String[] args) {
		System.out.println("hello");
		
		DAO<User> userDAO = new UserDB();
		
		List<User> users = userDAO.getAll();
		for (User u: users) {
			System.out.println(u);
		}
		System.out.println("bye");

	}

}
