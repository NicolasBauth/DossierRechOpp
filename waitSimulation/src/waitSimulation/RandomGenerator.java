package waitSimulation;


public class RandomGenerator 
{
	private int a;
	private int c;
	private int previousGenerated;
	private int m;
	public RandomGenerator()
	{
		a = 69069;
		c = 0;
		previousGenerated = 292;
		m = Integer.MAX_VALUE +1;
	}
	public int randomGeneration()
	{
		int rng = ((a * previousGenerated) + c)%m;
		previousGenerated = rng;
		return rng;
	}
	public double getRandomNumberZeroToOne()
	{
		int rng =randomGeneration();
		double result = (double)rng/m;
		if(result < 0)
		{
			result = result *(-1);
		}
		return result;
	}
	public int generateRandomServiceDuration()
	{
		double randomNumber = getRandomNumberZeroToOne();
		int serviceDuration;
		double limite1 = (double)2/57;
		double limite2 = (double)5/57;
		double limite3 = (double)7/57;
		double limite4 = (double)18/57;
		double limite5 = (double)35/57;
		if(randomNumber<limite1)
		{
			serviceDuration = 1;
		}
		else
		{
			if(randomNumber<limite2)
			{
				serviceDuration = 2;
			}
			else
			{
				if(randomNumber<limite3)
				{
					serviceDuration = 3;
				}
				else
				{
					if(randomNumber<limite4)
					{
						serviceDuration = 4;
					}
					else
					{
						if(randomNumber<limite5)
						{
							serviceDuration = 5;
						}
						else
						{
							serviceDuration = 6;
						}
					}
				}
			}
		}
		
		return serviceDuration;
	}
	public int generateRandomArrivalsNumber()
	{
		double randomNumber = getRandomNumberZeroToOne();
		double limite1 = (double)5/57;
		double limite2 = (double)7/57;
		double limite3 = (double)10/57;
		double limite4 = (double)38/57;
		double limite5 = (double)50/57;
		int arrivalsNumber;
		if(randomNumber<limite1)
		{
			arrivalsNumber = 0;
		}
		else
		{
			if(randomNumber<limite2)
			{
				arrivalsNumber = 1;
			}
			else
			{
				if(randomNumber<limite3)
				{
					arrivalsNumber = 2;
				}
				else
				{
					if(randomNumber<limite4)
					{
						arrivalsNumber = 3;
					}
					else
					{
						if(randomNumber<limite5)
						{
							arrivalsNumber = 4;
						}
						else
						{
							arrivalsNumber = 5;
						}
					}
				}
			}
		}
		
		return arrivalsNumber;
	}
	Priority generateRandomPriorityType()
	{
		double randomNumber = getRandomNumberZeroToOne();
		if(randomNumber < 0.3)
		{
			return Priority.ABSOLUTE;
		}
		else
		{
			if(randomNumber < 0.4)
			{
				return Priority.RELATIVE;
			}
			else
			{
				return Priority.STANDARD;
			}
		}
		
	}
}
