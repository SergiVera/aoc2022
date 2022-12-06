import utils.StaticUtils;

import java.io.File;
import java.util.List;

public class Day6 {
    private final List<String> input;
    private int sumOfPriorities;

    private Day6(File file) {
        input = StaticUtils.inputFileToStringList(file);
        sumOfPriorities = 0;
    }

    private void initialize() {
        sumOfPriorities = 0;
    }

    private int runFirstPart() {
        for (String rucksack : input) {

        }

        return sumOfPriorities;
    }

    private int runSecondPart() {
        for (int i = 0; i < input.size() - 2; i+=3) {

        }

        return sumOfPriorities;
    }

    public static void main(String[] args) {
        Day6 day6 = new Day6(new File("/Users/mangelesmartinezmoreno/Library/Mobile Documents/com~apple~CloudDocs/Otros/Programming/src/main/resources/Day6.txt"));
        System.out.println(day6.runFirstPart());
        day6.initialize();
        System.out.println(day6.runSecondPart());
    }
}
