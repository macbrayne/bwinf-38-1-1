import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FlowerbedTest {

    @Test
    void getScore() {
        var bonus = new FlowerBonus[]{new FlowerBonus(Flower.Colors.BLUE, Flower.Colors.RED, 3),
                new FlowerBonus(Flower.Colors.RED, Flower.Colors.TURQUOISE, 2)};
        Flowerbed input = new Flowerbed(0, bonus, 7);
        input.setFlower(0, new Flower(Flower.Colors.RED));
        assertEquals(input.getScore(), 7);
    }
}