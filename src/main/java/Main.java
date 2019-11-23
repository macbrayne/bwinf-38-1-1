import java.util.Arrays;

final class Main {
    public static void main(String[] args) {
        Flowerbed[] flowerbeds = Parser.run();
        Arrays.stream(flowerbeds).forEach(Main::findOptimum);
    }

    private static void init(Flowerbed flowerbed) {
        for (int i = 0; i < flowerbed.getFlowerCount(); i++) {
            flowerbed.setFlower(i, new Flower(Flower.Colors.BLUE));
        }
    }

    private static void findOptimum(Flowerbed flowerbed) {
        init(flowerbed);
        Flowerbed working = flowerbed;
        int bestScore = -10;
        for (int flowerIndex = 0; flowerIndex < flowerbed.getFlowerCount(); flowerIndex++) {
            for (int colorIndex = 0; colorIndex < Flower.Colors.size(); colorIndex++) {
                for (int innerFlowerIndex = 0; innerFlowerIndex < flowerbed.getFlowerCount(); innerFlowerIndex++) {
                    for (int innerColorIndex = 0; innerColorIndex < Flower.Colors.size(); innerColorIndex++) {
                        Flowerbed copy = new Flowerbed(working);
                        copy.setFlower(innerFlowerIndex, new Flower(Flower.Colors.fromValue(innerColorIndex + 1)));
                        if (copy.getScore() > bestScore) {
                            bestScore = copy.getScore();
                            working = new Flowerbed(copy);
                        }
                    }
                }
            }
        }
        prettyPrint(working);
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
