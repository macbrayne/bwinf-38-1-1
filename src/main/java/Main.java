import java.util.Arrays;

final class Main {
    public static void main(String[] args) {
        Flowerbed[] flowerbeds = Parser.run();
        Arrays.stream(flowerbeds).forEach((flowerbed) -> {
            findOptimum(flowerbed);
            Main.prettyPrint(flowerbed);
        });
    }


    private static void findOptimum(Flowerbed flowerbed) {
        int i = 0;
        int bestScore = 0;
        while (i < 10000) {
            Flowerbed copy = new Flowerbed(flowerbed);
            for (var j = 0; j < copy.getFlowerCount(); j++) {
                copy.setFlower(j, Flower.getRandom());
            }
            if (copy.getScore() > bestScore) {
                bestScore = copy.getScore();
                flowerbed = copy;
            }
            i++;
        }
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
                String.format("Bewertung: %d", result.getScore()));
    }
}
