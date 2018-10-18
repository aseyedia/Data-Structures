import java.io.*;
import java.util.Scanner;

public class Main
    {

        public static void main(String[] args) throws FileNotFoundException
            {
                System.out.println(
                        "Please enter the full file name of the input.");
                Scanner input = new Scanner(System.in);
                String fileName = input.nextLine();
                try
                    {
                        BufferedReader file =
                                new BufferedReader(new FileReader(fileName));
                    } catch (FileNotFoundException e)
                    {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                        System.err.println(e.getMessage()
                                + ": couldn't find that file, friend.");
                    }

            }

    }
