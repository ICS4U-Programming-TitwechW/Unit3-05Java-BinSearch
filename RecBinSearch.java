import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
* Program finds a number using binary search.
*
* @author Titwech Wal
* @version 1.0
* @since   2023-06-09
*/

public final class RecBinSearch {

    /**
     * This is a private constructor used to satisfy the.
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private RecBinSearch() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     */
    public static void main(String[] args) {

        // Pass path to file as parameter.
        final File input = new File("input.txt");

        // Display on the marks spreadsheet.
        final File output = new File("output.txt");

        final List<String> inputLines = new ArrayList<>();

        try {

            // Create FileWriter object to write to file.
            final FileWriter fW = new FileWriter(output);
            // Create Scanner object to read from file.
            final Scanner sc = new Scanner(input);
            // Create PrintWriter object to write to file.
            final PrintWriter write = new PrintWriter(fW);

            while (sc.hasNextLine()) {
                // Read the next line as a string.
                final String line = sc.nextLine();

                // Add it to a list/
                inputLines.add(line);
            }

            // Process each pair of input lines
            for (int counter = 0; counter < inputLines.size(); counter += 2) {
                // Parse the array of numbers
                final String[] numStrings = inputLines.get(counter).split(" ");
                final int[] array = new int[numStrings.length];

                for (int SecCounter = 0; SecCounter
                        < numStrings.length; SecCounter++) {
                    array[SecCounter] =
                        Integer.parseInt(numStrings[SecCounter]);
                }

                // Sort the array.
                java.util.Arrays.sort(array);

                // Parse the array.
                final int searchNum =
                    Integer.parseInt(inputLines.get(counter + 1).trim());

                // Call function.
                final int index =
                    recBinS(array, 0, array.length - 1, searchNum);

                // Print to file and console.
                System.out.println(index);
                write.println(index);
            }

            // Closes scanner & writer.
            write.close();
            sc.close();

        } catch (IOException error) {
            System.out.println("An error occurred: "
                + error.getMessage());

        }
    }

    /**
     * This function returns recBinS.
     *
     * @param arrayNum
     * @param start
     * @param end
     * @param searchNum
     *
     * @return recBinS
     *
     */
    public static int recBinS(int[] arrayNum,
            int start, int end, int searchNum) {
        // The the input number is not found
        // Return -1
        if (start > end) {
            return -1;
        }

        // Calculate the middle index
        final int mid = (start + end) / 2;

        // Input number doesn't mid return mid
        if (arrayNum[mid] == searchNum) {
            return mid;

        } else if (searchNum > arrayNum[mid]) {
            // If search number is greater than
            // Middle element, search in the right half
            return recBinS(arrayNum, mid + 1, end, searchNum);

        } else {
            // If search number is less than middle
            // Element, search in the left half
            return recBinS(arrayNum, start, mid - 1, searchNum);
        }
    }
}
