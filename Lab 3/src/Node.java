
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

        public Node(int binValue, int i)
            {
                super();
                this.binValue = binValue;
                this.nextVert = i;
            }

        public Node(int binValue)
            {
                super();
                this.binValue = binValue;
            }

        public int getBinValue()
            {
                return binValue;
            }

        public void setBinValue(int binValue)
            {
                this.binValue = binValue;
            }

	public int getNextVert() {
	    return nextVert;
	}

	public void setNextVert(int nextVert) {
	    this.nextVert = nextVert;
	}



    }
