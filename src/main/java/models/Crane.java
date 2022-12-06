package models;

import java.util.*;
import java.util.stream.Stream;

public class Crane {

    private final List<Stack<String>> stacks;

    public Crane(int size) {
        this.stacks = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            stacks.add(new Stack<>());
        }
    }

    public List<Stack<String>> getStacks() {
        return stacks;
    }

    public void insertCrateIntoStack(int stackNumber, String crate) {
        stacks.get(stackNumber).push(crate);
    }

    public void orderStackCranes() {
        for (Stack<String> stack : stacks) {
            List<String> crates = new ArrayList<>();
            do {
                String crate = stack.pop();
                crates.add(crate);
            }
            while (stack.size() > 0);

            for (String crate : crates) {
                stack.push(crate);
            }
        }
    }
}
