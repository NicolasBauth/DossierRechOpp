package waitSimulation;

public class Simulation 
{
	

	public static void main(String[] args) 
	{	
		RandomGenerator randomGenerator = new RandomGenerator();
		int NB_STATIONS_MIN = 15;
		int NB_STATIONS_MAX = 30;
		int nbStations = NB_STATIONS_MIN;
		double rng;
		while(nbStations<100)
		{
			rng=randomGenerator.getRandomNumberZeroToOne();
			System.out.println(rng);
			nbStations++;
		}
	}

}
