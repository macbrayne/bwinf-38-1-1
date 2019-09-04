import java.util.Arrays;

public final class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(Parser.run()));
        var flowerbed = new Flowerbed(
                new FlowerBonus[]{new FlowerBonus(Flower.Colors.GREEN, Flower.Colors.BLUE, 2)},
                3);
        for (int i = 0; i < 9; i++) {
            flowerbed.setFlower(i, new Flower(Flower.Colors.RED));
        }
        prettyPrint(flowerbed);
    }

    public static void prettyPrint(Flowerbed result) {
        System.out.println("Hochbeet:");
        System.out.println(String.format("    %d    ", result.getFlower(0).color.value()));
        System.out.println(String.format("  %d   %d  ", result.getFlower(1).color.value(),
                result.getFlower(2).color.value()));
        System.out.println(String.format("%d   %d   %d", result.getFlower(3).color.value(),
                result.getFlower(4).color.value(), result.getFlower(5).color.value()));
        System.out.println(String.format("  %d   %d  ", result.getFlower(6).color.value(),
                result.getFlower(7).color.value()));
        System.out.println(String.format("    %d    ", result.getFlower(8).color.value()));
        System.out.println(String.format("Bewertung: %d", result.getScore()));
    }
}
