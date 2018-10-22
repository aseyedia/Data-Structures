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
	public void DFSUtil(int id, boolean visited[], boolean root, Stack stack) {
		// Mark the current node as visited and print it

		if (!visited[id]) {
			stack.append(id);

			visited[id] = true;
			stack.print();
			System.out.print("end path \n");

			// Recur for all the vertices adjacent to this vertex
			// Implement a hasNext and next for the vertices
			for (int q = 0; q < vertBankSize; q++) {
				if (vertBank[id].getConn(q) == 1) {
					root = false;
					DFSUtil(q, visited, root, stack);

					if (q == vertBankSize - 1) {
						stack.delete();
						visited [q] = false;
						}

//				} else if (q == vertBankSize - 1) {
//					stack.delete();
//					visited [q] = false;
//					
//					
				}
//				else if (id == vertBankSize -1) {
//					stack.delete();
//					visited[q] = false;
//					System.out.println("fuck");
//				}
			}

		} else if (id == this.root) {
			stack.append(id);
			stack.print();
			System.out.print("end path \n");
			stack.delete();
			visited[id] = false;

			return;
		} else if (visited[id]) {

		}
//		visited[id] = false;
	}

	// The function to do DFS traversal. It uses recursive DFSUtil()
	public void DFS(int id) {
		// Mark all the vertices as not visited(set as
		// false by default in java)
		boolean visited[] = new boolean[vertBankSize];
		boolean root = true;
		// Call the recursive helper function to print DFS traversal
		setRootVert(id);
		Stack kew = new Stack();
		DFSUtil(id, visited, root, kew);
		System.out.println();

	}

	class Stack {
		int[] path = new int[50];
		int bottom = 0;
		int top = 0;

//		public queue (int dims) {
//			path = new int[dims];
//		}

		public void append(int vert) {
			path[top] = vert;
			top++;
		}

		public void delete() {

			path[top] = 0;
			top--;
			System.out.println("Vertex " + path[top] + " has been removed from the path");

		}

		public void reset() {
			this.bottom = 0;
			this.top = 0;
		}

		public void print() {
			for (int i = bottom; i < top; i++) {

				System.out.print(path[i] + " ");

			}
			System.out.println();
		}

	}

}
