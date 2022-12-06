import utils.StaticUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static utils.StaticUtils.BASE_RESOURCES_PATH;

public class Day1 {

    private final List<String> input;
    private List<Integer> totalElfCalories;
    private int maxCalories;
    private int elfCalories;

    private Day1(File file) {
        input = StaticUtils.inputFileToStringList(file);
        totalElfCalories = new ArrayList<>();
        maxCalories = 0;
        elfCalories = 0;
    }

    private int runFirstPart() {
        for (String calories : input) {
            if (!calories.equals("")) {
                elfCalories += Integer.valueOf(calories);
            } else {
                if (elfCalories > maxCalories) {
                    maxCalories = elfCalories;
                }
                totalElfCalories.add(elfCalories);
                elfCalories = 0;
            }
        }
        return maxCalories;
    }

    private int runSecondPart() {
        List<Integer> sortedTotalElfCalories = totalElfCalories.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        return sortedTotalElfCalories.get(0) + sortedTotalElfCalories.get(1) + sortedTotalElfCalories.get(2);
    }


    public static void main(String[] args) {
        Day1 day1 = new Day1(new File(BASE_RESOURCES_PATH + "Day1.txt"));
        System.out.println(day1.runFirstPart());
        System.out.println(day1.runSecondPart());
    }
}
