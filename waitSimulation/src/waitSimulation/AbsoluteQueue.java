package waitSimulation;

public class AbsoluteQueue extends Queue
{
	private int numberOfCustomers;
	public AbsoluteQueue()
	{
		super();
		numberOfCustomers = 0;
	}
	public int getNumberOfCustomers() {
		return numberOfCustomers;
	}
	public void setNumberOfCustomers(int numberOfCustomers) {
		this.numberOfCustomers = numberOfCustomers;
	}

	public void joinQueue(Customer customerToAdd, Queue relativeQueue)
	{
		if(numberOfCustomers < 5 )
		{
			super.joinQueue(customerToAdd);
			numberOfCustomers++;
		}
		else
		{
			customerToAdd.setPriorityType(Priority.RELATIVE);
			relativeQueue.joinQueue(customerToAdd);
		}
	}
	public void proceed(Stations stationsArray)
	{
		if(!stationsArray.isFull())
		{
			super.proceed(stationsArray);
		}
		if(stationsArray.isFull())
		{
			int index 
		}
	}
	
	
}
