import types.RockPaperScissorsEnum;
import utils.StaticUtils;

import java.io.File;
import java.util.List;

import static types.RockPaperScissorsEnum.PAPER;
import static types.RockPaperScissorsEnum.ROCK;
import static types.RockPaperScissorsEnum.SCISSORS;

public class Day2 {

    private final List<String> input;
    private int totalScore;

    private Day2(File file) {
        input = StaticUtils.inputFileToStringList(file);
        totalScore = 0;
    }

    private void initialize() {
        totalScore = 0;
    }

    private int runFirstPart() {
        for (String play : input) {
            RockPaperScissorsEnum opponent = RockPaperScissorsEnum.getEnumFromShape(String.valueOf(play.charAt(0))).get();
            RockPaperScissorsEnum player = RockPaperScissorsEnum.getEnumFromShape(String.valueOf(play.charAt(2))).get();

            int result = getResult(opponent, player);

            totalScore += result + player.getScore();
        }

        return totalScore;
    }

    private int getResult(RockPaperScissorsEnum opponent, RockPaperScissorsEnum player) {
        if (opponent.equals(player)) {
            return 3;
        } else if ((opponent.equals(PAPER) && player.equals(ROCK))
                || (opponent.equals(ROCK) && player.equals(SCISSORS))
                || (opponent.equals(SCISSORS) && player.equals(PAPER))) {
            return 0;
        } else {
            return 6;
        }
    }

    private int runSecondPart() {
        for (String play : input) {
            RockPaperScissorsEnum opponent = RockPaperScissorsEnum.getEnumFromShape(String.valueOf(play.charAt(0))).get();
            RockPaperScissorsEnum player = RockPaperScissorsEnum.getEnumFromShape(String.valueOf(play.charAt(2))).get();

            int result = getResultNewStrategy(opponent, player);

            switch (player.getPlayer()) {
                case "X":
                    totalScore += result;
                    break;
                case "Y":
                    totalScore += result + 3;
                    break;
                default:
                    totalScore += result + 6;
                    break;
            }
        }

        return totalScore;
    }

    private int getResultNewStrategy(RockPaperScissorsEnum opponent, RockPaperScissorsEnum player) {
        switch (player.getPlayer()) {
            case "X":
                if (opponent == PAPER) {
                    return ROCK.getScore();
                } else if (opponent == ROCK) {
                    return SCISSORS.getScore();
                } else {
                    return PAPER.getScore();
                }
            case "Y":
                return opponent.getScore();
            default:
                if (opponent == PAPER) {
                    return SCISSORS.getScore();
                } else if (opponent == ROCK) {
                    return PAPER.getScore();
                } else {
                    return ROCK.getScore();
                }
        }
    }

    public static void main(String[] args) {
        Day2 day2 = new Day2(new File("/Users/mangelesmartinezmoreno/Library/Mobile Documents/com~apple~CloudDocs/Otros/Programming/src/main/resources/Day2.txt"));
        System.out.println(day2.runFirstPart());
        day2.initialize();
        System.out.println(day2.runSecondPart());
    }
}
