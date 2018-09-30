
public class Passenger
	{
		private String name;
		private int floorEntered;
		private int floorExited;
		private int numTimesTemp;

		public Passenger(String name, int floorEntered, int floorExited)
			{
				this.name = name;
				this.floorEntered = floorEntered;
				this.floorExited = floorExited;
			}

		public int getFloorEntered()
			{
				return floorEntered;
			}

		public void setFloorEntered(int floorEntered)
			{
				this.floorEntered = floorEntered;
			}

		public int getFloorExited()
			{
				return floorExited;
			}

		public void setFloorExited(int floorExited)
			{
				this.floorExited = floorExited;
			}

		public int getNumTimesTemp()
			{
				return numTimesTemp;
			}

		public void setNumTimesTemp(int numTimesTemp)
			{
				this.numTimesTemp = numTimesTemp;
			}

	}
