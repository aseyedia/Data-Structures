import java.io.*;
import java.util.Scanner;
// Per Professor Cost's discussion board post, ArrayLists are fair to use or at
// least not as heinous of a crime. As it stands right now, I've spent several
// hours trying to figure out how read the data into a 2D array, and as a
// temporary data structure to hold the file information before putting it into
// the 2D array, I'm just going to go ahead and use ArrayLists.
import java.util.ArrayList;

public class Main {
	// Driver program
	public static void main(String args[]) throws FileNotFoundException {
		Scanner fileRead;
		// Name of the directory
		String dirName = "/home/arta/Documents/GitHub/Data-Structures/Lab 4/Lab 4 Input Files/";
		File directory = new File(dirName);
		File[] fileArr = directory.listFiles();
		String[] fileNames;

		// Below is a code that reads all of the raw data into a 2D array
		// The ArrayList is only used to hold the values of each file to be
		// transferred to the 2D array
		int[][] nums = new int[fileArr.length][];
		for (int i = 0; i < fileArr.length; i++) {
			ArrayList<String> line = new ArrayList<String>();
			fileRead = new Scanner(
					new BufferedReader(new FileReader(fileArr[i])));
			while (fileRead.hasNext() != false) {
				line.add(fileRead.next());
			}
			nums[i] = new int[line.size()];
			for (int q = 0; q < line.size(); q++) {
				nums[i][q] = Integer.parseInt(line.get(q));
			}
			fileRead.close();
		}
		// end block
		fileNames = new String[fileArr.length];
		for (int i = 0; i < fileArr.length; i++) {
			fileNames[i] = fileArr[i].getName();
		}
		fileArr = null;
		directory = null;

		for (int i = 0; i < nums.length; i++) {
			int arr[] = nums[i];
			int n = arr.length;

			QuickSort ob = new QuickSort();
			// 0 for Select the first item of the partition as the pivot. Treat
			// partitions
			// of size one and two as stopping cases.
			// 1 for Select the first item of the partition as the pivot. Treat
			// a partition
			// of size 100 as a stopping case. Use an insertion sort to finish.
			// 2 for Select the first item of the partition as the pivot. Treat
			// a partition
			// of size 50 as a stopping case. Use an insertion sort to finish.
			// 3 for Select the median-of-three as the pivot. Treat partitions
			// of size one
			// and two as stopping cases.
			ob.sort(arr, 0, n - 1, 0);
			ob.printArray(arr, fileNames[i],0);
			ob.sort(arr, 0, n - 1, 1);
			ob.printArray(arr, fileNames[i],1);
			ob.sort(arr, 0, n - 1, 2);
			ob.printArray(arr, fileNames[i],2);
			System.out.println("Number of files sorted: " + i);
//			QuickSort.printArray(arr);

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
