enum Flowers {
    BLUE("blau", 1), YELLOW("gelb", 2),
    GREEN("gruen", 3), ORANGE("orange", 4),
    PINK("rosa", 5), RED("rot", 6),
    TURQUOISE("tuerkis", 7);
    final private String parser;
    final private int value;

    Flowers(String parser, int value) {
        this.parser = parser;
        this.value = value;
    }

    static Flowers parseString(String parser) {
        for (Flowers flower : values()) {
            if (flower.parser.equals(parser)) return flower;
        }
        return null;
    }

    public int value() {
        return value;
    }
}