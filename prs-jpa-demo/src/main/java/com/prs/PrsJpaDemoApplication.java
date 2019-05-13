package com.prs;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.prs.business.Product;
import com.prs.business.User;
import com.prs.business.Vendor;
import com.prs.db.ProductDB;
import com.prs.db.UserDB;
import com.prs.db.VendorDB;
import com.prs.util.Console;

@SpringBootApplication
public class PrsJpaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrsJpaDemoApplication.class, args);
		System.out.println("Hello");
		
		
		String choice = "";
		while (!choice.equalsIgnoreCase("exit")) {
			displayMenu();
			choice = Console.getRequiredString("Option?:");
			if (choice.equalsIgnoreCase("user")) {
				// list users
				List<User> users = UserDB.getAll();
				
				if (users!=null) {
					for (User u:  users) {
						System.out.println(u);
					}
				}
				else  {
					System.out.println("users null");
				}
				
			}
			else if (choice.equalsIgnoreCase("vendor")) {
				// list vendors
				List<Vendor> vendors = VendorDB.getAll();
				
				if (vendors!=null) {
					for (Vendor v:  vendors) {
						System.out.println(v);
					}
				}
				else  {
					System.out.println("vendors null");
				}
				
			}
			else if (choice.equalsIgnoreCase("product")) {
				// list products
				List<Product> products = ProductDB.getAll();
				
				if (products!=null) {
					for (Product p:  products) {
						System.out.println(p);
					}
				}
				else  {
					System.out.println("products null");
				}
				
			}
		}
		String uname = Console.getRequiredString("Username: ");
		String pwd = Console.getRequiredString("Pwd:  ");
		String fname = Console.getRequiredString("First Name:  ");
		String lname = Console.getRequiredString("Last Name:  ");
		String phone = Console.getRequiredString("Phone:  ");
		String email = Console.getRequiredString("Email:  ");
		
		User usr = new User(uname,pwd,fname,lname,phone,email,true,true);
		if (UserDB.add(usr)) {
			System.out.println("User added");
		}
		else {
			System.out.println("Error adding user");
		}
		
		
		System.out.println("Bye");
	}

	private static void displayMenu() {
		System.out.println("Options:");
		System.out.println("User:\t\tList Users");
		System.out.println("Vendor:\t\tList Vendors");
		System.out.println("Product:\tList Products");
		System.out.println("Exit:\t\tExit App");
	}
}
