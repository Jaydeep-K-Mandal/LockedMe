package com.lockedme;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FileManager 
{
	/**
	 * This method will return the file names from the folder
	 * @param folderpath
	 * @return ArrayList
	 */
	public static List<String> getAllFiles(String folderpath)
	{
		//Creating file object
		File folder = new File(folderpath);
		
		//Getting all the files into file array
		File[] listOfFiles = folder.listFiles();
		
		//Declare a list to store file names
		List<String> fileNames = new ArrayList<String>();
		
		//Getting file names from array of files
		for(File f : listOfFiles)
			fileNames.add(f.getName());
		
		//return the list of file names
		return fileNames;
	}
	
	/**
	 * This method will create and append content to the file specified
	 * @param folderpath
	 * @param fileName
	 * @param content
	 * @return boolean
	 */
	public static boolean createAndWriteToFile(String folderpath, String fileName, List<String> content)
	{
		try
		{
			//Creating file and file writer object
			File file = new File(folderpath, fileName);
			FileWriter fwrite = new FileWriter(file);
			
			//Writing to file
			for(String s : content)
				fwrite.write(s+"\n");
			
			fwrite.close();
			return true;
		}
		catch(Exception ex)
		{
			return false;
		}
	}
	
	/**
	 * This method will delete the file name specified if exists
	 * @param folderpath
	 * @param fileName
	 * @return boolean
	 */
	public static boolean deleteFile(String folderpath, String fileName)
	{
		//Creating file object
		File file = new File(folderpath+"\\"+fileName);
		try
		{
			//Deleting file
			if(file.delete())
				return true;
			else
				return false;
		}
		catch(Exception ex)
		{
			return false;
		}
	}
	
	/**
	 * This method will search the file from the folder
	 * @param folderpath
	 * @param fileName
	 * @return boolean
	 */
	public static boolean searchFile(String folderpath, String fileName)
	{
		//Creating file object
		File file = new File(folderpath+"\\"+fileName);
		
		//Search condition
		if(file.exists())
			return true;
		else
			return false;
	}
	
}