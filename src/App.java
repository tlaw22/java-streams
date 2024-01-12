import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) throws Exception {
        String div = "===============";
        System.out.println("Executing app...");
        IntStream
                .range(1, 10)
                .skip(5)
                .forEach((x) -> System.out.print(x));
        System.out.println();
        ;
        System.out.println(div);
        int val = IntStream
                .range(1, 5)
                .sum();
        System.out.println(val);
        System.out.println(div);

        Stream.of("Zebra", "Tom", "Rick")
                .sorted()
                .findFirst()
                .ifPresent((x) -> System.out.println(x));
        System.out.println(div);

        String[] items = { "car", "computer", "toothpaste", "box", "pencil", "tent", "door", "toy" };
        Stream.of(items)
                .filter((x) -> x.startsWith("t"))
                .sorted()
                .forEach(x -> System.out.println(x + ", "));
        System.out.println(div);

        Arrays.stream(new int[] { 2, 4, 6, 8, 9, 10, 12 })
                .map((x -> x * x))
                .average()
                .ifPresent(n -> System.out.println(n));
        System.out.println(div);

        List<String> listOfItems = Arrays.asList("car", "Computer", "toothpaste", "box", "pencil", "tent", "door",
                "toy");
        listOfItems.stream()
                .map(x -> x.toLowerCase())
                .filter(x -> x.startsWith("c"))
                .sorted()
                .forEach(x -> System.out.println(x + ", "));
        System.out.println(div);

        Stream<String> lines = Files.lines(Paths.get("Files/wordFile.txt"));
        lines.sorted()
                .filter(l -> l.length() > 6)
                .forEach(x -> System.out.print(x + ", "));
        lines.close();

        System.out.println(div);

        List<String> words = Files.lines(Paths.get("Files/wordFile.txt"))
                .filter(x -> x.contains("th"))
                .collect(Collectors.toList());
        words.forEach(x -> System.out.print(x + ", "));
        System.out.println();
        System.out.println(div);

        Stream<String> rows = Files.lines(Paths.get("Files/stockDataCsv.csv"));
        int rowCount = (int) rows
                .map(x -> x.split(","))
                .filter(x -> x.length > 3)
                .count();
        System.out.println(rowCount + " good rows");
        rows.close();
        System.out.println(div);
        Stream<String> rows2 = Files.lines(Paths.get("Files/stockDataCsv.csv"));
        rows2.map(x -> x.split(","))
                .filter(x -> x.length > 3)
                .filter(x -> Integer.parseInt(x[1].trim()) > 15)
                .forEach(x -> System.out.println(x[0].trim() + " " + x[1].trim() + " " + x[3].trim()));
        rows2.close();

    }

}
