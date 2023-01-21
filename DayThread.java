

public class DayThread extends Thread {
	
	// declare variable
	Day day;
	private int pause;
	

	// constructor
	public DayThread (int pause, Day day) {
		this.day = day;
		this.pause = pause;
	}//end constructor DayThread
	

	// thread run method (required)
	@Override
	public void run() {
		// run event loop
		for (int i = 0; i < 5; i++) {
			int count = i + 1;
			System.out.println("-".repeat(10) + " EVENT CHANGE " + count + " " + "-".repeat(10) + "\n");
			System.out.printf(" %-25s %s\n", "Thread Name:", this.getName());
			System.out.printf(" %-25s %s\n\n", "Current Weather Status:", day.getWeather());
			
			// set updated event
			day.checkWeather();
			System.out.printf(" %-25s %s\n", "Event Forcast:", day.getEvent());
			System.out.printf(" %-25s %s\n", "Updated Weather Status:", day.getWeather());
			System.out.printf(" %-25s %d\n", "Status After Check:", day.getStatus());
			System.out.printf(" %-25s %d\n", "Flow:", day.flow);
			System.out.println();
			pause();
		}//end for loop		
	}//end method run
	
	
	// pause thread
	public void pause() {
		try {Thread.sleep(pause);} 
		catch (InterruptedException e) {e.printStackTrace();}
	}//end method pause

}//end class DayThread
