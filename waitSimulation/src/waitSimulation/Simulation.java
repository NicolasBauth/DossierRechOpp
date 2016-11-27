package waitSimulation;

public class Simulation 
{
	

	public static void main(String[] args) 
	{	
		RandomGenerator randomGenerator = new RandomGenerator();
		int NB_STATIONS_MIN = 15;
		int NB_STATIONS_MAX = 30;
		int arrivalIndex, numberOfArrivals;
		Customer generatedCustomer;
		int nbStations = NB_STATIONS_MIN;
		Queue standardQueue = new Queue();
		Queue relativeQueue = new Queue();
		AbsoluteQueue absoluteQueue = new AbsoluteQueue();
		Stations stationsArray = new Stations();
		stationsArray.createStations(NB_STATIONS_MIN);
		int totalCost;
		int time;
		while(nbStations<NB_STATIONS_MAX)
		{
			totalCost = 0;
			time = 0;
			while(time < 960)
			{
				numberOfArrivals = randomGenerator.generateRandomArrivalsNumber();
				arrivalIndex = 0;
				while(arrivalIndex < numberOfArrivals)
				{
					generatedCustomer = new Customer(randomGenerator);
					if(stationsArray.getNumberOfCurrentServices() <= nbStations)
					{
						stationsArray.assignCustomer(generatedCustomer);
					}
					else
					{
						switch(generatedCustomer.getPriorityType())
						{
							case ABSOLUTE:
								stationsArray.handleAbsoluteCustomer(generatedCustomer, relativeQueue, absoluteQueue);
								break;
							case RELATIVE:
								relativeQueue.joinQueue(generatedCustomer);
								break;
							case STANDARD:
								standardQueue.joinQueue(generatedCustomer);
								
						}
					}
					arrivalIndex++;
				}
				totalCost += stationsArray.oneMinuteElapses();
				absoluteQueue.oneMinuteElapses();
				relativeQueue.oneMinuteElapses();
				standardQueue.oneMinuteElapses();
				
				time ++;
			}
			stationsArray.reinitializeStations();
			stationsArray.addStation();
			nbStations++;
			
		}
	}

}
