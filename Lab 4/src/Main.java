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
	public static void main(String args[]) throws IOException {
		Scanner fileRead;
		// Name of the directory
		String dirName = "/home/arta/Documents/GitHub/Data-Structures/Lab 4/Lab 4 Input Files/";
		File directory = new File(dirName);
		File[] fileArr = directory.listFiles();
		String[] fileNames;

		fileNames = new String[fileArr.length];
		for (int p = 0; p < fileArr.length; p++) {
			fileNames[p] = fileArr[p].getName();
		}
		int[] nums;
		for (int i = 0; i < fileArr.length; i++) {
			ArrayList<String> line = new ArrayList<String>();
			fileRead = new Scanner(
					new BufferedReader(new FileReader(fileArr[i])));

			while (fileRead.hasNext()) {
				line.add(fileRead.next());
			}
			nums = new int[line.size()];
			for (int q = 0; q < line.size(); q++) {
				nums[q] = Integer.parseInt(line.get(q));
			}

			// fileArr = null;
			// directory = null;

			// for (int q = 0; q < fileNames.length; q++) {
			int arr[] = nums;
			int n = arr.length;

			QuickSort quickSort = new QuickSort();
			NatMergeSort natMerSort = new NatMergeSort();
			// 0 for Select the first item of the partition as the pivot.
			// Treat
			// partitions
			// of size one and two as stopping cases.
			// 1 for Select the first item of the partition as the pivot.
			// Treat
			// a partition
			// of size 100 as a stopping case. Use an insertion sort to
			// finish.
			// 2 for Select the first item of the partition as the pivot.
			// Treat
			// a partition
			// of size 50 as a stopping case. Use an insertion sort to
			// finish.
			// 3 for Select the median-of-three as the pivot. Treat
			// partitions
			// of size one
			// and two as stopping cases.
			int[] hold = arr;
			quickSort.sort(arr, 0, n - 1, 0);
			quickSort.printArray(arr, fileNames[i], 0);
			arr = hold;
			quickSort.sort(arr, 0, n - 1, 1);
			quickSort.printArray(arr, fileNames[i], 1);
			arr = hold;
			quickSort.sort(arr, 0, n - 1, 2);
			quickSort.printArray(arr, fileNames[i], 2);
			arr = hold;
			quickSort.sort(arr, 0, n - 1, 3);
			quickSort.printArray(arr, fileNames[i], 3);
			arr = hold;
			// Natural Merge Sort
			natMerSort.xFer(arr, fileNames[i]);
			
			System.out.println("Number of files sorted: " + i);
		}


	}
}