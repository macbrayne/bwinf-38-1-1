class Flower {
    Colors color;

    Flower(Colors color) {
        this.color = color;
    }

    enum Colors {
        BLUE("blau", 1), YELLOW("gelb", 2),
        GREEN("gruen", 3), ORANGE("orange", 4),
        PINK("rosa", 5), RED("rot", 6),
        TURQUOISE("tuerkis", 7);
        final private String parser;
        final private int value;

        Colors(String parser, int value) {
            this.parser = parser;
            this.value = value;
        }

        static Colors parseString(String parser) {
            for (Colors color : values()) {
                if (color.parser.equals(parser)) return color;
            }
            return null;
        }

        public int value() {
            return value;
        }
    }
}
