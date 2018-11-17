//Name: Cynthia Mo
//UFL ID: 04938124
//Section: 2296
//Project Number: 5
//Brief description of file contents: Project 5

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class UndergraduateStudent extends Student
{
	private String major;
	
	public String getMajor()
	{
		return major;
	}
	
	public void setMajor(String major)
	{
		this.major = major; 
	}
	
	public void writeToFile()
	{
		//received help from student: Jack Altman

		String fileName = getId() + "_graded.txt";
		
		File file = new File(fileName);
		
		try 
		{
			PrintWriter output = new PrintWriter(file);

			output.println("Undergraduate Student\r\n" + getName());
			//received help from student: Jack Altman

			output.println("Student ID: " + getId());
			output.println("Major: " + getMajor());
			output.println(getPrintableErrorList());

			output.close();
		}
		
		catch (FileNotFoundException ex)
		{
			ex.printStackTrace();
		}
	}
	
	UndergraduateStudent(String name, String id, String essay, ArrayList<String> errorList, String major)
	{
		super(name, id, essay, errorList);
		setName(name);
		setId(id);
		setEssay(essay);
		setErrorList(errorList);
		
		this.major = major; 
	}
}
