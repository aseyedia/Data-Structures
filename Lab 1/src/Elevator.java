import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

/**
 * Elevator class which contains bulk of elevator-related activities.
 * 
 * This elevator executes much of not just the functioning of the elevator but
 * also the movements of the passengers.
 * 
 * Comes with an elevator stack (real elevator), temp elevator, stairJail
 * (passengers who took the stairs) and elevatorHeaven (passengers who
 * completed their ride on the elevator).
 * 
 * In the lore of this project, this data is observed by the GoPro in the
 * corner of the elevator.
 * 
 * @author arta
 *
 */
public class Elevator
    {
        private int top = -1;
        private int tempTop = -1;
        private boolean tempElevatorEmpty;
        private boolean isFunctional;
        private boolean direction;
        private boolean isFull;
        private int isFullTimes = 0;
        private boolean elevatorEmpty;
        private int tempCounter = 0;
        private int timesEmpty = 0;
        private int isFullCounter = 0;
        private int isEmptyCounter = 0;
        private int currentFloor = 1;
        private int numRode = 0;
        private Passenger[] elevatorPass = new Passenger[5];
        private Passenger[] temp = new Passenger[5];
        private Passenger[] stairJail = new Passenger[100];
        private int stairJailCounter = 0;
        private Passenger[] elevatorHeaven = new Passenger[100];
        private int elevatorHeavenCounter = 0;

        public boolean isFunctional()
            {
                return isFunctional;
            }

        /**
         * adds passenger objects given as an argument checks to see if full
         * prints relevant information about the passenger
         * 
         * @param passenger
         *            The passenger object from main
         */
        public void addPassenger(Passenger passenger)
            {
                if (top >= 4)
                    {
                        isFull(passenger);
                    } else if (passenger.getFloorEntered() == currentFloor)
                    {
                        push(passenger);
                        numRode++;
                        System.out.println(passenger.getName()
                                + " got onto the elevator at floor "
                                + this.currentFloor
                                + " and intends on getting off at floor "
                                + passenger.getFloorExited());
                    }
            }

        /**
         * Pops the top item off the stack and moves the top to the next item
         * down.
         * 
         * @return The top item from the stack.
         */
        public Passenger pop()
            {
                Passenger pass = null;
                if (elevatorEmpty)
                    {
                    } else
                    {
                        Passenger passToReturn;
                        passToReturn = elevatorPass[top];
                        elevatorPass[top] = null;
                        top--;
                        return passToReturn;
                    }
                return pass;
            }

        /**
         * Pushes an integer onto the stack.
         * 
         * @param number
         *            An integer to push onto the top of the stack.
         */
        public Passenger push(Passenger passenger)
            {
                top++;
                elevatorPass[top] = passenger;
                this.elevatorEmpty = false;
                return elevatorPass[top];
            }

        /**
         * Pops the top item off the stack and moves the top to the next item
         * down.
         * 
         * @return The top item from the stack.
         */
        public Passenger tempPop()
            {
                Passenger pass = null;
                if (tempElevatorEmpty)
                    {
                    } else
                    {
                        Passenger passToReturn;
                        passToReturn = temp[tempTop];
                        passToReturn.numTimesTemp();
                        temp[tempTop] = null;
                        tempTop--;
                        pass = passToReturn;
                    }
                return pass;
            }

        /**
         * Pushes an integer onto the stack.
         * 
         * @param number
         *            An integer to push onto the top of the stack.
         */
        public Passenger tempPush(Passenger passenger)
            {
                tempTop++;
                temp[tempTop] = passenger;
                return temp[tempTop];
            }

        /**
         * Returns empty if elevator is empty; otherwise, each passenger is
         * pushed onto the temp elevator stack and the top of the tenp stack
         * is evaluated as to whether that passenger is getting off at that
         * floor. If so, they ascend to elevator heaven. If not, another
         * passenger is pushed onto temp and the process repeats until the
         * main elevator is empty and everyone has been evaluated.
         * 
         * @param currentFloor
         *            Floor passed from main which the elevator is on
         */
        public void removePassenger(int currentFloor)
            {
                if (top == -1)
                    {
                        timesEmpty++;
                    } else
                    {
                        for (int i = 0; i < top + 1; i++)
                            {
                                tempPush(pop());
                                // above is pop
                                if (temp[tempTop]
                                        .getFloorExited() == currentFloor)
                                    {
                                        elevatorHeaven[elevatorHeavenCounter++] =
                                                temp[tempTop];
                                        System.out.println(tempPop().getName()
                                                + " got off the elevator at floor "
                                                + currentFloor);
                                       

                                        // } else if (i < top + 1) {
                                        // tempPush(pop());
                                    } else if (elevatorEmpty)
                                    {
                                        while (tempTop != -1)
                                            {
                                                push(tempPop());
                                            }
                                    }

                            }
                    }
                while (tempTop != -1)
                    {
                        push(tempPop());
                    }

            }

        /**
         * Evaluates whether the elevator is full and if the passenger waiting
         * to get on must take the stairs.
         * 
         * @param passenger
         *            The passenger waiting to get on the elevator
         * @return Boolean true/false as to whether the elevator is full
         */
        public boolean isFull(Passenger passenger)
            {
                this.isFull = false;
                if (top == 4 && isFullTimes == 0)
                    {
                        this.isFull = true;
                        this.isFullCounter += 1;
                        this.isFullTimes += 1;
                        if (passenger.getFloorEntered() == currentFloor)
                            {
                                System.out.println("The elevator is full and "
                                        + passenger.getName()
                                        + " had to take the stairs");
                                stairJail[stairJailCounter++] = passenger;
                            }
                    }
                return isFull;
            }

        /**
         * A counter designed to prevent the next passenger in isFull from
         * taking the stairs and displaying the isFull message multiple times
         * in the same main while-loop iteration.
         */
        public void setIsFullTimes()
            {
                this.isFullTimes = 0;

            }

        /**
         * Detects if the elevator is empty. If so, the empty counter is
         * incremented and the method returns true. If not, the method returns
         * false.
         * 
         * @return Boolean value true/false as to whether the elevator was
         *         empty.
         */
        public boolean elevatorEmpty()
            {
                this.elevatorEmpty = false;
                if (top == -1)
                    {
                        this.elevatorEmpty = true;
                        timesEmpty++;
                        System.out.println("Elevator is empty.");
                    }
                return this.elevatorEmpty;
            }

        /**
         * Returns whether the temp elevator is empty.
         * 
         * @return Boolean true/false value as to whether the temp elevator is
         *         empty
         */
        public boolean tempElevatorEmpty()
            {
                this.tempElevatorEmpty = false;
                if (top == -1)
                    {
                        this.tempElevatorEmpty = true;
                    }
                return tempElevatorEmpty;
            }

        /**
         * Constructor for the Elevator class.
         * 
         * @param isFunctional
         *            Boolean true/false value for whether the elevator is
         *            functioning
         * @param capacity
         *            Passenger stack
         */
        public Elevator(boolean isFunctional, Passenger[] capacity)
            {
                super();
                this.isFunctional = isFunctional;
                this.elevatorPass = capacity;
            }

        /**
         * Determines which floor to next travel to, given a passenger who is
         * trying to get on
         * 
         * @param newPass
         *            the passenger who wants get onto the elevator
         * @return int value for the closestFloor to which the elevator will
         *         travel
         */
        public int whichFloor(Passenger newPass)
            {
                int closestFloor = newPass.getFloorEntered();
                if (top == -1)
                    {
                        elevatorEmpty();
                    } else
                    {
                        for (int i = 0; i < 5; i++)
                            {
                                tempPush(pop());
                                // if the absolute difference between the
                                // current floor and the closest floor,
                                // which is the potential passenger's floor of
                                // entrance,
                                // is less than the absolute difference
                                // between
                                // the floor which the person at the top of
                                // the
                                // temp stack wants to enter, then the
                                // elevator
                                // will next travel to the new passenger's
                                // floor
                                // of entrance; otherwise, another elevator
                                // passenger will be pushed into the temp
                                // stack to be evaluated again until the
                                // elevator
                                // is empty
                                if (Math.abs(closestFloor
                                        - currentFloor) < Math.abs(
                                                temp[tempTop].getFloorExited()
                                                        - currentFloor))
                                    {
                                        // empties temp stack into the
                                        // elevator
                                        while (tempTop != -1)
                                            {
                                                push(tempPop());
                                            }
                                        continue;
                                    } else
                                    {
                                        closestFloor = temp[tempTop]
                                                .getFloorExited();

                                        while (tempTop != -1)
                                            {
                                                push(tempPop());
                                            }
                                        return closestFloor;
                                    }
                            }
                    }
                return closestFloor;
            }

        /**
         * Gets current floor of the elevator object.
         * 
         * @return Current floor of elevator
         */
        public int getCurrentFloor()
            {
                return currentFloor;
            }

        /**
         * Sets the current floor given an int argument
         * 
         * @param currentFloor
         *            Integer value between 1-5 which will then become the
         *            current floor of this elevator object
         */
        public void setCurrentFloor(int currentFloor)
            {
                this.currentFloor = currentFloor;
            }

        /**
         * Prints total statistics for the entire activity as observed by the
         * "GoPro" mounted in the elevator. Takes the fileName to generate 
         * an output file
         * 
         * elevatorHeaven is where people go when they leave the elevator.
         * stairJail is where people go when they have to take the stairs.
         * 
         * @throws IOException
         *             Exception that probably indicates an inability to write
         *             to file
         */
        public void printStats(String fileName) throws IOException
            {
                fileName = fileName.substring(0, 5);
                PrintWriter print = new PrintWriter(
                        new FileWriter(fileName + "_output.txt", false));
                int i = 0;
                print.println("The following data are those of the people "
                        + "who rode this elevator."
                        + " The columns from left to "
                        + "right represent the "
                        + "floor they entered, the floor they exited,"
                        + " and the number of times they "
                        + "had to temporarily "
                        + "vacate the narrow elevator."
                        + " These are their stories.\n");
                print.println("People who took the elevator:\n");
                while (elevatorHeaven[i] != null)
                    {
                        print.println(elevatorHeaven[i].getName() + "\t"
                                + elevatorHeaven[i].getFloorEntered() + "\t"
                                + elevatorHeaven[i].getFloorExited() + "\t"
                                + elevatorHeaven[i].getNumTimesTemp());
                        i++;

                    }
                i = 0;
                print.println("\nPeople who took the stairs:\n");
                while (stairJail[i] != null)
                    {
                        print.println(stairJail[i].getName() + "\t"
                                + stairJail[i].getFloorEntered() + "\t"
                                + stairJail[i].getFloorExited() + "\t"
                                + stairJail[i].getNumTimesTemp());
                        i++;
                    }
                print.println("Number of times the elevator was full: "
                        + isFullCounter + " " + "Number of times the elevator"
                        + " was empty: " + timesEmpty
                        + " " + "Number of times the elevator was ridden: "
                        + numRode);
                print.close();

            }
    }