public class Vertex {
    int edges;
    char vert;
    int[] conn;
    int id;

    public Vertex(int id, int dims) {
	super();
	this.id = id;
	this.conn = new int[dims];
    }

    public boolean hasNext() {
	boolean next = false;
	for (int i = 0; i < conn.length; i++) {
	    if (conn[i] == 1) {
		next = true;
	    }
	}
	return next;

    }
    
    public int next() {
	int next = null;
	int i = 0;
	while(next == null) {
	    if (conn[i] == 1) {
		next = i;
	    }
	}
	
	return next;
    }
}
