//Name: Cynthia Mo
//UFL ID: 04938124
//Section: 2296
//Project Number: 5
//Brief description of file contents: Project 5

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class GraduateStudent extends Student
{
	private String major;
	private String advisor;
	
	public String getMajor()
	{
		return major; 
	}
	
	public void setMajor(String major)
	{
		this.major = major;
	}
	
	public String getAdvisor()
	{
		return advisor;
	}
	
	public void setAdvisor(String advisor)
	{
		this.advisor= advisor; 
	}
	
	public void writeToFile()
	{
		String fileName = getId() + "_graded.txt";
		
		File file = new File(fileName);
		
		try 
		{
			PrintWriter output = new PrintWriter(file);

			output.println("Graduate Student\r\n" + getName());
			output.println("Student ID: " + getId());
			output.println("Major: " + getMajor());
			output.println("Advisor: " + getAdvisor());
			output.println(getPrintableErrorList());
			
			output.close();
		}
		
		catch (FileNotFoundException ex)
		{
			ex.printStackTrace();
			//System.out.println("File not found");
		}	
	}
	
	GraduateStudent(String name, String id, String essay, ArrayList<String> errorList, String major, String advisor)
	{
		super(name, id, essay, errorList);
		setName(name);
		setId(id);
		setEssay(essay);
		setErrorList(errorList);
		
		this.major = major; 
		this.advisor = advisor;
	}
}
