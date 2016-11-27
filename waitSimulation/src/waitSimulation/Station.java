package waitSimulation;

public class Station 
{
	private Customer currentCustomer;
	private double stationCost;
	public Station()
	{
		currentCustomer = null;
		stationCost = 0;
	}
	public Customer getCurrentCustomer() {
		return currentCustomer;
	}
	public void setCurrentCustomer(Customer currentCustomer) {
		this.currentCustomer = currentCustomer;
	}
	public double getStationCost() {
		return stationCost;
	}
	public void setStationCost(double stationCost) {
		this.stationCost = stationCost;
	}
	public void kickCustomerToReplace(Queue relativeQueue, Customer absoluteCustomer)
	{
		currentCustomer.setPriorityType(Priority.RELATIVE);
		relativeQueue.joinQueue(currentCustomer);
		currentCustomer = absoluteCustomer;
	}
	public String toString()
	{
		String msg;
		if(currentCustomer != null)
		{
			msg = "La station est en train de servir le client "+currentCustomer+"\n";
		}
		else
		{
			msg = "La station ne sert personne pour le moment\n";
		}
		msg +="Son cout est, pour le moment, de "+stationCost+"\n";
		return msg;
	}
}
