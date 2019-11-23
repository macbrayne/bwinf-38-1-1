import java.util.Arrays;
import java.util.Random;

final class Main {
    public static void main(String[] args) {
        Flowerbed[] flowerbeds = Parser.run();
        Arrays.stream(flowerbeds).forEach(Main::findOptimum);
    }

    private static void init(Flowerbed flowerbed) {
        for (int i = 0; i < flowerbed.getFlowerCount(); i++) {
            flowerbed.setFlower(i, Flower.getRandom());
        }
    }


    private static void findOptimum(Flowerbed flowerbed) {
        long start = System.nanoTime();
        init(flowerbed);
        double temperature = flowerbed.getAnnealingScore() - 20;
        Random rng = new Random();
        Flowerbed working = flowerbed;
        Flowerbed best = new Flowerbed(flowerbed);
        for (int i = 0; i < 2000000; i++) {
            Flowerbed copy = new Flowerbed(working);
            working.setFlower(rng.nextInt(working.getFlowerCount()), Flower.getRandom());
            int costDifference = copy.getAnnealingScore() - working.getAnnealingScore();
            if (calculateAcceptanceProbability(costDifference, temperature) > rng.nextDouble()) {
                working = new Flowerbed(copy);
            }
            if (working.getAnnealingScore() < best.getAnnealingScore()) {
                best = new Flowerbed(working);
            }
            temperature *= 0.9999; //0.99999
        }
        long finish = System.nanoTime();
        System.out.println((finish - start) / 1000000);
        prettyPrint(best);
    }

    private static double calculateAcceptanceProbability(int costDifference, double temperature) {
        if (costDifference < 0) {
            return 1.0;
        }
        return Math.exp(costDifference / temperature);
    }

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
}
