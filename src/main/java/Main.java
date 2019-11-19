public final class Main {
    public static void main(String[] args) {
        Flowerbed[] flowerbeds = Parser.run();
        findOptimum(flowerbeds);
    }


    private static void findOptimum(Flowerbed[] data) {
        for (var flowerbed : data) {
            for (var i = 0; i < flowerbed.getFlowerCount(); i++) {
                flowerbed.setFlower(i, Flower.getRandom());
            }
            //TODO: Implement algorithm

            prettyPrint(flowerbed);
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
