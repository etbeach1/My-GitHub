
public class Person
{
	//Creates a private string and variable for name, height, and weight.
	private String name;    // the person's name, e.g. "Mario"
	private double height;  // height in centimeters (metric)
	private double weight;  // weight in kilograms (metric)

	/*
	 * Constructor: a special method that runs when you write "new Person(...)".
	 * It has the same name as the class and no return type. Its job is to
	 * set up a brand new object with starting values.
	 */
	public Person(String name, double height, double weight)
	{
		//"this.name" assigns the attribute belonging to this object.
		this.name = name;
		this.height = height;
		this.weight = weight;
	}

	//Creates the getter for name, height, and weight.
	public String getName()
	{
		return name;
	}

	public double getHeight()
	{
		return height;
	}

	public double getWeight()
	{
		return weight;
	}

	//Setter: lets other classes CHANGE the height and weight
	//"void" means this method doesn't give anything back
	public void setHeight(double height)
	{
		this.height = height;
	}

	public void setWeight(double weight)
	{
		this.weight = weight;
	}

	//toString: returns the Person as a String in the same tab-separated
	//format as hr.txt, so it's "database-ready". Java calls this
	//automatically whenever you print a Person with System.out.println
	//"\t" is a tab character
	@Override
	public String toString()
	{
		return name + "\t" + height + "\t" + weight;
	}

	//equals: decides whether two Person objects count as "the same".
	//Without this, Java only considers two objects equal if they are the
	//exact same object in memory. We want two Persons with the same name,
	//height, and weight to be equal, so we override (replace) the default.
	//ArrayList's contains() method uses this to find duplicates.
	@Override
	public boolean equals(Object o)
	{
		//If o is null (nothing), it can't be equal to us
		if (o == null)
		{
			return false;
		}

		//If o is literally this same object, it's obviously equal
		if (o == this)
		{
			return true;
		}

		//If o isn't a Person at all (e.g. a String), it can't be equal
		if (!(o instanceof Person))
		{
			return false;
		}

		//Now we know o is a Person, so we "cast" it: we tell Java to treat
		//it as a Person so we can use Person's methods and attributes.
		Person p = (Person) o;

		//Equal only if name, height, and weight all match
		//Strings are compared with .equals(), never with ==
		//Doubles can safely be compared with == here because the values
		//come straight from the file and are never calculated
		if (this.name.equals(p.name)
				&& this.height == p.height
				&& this.weight == p.weight)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
