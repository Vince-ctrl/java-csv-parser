import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner reader = new Scanner(new File("src\\letter_frequency.csv"));
        String[] letters = new String[26];
        int[] frequencies = new int[26];
        double[] percentages = new double[26];
        int index = 0;

        // Read CSV file and store data in arrays
        while (reader.hasNext()) {
            String[] lineData = reader.nextLine().split(",");
            letters[index] = lineData[0].replaceAll("\"", "");
            frequencies[index] = Integer.parseInt(lineData[1]);
            percentages[index] = Double.parseDouble(lineData[2]);
            index++;
        }
        reader.close();

        // Calculate average frequency
        int totalFrequency = Arrays.stream(frequencies).sum();
        int averageFrequency = totalFrequency / frequencies.length;

        // Calculate combined percentage
        double totalPercentage = Arrays.stream(percentages).sum();

        // Print results
        System.out.println("Letters: " + Arrays.toString(letters));
        System.out.println("Average Frequency: " + averageFrequency);
        System.out.println("Combined Percentage: " + totalPercentage);
    }
}
