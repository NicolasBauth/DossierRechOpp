package waitSimulation;

import java.util.ArrayList;

public class Stations 
{
	private ArrayList<Station> stationsArray;
	private int numberOfCurrentServices;
	public Stations()
	{
		stationsArray = new ArrayList<Station>();
		numberOfCurrentServices = 0;
		createStations(15);
	}
	public ArrayList<Station> getStationsArray() {
		return stationsArray;
	}
	public void setStationsArray(ArrayList<Station> stationsArray) {
		this.stationsArray = stationsArray;
	}
	public int getNumberOfCurrentServices() {
		return numberOfCurrentServices;
	}
	public void setNumberOfCurrentServices(int numberOfCurrentServices) {
		this.numberOfCurrentServices = numberOfCurrentServices;
	}
	public void createStations (int numberOfStations)
	{
		int index = 0;
		while(index < numberOfStations)
		{
			stationsArray.add(new Station());
			index ++;
		}
	}
	public void addStation()
	{
		Station stationToAdd = new Station();
		stationsArray.add(stationToAdd);
	}
	public void reinitializeStations()
	{
		int index = 0;
		int size =stationsArray.size();
		while(index < size)
		{
			stationsArray.get(index).setStationCost(0);
			stationsArray.get(index).setCurrentCustomer(null);
			index ++;
		}
		numberOfCurrentServices = 0;
	}
	public void assignCustomer(Customer customerToAssign)
	{
		int index = 0;
		while(index < stationsArray.size() && stationsArray.get(index).getCurrentCustomer() != null 
				&& customerToAssign.getPriorityType().ordinal() <= stationsArray.get(index).getCurrentCustomer().getPriorityType().ordinal())
		{
			index++;
		}
		if(stationsArray.get(index).getCurrentCustomer() != null)
		{
			int indexFree = index;
			while(indexFree < stationsArray.size() && stationsArray.get(indexFree).getCurrentCustomer() != null)
			{
				indexFree++;
			}
			stationsArray.get(indexFree).setCurrentCustomer(customerToAssign);
			Station savedStation = stationsArray.get(indexFree);
			stationsArray.remove(indexFree);
			stationsArray.add(index,savedStation);
		}
		else
		{
			stationsArray.get(index).setCurrentCustomer(customerToAssign);
		}
		numberOfCurrentServices++;
		
	}
	public double getTotalStationCost()
	{
		int index = 0;
		int size = stationsArray.size();
		double totalStationCost = 0;
		while(index < size)
		{
			totalStationCost += stationsArray.get(index).getStationCost();
			index ++;
		}
		return totalStationCost;
	}
	
	public double oneMinuteElapses()
	{
		int index = 0;
		int size = stationsArray.size();
		double totalCustomerCost = 0;
		double emptyStationCost = (double)(18/60);
		double busyStationCost = (double)(30/60);
		boolean servedCustomerDone;
		while(index < size)
		{
			servedCustomerDone = false;
			if(stationsArray.get(index)!= null)
			{
				stationsArray.get(index).getCurrentCustomer().setSystTime(stationsArray.get(index).getCurrentCustomer().getSystTime() +1);
				stationsArray.get(index).getCurrentCustomer().setServiceDuration(stationsArray.get(index).getCurrentCustomer().getServiceDuration() -1);
				stationsArray.get(index).setStationCost(stationsArray.get(index).getStationCost()+busyStationCost);
				if(stationsArray.get(index).getCurrentCustomer().getServiceDuration() == 0)
				{
					totalCustomerCost += stationsArray.get(index).getCurrentCustomer().getFinalCost();
					stationsArray.get(index).setCurrentCustomer(null);
					Station savedStation = stationsArray.get(index);
					stationsArray.remove(index);
					stationsArray.add(savedStation);
					numberOfCurrentServices--;
					servedCustomerDone = true;
					size--;
				}				
			}
			else
			{
				stationsArray.get(index).setStationCost(stationsArray.get(index).getStationCost()+emptyStationCost);
			}
			if(!servedCustomerDone)
			{
				index++;
			}
		}
		return totalCustomerCost;
	}
	public boolean isFull()
	{
		if(numberOfCurrentServices < stationsArray.size())
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	public void handleAbsoluteCustomer(Customer absoluteCustomer, Queue relativeQueue, AbsoluteQueue absoluteQueue)
	{
		int size = stationsArray.size();
		int index = size-1;
		boolean canReplace = false;
		int maxServiceDuration = -1;
		int indexOfCustomerToReplace = stationsArray.size();
		while(stationsArray.get(index).getCurrentCustomer() == null)
		{
			index --;
		}
		while(index >= 0 && stationsArray.get(index).getCurrentCustomer().getPriorityType() == Priority.STANDARD)
		{
			canReplace = true;
			if(stationsArray.get(index).getCurrentCustomer().getServiceDuration() > maxServiceDuration)
			{
				maxServiceDuration = stationsArray.get(index).getCurrentCustomer().getServiceDuration();
				indexOfCustomerToReplace = index;
			}
			index--;
		}
		if(canReplace)
		{
			stationsArray.get(indexOfCustomerToReplace).kickCustomerToReplace(relativeQueue, absoluteCustomer);
		}
		else
		{
			absoluteQueue.joinQueue(absoluteCustomer);
		}
	}
	
}
