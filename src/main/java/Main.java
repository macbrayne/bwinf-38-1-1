import java.util.Arrays;

final class Main {
    public static void main(String[] args) {
        Flowerbed[] flowerbeds = Parser.run();
        Arrays.stream(flowerbeds).forEach(Main::findOptimum);
    }


    private static void findOptimum(Flowerbed flowerbed) {
        // For tracking the duration of the algorithm run
        long start = System.nanoTime();
        Flowerbed working = flowerbed;
        int bestScore = 0;
        for (int i = 0; i < 2000000; i++) {
            Flowerbed copy = new Flowerbed(working);
            for (int j = 0; j < copy.getFlowerCount(); j++) {
                copy.setFlower(j, Flower.getRandom());
            }
            if (copy.getScore() > bestScore) {
                bestScore = copy.getScore();
                working = new Flowerbed(copy);
            }
        }
        // After finishing stop the timer
        long finish = System.nanoTime();
        // and print the duration
        System.out.println("Das Blumenbeet hat " + (finish - start) / 1000000 + "ms zum Lösen gebraucht");
        // Print the flowerbed
        prettyPrint(working);
    }

    /**
     * Prints a graphical representation of the flowerbed
     *
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
    }
}
