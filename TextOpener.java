import java.io.File;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;

import java.util.ArrayList;

class TextOpener
{
    public static void main(String[] args) {
        boolean response = false;
            System.out.println("Enter 1 to open a file. Enter 2 to see a list of avaliable files.");
            Scanner input = new Scanner(System.in);
            if (input.nextLine().equals("1"))
                openFile();
            else if (input.nextLine().equals("2"))
                getNamesOfFiles();
            else
            {
                response = true;
                //System.out.println("Invalid Response!");
            }
    }
    public static void openFile()
    {
        try {
            System.out.print("Enter the file name: ");
            Scanner input = new Scanner(System.in);
            String inputValue = "C:\\Users\\Masroor Siddiqui\\OneDrive\\Pictures\\Documents\\GitHub\\csaFinal\\Text Files\\" + input.nextLine() + ".txt";
            File file = new File(inputValue);

            input = new Scanner(file);
            System.out.println("");
            while (input.hasNextLine()) {
                String line = input.nextLine();
                System.out.println(line);
            }
            input.close();
        } catch (Exception ex) {
            //ex.printStackTrace();
            System.out.println("File not found!");
        }
    }

    public static void getNamesOfFiles()
    {
        ArrayList<String> results = new ArrayList<String>();


        File[] files = new File("C:\\Users\\Masroor Siddiqui\\OneDrive\\Pictures\\Documents\\GitHub\\csaFinal\\Text Files").listFiles();
        //If this pathname does not denote a directory, then listFiles() returns null. 
        
        for (File file : files) {
            if (file.isFile()) {
                results.add(file.getName());
            }
        }
        for (String file: results)
        {
            System.out.println(file);
        }
    }
}