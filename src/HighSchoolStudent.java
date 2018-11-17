//Name: Cynthia Mo
//UFL ID: 04938124
//Section: 2296
//Project Number: 5
//Brief description of file contents: Project 5

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class HighSchoolStudent extends Student
{
	private String nameOfSchool;
	
	public String getSchoolName()
	{
		return nameOfSchool;
	}
	
	public void setSchoolName(String schoolName)
	{
		nameOfSchool = schoolName;
	}
	
	public void writeToFile()  
	{
		//received help from student: Nicolas Kungik

		String fileName = getId() + "_graded.txt";
		
		File file = new File(fileName);
		
		try 
		{
			PrintWriter output = new PrintWriter(file);

			output.println("High School Student\r\n " + getName());
			output.println("Student ID: " + getId());
			output.println("School Name: " + getSchoolName());
			output.println(getPrintableErrorList());
			
			output.close();
		}
		
		//end help from student: Nicolas Kungik 
		
		catch (FileNotFoundException ex)
		{
			ex.printStackTrace();
			System.out.println("File not found");
		}
		
	}
	
	HighSchoolStudent(String name, String id, String essay, ArrayList<String> errorList, String nameOfSchool)
	{
		super(name, id, essay, errorList);
		setName(name);
		setId(id);
		setEssay(essay);
		setErrorList(errorList);
		 
		this.nameOfSchool = nameOfSchool;
	}
}
