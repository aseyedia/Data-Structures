
public class LinkedStruct {
	// size is the int array to represent each node's relationship with the other
	// nodes
	private int[] size;
	// row is the array of LinkedStructs that hold the 1's and 0's.
	// The use of row and size is mutually exclusive; Some LinkedStructs are used to
	// hold other LinkedStructs and
	// some LinkedStructs are use to hold int values, and while you could
	// potentially use both, for this project,
	// that likely would not happen.
	private LinkedStruct[] row;
	// This points to the next LinkedStruct only; the use of this variable is tentative.
	private LinkedStruct next;

	public LinkedStruct[] getRow() {
		return row;
	}

	public void setRow(LinkedStruct[] row) {
		this.row = row;
	}

	public LinkedStruct(int rows) {
		this.size = new int[rows];

	}

	/** This method is to translate the 1's and 0's from the matrix to the row, which is actually a node, 
	 * @param ind
	 * @param val
	 */
	public void setRowVal(int ind, int val) {

	}
}
