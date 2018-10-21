public class Graph {
	Vertex[] vertBank;
	int vertBankSize;
	int root;

	public void setVertBankSize(int dims) {
		this.vertBankSize = dims;
		vertBank = new Vertex[vertBankSize];
	}

	public void setVert(int id, Vertex vert) {
		vertBank[id] = vert;
	}
	
	public void setRootVert(int id) {
		this.root = id;
	}

	// IMPORTANT: this method counts as 'visited' even if
	// you start on that node. fix it.
	public void DFSUtil(int id, boolean visited[], boolean root) {
		// Mark the current node as visited and print it

		if (!visited[id]) {
			visited[id] = true;
			if (root == true) {
				visited[id] = false;
			}
			System.out.print(id + " ");
			// Recur for all the vertices adjacent to this vertex
			// Implement a hasNext and next for the vertices
			for (int i = id; i < vertBank.length; i++) {
				for (int q = 0; q < vertBank[i].getConn().length; q++) {
					if (vertBank[i].getConn(q) == 1) {
						root = false;
						DFSUtil(q, visited, root);
					}
				}

			}
		}
	}

	// The function to do DFS traversal. It uses recursive DFSUtil()
	public void DFS(int id) {
		// Mark all the vertices as not visited(set as
		// false by default in java)
		boolean visited[] = new boolean[vertBankSize];
		boolean root = true;
		// Call the recursive helper function to print DFS traversal
		setRootVert(id);
		DFSUtil(id, visited, root);
		System.out.println();

	}
}
