import java.util.Arrays;

final class Flowerbed {
    private int id;
    private FlowerBonus[] bonuses;
    private Flower[] flowers = new Flower[9];
    private int colorCount;

    Flowerbed(int id, FlowerBonus[] bonuses, int colorCount) {
        this.id = id;
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

    int getFlowerCount() {
        return flowers.length;
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

    public int getId() {
        return id;
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
