import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        boolean debug = true;
        int checks = 0;
        Scanner reader = new Scanner(new File("letter_frequency.csv"));
        String[] letters = new String[26];
        int[] frequencies = new int[26];
        double[] percentages = new double[26];
        int index = 0;

        try {
            while (reader.hasNext()) {
                String[] lineData = reader.nextLine().split(",");
                letters[index] = lineData[0].replaceAll("\"", "");
                frequencies[index] = Integer.parseInt(lineData[1]);
                percentages[index] = Double.parseDouble(lineData[2]);
                index++;
            }
            reader.close();
            checks++;
        } catch (Exception e) {
            if (debug) {
                System.err.println("Error reading file: " + e.getMessage());
            }
        }

        // Debug success message for reading
        if (checks == 1) {
            System.out.println("Reading was successful.");
        }

        // Calculate average frequency
        int totalFrequency = 0;
        try {
            totalFrequency = Arrays.stream(frequencies).sum();
            int averageFrequency = totalFrequency / frequencies.length;
            System.out.println("Average Frequency: " + averageFrequency);
        } catch (ArithmeticException e) {
            if (debug) {
                System.err.println("Error calculating average frequency: " + e.getMessage());
            }
        }

        // Calculate combined percentage
        double totalPercentage = 0.0;
        try {
            totalPercentage = Arrays.stream(percentages).sum();
            System.out.println("Combined Percentage: " + totalPercentage);
        } catch (Exception e) {
            if (debug) {
                System.err.println("Error calculating combined percentage: " + e.getMessage());
            }
        }

        // Debugging for final output
        if (debug) {
            System.out.println("Debugging Output:");
            System.out.println("Letters: " + Arrays.toString(letters));
            System.out.println("Frequencies: " + Arrays.toString(frequencies));
            System.out.println("Percentages: " + Arrays.toString(percentages));
        }
    }
}
