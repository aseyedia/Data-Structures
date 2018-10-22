import java.io.*;
import java.util.Scanner;

public class Main {
	// Remember to format this Intro to Java style
	public static void main(String[] args) throws IOException, FileNotFoundException {
		System.out.println("Please enter the full file name of the input.");
		Scanner input = new Scanner(System.in);
		String fileName = "UserPathsGraphsInput (copy).txt";
		try {
			MatrixRead file = new MatrixRead(fileName);
			while (file.ready()) {

				// Spent way too much time like an idiot trying to implement this thing
				// in a way that was much harder than it needed to be.
				Graph graph = new Graph();
				int dims = file.readMatrix(graph);
				for (int row = 0; row < dims; row++) {
					System.out.println("Row: " + row);
					graph.DFS(row);
				}
				System.out.println();

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e.getMessage() + ": couldn't find that file, friend.");
		} finally {
		}

	}

}
