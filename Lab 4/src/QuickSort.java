import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

// Java program for implementation of QuickSort
/**
 * This QuickSort class was borrowed in large part from the following source:
 * â€œQuickSort - GeeksforGeeks.â€�
 * 
 * The median-of-three method was found here: "Quick Sort with Median-of-Three
 * Partitioning: Sort < Collections < Java Tutorial."
 * 
 * This class is not an exact copy of these sources, however, as personal
 * contributions have been made to fit the requirements of this project. The
 * standard quicksort method was altered to work with a pivot at the first
 * element. The 100 and 50 quicksort methods were based on the first quicksort
 * method after its alteration.
 * 
 * @author arta
 *
 */
public class QuickSort
    {
        /*
         * Select the first item of the partition as the pivot. Treat
         * partitions of size one and two as stopping cases.
         * 
         * WORKS
         */
        /**
         * "Select the first item of the partition as the pivot. Treat
         * partitions of size one and two as stopping cases."
         * 
         * @param arr
         *            Array being sorted
         * @param low
         *            Low index of array/partition
         * @param high
         *            High index of array/partition
         * @return Pivot index
         */
        public int firstPartition(int arr[], int low, int high)
            {
                int pivot = arr[low];
                int i = (high + 1); // index of larger element
                for (int j = high; j > low; j--)
                    {
                        // If current element is smaller than or
                        // equal to pivot
                        if (arr[j] >= pivot)
                            {
                                i--;

                                // swap arr[i] and arr[j]
                                int temp = arr[i];
                                arr[i] = arr[j];
                                arr[j] = temp;
                            }
                    }

                // swap arr[i-1] and arr[low] (or *pivot*)
                int temp = arr[i - 1];
                arr[i - 1] = arr[low];
                arr[low] = temp;

                return i - 1;
            }

        /**
         * "Select the first item of the partition as the pivot. Treat a
         * partition of size 100 as a stopping case. Use an insertion sort to
         * finish."
         * 
         * @param arr
         *            Array to be sorted
         * @param low
         *            Lowest index of array/partition
         * @param high
         *            Highest index of array/partition
         * @return Pivot index
         */
        public int oneHundPart(int arr[], int low, int high)
            {
                int pivot = arr[low];
                int i = (high + 1);
                for (int j = high; j > low; j--)
                    {
                        if (high - low <= 100)
                            {
                                InsertionSort iS = new InsertionSort();
                                arr = iS.sort(arr);
                                break;
                            }
                        // If current element is smaller than or
                        // equal to pivot
                        else if (arr[j] >= pivot)
                            {
                                i--;

                                // swap arr[i] and arr[j]
                                int temp = arr[i];
                                arr[i] = arr[j];
                                arr[j] = temp;
                            }
                    }

                // swap arr[i+1] and arr[high] (or pivot)
                int temp = arr[i - 1];
                arr[i - 1] = arr[low];
                arr[low] = temp;

                return i - 1;
            }

        /**
         * "Select the first item of the partition as the pivot. Treat a
         * partition of size 50 as a stopping case. Use an insertion sort to
         * finish."
         * 
         * @param arr
         *            Array to be sorted
         * @param low
         *            Lowest index of array/partition
         * @param high
         *            Highest index of array/partition
         * @return Pivot index
         */
        public int fiddyPart(int arr[], int low, int high)
            {
                int pivot = arr[low];
                int i = (high + 1);
                for (int j = high; j > low; j--)
                    {
                        if (high - low <= 50)
                            {
                                InsertionSort iS = new InsertionSort();
                                arr = iS.sort(arr);
                                break;
                            }
                        // If current element is smaller than or
                        // equal to pivot
                        else if (arr[j] >= pivot)
                            {
                                i--;

                                // swap arr[i] and arr[j]
                                int temp = arr[i];
                                arr[i] = arr[j];
                                arr[j] = temp;
                            }
                    }

                // swap arr[i+1] and arr[high] (or pivot)
                int temp = arr[i - 1];
                arr[i - 1] = arr[low];
                arr[low] = temp;

                return i - 1;
            }

        /**
         * Median-of-three quicksort, sourced in whole from â€œQuick Sort with
         * Median-of-Three Partitioningâ€¯: SortÂ Â«Â CollectionsÂ Â«Â Java
         * Tutorial.â€� (see References)
         * 
         * @param intArray
         *            Array of integers to be sorted
         * @param left
         *            Left-most int
         * @param right
         *            Right-most int
         * @return Value of split point of array
         */
        public static int medianOf3(int[] intArray, int left, int right)
            {
                int center = (left + right) / 2;

                if (intArray[left] > intArray[center])
                    swap(intArray, left, center);

                if (intArray[left] > intArray[right])
                    swap(intArray, left, right);

                if (intArray[center] > intArray[right])
                    swap(intArray, center, right);

                swap(intArray, center, right - 1);
                return intArray[right - 1];
            }

        /**
         * Swapping the array elements in median-of-three quicksort.
         * 
         * @param intArray
         *            Array to be sorted
         * @param dex1
         *            Index A to be swapped
         * @param dex2
         *            Index B to be swapped
         */
        public static void swap(int[] intArray, int dex1, int dex2)
            {
                int temp = intArray[dex1];
                intArray[dex1] = intArray[dex2];
                intArray[dex2] = temp;
            }

        /**
         * Partitioning the array for median-of-three sorting
         * 
         * @param intArray
         *            Array to be sorted
         * @param left
         *            Left pointer
         * @param right
         *            Right pointer
         * @param pivot
         *            Pivot around which array is sorted
         * @return Split position
         */
        public static int partitionIt(int[] intArray, int left, int right,
                double pivot)
            {
                int leftPtr = left;
                int rightPtr = right - 1;

                while (true)
                    {
                        while (intArray[++leftPtr] < pivot)
                            ;
                        while (intArray[--rightPtr] > pivot)
                            ;
                        if (leftPtr >= rightPtr)
                            break;
                        else
                            swap(intArray, leftPtr, rightPtr);
                    }
                swap(intArray, leftPtr, right - 1);
                return leftPtr;
            }

        /**
         * A median-of-three sort for partitions of size 1 and 2
         * 
         * @param intArray
         *            Array to be sorted
         * @param left
         *            Left element pointer
         * @param right
         *            Right element pointer
         */
        public static void manualSort(int[] intArray, int left, int right)
            {
                int size = right - left + 1;
                if (size <= 1)
                    return;
                if (size == 2)
                    {
                        if (intArray[left] > intArray[right])
                            swap(intArray, left, right);
                        return;
                    } else
                    {
                        if (intArray[left] > intArray[right - 1])
                            swap(intArray, left, right - 1);
                        if (intArray[left] > intArray[right])
                            swap(intArray, left, right);
                        if (intArray[right - 1] > intArray[right])
                            swap(intArray, right - 1, right);
                    }
            }

        /**
         * "The main function that implements QuickSort() arr[] --> Array to
         * be sorted, low --> Starting index, high --> Ending index"
         * 
         * @param arr
         *            Array to be sorted
         * @param low
         *            Element at the bottom of partition
         * @param high
         *            Element at the top of partition
         * @param sortKind
         *            Type of quicksort that will be done on arr
         */
        public void sort(int arr[], int low, int high, int sortKind)
            {
                // QuickSort type 1; Pivot at first element, stopping case
                // partitions of
                // 1 and 2
                if (low < high && sortKind == 0)
                    {
                        int pi = firstPartition(arr, low, high);

                        // Recursively sort elements before
                        // partition and after partition
                        sort(arr, low, pi - 1, 0);
                        sort(arr, pi + 1, high, 0);
                    }
                // Quicksort type 2: stop at partitions of 100, then do
                // insertion sort
                else if (low < high && sortKind == 1)
                    {
                        int pi = oneHundPart(arr, low, high);
                        if (100 - pi >= 100)
                            {
                                sort(arr, low, pi - 1, 1);
                                sort(arr, pi + 1, high, 1);
                            }

                    }
                // Quicksort type 3: stop at partitions of 50, then do
                // insertion sort
                else if (low < high && sortKind == 2)
                    {
                        int pi = fiddyPart(arr, low, high);
                        if (100 - pi >= 100)
                            {
                                sort(arr, low, pi - 1, 1);
                                sort(arr, pi + 1, high, 1);
                            }
                    }
                // Median-of-three Quicksort
                else if (low < high && sortKind == 3)
                    {
                        int size = high - low + 1;
                        if (size <= 3)
                            manualSort(arr, low, high);
                        else
                            {
                                double median = medianOf3(arr, low, high);
                                int partition =
                                        partitionIt(arr, low, high, median);
                                sort(arr, low, partition - 1, 3);
                                sort(arr, partition + 1, high, 3);
                            }
                    }
            }

        /**
         * Prints entire array as well as sort type, elapsed time in
         * nanoseconds and data file name to std out
         * 
         * @param arr
         *            Sorted array
         * @param fileName
         *            Name of data file
         * @param sortType
         *            Type of quicksort
         * @param elapsedTime
         *            Time in nanoseconds of sort
         * @param fileNum
         *            Number of files processed
         * @throws IOException
         * 
         */
        public void printArray(int arr[], String fileName, int sortType,
                long elapsedTime, int fileNum) throws IOException
            {
//                int n = arr.length;
////                PrintWriter print =
////                        new PrintWriter(new FileWriter("QSOut.txt", true));
//                switch (sortType)
//                    {
//                    case 0:
//                        System.out.println("QuickSort Standard");
//                        print.print("QS STD\t");
//                        break;
//                    case 1:
//                        System.out.println("QuickSort 100");
//                        print.print("QS 100\t");
//                        break;
//                    case 2:
//                        System.out.println("QuickSort 50");
//                        print.print("QS 50\t");
//                        break;
//                    case 3:
//                        System.out.println("QuickSort Median-of-Three");
////                        print.print("QS MED\t");
//                        break;
//                    }
//                System.out.println("Name of data file: " + fileName);
////                print.print(fileName + "\t");
//                for (int i = 0; i < n; ++i)
//                    System.out.print(arr[i] + " ");
//                System.out.println();
//                System.out.println(
//                        "Elapsed time of sort calculation in nanoseconds: "
//                                + elapsedTime);
////                print.print(elapsedTime + "\t");
////                print.print(fileNum + "\n");
////                print.close();
//                System.out.println();

            }

    }
/* This code is contributed by Rajat Mishra */