//A PersonSet that stores heights in inches and weights in pounds
public class PersonImperialSet extends PersonSet
{
	private static final double CM_PER_INCH = 2.54;
	private static final double POUNDS_PER_KG = 2.20462;

	//Converts the Person from metric to imperial, then lets PersonSet.add
	//check for duplicates and store it.
	
	@Override
	public void add(Person p)
	{
		p.setHeight(convertHeight(p.getHeight()));
		p.setWeight(convertWeight(p.getWeight()));
		super.add(p);
	}

	//Centimeters -> inches
	private double convertHeight(double height)
	{
		return height / CM_PER_INCH;
	}

	//Kilograms -> pounds
	private double convertWeight(double weight)
	{
		return weight * POUNDS_PER_KG;
	}

	//Overrides the header so the units are labeled correctly
	@Override
	public String getHeader()
	{
		return "Name\tHeight (in)\tWeight (lb)";
	}
}
