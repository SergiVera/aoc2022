package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StaticUtils {
    public static final String BASE_RESOURCES_PATH = "/Users/mangelesmartinezmoreno/Library/Mobile Documents/com~apple~CloudDocs/Otros/Programming/aoc2022/src/main/resources/";

    public static List<String> inputFileToStringList(File inputFile) {
        List<String> inputList = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            String line = "";
            while ((line = br.readLine()) != null) {
                inputList.add(line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return inputList;
    }
}