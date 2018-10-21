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

	public void setEdges(int[] myArray) {
		this.conn = myArray;
	}

	public int getConn(int ind) {
		return conn[ind];
	}
	
	public int[] getConn() {
		return conn;
	}

}
