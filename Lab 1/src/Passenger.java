
/**
 * This is the passenger object. Each passenger represents an individual who
 * boards the elevator. Passengers have a name, floor entered, destination,
 * and number of times they were forced to temporarily evacuate the elevator.
 * 
 * @author Arta
 *
 */
public class Passenger
    {
        private String name;
        private int floorEntered;
        private int floorExited;
        private int numTimesTemp = 0;

        /**
         * Constructor class for the passenger. Accepts all relevant data as
         * arguments.
         * 
         * @param name
         *            The passenger's name
         * @param floorEntered
         *            Where the passenger boarded the elevator
         * @param floorExited
         *            Where the passenger is going
         */
        public Passenger(String name, int floorEntered, int floorExited)
            {
                this.name = name;
                this.floorEntered = floorEntered;
                this.floorExited = floorExited;
            }

        /**
         * Getter method for the floor that they entered
         * 
         * @return Integer value for floor entered
         */
        public int getFloorEntered()
            {
                return floorEntered;
            }

        /**
         * Setter method for the floor that they exited
         * 
         * @return Integer value for the floor exited
         */
        public int getFloorExited()
            {
                return floorExited;
            }

        /**
         * Returns the integer value for the number of times the passenger had
         * to temporarily unload from the elevator
         * 
         * @return integer value for the number of times the passenger had to
         *         temporarily unload from the elevator
         */
        public int getNumTimesTemp()
            {
                return numTimesTemp;
            }

        /**
         * An int method that, when called, increments the number of times the
         * passenger had to temporarily unload from the elevator by one.
         * 
         * @return integer value for the number of times the passenger had to
         *         temporarily unload from the elevator
         */
        public int numTimesTemp()
            {
                numTimesTemp += 1;
                return numTimesTemp;
            }

        /**
         * Gets the name of the passenger
         * @return the name of the passenger
         */
        public String getName()
            {
                return name;
            }

    }
