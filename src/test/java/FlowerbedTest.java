import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FlowerbedTest {

    @Test
    void getScore() {
        var bonus = new FlowerBonus[]{new FlowerBonus(Flower.Colors.BLUE, Flower.Colors.RED, 3),
                new FlowerBonus(Flower.Colors.RED, Flower.Colors.TURQUOISE, 2)};
        Flowerbed input = new Flowerbed(0, bonus, 7);
        input.setFlower(0, new Flower(Flower.Colors.RED));
        input.setFlower(1, new Flower(Flower.Colors.TURQUOISE));
        input.setFlower(2, new Flower(Flower.Colors.PINK));
        input.setFlower(3, new Flower(Flower.Colors.YELLOW));
        input.setFlower(4, new Flower(Flower.Colors.BLUE));
        input.setFlower(5, new Flower(Flower.Colors.ORANGE));
        input.setFlower(6, new Flower(Flower.Colors.GREEN));
        input.setFlower(7, new Flower(Flower.Colors.RED));
        input.setFlower(8, new Flower(Flower.Colors.TURQUOISE));
        System.out.println(input);
        assertEquals(7, input.getScore());
    }
}