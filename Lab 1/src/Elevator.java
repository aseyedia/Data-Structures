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
    static final int MAX_PASSENGERS = 5;
    private static final int FLOORS = 5;

    public boolean isFunctional() {
	return isFunctional;
    }

    public void addPassenger(Passenger passenger) {
	if (top >= 4) {
	    isFull();
	} else if (passenger.getFloorEntered() == currentFloor) {
	    push(passenger);
	    System.out.println(passenger.getName() + " got onto the elevator at floor " + this.currentFloor);
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
	    isEmptyCounter++;
	} else {
	    for (int i = 0; i < top + 1; i++) {
		tempPush(pop());
		// above is pop
		if (temp[tempTop].getFloorExited() == currentFloor) {
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

    public boolean isFull() {
	this.isFull = false;
	if (top == 4 && isFullTimes == 0) {
	    this.isFull = true;
	    this.isFullCounter += 1;
	    this.isFullTimes += 1;
	    System.out.println("The elevator is full.");
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
	if (top == -1) {
	    this.tempElevatorEmpty = true;
	}
	return elevatorEmpty();
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
}