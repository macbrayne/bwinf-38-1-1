import java.util.Arrays;

/**
 * Stores and calculates flowerbed related information
 */
final class Flowerbed {
    /**
     * File suffix for distinguishing flowerbeds
     */
    private final int id;

    /**
     * Bonuses as being described in the file
     */
    private final FlowerBonus[] bonuses;
    /**
     * Flowers
     */
    private final Flower[] flowers;
    /**
     * Number of flower colors to be put into the flowerbed
     */
    private int colorCount;

    Flowerbed(int id, FlowerBonus[] bonuses, int colorCount) {
        this.id = id;
        if (colorCount > 7 || bonuses.length > 7) {
            throw new IllegalArgumentException(String.format("Out of Range. Expected: <7 Actual: %s",
                    colorCount > 7 ? colorCount : bonuses.length));
        }
        this.bonuses = bonuses;
        this.colorCount = colorCount;
        flowers = new Flower[9];
    }

    Flowerbed(Flowerbed copy) {
        this.id = copy.id;
        this.bonuses = copy.bonuses.clone();
        this.flowers = copy.flowers.clone();
        this.colorCount = copy.colorCount;
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

    int getScore() {
        // Flower color count check
        if (Arrays.stream(flowers).map(i -> i.color).distinct().count() < colorCount) {
            return -10;
        }


        int score = 0;
        // Loop through flowers
        for (int i = 0; i < flowers.length; i++) {
            Flower flower = flowers[i];
            // Loop through neighbours
            for (int relativeIndex : getRelativeNeighbourIndices(i)) {
                Flower neighbourFlower = flowers[i + relativeIndex];
                // Check for bonus
                if (Arrays.stream(bonuses).anyMatch(bonus -> bonus.checkForBonus(flower.color, neighbourFlower.color))) {
                    FlowerBonus pair = Arrays.stream(bonuses).filter(bonus -> bonus.checkForBonus(flower.color, neighbourFlower.color)).findAny().get();
                    // Apply bonus
                    score += pair.getBonus();
                }
            }
        }
        return score;
    }

    /**
     * @param index Index to look from
     * @return Returns the relative index of the neighbours
     */
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

    /**
     * @return The id set at the creation of the object
     */
    int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Flowerbed{" +
                "id=" + id +
                ", bonuses=" + Arrays.toString(bonuses) +
                ", flowers=" + Arrays.toString(flowers) +
                ", colorCount=" + colorCount +
                '}';
    }
}
