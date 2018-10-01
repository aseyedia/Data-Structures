import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * This is the main java class in which the elevator program will run.
 * 
 * @author Arta
 */
@SuppressWarnings("unused")
public class Main {

    public static void main(String[] args) throws IOException {
	int riders = 0;
	int currentFloor = 1;
	Scanner input = new Scanner(System.in);
	System.out.println("Enter the file name of the input.");
	String fileName = "elevator input data.txt";
	Passenger[] passengers = new Passenger[6];
	Elevator elev = new Elevator(true, passengers);
	Elevator elevNonFunctioning = new Elevator(false, null);
	// use array
	BufferedReader file = new BufferedReader(new FileReader(fileName));

	try {
	    while (file.ready()) {
		String fileLine = file.readLine();
		if (fileLine.length() > 1 && !fileLine.startsWith("//")) {
//		    if (elev.isFull()) {
//			String[] passInfo = fileLine.split("\t");
//			System.out.println(passInfo[0] + " tried to get onto the elevator at floor " + passInfo[1]
//				+ " to get off at floor " + passInfo[2] + ", but the elevator was full.");

		    // Print out if elevator is full
//		    } else {
		    String[] passInfo = fileLine.split("\t");
		    Passenger newPass = new Passenger(passInfo[0], Integer.parseInt(passInfo[1]),
			    Integer.parseInt(passInfo[2]));
		    currentFloor = elev.whichFloor(newPass);
		    System.out.println("Elevator at floor " + currentFloor);

		    if (!elev.isFull() && newPass.getFloorEntered() == currentFloor) {

			elev.setCurrentFloor(currentFloor);
			elev.removePassenger(currentFloor);
			elev.addPassenger(newPass);
			elev.setIsFullTimes();
			riders++;

			// the elevator received a passenger into the stack
			// then we have to figure out where the elevator should
			// go next. and then add those people as passengers.
		    } else if (elev.isFull() && newPass.getFloorEntered() == currentFloor) {
			elev.setCurrentFloor(currentFloor);
			elev.removePassenger(currentFloor);
			if (elev.isFull()) {
			    System.out.println(newPass.getName() + " had to take the stairs.");
			    elev.setIsFullTimes();
			} else {
			    elev.addPassenger(newPass);
			    riders++;
			    elev.setIsFullTimes();
			}
		    }
//		    }
		}
	    }
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	Elevator elevator;

    }
    /* @formatter:off
    	 * # Dang ol' Elevator Problem
    	 * - Two elevators which each hold five people
    	 * 		- Elevator A is small
    	 * 		- Elevator B is permanently broken
    	 * - The [working] elevator is very narrow so people have to 
    	 * 		get off to let out anyone behind them
    	 * - The building has 5 floors serviced by the elevator
    	 * - People always get on the elevator if there is room, even if
    	 * 		it's going in the wrong direction (e.g. they may go down
    	 * 		even if they want to go up)
    	 * ## Dang ol' Stacks n shit
    	 * - Remove ppl scheduled to get off on that floor
    	 * - Print the name of people exiting along with the number of times each
    	 * 		person has had to exit temporarily during their trip
    	 * - Restore people who got off temporarily
    	 * - Load people waiting to get on
    	 * - If elevator is full or empty, print that out. Identify people who 
    	 * 		are waiting to get on but are unable to do so, if the elevator is
    	 * 		full. Assume that people unable to get on the elevator will take
    	 * 		the stairs
    	 * - Print the name of each person getting on along with their destination
    	 * 		floor
    	 * - Proceed to the next floor, which is the next floor selected by a current
    	 * 		passenger or the next floor selected by a person waiting to get on,
    	 * 		whichever is sooner.
    	 * @formatter:on
    	 */

}