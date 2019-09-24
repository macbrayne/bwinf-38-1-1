public final class Main {
    public static void main(String[] args) {
        Flowerbed[] flowerbeds = Parser.run();
        Flowerbed optimum = findOptimum(flowerbeds);
        prettyPrint(optimum);
    }


    private static Flowerbed findOptimum(Flowerbed[] data) {
        //TODO: Implement algorithm
        return null;
    }

    private static void prettyPrint(Flowerbed result) {
        System.out.println("Hochbeet:\n" +
                String.format("%5d      %n",
                        result.getFlower(0).color.value()) +
                String.format("%3d%4d   %n",
                        result.getFlower(1).color.value(),
                        result.getFlower(2).color.value()) +
                String.format("%d%4d%4d %n",
                        result.getFlower(3).color.value(),
                        result.getFlower(4).color.value(),
                        result.getFlower(5).color.value()) +
                String.format("%3d%4d   %n",
                        result.getFlower(6).color.value(),
                        result.getFlower(7).color.value()) +
                String.format("%5d      %n",
                        result.getFlower(8).color.value()) +
                String.format("Bewertung: %d", result.getScore()));
    }
}
