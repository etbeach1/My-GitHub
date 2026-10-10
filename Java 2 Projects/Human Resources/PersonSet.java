//Imports the ArrayList
import java.util.ArrayList;

//Creates the PersonSet class that implements the PersonList interface
public class PersonSet implements PersonList
{
	//Creates a protected ArrayList to store Person objects, called by PersonOrderedSet and
	//PersonImperialSet later
	protected ArrayList<Person> people;

	//Creates a new, empty PersonSet
	public PersonSet()
	{
		people = new ArrayList<Person>();
	}

	//Adds a Person, but only if they aren't already in the set
	@Override
	public void add(Person p)
	{
		if (!people.contains(p))
		{
			people.add(p);
		}
		//If the person is already there, does nothing
	}

	//Returns the Person at the given index (0 is the first person)
	@Override
	public Person get(int index)
	{
		return people.get(index);
	}

	/*
	 * Builds one big String of everyone in the set, one Person per line,
	 * so the whole set can be printed or written to a file at once.
	 * "\n" is a newline character (moves to the next line).
	 */
	@Override
	public String toString()
	{
		String result = "";

		// Enhanced for-loop: "for each Person p in the list people".
		for (Person p : people)
		{
			result += p.toString() + "\n";
		}

		return result;
	}
}
