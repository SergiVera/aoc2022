import utils.StaticUtils;

import java.io.File;
import java.util.*;

import static utils.StaticUtils.BASE_RESOURCES_PATH;

public class Day6 {
    private final char[] dataStreamBuffer;
    private Queue<Character> packet;
    private Queue<Character> message;
    private int startOfPacket;
    private int startOfMessage;

    private Day6(File file) {
        dataStreamBuffer = StaticUtils.inputFileToStringList(file).get(0).toCharArray();
        packet = new LinkedList<>();
        message = new LinkedList<>();
        startOfPacket = 0;
        startOfMessage = 0;
    }

    private int runFirstPart() {
        for (char marker : dataStreamBuffer) {
            if (packet.size() == 4) {
                packet.poll();
            }

            packet.add(marker);
            startOfPacket++;
            if (isAValidPacket(packet)) {
                break;
            }
        }

        return startOfPacket;
    }

    private int runSecondPart() {
        for (char marker : dataStreamBuffer) {
            if (message.size() == 14) {
                message.poll();
            }

            message.add(marker);
            startOfMessage++;
            if (isAValidMessage(message)) {
                break;
            }
        }

        return startOfMessage;
    }

    private boolean isAValidPacket(Queue<Character> packet) {
        return packet.equals(packet.stream().distinct().toList()) && packet.size() == 4;
    }

    private boolean isAValidMessage(Queue<Character> message) {
        return message.equals(message.stream().distinct().toList()) && message.size() == 14;
    }

    public static void main(String[] args) {
        Day6 day6 = new Day6(new File( BASE_RESOURCES_PATH + "Day6.txt"));
        System.out.println(day6.runFirstPart());
        System.out.println(day6.runSecondPart());
    }
}
