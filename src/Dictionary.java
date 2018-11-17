//Name: Cynthia Mo
//UFL ID: 04938124
//Section: 2296
//Project Number: 5
//Brief description of file contents: Project 5

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary 
{
	private ArrayList<String> dictionary = new ArrayList<String>();
	
	public int getVocabularySize()
	{
		return dictionary.size();
	}
	
	public boolean loadDictionaryFromFile(String filePath)
	{
		boolean a;
		File dictionary2 = new File(filePath);
		
		if(dictionary2.exists())
		{
			try
			{
				//received help from student: Nicolas Kungik
				
				Scanner in = new Scanner(dictionary2);
				while (in.hasNext())
				{
					dictionary.add(in.next());
				}
				
				//end help from student: Nicolas Kungik
				
				in.close();
			}
			
			catch (FileNotFoundException ex)
			{
				ex.printStackTrace();
			}
			 
			a = true;
		}
		
		else
		{
			a = false;
		}
		System.out.println(dictionary.size());
		return a; 
	}
	
	public boolean isWord(String word)
	{
		boolean b = false; 
		
		//received help from student: Jack Altman
		
		for (int i = 0; i < dictionary.size(); i++)
		{
			if(word.equalsIgnoreCase(dictionary.get(i)))
			{
				b = true; 
				break;
			}
			
		}
		//end help from student: Jack Altman

		return b;
	}
}
