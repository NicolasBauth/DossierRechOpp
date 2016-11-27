package waitSimulation;

public class Customer 
{
	private int systTime;
	private int serviceDuration;
	private Priority priorityType;
	public Customer(RandomGenerator randomGenerator)
	{
		systTime = 0;
		serviceDuration = randomGenerator.generateRandomServiceDuration();
		priorityType = randomGenerator.generateRandomPriorityType();
	}
	public int getSystTime() {
		return systTime;
	}
	public void setSystTime(int systTime) {
		this.systTime = systTime;
	}
	public int getServiceDuration() {
		return serviceDuration;
	}
	public void setServiceDuration(int serviceDuration) {
		this.serviceDuration = serviceDuration;
	}

	
	public Priority getPriorityType() {
		return priorityType;
	}
	public void setPriorityType(Priority priorityType) {
		this.priorityType = priorityType;
	}
	public double getFinalCost()
	{
		double finalCost;
		double absoluteFactor = (37.50/60);
		double relativeFactor = (25.50/60);
		double standardFactor = (22.50/60);
		switch(priorityType)
		{
			case ABSOLUTE:
				finalCost = systTime*absoluteFactor;
				break;
			case RELATIVE:
				finalCost = systTime*relativeFactor;
				break;
			default:
				finalCost = systTime*standardFactor;
				break;
		}
		return finalCost;
	}
	public String toString()
	{
		String msg = "Le client a un systTime de "+systTime;
		msg +=" et une durée de service prévue de "+serviceDuration;
		msg +=" et une priorité valant "+priorityType;
		return msg;
	}
	
}
