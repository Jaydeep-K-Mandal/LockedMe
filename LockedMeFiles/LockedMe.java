package com.lockedme;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LockedMe 
{
	private static Scanner scan = new Scanner(System.in);

	private static final String FOLDERPATH = "C:\\Users\\Jay Deep\\Desktop\\Cohort2\\Eclipse\\src\\com\\lockedme";
	
	public static void main(String[] args) 
	{
		//Variable declaration
		int proceed = 1;
		int choice = 0;
		
		do
		{			
			welcomeScreen();
			
			try
			{
			//Read choice from user
			System.out.println("Please enter your choice:");
			choice = Integer.parseInt(scan.nextLine());
			}
			catch(Exception e)
			{
				System.out.println("Please enter valid choice between integer 1 to 5.\n");
				continue;
			}
			
			switch(choice)
			{
				case 1 : getAllFileNames();
							break;
				case 2 : addFile();
							break;
				case 3 : deleteFile();
							break;
				case 4 : searchFile();
							break;
				case 5 : System.out.println("Thank you for using the application.");
							System.exit(0);
							break;
				default : System.out.println("Invalid Option. Please enter correct choice between 1 to 5.");
			}
			
		}while(proceed != 0);
	}
	
	public static void welcomeScreen()
	{
		System.out.println("*********************************************");
		System.out.println("\t\t     LockedMe.com");
		System.out.println("\t\t Jaydeep Kumar Mandal");
		System.out.println("*********************************************\n");
		
		System.out.println("1. Display all the files");
		System.out.println("2. Add new file");
		System.out.println("3. Delete a file");
		System.out.println("4. Search a file");
		System.out.println("5. Exit\n");
		
		System.out.println("*********************************************");
	}
	
	public static void getAllFileNames()
	{
		//Variable declaration
		List<String> fileNames = FileManager.getAllFiles(FOLDERPATH);
		
		//Edge condition
		if(fileNames.size() == 0)
			System.out.println("No files in the directory.\n");
		else
			System.out.println("Below is the file list:\n");
		
		//Sorting file names in ascending order
		Collections.sort(fileNames);
		
		//Print output to console
		for(String fileName : fileNames)
			System.out.println(fileName);
		System.out.println();
	}
	
	public static void addFile()
	{
		//Variable declaration
		String fileName;
		int linesCount=0;
		boolean isAdded;
		List<String> content = new ArrayList<String>();
		
		//Read file name from user
		System.out.println("Enter file name: ");
		fileName = scan.nextLine();
		
		try
		{
			//Read number of lines from user
			System.out.println("Enter number of lines:");
			linesCount = Integer.parseInt(scan.nextLine());
		}
		catch(Exception ex)
		{
			System.out.println("Please enter only integer values. To add content to the file.\n");
			isAdded=false;
		}
		
		//Read lines from user
		for(int i = 1; i <= linesCount; i++)
		{
			System.out.println("Enter line "+i);
			content.add(scan.nextLine());
		}
		
		//Save content to file
		isAdded = FileManager.createAndWriteToFile(FOLDERPATH, fileName, content);
		
		//Print output to console
		if(isAdded)
			System.out.println("File added successfully.\n");
		else
			System.out.println("Error occured. Please try again.\n");
	}
	
	public static void deleteFile()
	{
		//Variable declaration
		String fileName;
		boolean isDeleted;
		
		//Read file name from user
		System.out.println("Enter file name to be deleted: ");
		fileName = scan.nextLine();
		
		//Check for deletion
		isDeleted = FileManager.deleteFile(FOLDERPATH, fileName);
		
		//Print output to console
		if(isDeleted)
			System.out.println("File deleted successfully.\n");
		else
			System.out.println("File not found or some access issue.\n");
	}
	
	public static void searchFile()
	{
		//Variable declaration
		String fileName;
		boolean isFound;
		
		//Read file name from user
		System.out.println("Enter file name to be searched: ");
		fileName = scan.nextLine();
		
		//Check for search result
		isFound = FileManager.searchFile(FOLDERPATH, fileName);
		
		//Print output to console
		if(isFound)
			System.out.println("File is present in the directory.\n");
		else
			System.out.println("File is not present in the directory.\n");	
	}
}