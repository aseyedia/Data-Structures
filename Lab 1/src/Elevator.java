import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

/**
 * Elevator class which contains bulk of elevator-related activities
 * 
 * This elevator executes much of not just the functioning of the elevator
 * but also the movements of the passengers. 
 * 
 * Comes with an elevator stack (real elevator), temp elevator, stairJail (passengers who took the stairs)
 * 	and elevatorHeaven (passengers who completed their ride on the elevator)
 *  
 * @author arta
 *
 */
public class Elevator {
    int top = -1;
    int tempTop = -1;
    boolean tempElevatorEmpty;
    boolean isFunctional;
    boolean direction;
    boolean isFull;
    int isFullTimes = 0;
    boolean elevatorEmpty;
    int tempCounter = 0;
    int timesEmpty = 0;
    int isFullCounter = 0;
    int isEmptyCounter = 0;
    int currentFloor = 1;
    int numRode = 0;
    private Passenger[] elevatorPass = new Passenger[5];
    private Passenger[] temp = new Passenger[5];
    private Passenger[] stairJail = new Passenger[100];
    int stairJailCounter = 0;
    private Passenger[] elevatorHeaven = new Passenger[100];
    int elevatorHeavenCounter = 0;

    public boolean isFunctional() {
	return isFunctional;
    }

    /**
     * adds passenger objects given as an argument
     * checks to see if full
     * prints relevant information about the passenger
     * @param passenger The passenger object from main
     */
    public void addPassenger(Passenger passenger) {
	if (top >= 4) {
	    isFull(passenger);
	} else if (passenger.getFloorEntered() == currentFloor) {
	    push(passenger);
	    System.out.println(passenger.getName() + " got onto the elevator at floor " + this.currentFloor
		    + " and intends on getting off at floor " + passenger.getFloorExited());
	}
    }

    /**
     * Pops the top item off the stack and moves the top to the next item down.
     * 
     * @return The top item from the stack.
     */
    public Passenger pop() {
	Passenger pass = null;
	if (elevatorEmpty) {
	} else {
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
     * @param number An integer to push onto the top of the stack.
     */
    public Passenger push(Passenger passenger) {
	top++;
	elevatorPass[top] = passenger;
	this.elevatorEmpty = false;
	return elevatorPass[top];
    }

    /**
     * Pops the top item off the stack and moves the top to the next item down.
     * 
     * @return The top item from the stack.
     */
    public Passenger tempPop() {
	Passenger pass = null;
	if (tempElevatorEmpty) {
	} else {
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
     * @param number An integer to push onto the top of the stack.
     */
    public Passenger tempPush(Passenger passenger) {
	tempTop++;
	temp[tempTop] = passenger;
	return temp[tempTop];
    }

    public void removePassenger(int currentFloor) {
	if (top == -1) {
	    timesEmpty++;
	} else {
	    for (int i = 0; i < top + 1; i++) {
		tempPush(pop());
		// above is pop
		if (temp[tempTop].getFloorExited() == currentFloor) {
		    elevatorHeaven[elevatorHeavenCounter++] = temp[tempTop];
		    System.out.println(tempPop().getName() + " got off the elevator at floor " + currentFloor);
		    numRode++;

//		} else if (i < top + 1) {
//		    tempPush(pop());
		} else if (elevatorEmpty) {
		    while (tempTop != -1) {
			push(tempPop());
		    }
		}

	    }
	}
	while (tempTop != -1) {
	    push(tempPop());
	}

    }

    public boolean isFull(Passenger passenger) {
	this.isFull = false;
	if (top == 4 && isFullTimes == 0) {
	    this.isFull = true;
	    this.isFullCounter += 1;
	    this.isFullTimes += 1;
	    if (passenger.getFloorEntered() == currentFloor) {
		System.out.println("The elevator is full and " + passenger.getName() + " had to take the stairs");
		stairJail[stairJailCounter++] = passenger;
	    }
	}
	return isFull;
    }

    public void setIsFullTimes() {
	this.isFullTimes = 0;

    }

    public boolean elevatorEmpty() {
	this.elevatorEmpty = false;
	if (top == -1) {
	    this.elevatorEmpty = true;
	    timesEmpty++;
	    System.out.println("Elevator is empty.");
	}
	return this.elevatorEmpty;
    }

    public boolean tempElevatorEmpty() {
	this.tempElevatorEmpty = false;
	if (top == -1) {
	    this.tempElevatorEmpty = true;
	}
	return tempElevatorEmpty;
    }

    public Elevator(boolean isFunctional, Passenger[] capacity) {
	super();
	this.isFunctional = isFunctional;
	this.elevatorPass = capacity;
    }

    public boolean isDirection() {
	return direction;
    }

    public void setDirection(boolean direction) {
	this.direction = direction;
    }

    public int whichFloor(Passenger newPass) {
	int closestFloor = newPass.getFloorEntered();
	if (top == -1) {
	    elevatorEmpty();
	} else {
	    for (int i = 0; i < 5; i++) {
		tempPush(pop());
		if (Math.abs(closestFloor - currentFloor) < Math.abs(temp[tempTop].getFloorExited() - currentFloor)) {
		    while (tempTop != -1) {
			push(tempPop());
		    }
		    continue;
		} else {
		    closestFloor = temp[tempTop].getFloorExited();
		    while (tempTop != -1) {
			push(tempPop());
		    }
		    return closestFloor;
		}
	    }
	}
	return closestFloor;
    }

    public int getCurrentFloor() {
	return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
	this.currentFloor = currentFloor;
    }

    public void printStats() throws IOException {
	PrintWriter print = new PrintWriter(new FileWriter("elevator output data.txt", false));
	int i = 0;
	print.println("The following data are those of the people who rode this elevator."
		+ " The columns from left to right represent the floor they entered, the floor they exited,"
		+ " and the number of times they had to temporarily vacate the narrow elevator."
		+ " These are their stories.\n");
	print.println("People who took the elevator:\n");
	while (elevatorHeaven[i] != null) {
	    print.println(elevatorHeaven[i].getName() + "\t" + elevatorHeaven[i].getFloorEntered() + "\t"
		    + elevatorHeaven[i].getFloorExited() + "\t" + elevatorHeaven[i].getNumTimesTemp());
	    i++;

	}
	i = 0;
	print.println("\nPeople who took the stairs:\n");
	while (stairJail[i] != null) {
	    print.println(stairJail[i].getName() + "\t" + stairJail[i].getFloorEntered() + "\t"
		    + stairJail[i].getFloorExited() + "\t" + stairJail[i].getNumTimesTemp());
	    i++;
	}
	print.println("\nNumber of times the elevator was full: " + isFullCounter + "\nNumber of times the elevator"
		+ " was empty: " + timesEmpty);
	print.close();

    }
}