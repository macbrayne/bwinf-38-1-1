import java.util.Objects;

public class FlowerResult {
    FlowerBonus bonus;
    Flower flower1, flower2;

    public FlowerResult(Flower flower1, Flower flower2, FlowerBonus bonus) {
        this.bonus = bonus;
        this.flower1 = flower1;
        this.flower2 = flower2;
    }

    public FlowerBonus getBonus() {
        return bonus;
    }

    public Flower getFlower1() {
        return flower1;
    }

    public Flower getFlower2() {
        return flower2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlowerResult that = (FlowerResult) o;
        return Objects.equals(bonus, that.bonus) &&
                ((Objects.equals(flower1, that.flower1) && Objects.equals(flower2, that.flower2)) ||
                        (Objects.equals(flower1, that.flower2) && Objects.equals(flower2, that.flower1)));
    }

    @Override
    public int hashCode() {
        return Objects.hash(bonus, flower1, flower2);
    }

    @Override
    public String toString() {
        return "FlowerResult{" +
                "bonus=" + bonus +
                ", flower1=" + flower1 +
                ", flower2=" + flower2 +
                '}';
    }
}
