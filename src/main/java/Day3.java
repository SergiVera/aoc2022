import utils.StaticUtils;

import java.io.File;
import java.util.List;

import static utils.StaticUtils.BASE_RESOURCES_PATH;

public class Day3 {

    private final String alphabet = "abcdefghijklmnopqrstuvwxyz";
    private final List<String> input;
    private int sumOfPriorities;

    private Day3(File file) {
        input = StaticUtils.inputFileToStringList(file);
        sumOfPriorities = 0;
    }

    private void initialize() {
        sumOfPriorities = 0;
    }

    private int runFirstPart() {
        for (String rucksack : input) {
            String firstCompartment = rucksack.substring(0, (rucksack.length() / 2));
            String secondCompartment = rucksack.substring((rucksack.length() / 2));

            char itemTypeShared = 0;

            for (char letter : firstCompartment.toCharArray()){
                if (secondCompartment.contains(String.valueOf(letter))) {
                    itemTypeShared = letter;
                }
            }

            if (!Character.isUpperCase(itemTypeShared)) {
                sumOfPriorities += alphabet.indexOf(String.valueOf(itemTypeShared)) + 1;
            } else {
                sumOfPriorities += alphabet.indexOf(String.valueOf(itemTypeShared).toLowerCase()) + 27;
            }
        }

        return sumOfPriorities;
    }

    private int runSecondPart() {
        for (int i = 0; i < input.size() - 2; i+=3) {
            char itemTypeShared = 0;

            for (char letter : input.get(i).toCharArray()){
                if (input.get(i+1).contains(String.valueOf(letter)) && input.get(i+2).contains(String.valueOf(letter))) {
                    itemTypeShared = letter;
                }
            }

            if (!Character.isUpperCase(itemTypeShared)) {
                sumOfPriorities += alphabet.indexOf(String.valueOf(itemTypeShared)) + 1;
            } else {
                sumOfPriorities += alphabet.indexOf(String.valueOf(itemTypeShared).toLowerCase()) + 27;
            }
        }

        return sumOfPriorities;
    }

    public static void main(String[] args) {
        Day3 day3 = new Day3(new File(BASE_RESOURCES_PATH + "Day3.txt"));
        System.out.println(day3.runFirstPart());
        day3.initialize();
        System.out.println(day3.runSecondPart());
    }
}
