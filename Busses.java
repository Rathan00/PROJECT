
public class Busses {
	public static void main(String[] args) {
		
	} 
}
class Buses{
	private int busId;
	private String number;
	private String departure;
	private String destination;
	private String busType;
	private long availableDate[];//ddmmyy format example 070723 is 7th jul 2023
	private int rootId;
	private int startTime;//24hr format hhmm example 1830 is 18hrs 30 min
	private int availableSeats[];
	private int journeyTime;//hhmm format example 0825 means 8hrs 25min
	private int endTime;
	private long reachingDate[];
	public Buses(int busID, String number, String departure, String destination, String busType, long[] availableDate,
			int rootId, int startTime, int[] availableSeats, int journeyTime, int endTime, long[] reachingDate) {
		super();
		this.busId = busID;
		this.number = number;
		this.departure = departure;
		this.destination = destination;
		this.busType = busType;
		this.availableDate = availableDate;
		this.rootId = rootId;
		this.startTime = startTime;
		this.availableSeats = availableSeats;
		this.journeyTime = journeyTime;
		this.endTime = endTime;
		this.reachingDate = reachingDate;
	}
	public Buses() {
		// TODO Auto-generated constructor stub
	}
	public int getBusId() {
		return busId;
	}
	public void setBusId(int busId) {
		this.busId = busId;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getBusType() {
		return busType;
	}
	public void setBusType(String busType) {
		this.busType = busType;
	}
	public long[] getAvailableDate() {
		return availableDate;
	}
	public void setAvailableDate(long[] availableDate) {
		this.availableDate = availableDate;
	}
	public int getRootId() {
		return rootId;
	}
	public void setRootId(int rootId) {
		this.rootId = rootId;
	}
	public int getStartTime() {
		return startTime;
	}
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	public int[] getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int[] availableSeats) {
		this.availableSeats = availableSeats;
	}
	
	public int getJourneyTime() {
		return journeyTime;
	}
	public void setJourneyTime(int journeyTime) {
		this.journeyTime = journeyTime;
	}
	public int getEndTime() {
		return endTime;
	}
	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
	public long[] getReachingDate() {
		return reachingDate;
	}
	public void setReachingDate(long[] reachingDate) {
		this.reachingDate = reachingDate;
	}
	
}