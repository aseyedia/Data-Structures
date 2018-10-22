/**
 * Vertex class. Stores information from the text file. Has array 'conn',
 * which is the array of its possible connections, length of the dimensions of
 * the matrix, and int 'id', which is the vertex number/row.
 * 
 * @author arta
 *
 */
public class Vertex
    {
        private int[] conn;
        private int id;

        /**
         * Constructor for creating a vertex
         * 
         * @param id
         *            Vertex id/row number of matrix
         * @param dims
         *            Dimensions of the matrix as read from the file
         */
        public Vertex(int id, int dims)
            {
                super();
                this.id = id;
                this.conn = new int[dims];
            }

        /**
         * This method accepts a binary array that represents the connections
         * made by a vertex
         * 
         * @param myArray
         *            Binary array of the vertex
         */
        public void setEdges(int[] myArray)
            {
                this.conn = myArray;
            }

        /**
         * Gets a connection at a certain vertex ID.
         * 
         * @param ind
         *            The row id of the vertex
         * @return Binary 1/0 representing whether there is a connection there
         *         or not
         */
        public int getConn(int ind)
            {
                return conn[ind];
            }

    }
