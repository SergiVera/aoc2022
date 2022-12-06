import models.Elf;
import utils.StaticUtils;

import java.io.File;
import java.util.List;

public class Day4 {
    private final List<String> input;
    private int pairsFullyContained;
    private int totalOverlaps;

    private Day4(File file) {
        input = StaticUtils.inputFileToStringList(file);
        pairsFullyContained = 0;
        totalOverlaps = 0;
    }

    private void run() {
        for (String pair : input) {
            Elf elf1 = new Elf(pair.split(",")[0]);
            Elf elf2 = new Elf(pair.split(",")[1].split(",")[0]);

            if ((elf1.getSectionFinish() >= elf2.getSectionStart() && elf1.getSectionFinish() <= elf2.getSectionFinish())
                    || (elf1.getSectionStart() >= elf2.getSectionStart() && elf1.getSectionStart() <= elf2.getSectionFinish())
                    || (elf2.getSectionFinish() >= elf1.getSectionStart() && elf2.getSectionFinish() <= elf1.getSectionStart())
                    || (elf2.getSectionStart() >= elf1.getSectionStart() && elf2.getSectionStart() <= elf1.getSectionFinish())) {
                totalOverlaps++;

                if ((elf2.getSectionStart() >= elf1.getSectionStart() && elf2.getSectionFinish() <= elf1.getSectionFinish())
                        || (elf1.getSectionStart() >= elf2.getSectionStart() && elf1.getSectionFinish() <= elf2.getSectionFinish())) {
                    pairsFullyContained++;
                }
            }
        }
    }

    public static void main(String[] args) {
        Day4 day4 = new Day4(new File("/Users/mangelesmartinezmoreno/Library/Mobile Documents/com~apple~CloudDocs/Otros/Programming/src/main/resources/Day4.txt"));
        day4.run();
        System.out.println(day4.pairsFullyContained);
        System.out.println(day4.totalOverlaps);
    }
}
