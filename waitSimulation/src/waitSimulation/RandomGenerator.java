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
		int randomNumber = randomGeneration();
		int serviceDuration;
		if(randomNumber<2)
		{
			serviceDuration = 1;
		}
		else
		{
			if(randomNumber<5)
			{
				serviceDuration = 2;
			}
			else
			{
				if(randomNumber<7)
				{
					serviceDuration = 3;
				}
				else
				{
					if(randomNumber<18)
					{
						serviceDuration = 4;
					}
					else
					{
						if(randomNumber<35)
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
		int randomNumber = randomGeneration();
		int arrivalsNumber;
		if(randomNumber<5)
		{
			arrivalsNumber = 0;
		}
		else
		{
			if(randomNumber<7)
			{
				arrivalsNumber = 1;
			}
			else
			{
				if(randomNumber<10)
				{
					arrivalsNumber = 2;
				}
				else
				{
					if(randomNumber<38)
					{
						arrivalsNumber = 3;
					}
					else
					{
						if(randomNumber<50)
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
}
