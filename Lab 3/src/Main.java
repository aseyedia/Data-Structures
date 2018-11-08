import java.io.*;
import java.util.Scanner;

/**
 * This is the driver class for the recursive graph traversal program. There are
 * four classes total, and this program accepts a text file with space-delimited
 * matrices and a header for the dimensions of each matrix.
 * 
 * @author arta
 * @since 11/08/2018
 *
 */
public class Main {
	/**
	 * The main method accepts the name of the file to be processed. That is the
	 * only thing it does, other than create other class objects and call their
	 * methods.
	 * 
	 * @param args none
	 * @throws IOException           Thrown in case the file cannot be read
	 * @throws FileNotFoundException Thrown if the file specified is not found
	 */
	public static void main(String[] args) throws IOException, FileNotFoundException {
		System.out.println("Please enter the full file name of the input.");
		Scanner input = new Scanner(System.in);
		String fileName = input.nextLine();
		try {
			MatrixRead file = new MatrixRead(fileName);
			while (file.ready()) {
				Graph graph = new Graph();
				int dims = file.readMatrix(graph);
				for (int row = 0; row < dims; row++) {
					System.out.println("Row: " + row);
					graph.deepSearchCall(row);
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
