import java.util.Arrays;
import java.util.Random;

/**
 *
 */
final class Main {
    /**
     *
     */
    public static void main(String[] args) {
        Flowerbed[] flowerbeds = Parser.run();
        Arrays.stream(flowerbeds).forEach(Main::findOptimum);
    }

    /**
     * Sets all flowers in a flowerbed to a random color.
     *
     * @param flowerbed Flowerbed to be initialised
     */
    private static void init(Flowerbed flowerbed) {
        for (int i = 0; i < flowerbed.getFlowerCount(); i++) {
            flowerbed.setFlower(i, Flower.getRandom());
        }
    }


    /**
     * @param flowerbed Finds and prints the optimum flower constellation
     */
    private static void findOptimum(Flowerbed flowerbed) {
        // For tracking the duration of the algorithm run
        long start = System.nanoTime();
        // Randomize flowerbed
        init(flowerbed);
        // Set the Annealing start temperature
        double temperature = flowerbed.getAnnealingScore() - 20;
        Random rng = new Random();

        Flowerbed current = flowerbed; // The current flowerbed
        Flowerbed best = new Flowerbed(flowerbed); // The best flowerbed
        for (int i = 0; i < 2000000; i++) {
            Flowerbed copy = new Flowerbed(current); // Copy the current flowerbed
            current.setFlower(rng.nextInt(current.getFlowerCount()), Flower.getRandom()); // Change a random flower's color
            int costDifference = copy.getAnnealingScore() - current.getAnnealingScore(); // Calculate the cost difference
            if (calculateAcceptanceProbability(costDifference, temperature) > rng.nextDouble()) {
                current = new Flowerbed(copy); // Set the current flowerbed to a copy of the modified
            }
            if (current.getAnnealingScore() < best.getAnnealingScore()) {
                best = new Flowerbed(current); // Sets the best flowerbed to a copy of the modified
            }
            temperature *= 0.9999; // Decrease the temperature
        }
        // After finishing stop the timer
        long finish = System.nanoTime();
        // Print the flowerbed
        prettyPrint(best);
        // Print the legend
        printLegend();
        // and print the duration
        System.out.println("Das Blumenbeet hat " + (finish - start) / 1000000 + "ms zum Lösen gebraucht");
    }

    /**
     * Returns the probability to accept a certain change
     *
     * @param costDifference Difference between the old and new cost
     * @param temperature    Current annealing temperature
     * @return Probability for change
     */
    private static double calculateAcceptanceProbability(int costDifference, double temperature) {
        if (costDifference < 0) {
            return 1.0;
        }
        return Math.exp(costDifference / temperature);
    }

    /**
     * Prints a graphical representation of the flowerbed
     * @param result The flowerbed to print
     */
    private static void prettyPrint(Flowerbed result) {
        System.out.println(String.format("Hochbeet: %d%n", result.getId()) +
                String.format("%5d      %n",
                        result.getFlower(0).color.value()) +
                String.format("%3d%4d   %n",
                        result.getFlower(1).color.value(),
                        result.getFlower(2).color.value()) +
                String.format("%d%4d%4d %n",
                        result.getFlower(3).color.value(),
                        result.getFlower(4).color.value(),
                        result.getFlower(5).color.value()) +
                String.format("%3d%4d   %n",
                        result.getFlower(6).color.value(),
                        result.getFlower(7).color.value()) +
                String.format("%5d      %n",
                        result.getFlower(8).color.value()) +
                String.format("Bewertung: %d%n", result.getScore()));
    }

    private static void printLegend() {
        for (int i = 0; i < Flower.Colors.count(); i++) {
            System.out.print(String.format(" %d -> %s ", i, Flower.Colors.fromValue(i + 1).getParser()));
        }
        System.out.println();
    }
}
