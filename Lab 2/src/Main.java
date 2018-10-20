import java.io.*;
import java.util.Scanner;

public class Main {
    // Remember to format this Intro to Java style
    public static void main(String[] args) throws IOException, FileNotFoundException {
	System.out.println("Please enter the full file name of the input.");
	Scanner input = new Scanner(System.in);
	String fileName = "PathsGraphInput.txt";
	try {
	    @SuppressWarnings("resource")
	    FileReader file = new FileReader(fileName);
	    while (file.ready()) {

		// Read header number of the matrix, which is
		// the dimensions of the matrix, and then
		// process the the 1s and 0s or something

		// so I guess here the dimensions of the
		// matrix will define how many possible
		// direct connections the vertex in question
		// can have
		int dims = Character.getNumericValue((char) file.read());
		// in the case of a two digit dimension
		char next = (char) file.read();
		if (next == '\n' || next == ' ') {
		    // sometimes java is weird and the converse of this
		    // if statement doesn't work
		} else {
		    dims = dims * 10 + Character.getNumericValue(next);
		}

		// This array holds the vertices that
		// are in
		// each adjacency graph
		Vertex[] verts = new Vertex[dims];
		// Have to line break so the dimension line
		// doesn't get counted as a row
		for (int row = 0; row < dims; row++)
		// Maybe create an array of 1's and 0's for
		// each vertex
		{

		    // The vert object is created with i
		    // as its ID
		    // and dims as the max number of
		    // connections it
		    // can have
		    Vertex vert = new Vertex(row, dims);

		    // This nested for-loop is row-major
		    // order,
		    // so for each line, the data is going
		    // to be
		    // read into the vertex created above
		    // in the
		    // below for loop, and set
		    for (int col = 0; col < 2 * dims + 1; col++)
		    // ERROR this is incrementing for whitespaces and linebreaks
		    {
			char connect = (char) file.read();
			if (connect == '0' || connect == '1') {
			    vert.setEdges(Character.getNumericValue(connect), col / 2);
			    // The array then stores
			    // the vertex
			    // in the index of its
			    // ID (or
			    // something)
			    verts[row] = vert;
			} else if (connect == (char) -1) {
			    System.out.println("Reached end of file.");
			    System.exit(0);

			} else if (connect == ' ') {
			    continue;
			} else if (connect == '\n') {
			    System.out.println();
			    break;
			}
			System.out.print(connect);
		    }
		}
	    }

	}

	catch (FileNotFoundException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    System.err.println(e.getMessage() + ": couldn't find that file, friend.");
	}

    }

}
