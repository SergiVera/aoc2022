import models.Crane;
import utils.StaticUtils;

import java.io.File;
import java.util.*;

import static utils.StaticUtils.BASE_RESOURCES_PATH;

public class Day5 {
    private final List<String> input;
    private Crane crane;
    private String cratesAtTheTop;
    private int quantity;
    private int sourceStack;
    private int destinationStack;

    private Day5(File file) {
        input = StaticUtils.inputFileToStringList(file);
        initialize();
    }

    private void initialize() {
        cratesAtTheTop = "";
        generateCrane();
    }

    private void generateCrane() {
        crane = new Crane(9);

        String craneString = """
                        [H]     [W] [B]           \s
                    [D] [B]     [L] [G] [N]       \s
                [P] [J] [T]     [M] [R] [D]       \s
                [V] [F] [V]     [F] [Z] [B]     [C]
                [Z] [V] [S]     [G] [H] [C] [Q] [R]
                [W] [W] [L] [J] [B] [V] [P] [B] [Z]
                [D] [S] [M] [S] [Z] [W] [J] [T] [G]
                [T] [L] [Z] [R] [C] [Q] [V] [P] [H]
                 1   2   3   4   5   6   7   8   9\s
                """;
        List<String> lines = craneString.lines().toList();
        lines = lines.subList(0, lines.size() - 1);

        for (String line : lines) {
            int j = 0;
            for (int i = 1; i < 38 && i < line.length(); i += 4, ++j) {
                char c = line.charAt(i);
                if (c != ' ') {
                    crane.insertCrateIntoStack(j, String.valueOf(c));
                }
            }
        }

        crane.orderStackCranes();
    }

    private String runFirstPart() {
        List<Stack<String>> stacks = crane.getStacks();

        for (String arrangement : input) {
            processArrangement(arrangement);

            for (int i = 0; i < quantity; i++) {
                String crate = stacks.get(sourceStack-1).pop();
                stacks.get(destinationStack-1).push(crate);
            }
        }

        for (Stack<String> stack : stacks) {
            cratesAtTheTop = cratesAtTheTop.concat(stack.peek());
        }

        return cratesAtTheTop;
    }

    private String runSecondPart() {
        List<Stack<String>> stacks = crane.getStacks();

        for (String arrangement : input) {
            processArrangement(arrangement);

            List<String> cratesToArrange = new ArrayList<>();

            for (int i = 0; i < quantity; i++) {
                String crate = stacks.get(sourceStack-1).pop();
                cratesToArrange.add(crate);
            }

            Collections.reverse(cratesToArrange);
            cratesToArrange.forEach(crate -> stacks.get(destinationStack-1).push(crate));
        }

        for (Stack<String> stack : stacks) {
            cratesAtTheTop = cratesAtTheTop.concat(stack.peek());
        }

        return cratesAtTheTop;
    }

    private void processArrangement(String arrangement) {
        quantity = Integer.parseInt(arrangement.split(" ")[1]);
        sourceStack = Integer.parseInt(arrangement.split(" ")[3]);
        destinationStack = Integer.parseInt(arrangement.split(" ")[5]);
    }

    public static void main(String[] args) {
        Day5 day5 = new Day5(new File(BASE_RESOURCES_PATH + "Day5.txt"));
        System.out.println(day5.runFirstPart());
        day5.initialize();
        System.out.println(day5.runSecondPart());
    }
}
