/*
Name: Ethan Beach
Assignment: Human Resources Part 1/2
Purpose: apply inheritance to objects,implement an interface,apply polymorphism to the class hierarchy,read data from file and create new output files 
Sources: https://www.geeksforgeeks.org/overriding-equals-method-in-java/ (I did not have much luck in getting it to work for the override.)
https://www.geeksforgeeks.org/java/java-program-to-insert-details-in-a-table-using-jdbc/ (For inserting details into a database using JDBC, and seeing how that works.)
https://stackoverflow.com/questions/8180430/how-to-override-equals-method-in-java (More on overriding equals, did not help me figure it out.)
Notes: I am trying to teach my step-son a bit of good coding practices, so this is commented more detailed than normal in places so he can see how some things work (and learns to comment) 
as he learns some early object-oriented concepts in Python. I will clean that up with Part 2.

Q1: Car and Engine are related
by which, Inheritance or Composition?
A1: Composition. A Car HAS an Engine 

Q2: Color and Red are related
by which, Inheritance or Composition?
A2: Inheritance. Red IS a Color 

Q3: Shirt and Clothing are related
by which, Inheritance or Composition?
A3: Inheritance. A Shirt IS a piece of Clothing

Q4: Furniture and Desk are related
by which, Inheritance or Composition?
A4: Inheritance. A Desk IS a piece of Furniture 

Q5: CellPhone and Battery are related
by which, Inheritance or Composition?
A5: Composition. A CellPhone HAS a Battery 

Quick rule of thumb: if you can say "X is a Y", use inheritance.
If you can say "X has a Y", use composition. --I found this online, summed up from several stack Overflow explanations. 
*/

//Imported Java classes for file handling and user input
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main
{
	
	public static void main(String[] args)
	{
		System.out.println();

		//Test 1: create a single Person
		//"new Person" calls the constructor to build the object
		Person testPerson = new Person("Test Person", 170.0, 65.0);
		System.out.println("Test Person object:");
		//println automatically calls the Person's toString method.
		System.out.println(testPerson);
		System.out.println();

		//Test 2: Creates the PersonSet, adding the same person twice to block duplicates
		PersonSet testSet = new PersonSet();
		
		testSet.add(testPerson);
		testSet.add(testPerson);
		System.out.println("Test PersonSet (added the same person twice):");
		System.out.print(testSet); // only one line should appear
		System.out.println();

		
		//Reads the .txt file, defaults to hr.txt if no other is found
		String fileName = "hr.txt";
		if (args.length > 0)
		{
			fileName = args[0];
		}

		//Creates a try/catch block to handle potential file reading errors
		try
		{
			//Initializes the Scanner to read the file
			Scanner fileReader = new Scanner(new File(fileName));

			fileReader.nextLine();

			//This set will hold everyone from the file, with no duplicates
			PersonSet hrSet = new PersonSet();

			//hasNext() is true while there is more data to read.
			System.out.println("Raw data from " + fileName + ":");
			while (fileReader.hasNext())
			{
				//Each row is: name, height, weight. The Scanner splits
				//on whitespace (spaces/tabs), so each call grabs the
				//next item and converts it to the right type
				String name = fileReader.next();
				double height = fileReader.nextDouble();
				double weight = fileReader.nextDouble();

				//Builds a Person from this row
				Person p = new Person(name, height, weight);

				//Display every row exactly as it appears in the file (duplicates included)
				System.out.println(p);

				//Adds to the set, ignoring duplicates
				hrSet.add(p);
			}

			//Closes the file reader (good practice)
			fileReader.close();

			//Shows the de-duplicated version
			System.out.println();
			System.out.println("Same data with duplicates removed:");
			System.out.print(hrSet);
		}
		catch (FileNotFoundException e)
		{
			//Throws an error if file not found
			System.out.println("Could not find the file: " + fileName);
			e.printStackTrace();
			System.exit(1);
		}
	}
}

