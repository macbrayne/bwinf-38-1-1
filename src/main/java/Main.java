public final class Main {
    public static void main(String[] args) {
        Flowerbed[] data = Parser.run();
        var flowerbed = new Flowerbed(
                new FlowerBonus[]{new FlowerBonus(Flower.Colors.GREEN, Flower.Colors.BLUE, 2)},
                3);
        for (int i = 0; i < 9; i++) {
            flowerbed.setFlower(i, new Flower(Flower.Colors.RED));
        }
        prettyPrint(flowerbed);
    }

    private static void prettyPrint(Flowerbed result) {
        System.out.println("Hochbeet:\n" +
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
