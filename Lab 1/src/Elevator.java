import java.util.Stack;

public class Elevator
	{
		boolean isFunctional;
		boolean direction;
		private Stack<Passenger> capacity = new Stack<Passenger>();
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
				return capacity;
			}

		public void setCapacity(Stack<Passenger> capacity)
			{
				this.capacity = capacity;
			}

		public Elevator(boolean isFunctional, Stack<Passenger> capacity)
			{
				super();
				this.isFunctional = isFunctional;
				this.capacity = capacity;
			}

		public boolean isDirection()
			{
				return direction;
			}

		public void setDirection(boolean direction)
			{
				this.direction = direction;
			}
		public void simulate() {
			
		}

	}
