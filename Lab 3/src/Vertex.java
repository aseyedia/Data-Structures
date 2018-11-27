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
        // The edges of the vertex
        private Node[] conn;
        // The id of the vertex in the graph
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
                this.conn = new Node[dims];
            }

        /**
         * This method accepts a binary array that represents the connections
         * made by a vertex
         * 
         * @param myArray
         *            Binary array of the vertex
         */
        public void setEdges(Node[] myArray)
            {
                this.conn = myArray;
            }

        /**
         * Gets a connection at a certain vertex ID.
         * 
         * @param ind
         *            Index of vertex's connections that should be retrieved
         * 
         *            The row id of the vertex
         * @return Binary 1/0 representing whether there is a connection there
         *         or not
         */
        public Node getConn(int ind)
            {
                return conn[ind];
            }

    }
