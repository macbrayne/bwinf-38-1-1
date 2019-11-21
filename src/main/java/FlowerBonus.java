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

    Flower.Colors getFlower2() {
        return flower2;
    }

    int getBonus() {
        return bonus;
    }

    boolean checkForBonus(Flower.Colors flower1, Flower.Colors flower2) {
        return (flower1 == this.flower1 && flower2 == this.flower2) ||
                (flower2 == this.flower1 && flower1 == this.flower2);
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