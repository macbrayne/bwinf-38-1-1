import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.stream.Stream;

class Parser {
    private static final int FILE_COUNT = 5;

    static Flowerbed[] run() {
        var result = new Flowerbed[FILE_COUNT];
        for (var i = 0; i < FILE_COUNT; i++) {
            String[] file = loadStrings(i + 1); // Loop begins with 0!
            // LINE 1:
            var colorCount = Integer.parseInt(file[0]);
            // LINE 2:
            var flowerBonusesSize = Integer.parseInt(file[1]);
            // NEXT LINES:
            var flowerBonuses = new ArrayList<FlowerBonus>();
            Stream.of(file).skip(2).forEach(line -> {
                String[] split = line.split(" ");
                var flowerColor1 = Flower.parseString(split[0]);
                var flowerColor2 = Flower.parseString(split[1]);
                var bonus = Integer.parseInt(split[2]);
                flowerBonuses.add(new FlowerBonus(flowerColor1, flowerColor2, bonus));
            });
            result[i] = new Flowerbed(flowerBonuses.toArray(new FlowerBonus[flowerBonusesSize]), colorCount);
        }
        return result;
    }

    private static String[] loadStrings(int iteration) {
        var content = new String[]{};
        var path = new File(ClassLoader.getSystemClassLoader().getResource(String.format("blumen%d.txt", iteration)).getPath()).toPath();
        try {
            content = Files.readAllLines(path).toArray(new String[]{});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
}
