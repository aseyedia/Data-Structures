import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * This is the main java class in which the elevator program will run.
 * 
 * @author Arta
 */
@SuppressWarnings("unused")
public class Main
	{

		public static void main(String[] args) throws FileNotFoundException
			{
				Scanner input = new Scanner(System.in);
				System.out.println("Enter the file name of the input.");
				String fileName = input.nextLine();
				passengerList(fileName);

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

		private static ArrayList<Passenger> passengerList(String fileName)
			{
				ArrayList<Passenger> passengerList = new ArrayList<>();
				try
					{
						@SuppressWarnings("resource")
						BufferedReader input =
								new BufferedReader(new InputStreamReader(
										new FileInputStream(fileName)));
						while (input.ready())
							{
								String fileLine = input.readLine();
								if (fileLine.length() > 1
										&& !fileLine.startsWith("//"))
									{
										List<String> passengerInfo = Arrays
												.asList(fileLine.split("\t"));
										String passengerName =
												passengerInfo.get(0);
										passengerName = passengerName.trim();
										int floorEntered = Integer
												.parseInt(passengerInfo.get(1));
										int floorExited = Integer
												.parseInt(passengerInfo.get(2));
										passengerList.add(new Passenger(
												passengerName, floorEntered,
												floorExited));
									}
							}
					} catch (Exception e)
					{
						e.printStackTrace();
						System.out.println(e.getMessage());
					}
				return passengerList;
			}
		
		
	}