//Imports for sorting
import java.util.Collections;

//A PersonSet that keeps its Persons in alphabetical order by name
public class PersonOrderedSet extends PersonSet
{
	//Adds the Person (super.add skips duplicates), then re-sorts the list
	@Override
	public void add(Person p)
	{
		super.add(p);
		sort();
	}

	//Sorts the people list using Person's compareTo method
	private void sort()
	{ 
		Collections.sort(people);
	}
}
