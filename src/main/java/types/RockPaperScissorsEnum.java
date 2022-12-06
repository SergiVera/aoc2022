package types;

import java.util.Arrays;
import java.util.Optional;

public enum RockPaperScissorsEnum {

    ROCK("A", "X", 1),
    PAPER("B", "Y", 2),
    SCISSORS("C", "Z", 3);

    private final String opponent;
    private final String player;
    private final int score;

    RockPaperScissorsEnum(String opponent, String player, int score) {
        this.opponent = opponent;
        this.player = player;
        this.score = score;
    }

    public String getOpponent() {
        return opponent;
    }

    public String getPlayer() {
        return player;
    }

    public int getScore() {
        return score;
    }

    public static Optional<RockPaperScissorsEnum> getEnumFromShape(String shape) {
        return Arrays.stream(RockPaperScissorsEnum.values())
                .filter(shapeValue -> shapeValue.getOpponent().equals(shape)
                        || shapeValue.getPlayer().equals(shape))
                .findFirst();
    }
}
