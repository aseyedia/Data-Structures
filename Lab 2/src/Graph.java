import java.util.Iterator;

public class Graph {
    Vertex[] vertBank;
    int vertBankSize;

    public void setVertBankSize(int dims) {
	this.vertBankSize = dims;
	vertBank = new Vertex[vertBankSize];
    }

    public void setVert(int id, Vertex vert) {
	vertBank[id] = vert;
    }

    // A function used by DFS
    void DFSUtil(int id, boolean visited[]) {
	// Mark the current node as visited and print it
	visited[id] = true;
	System.out.print(id + " ");

	
	// Recur for all the vertices adjacent to this vertex
	// Implement a hasNext and next for the vertices
	Vertex curr = vertBank[id];
	while (curr.hasNext()) {
	    int n = curr.next();
	    if (!visited[n])
		DFSUtil(n, visited);
	}
    }

    // The function to do DFS traversal. It uses recursive DFSUtil()
    void DFS(int id) {
	// Mark all the vertices as not visited(set as
	// false by default in java)
	boolean visited[] = new boolean[vertBankSize];

	// Call the recursive helper function to print DFS traversal
	DFSUtil(id, visited);
    }
}
