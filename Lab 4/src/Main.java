import java.io.*;
import java.util.Scanner;

public class Main {
	// Driver program
	public static void main(String args[]) throws FileNotFoundException {
		Scanner fileRead;
		// Name of the directory
		String dirName = "/home/arta/Documents/GitHub/Data-Structures/Lab 4/Lab 4 Input Files/";
		File directory = new File(dirName);
		File[] fileArr = directory.listFiles();
		String[] line;
//		fileRead = new Scanner(
//                 new BufferedReader(new FileReader(fileName)));

		// Below is a code that reads all of the raw data into a 2D array
		int[][] nums = new int[fileArr.length][];
		for (int i = 0; i < fileArr.length; i++) {
			fileRead = new Scanner(new BufferedReader(new FileReader(fileArr[i])));
			if (fileRead.hasNext("\\n")) {
				line = fileRead.nextLine().trim().split("\\n+");
			} else {
				line = fileRead.nextLine().trim().split("\\s+");
			}
			nums[i] = new int[line.length];
			for (int q = 0; q < line.length; q++) {
				nums[i][q] = Integer.parseInt(line[q]);
			}
		}
		// end block

		for (int i = 0; i < nums.length; i++) {
			int arr[] = nums[i];
			int n = arr.length;

			QuickSort ob = new QuickSort();
			// 0 for Select the first item of the partition as the pivot. Treat partitions
			// of size one and two as stopping cases.
			// 1 for Select the first item of the partition as the pivot. Treat a partition
			// of size 100 as a stopping case. Use an insertion sort to finish.
			// 2 for Select the first item of the partition as the pivot. Treat a partition
			// of size 50 as a stopping case. Use an insertion sort to finish.
			// 3 for Select the median-of-three as the pivot. Treat partitions of size one
			// and two as stopping cases.

			ob.sort(arr, 0, n - 1, 0);

			System.out.println("sorted array");
			QuickSort.printArray(arr);

		}
	}
}
/* @formatter:off
 * 
                                for (int i = 0; i < dims; i++)
                                    {
                                        // This is the linked structure of the
                                        // row itself
                                        LinkedStruct rowVal =
                                                new LinkedStruct(columns);
                                        // read row
                                        String[] line = fileRead.nextLine()
                                                .trim().split(" ");

                                        for (int j = 0; j < line.length; j++)
                                            {
                                                // Lab 3: is this where I
                                                // should potentially make
                                                // into a linked list
                                                // the matrix???

                                                // make a node, pass the bin
                                                // value to it and point to
                                                // vertex to
                                                // which it references, which
                                                // is the array index (I
                                                // think)
                                                Node node = new Node(Integer
                                                        .parseInt(line[j]),
                                                        j);
                                                // apply this to the row array
                                                // of edges
                                                rowVal.setRowVal(j, node);
                                            }
                                        rowHold.setRowHold(rowVal, i);
                                    }
 */
