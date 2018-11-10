
public class LinkedStruct {
    // size is the int array to represent each node's relationship with the other
    // nodes
    private Node[] size;
    // row is the array of LinkedStructs that hold the 1's and 0's.
    // The use of row and size is mutually exclusive; Some LinkedStructs are used to
    // hold other LinkedStructs and
    // some LinkedStructs are use to hold int values, and while you could
    // potentially use both, for this project,
    // that likely would not happen.
    private LinkedStruct[] row;
    // This points to the next LinkedStruct only; the use of this variable is
    // tentative.
    private LinkedStruct next;

    public LinkedStruct[] getRow() {
	return row;
    }

    public void setRow(LinkedStruct[] row) {
	this.row = row;
    }

    public LinkedStruct(int rows) {
	this.size = new Node[rows];

    }

    /**
     * This method is to apply the node (edge) to the array of this vertex
     * 
     * @param ind
     *            Index in the array of binary values; vertex to which the edge
     *            points
     * @param node
     *            The node (edge) in question
     */
    public void setRowVal(int ind, Node node) {
	this.size[ind] = node;

    }
}
