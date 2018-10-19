import java.io.*;
import java.util.Scanner;

public class Main
    {

        public static void main(String[] args)
                throws IOException, FileNotFoundException
            {
                System.out.println(
                        "Please enter the full file name of the input.");
                Scanner input = new Scanner(System.in);
                String fileName = input.nextLine();
                try
                    {
                        FileReader file = new FileReader(fileName);
                        while (file.ready() && file.read() != -1)
                            {

                                // Read header number of the matrix, which is
                                // the dimensions of the matrix, and then
                                // process the the 1s and 0s or something

                                // so I guess here the dimensions of the
                                // matrix will define how many possible
                                // direct connections the vertex in question
                                // can have

                                int dims = file.read();
                                for (int i = 0; i < dims; i++)
                                    {
                                        for (int q = 0; i < dims; i++)
                                            {
                                                
                                            }
                                    }
                            }

                    }

                catch (FileNotFoundException e)
                    {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                        System.err.println(e.getMessage()
                                + ": couldn't find that file, friend.");
                    }

            }

    }
