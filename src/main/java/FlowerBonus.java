/**
 * Stores the bonus information stored inside the file
 */
final class FlowerBonus {
    private final Flower.Colors flower1;
    private final Flower.Colors flower2;
    private final int bonus;

    FlowerBonus(Flower.Colors flower1, Flower.Colors flower2, int bonus) {
        this.flower1 = flower1;
        this.flower2 = flower2;
        this.bonus = bonus;
    }

    int getBonus() {
        return bonus;
    }

    /**
     * Checks whether two flower colors are eligible for a bonus
     *
     * @param flower1 First Flower
     * @param flower2 Second flower
     * @return Result of the check
     */
    boolean checkForBonus(Flower.Colors flower1, Flower.Colors flower2) {
        return (flower1 == this.flower1 && flower2 == this.flower2);
    }

    @Override
    public String toString() {
        return "FlowerBonus{" +
                "flower1=" + flower1 +
                ", flower2=" + flower2 +
                ", bonus=" + bonus +
                '}';
    }
}