package waitSimulation;

import java.util.ArrayList;

public class Queue 
{
	protected ArrayList<Customer> queue;
	public Queue()
	{
		queue = new ArrayList<Customer>();
	}
	public ArrayList<Customer> getQueue()
	{
		return queue;
	}
	public void setQueue(ArrayList<Customer> newQueue)
	{
		queue = newQueue;
	}
	public Customer getCustomerAt(int index)
	{
		return queue.get(index);
	}
	public boolean isQueueEmpty()
	{
		return queue.isEmpty();
	}
	public void destroyQueue()
	{
		queue.clear();
	}
	public void joinQueue(Customer customerToAdd)
	{
		int iQueue = 0;
		while(iQueue < queue.size() && queue.get(iQueue).getServiceDuration() <= customerToAdd.getServiceDuration())
		{
			iQueue++;
		}
		queue.add(iQueue, customerToAdd);
	}
	public void oneMinuteElapses()
	{
		int index = 0;
		int size = queue.size();
		while(index < size)
		{
			queue.get(index).setSystTime(queue.get(index).getSystTime()+1);
			index ++;
		}
	}
	public double getRemainingCustomersCost()
	{
		double totalRemainingCustomersCost = 0;
		int index = 0;
		int size = queue.size();
		
		while (index < size)
		{
			totalRemainingCustomersCost += queue.get(index).getFinalCost();
			index ++;
		}
		return totalRemainingCustomersCost;
	}
	public void proceed (Stations stationsArray)
	{
			int size = queue.size();
			while(size > 0 && !stationsArray.isFull())
			{
				stationsArray.assignCustomer(queue.get(0));
				queue.remove(0);
			}
	}
	public String toString()
	{
		String msg = "la file est composée des clients suivants:";
		int iQueue = 0;
		while(iQueue < queue.size())
		{
			msg += queue.get(iQueue);
			msg +="\n";
			iQueue++;
		}
		return msg;
	}
}
