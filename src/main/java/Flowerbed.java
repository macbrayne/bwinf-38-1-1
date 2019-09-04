import java.util.Arrays;

final class Flowerbed {
    private FlowerBonus[] bonuses;
    private Flower[] flowers = new Flower[9];
    private int colorCount;

    Flowerbed(FlowerBonus[] bonuses, int colorCount) {
        if (colorCount > 7 || bonuses.length > 7) {
            throw new IllegalArgumentException(String.format("Out of Range. Expected: <7 Actual: %s",
                    colorCount > 7 ? colorCount : bonuses.length));
        }
        this.bonuses = bonuses;
        this.colorCount = colorCount;
    }

    FlowerBonus[] getBonuses() {
        return bonuses;
    }

    Flower getFlower(int index) {
        return flowers[index];
    }

    void setFlower(int index, Flower flower) {
        flowers[index] = flower;
    }

    int getColorCount() {
        return colorCount;
    }

    int getScore() {
        //TODO: Calculate Score
        return 0;
    }

    @Override
    public String toString() {
        return "Flowerbed{" +
                "bonuses=" + Arrays.toString(bonuses) +
                ", flowers=" + Arrays.toString(flowers) +
                ", colorCount=" + colorCount +
                '}';
    }
}
