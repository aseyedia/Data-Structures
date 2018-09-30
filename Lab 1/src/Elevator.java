import java.util.ArrayList;
import java.util.Stack;

public class Elevator
	{
		boolean isFunctional;
		boolean direction;
		private Stack<Passenger> elevatorPass = new Stack<Passenger>();
		private Stack<Passenger> temp = new Stack<Passenger>();
		static final int MAX_PASSENGERS = 5;
		private static final int FLOORS = 5;

		public boolean isFunctional()
			{
				return isFunctional;
			}

		public void setFunctional(boolean isFunctional)
			{
				this.isFunctional = isFunctional;
			}

		public Stack<Passenger> getCapacity()
			{
				return elevatorPass;
			}

		public void setCapacity(Stack<Passenger> capacity)
			{
				this.elevatorPass = capacity;
			}

		public Elevator(boolean isFunctional, Stack<Passenger> capacity)
			{
				super();
				this.isFunctional = isFunctional;
				this.elevatorPass = capacity;
			}

		public boolean isDirection()
			{
				return direction;
			}

		public void setDirection(boolean direction)
			{
				this.direction = direction;
			}

		public void simulate(ArrayList<Passenger> passengerList)
			{
				// Okay, so this is the part of the elevator object
				// where I want to get the elevator to go up and down
				// and do the stack popping/pushing depending on people
				// getting in and out

				// Where do I start?

				int currentFloor = 1;
				int targetFloor = -1;
				int elevatorCapacity = 0;
				int i = 0;
				int[] target = new int[10];
				while (!passengerList.isEmpty() || !this.elevatorPass.isEmpty())
					{
						if (this.elevatorPass.isEmpty()&& !passengerList.isEmpty()) {
							// in the case that the elevator is empty of passengers and 
							// the list of passengers to board is NOT empty
							while(elevatorCapacity < 5) {
								if(passengerList.get(i).getFloorEntered() == currentFloor) {
									elevatorPass.push(passengerList.get(i));
									elevatorCapacity++;
									i++;
								}
								else {
									i++;
								}
							}
							
							
						}
					}

				/*@formatter:off
 * 				int currentFloor = 1;
				int targetFloor = -1;
				int[] target = new int[10];
				 while(!passengerList.isEmpty()||!this.capacity.isEmpty())
				        {
				            if(this.capacity.isEmpty())
				            {
				                System.out.println("Elevator is empty.");
				                

				            }
				            //first check to see if there people who want to exit at current floor
				            if(currentFloor==targetFloor)
				            {
				                //if someone wants to exit
				                //remove others in front of them
				                while(target[currentFloor-1]!=0)
				                {
				                    //remove from elevator
				                    Passenger r=this.capacity.pop();
				                    //check if it is the passengers exit
				                    if(r.getFloorExited()==currentFloor)
				                    {
				                        target[currentFloor-1]--;
				                        System.out.println(r.getName()+" exit. His/"
				                        		+ "her exit floor is--->"+r.getFloorExited()
				                        +" His/her total number of temporary "
				                        + "exits----> "+r.getNumTimesTemp());
				                    }
				                    else
				                    {
				                        temp.push(r);
				                        r.numTimesTemp();
				                    }
				                }
				              
				                //load the elevator with temporary exit person
				                while(!temp.isEmpty())
				                {
				                    capacity.push(temp.pop());
				                }
				            }@formatter:on
*/
			}

	}
