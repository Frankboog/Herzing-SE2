

public class FiniteStateMachineTest {
	
	public static void main(String[] args) {

		// declare variables		
		String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
		String event = "Getting Warmer";
		String weather = "Clear";
		int status = 1;
		
		
		// print title
		displayTitle();
		
		
		// loop through days of week array
		for (int i = 0; i < daysOfWeek.length; i++) {
			Day day = new Day(status, daysOfWeek[i], event, weather);
			
			System.out.println("-".repeat(69) + "\n");
			System.out.println("=".repeat(10) + " NEW DAY "  + "=".repeat(50) + "\n");
			System.out.printf(" %-25s %s\n", "Day Of Week:", daysOfWeek[i]);
			System.out.println();			
			day.runDay();
			status = day.getStatus();
			weather = day.getWeather();
			event = day.getEvent();
		}//end for loop
		
		
		// format & print ending
		System.out.println();
		System.out.println("=".repeat(10) + " END FSM "  + "=".repeat(50) + "\n");

	}//end main method
	
	
	// format/print title
	private static void displayTitle() {		
		System.out.println("\n" + "=".repeat(69));
		System.out.println(" FINITE STATE MACHINE TEST");
		System.out.println("=".repeat(69) + "\n");
	}//end method displayTitle

}//end class FiniteStateMachineTest
