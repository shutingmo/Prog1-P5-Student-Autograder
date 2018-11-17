//Name: Cynthia Mo
//UFL ID: 04938124
//Section: 2296
//Project Number: 5
//Brief description of file contents: Project 5

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Grader 
{
	private boolean available;
	private Student student;
	private Dictionary dict;

	public Grader(Dictionary dict)
	{
		this.dict = dict;
		
	}
	
	public boolean gradeStudent(String fileName)
	{
		
		Scanner in = null;
		ArrayList<String> errorList = new ArrayList<String>();
		String studentType = "";
		String name = "";
		String nameOfSchool = "";
		String id = "";
		String major = "";
		String advisor = "";
		boolean studentGraded = true; 
		File x = null;
		
		try
		{
			 x = new File(fileName + ".txt");

			in = new Scanner(x);
			
			
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			available = false; 
			studentGraded = false;
			reset();
			
		}
		//received help from student: Jack Altman

		studentType = in.next() + " " + in.next();
		in.nextLine();
		name = in.nextLine();
		id = in.nextLine();

		if (studentType.equals("HighSchool Student"))
		{
			nameOfSchool = in.nextLine();
			
			boolean b = false; 
			
			
			while(in.hasNext())
			{
				String word = in.next();
				
				if(word.charAt(word.length()-1) == '?')
				{
					word = word.substring(0, word.length()-1);
				}
				
				else if(word.charAt(word.length()-1) == '!')
				{
					word = word.substring(0, word.length()-1);
				}
				
				else if(word.charAt(word.length()-1) == '.')
				{
					word = word.substring(0, word.length()-1);
				}
				
				else if(word.charAt(word.length()-1) == ',')
				{
					word = word.substring(0, word.length()-1);
				}
				
				else if(word.charAt(word.length()-1) == ')')
				{
					word = word.substring(0, word.length()-1);
				}
				
				else if(word.charAt(word.length()-1) == '"')
				{
					word = word.substring(0, word.length()-1);
				}
				
				else if(word.charAt(word.length()-1) == '/')
				{
					word = word.substring(0, word.length()-1);
				}
				
				else if(word.charAt(word.length()-1) == ';')
				{
					word = word.substring(0, word.length()-1);
				}
				
				if(!dict.isWord(word))
				{
					errorList.add(word);
				}
			}
			
			
			student = new HighSchoolStudent(name, id, x.toString(), errorList, nameOfSchool);
		}
		
		//end help from student: Jack Altman
		else if (studentType.equals("Undergraduate Student"))
		{
			major = in.nextLine();
			boolean b = false; 
			
			while(in.hasNext())
			{
				String word = in.next();
				
				if(word.charAt(word.length()-1) == '?')
				{
					word = word.substring(0, word.length()-1);
				}
				
				else if(word.charAt(word.length()-1) == '!')
				{
					word = word.substring(0, word.length()-1);
				}
				
				else if(word.charAt(word.length()-1) == '.')
				{
					word = word.substring(0, word.length()-1);
				}
				
				else if(word.charAt(word.length()-1) == ',')
				{
					word = word.substring(0, word.length()-1);
				}
				
				else if(word.charAt(word.length()-1) == ')')
				{
					word = word.substring(0, word.length()-1);
				}
				
				else if(word.charAt(word.length()-1) == '"')
				{
					word = word.substring(0, word.length()-1);
				}
				
				else if(word.charAt(word.length()-1) == '/')
				{
					word = word.substring(0, word.length()-1);
				}
				
				else if(word.charAt(word.length()-1) == ';')
				{
					word = word.substring(0, word.length()-1);
				}
				
				if(!dict.isWord(word))
				{
					errorList.add(word);
				}
			}
			
			student = new UndergraduateStudent(name, id, x.toString(), errorList, major);
			
		}
		
		else if (studentType.equals("Graduate Student"))
		{
			major = in.nextLine();
			advisor = in.nextLine();
			
			boolean b = false; 
						
			while(in.hasNext())
			{
				String word = in.next();
				
				if(word.charAt(word.length()-1) == '?')
				{
					word = word.substring(0, word.length()-1);
				}
				
				else if(word.charAt(word.length()-1) == '!')
				{
					word = word.substring(0, word.length()-1);
				}
				
				else if(word.charAt(word.length()-1) == '.')
				{
					word = word.substring(0, word.length()-1);
				}
				
				else if(word.charAt(word.length()-1) == ',')
				{
					word = word.substring(0, word.length()-1);
				}
				
				else if(word.charAt(word.length()-1) == ')')
				{
					word = word.substring(0, word.length()-1);
				}
				
				else if(word.charAt(word.length()-1) == '"')
				{
					word = word.substring(0, word.length()-1);
				}
				
				else if(word.charAt(word.length()-1) == '/')
				{
					word = word.substring(0, word.length()-1);
				}
				
				else if(word.charAt(word.length()-1) == ';')
				{
					word = word.substring(0, word.length()-1);
				}
				
				if(!dict.isWord(word))
				{
					errorList.add(word);
				}
			}
						
			student = new GraduateStudent(name, id, x.toString(), errorList, major, advisor);
			
		}
		
		return studentGraded;
	}
	
	public boolean isAvailable()
	{
		if (student == null)
		{
			available = true;
			return available; 
		}
		
		else
		{
			return false; 
		}
	}
	
	public Student getStudent()
	{
		return student;
	}
	
	public void reset()
	{
		available = true;
		student = null; 
	}
}
