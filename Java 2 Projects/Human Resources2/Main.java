/*
Name: Ethan Beach
Assignment: Human Resources Part 2
Purpose: To read a .txt file of names, heights, and weights, and creates two sets of Person objects. One set is ordered alphabetically by name, the other is converted to imperial units (inches and pounds). Each set is written to its own output file, and both are displayed on the screen.
Sources: https://www.geeksforgeeks.org/overriding-equals-method-in-java/ (I did not have much luck in getting it to work for the override.)
https://www.geeksforgeeks.org/java/java-program-to-insert-details-in-a-table-using-jdbc/ (For inserting details into a database using JDBC, and seeing how that works.)
https://stackoverflow.com/questions/8180430/how-to-override-equals-method-in-java (More on overriding equals, did not help me figure it out.)

*/

//Imported Java classes for file handling and user input
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{
		System.out.println();

		//Reads the .txt file, defaults to hr.txt if no other is found
		String fileName = "hr.txt";
		if (args.length > 0)
		{
			fileName = args[0];
		}

		//Creates a try/catch block to handle potential file errors
		try
		{
			//Initializes the Scanner to read the file
			//System.out.println("Looking for: " + new File(fileName).getAbsolutePath());
			//Used for debugging, to see where the program is looking for the file. 
			Scanner fileReader = new Scanner(new File(fileName));

			//Skips the header line of the input file
			fileReader.nextLine();

			//Declared as PersonSet variables (polymorphism): each one actually
			//holds a subclass object, so add() behaves differently for each
			PersonSet orderedSet = new PersonOrderedSet();
			PersonSet imperialSet = new PersonImperialSet();

			//hasNext() is true while there is more data to read
			while (fileReader.hasNext())
			{
				//Each row is: name, height, weight
				String name = fileReader.next();
				double height = fileReader.nextDouble();
				double weight = fileReader.nextDouble();

				//Two separate Person objects, so converting one to imperial
				//doesn't also change the one in the ordered set.
				orderedSet.add(new Person(name, height, weight));
				imperialSet.add(new Person(name, height, weight));
			}

			//Closes the file reader
			fileReader.close();

			//Writes each set (header + data) to its own output file
			writeToFile("hr_ordered_set_output.txt", orderedSet);
			writeToFile("hr_imperial_set_output.txt", imperialSet);

			//Displays both sets on the screen
			System.out.println("Ordered set (alphabetical, no duplicates):");
			System.out.print(orderedSet.toFileString());
			System.out.println();
			System.out.println("Imperial set (inches and pounds, no duplicates):");
			System.out.print(imperialSet.toFileString());
		}
		catch (FileNotFoundException e)
		{
			//Throws an error if a file can't be found/created
			System.out.println("Could not find or create a file: " + e.getMessage());
			e.printStackTrace();
			System.exit(1);
		}
	}

	//Writes the header and data of any PersonSet to the named file
	//Works for both subclasses because toFileString is inherited from PersonSet
	private static void writeToFile(String outputName, PersonSet set) throws FileNotFoundException
	{
		PrintWriter writer = new PrintWriter(outputName);
		writer.print(set.toFileString());
		writer.close();
	}
}

