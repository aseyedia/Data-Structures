
/**
 * This is intended to be a node object, basically synonymous with edges in a
 * graph. This object is supposed to hold value (either 1 or 0) and pointer
 * (which is the next pointer)
 * 
 * @author Arta
 *
 */
public class Node
    {
        // This is whether or not the edge even exists
        private int binValue;
        // This is the node directly following it in the vertex list
        private int nextVert;
        // This is the vertex that the edge is pointing to for path-building

        // Can't have a constructor with duplicate object types as parameters

        /**
         * Constructor for node; accepts binary value and int for next vertex
         * as arguments and creates a node
         * 
         * @param binValue
         *            0 or 1 to indicate presence of edge
         * @param nextVert
         *            Integer value for the next vertex
         */
        public Node(int binValue, int nextVert)
            {
                super();
                this.binValue = binValue;
                this.nextVert = nextVert;
            }

        /**
         * Retrieves the binary value for that node, either 1 or 0 int
         * 
         * @return An integer, 0 or 1, for the existence of an edge as
         *         represented by this node
         */
        public int getBinValue()
            {
                return binValue;
            }

        /**
         * Method for returning the vertex this node/edge points to
         * 
         * @return Vertex of focus
         */
        public int getNextVert()
            {
                return nextVert;
            }

    }
