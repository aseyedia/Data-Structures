
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
	

}
