package ui;

import java.io.*;
import java.nio.file.*;

import business.Product;

public class FileDemoApp {

	public static void main(String[] args) {
		System.out.println("Hello");
		
		try {
			// Define a folder on the hard drive
			String dirString = "c:/temp";
			Path dirPath = Paths.get(dirString);
			if (Files.notExists(dirPath)) {
				Files.createDirectories(dirPath);
				System.out.println("Directory successfully created!");
			}
			else {
				System.out.println("Directory already exists.");
			}
			
			// define a file within the folder
			String fileString = "products.txt";
			Path filePath = Paths.get(dirString, fileString);
			if (Files.notExists(filePath)) {
				Files.createFile(filePath);
				System.out.println(fileString+" successfully created!");
			}
			else {
				System.out.println(fileString+" NOT created.");
			}
			System.out.println("File Name:  "+filePath.getFileName());
			System.out.println("Absolute Path:  "+filePath.toAbsolutePath());
			System.out.println("Relative Is writable:  "+Files.isWritable(filePath));
			System.out.println(filePath.toString());
			
			// Print file info from a directory
			System.out.println("Files in a directory...");
			if (Files.exists(dirPath) && Files.isDirectory(dirPath)) {
				System.out.println("Directory:  "+dirPath.toAbsolutePath());
				System.out.println("Files:  ");
				DirectoryStream<Path> dirStream = Files.newDirectoryStream(dirPath);
				for (Path p: dirStream) {
					if (Files.isRegularFile(p)) {
						System.out.println("    "+p.getFileName());
					}
				}
			}
			
			// Write to the file
			Path productsPath = Paths.get("products.txt");
			// Note, this is NOT the same products.txt as 
			// the examples above!
			File productsFile = productsPath.toFile();
			
			// open an output stream
			PrintWriter out = new PrintWriter(
							  new BufferedWriter(
							  new FileWriter(productsFile)));
			// write data to the stream
			out.println("java\tMurach's Java Programming\t57.50");
			
			// close the stream to avoid a resource leak
			out.close();
			
			// open an input stream
			BufferedReader in = new BufferedReader(
								new FileReader(productsFile));
			// read date from the stream and print to console
			String line = in.readLine();
			System.out.println(line);
			
			// Bonus instruction - map this line to a Product
			String[] fields = line.split("\t");
			String code = fields[0];
			String desc = fields[1];
			double price = Double.parseDouble(fields[2]);
			
			Product p = new Product(code,desc,price);
			System.out.println(p);
			
			// close the input stream and free system resources
			in.close();
		} catch (IOException e) {
			System.out.println("Bad directory path entered.");
			e.printStackTrace();
		}	
		
		
		System.out.println("Bye");

	}

}
