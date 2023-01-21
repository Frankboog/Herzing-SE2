

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class Day {
	
	// object attributes
	private String[] events = {"Getting Warmer", "Getting Colder", "Humidity is Increasing", "Wind is Increasing"};
	private String[] weather_status = {"Clear", "Cloudy", "Raining", "Severe Weather"};
	private String dayOfWeek, weather, event;
	private int status;
	public int flow;
		
	// default constructor
	public Day() {
		this.status = 0;
		this.dayOfWeek = "None";
		this.event = "None";
		this.weather = "None";
	}//end default constructor Day
	
	
	// constructor
	public Day(int status, String dayOfWeek, String event, String weather) {
		this.setStatus(status);
		this.setDayOfWeek(dayOfWeek);
		this.setEvent(event);
		this.setWeather(weather);
	}//end constructor Day
	
		
	// return status
	public int getStatus() {
		return this.status;
	}//end method getStatus

	
	// return day of week
	public String getDayOfWeek() {
		return this.dayOfWeek;
	}//end method getDayOfWeek

	
	// return event
	public String getEvent() {
		return this.event;
	}//end method getEvent

	
	// return weather
	public String getWeather() {
		return this.weather;
	}//end method getWeather

	
	// update status
	public void setStatus(int status) {
		this.status = status;
	}//end method setStatus

	
	// update day of week
	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}//end method setDayOfWeek

	
	// update event
	public void setEvent(String event) {
		this.event = event;
	}//end method setEvent
	
	
	// update weather
	public void setWeather(String weather) {
		this.weather = weather;
	}//end method setWeather
	
	
	// start day thread
	public void runDay() {
		DayThread thread = new DayThread(2000, this);
		thread.setName(dayOfWeek);
		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {e.printStackTrace();}//end try/catch
	}//end method runDay
	
	
	// check weather
	public void checkWeather() {
		int flow = getRandomFlow();
		this.flow = flow;
		int update = getStatus(flow, status);
		setStatus(update);
		setEvent(events[status-1]);
		setWeather(weather_status[status-1]);
	}//end method checkWeather
	
	
	// get status
	public int getStatus(int flow, int status) {
		switch (flow) {
			case 0: {
				if (status != 1) {
					status += -1;
				}//end IF condition
				break;
			}//end case 0
			case 1: {break;}//end case 1
			case 2: {
				if (status != 4) {
					status += 1;
				}//end IF condition
				break;}//end case 2
			default: {break;}//default
		}//end switch
		return status;
	}//end method getStatus
	
	
	// generate random number
	public int getRandomFlow() {
		int min = 0;
		int max = 2;
		int flow = ThreadLocalRandom.current().nextInt(min, max + 1);
//			if (flow == 0 && status == 1) {flow = 2;}//end if condition
//			if (flow == 2 && status == 4) {flow = 0;}//end if condition
		return flow;
	}//end method generateRandom

	
	@Override
	public String toString() {
		return " DayClass(status=" + this.getStatus() + 
				", dayOfWeek=" + this.getDayOfWeek() + 
				", weather=" + this.getEvent() + 
				", event=" + this.getWeather() + ")";
	}//end method toString
	
	
	@Override
	public int hashCode() {
		return Objects.hash(status, dayOfWeek, event, weather);
	}//end method hashCode
	
	
	@Override
	public boolean equals(final Object o) {
		if (this == o) {return true;}//end IF condition
		if (o == null) {return false;}//end IF condition
		if (getClass() != o.getClass()) {return false;}//end IF condition
		Day day = (Day) o;
		return Objects.equals(status, day.status) 
				&& Objects.equals(dayOfWeek, day.dayOfWeek)
				&& Objects.equals(event, day.event)
				&& Objects.equals(weather, day.weather);
	}//end method equals
		
}//end class Day
