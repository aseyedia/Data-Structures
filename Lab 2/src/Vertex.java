public class Vertex
    {
        int edges;
        char vert;
        int[] conn;
        int id;

        public Vertex(int id, int dims)
            {
                super();
                this.id = id;
                this.conn = new int[dims];
            }

        public int getId()
            {
                return id;
            }

        public void setId(int id)
            {
                this.id = id;
            }

        public int[] getConn()
            {
                return conn;
            }

        public void setConn(int dims)
            {
                this.conn = new int[dims];
            }

        public char getVert()
            {
                return vert;
            }

        public void setVert(char vert)
            {
                this.vert = vert;
            }

        public int getEdges()
            {
                return edges;
            }

        public void setEdges(char edges, int i)
            {
                conn[i] = edges;
            }
        
    }
