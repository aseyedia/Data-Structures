
public class LinkedStruct
    {
        // nodes is the int array to represent each node's relationship with
        // the other
        // nodes
        private Node[] nodes;
        // row is the array of LinkedStructs that hold the 1's and 0's.
        // The use of row and size is mutually exclusive; Some LinkedStructs
        // are used to
        // hold other LinkedStructs and
        // some LinkedStructs are use to hold int values, and while you could
        // potentially use both, for this project,
        // that likely would not happen.
        // private LinkedStruct[] row;
        // This points to the next LinkedStruct only; the use of this variable
        // is
        // tentative.
        private LinkedStruct next;

        // LinkedStruct array to hold
        private LinkedStruct[] rowHold;

        /**
         * Sets the held row at the given index (row) to the given
         * LinkedStruct (vert)
         * 
         * @param vert
         *            The given LinkedStruct
         * @param row
         *            The given index
         */
        public void setRowHold(LinkedStruct vert, int row)
            {
                this.rowHold[row] = vert;
            }

        /**
         * Returns the set of nodes held by this LinkedStruct
         * 
         * @return The array of nodes held by this LinkedStruct
         */
        public Node[] getNodes()
            {
                return nodes;
            }

        /**
         * Returns the LinkedStruct held by this LinkedStruct at the index in
         * the argument; used to read rows of data from matrix.
         * 
         * @param ind
         *            Index of the LinkedStruct held by this LinkedStruct in
         *            rowHold
         * @return The LinkedStruct corresponding to the index.
         */
        public LinkedStruct getRowHoldIndex(int ind)
            {
                return rowHold[ind];
            }

        /**
         * Constructor for LinkedStruct; accepts int number of rows to
         * initialize its arrays for nodes and other linkedstruct's. Can be
         * used either way.
         * 
         * @param rows
         *            Int number of rows
         */
        public LinkedStruct(int rows)
            {
                this.nodes = new Node[rows];
                this.rowHold = new LinkedStruct[rows];

            }

        /**
         * Determines if there is no room remaining in the linked structure's
         * array of linked structures.
         * 
         * @return True if no room, false otherwise
         */
        public boolean hasNoRoom()
            {
                if (rowHold[rowHold.length - 1] == null)
                    {
                        return true;
                    }
                return false;
            }

        /**
         * This method is to apply the node (edge) to the array of this vertex
         * 
         * @param ind
         *            Index in the array of binary values; vertex to which the
         *            edge points
         * @param node
         *            The node (edge) in question
         */
        public void setRowVal(int ind, Node node)
            {
                this.nodes[ind] = node;

            }
    }
