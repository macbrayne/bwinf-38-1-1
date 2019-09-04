final class FlowerBonus {
    private Flower.Colors flower1;
    private Flower.Colors flower2;
    private int bonus;

    FlowerBonus(Flower.Colors flower1, Flower.Colors flower2, int bonus) {
        this.flower1 = flower1;
        this.flower2 = flower2;
        this.bonus = bonus;
    }

    Flower.Colors getFlower1() {
        return flower1;
    }

    void setFlower1(Flower.Colors flower1) {
        this.flower1 = flower1;
    }

    Flower.Colors getFlower2() {
        return flower2;
    }

    void setFlower2(Flower.Colors flower2) {
        this.flower2 = flower2;
    }

    int getBonus() {
        return bonus;
    }

    void setBonus(int bonus) {
        if (bonus < 1 || bonus > 3) {
            throw new IllegalArgumentException(String.format("Out of Range. Expected: 1-3 Actual: %s", bonus));
        }
        this.bonus = bonus;
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