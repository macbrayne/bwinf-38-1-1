import java.util.Arrays;
import java.util.Random;

/**
 * Class for differentiating between Flowers (like in a flowerbed) and Colors (like in the flower bonus)
 */
class Flower {
    /**
     * The flower color
     */
    Colors color;

    Flower(Colors color) {
        this.color = color;
    }

    /**
     * Generates and returns a new flower with a random color
     *
     * @return Random flower
     */
    static Flower getRandom() {
        return new Flower(Colors.fromValue(new Random().nextInt(Colors.count()) + 1));
    }

    /**
     * Enum for storing all possible Flower Colors
     */
    enum Colors {
        BLUE("blau", 1), YELLOW("gelb", 2),
        GREEN("gruen", 3), ORANGE("orange", 4),
        PINK("rosa", 5), RED("rot", 6),
        TURQUOISE("tuerkis", 7);
        /**
         * German version of the name
         */
        final private String parser;
        /**
         * int representation in the program
         */
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

        /**
         * @param value Int value
         * @return Returns the Color corresponding to a integer
         */
        static Colors fromValue(int value) {
            return Arrays.stream(Colors.values()).filter(i -> i.value == value).findAny().orElseThrow(() -> new IllegalStateException(String.format("Unsupported type %s", value)));
        }

        static int count() {
            return (int) Arrays.stream(Colors.values()).count();
        }

        public int value() {
            return value;
        }

        public String getParser() {
            return parser;
        }
    }
}
