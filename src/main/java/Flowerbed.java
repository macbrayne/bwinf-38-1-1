import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
        // Flower color count check
        if (Arrays.stream(flowers).map(i -> i.color).distinct().count() < colorCount) {
            return -10;
        }


        Set<FlowerResult> pairs = new HashSet<>();
        int score = 0;
        for (int i = 0; i < flowers.length; i++) {
            Flower flower = flowers[i];
            for (int relativeIndex : getRelativeNeighbourIndices(i)) {
                Flower neighbourFlower = flowers[i + relativeIndex];
                if (Arrays.stream(bonuses).anyMatch(bonus -> bonus.checkForBonus(flower.color, neighbourFlower.color))) {
                    FlowerBonus pair = Arrays.stream(bonuses).filter(bonus -> bonus.checkForBonus(flower.color, neighbourFlower.color)).findAny().get();
                    pairs.add(new FlowerResult(flower, neighbourFlower, pair));
                }
            }
        }
        System.out.println(pairs);

        for (var pair : pairs) {
            score += pair.getBonus().getBonus();
        }
        return score;
    }

    private int[] getRelativeNeighbourIndices(int index) {
        int[] result = null;
        switch (index) {
            case 0:
                result = new int[]{1, 2};
                break;
            case 1:
                result = new int[]{-1, 1, 2, 3};
                break;
            case 2:
                result = new int[]{-2, -1, 2, 3};
                break;
            case 3:
                result = new int[]{-2, 1, 3};
                break;
            case 4:
                result = new int[]{-3, -2, -1, 1, 2, 3};
                break;
            case 5:
                result = new int[]{-3, -1, 2};
                break;
            case 6:
                result = new int[]{-3, -2, 1, 2};
                break;
            case 7:
                result = new int[]{-3, -2, -1, 1};
                break;
            case 8:
                result = new int[]{-2, -1};
                break;
        }

        return result;
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
