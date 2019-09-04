import java.util.Arrays;

public final class Main {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(Parser.run()));
        var flowerbed = new Flowerbed(
                new FlowerBonus[]{new FlowerBonus(Flowers.GREEN, Flowers.BLUE, 2)},
                3);
        for (int i = 0; i < 9; i++) {
            flowerbed.setFlower(i, Flowers.RED);
        }
        prettyPrint(flowerbed);
    }

    public static void prettyPrint(Flowerbed result) {
        System.out.println("Hochbeet:");
        System.out.println(String.format("    %d    ", result.getFlower(0).value()));
        System.out.println(String.format("  %d   %d  ", result.getFlower(1).value(),
                result.getFlower(2).value()));
        System.out.println(String.format("%d   %d   %d", result.getFlower(3).value(),
                result.getFlower(4).value(), result.getFlower(5).value()));
        System.out.println(String.format("  %d   %d  ", result.getFlower(6).value(),
                result.getFlower(7).value()));
        System.out.println(String.format("    %d    ", result.getFlower(8).value()));
        System.out.println(String.format("Bewertung: %d", result.getScore()));
    }
}
