import java.util.Scanner;
import java.io.*;

/**
 * This is the main driver class in which the elevator program will run. This
 * class accepts a tab-delimited text file as input, and splits it up and uses
 * the first 3 columns (which should be the only columns) as passenger
 * information. The first column should be a name, and the second two columns
 * should be numbers representing the floor entered and exited.
 * 
 * @author Arta
 */
@SuppressWarnings("unused")
public class Main
    {

        public static void main(String[] args) throws IOException
            {

                int currentFloor = 1;
                Scanner input = new Scanner(System.in);
                System.out.println("Enter the file name of the input.");
                String fileName = input.nextLine();
                Passenger[] passengers = new Passenger[5];
                Elevator elev = new Elevator(true, passengers);
                Elevator elevNonFunctioning = new Elevator(false, null);
                // use array
                BufferedReader file =
                        new BufferedReader(new FileReader(fileName));

                try
                    {
                        while (file.ready())
                            {
                                String fileLine = file.readLine();
                                if (fileLine.length() > 1
                                        && !fileLine.startsWith("//"))
                                    {
                                        // Process the file one line at a time
                                        String[] passInfo =
                                                fileLine.split("\t");
                                        // Taking the line, splitting it up
                                        // by tabs, and storing that info
                                        // as passenger data
                                        Passenger newPass =
                                                new Passenger(passInfo[0],
                                                        Integer.parseInt(
                                                                passInfo[1]),
                                                        Integer.parseInt(
                                                                passInfo[2]));
                                        currentFloor =
                                                elev.whichFloor(newPass);
                                        elev.setCurrentFloor(currentFloor);
                                        System.out
                                                .println("Elevator at floor "
                                                        + currentFloor);
                                        elev.removePassenger(currentFloor);
                                        elev.setIsFullNotAgain();
                                        if (!elev.isFull(newPass))
                                            {

                                                elev.addPassenger(newPass);
                                                elev.setIsFullNotAgain();

                                                // the elevator received a
                                                // passenger into the stack
                                                // then we have to figure out
                                                // where the elevator should
                                                // go next. and then add those
                                                // people as passengers.
                                            } else if (elev.isFull(newPass))
                                            {

                                                elev.setIsFullNotAgain();
                                            }
                                    }
                            }

                    } catch (IOException e)
                    {
                        System.err.println(
                                e.getMessage() + ": file not available");
                    }

                elev.printStats(fileName);
                // printing stats to file using the Elevator
                // method, then closing all active streams
                file.close();
                input.close();
            }
    }
