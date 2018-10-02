import java.util.Scanner;
import java.io.*;

/**
 * This is the main driver class in which the elevator program will run.
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
                                        if (!elev.isFull(newPass))
                                            {

                                                elev.setCurrentFloor(
                                                        currentFloor);
                                                elev.addPassenger(newPass);
                                                elev.setIsFullTimes();

                                                // the elevator received a
                                                // passenger into the stack
                                                // then we have to figure out
                                                // where the elevator should
                                                // go next. and then add those
                                                // people as passengers.
                                            } else if (elev.isFull(newPass))
                                            {
                                                elev.setCurrentFloor(
                                                        currentFloor);
                                                elev.setIsFullTimes();
                                            } else
                                            {
                                                elev.addPassenger(newPass);

                                                elev.setIsFullTimes();
                                            }
                                    }
                            }

                    } catch (IOException e)
                    {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                elev.printStats(fileName);

                file.close();
                input.close();
            }
    }
