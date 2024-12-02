package CodingExercises.CodingExercises.InterviewExperiences.Oracle_ADBSTeam;

import java.util.HashMap;
import java.util.Map;

public class ConvertNumberIntoString {

    private static final Map<Integer, String> unitsMap = new HashMap<>();
    private static final Map<Integer, String> tensMap = new HashMap<>();
    private static final Map<Integer, String> teensMap = new HashMap<>();

    static {
        unitsMap.put(0, "");
        unitsMap.put(1, "one");
        unitsMap.put(2, "two");
        unitsMap.put(3, "three");
        unitsMap.put(4, "four");
        unitsMap.put(5, "five");
        unitsMap.put(6, "six");
        unitsMap.put(7, "seven");
        unitsMap.put(8, "eight");
        unitsMap.put(9, "nine");

        tensMap.put(2, "twenty");
        tensMap.put(3, "thirty");
        tensMap.put(4, "forty");
        tensMap.put(5, "fifty");
        tensMap.put(6, "sixty");
        tensMap.put(7, "seventy");
        tensMap.put(8, "eighty");
        tensMap.put(9, "ninety");

        teensMap.put(10, "ten");
        teensMap.put(11, "eleven");
        teensMap.put(12, "twelve");
        teensMap.put(13, "thirteen");
        teensMap.put(14, "fourteen");
        teensMap.put(15, "fifteen");
        teensMap.put(16, "sixteen");
        teensMap.put(17, "seventeen");
        teensMap.put(18, "eighteen");
        teensMap.put(19, "nineteen");
    }

    public static String convert(int number) {
        if (number == 0) {
            return "zero";
        }

        StringBuilder words = new StringBuilder();

        if (number / 1000 > 0) {
            words.append(unitsMap.get(number / 1000)).append(" thousand ");
            number %= 1000;
        }

        if (number / 100 > 0) {
            words.append(unitsMap.get(number / 100)).append(" hundred ");
            number %= 100;
        }

        if (number > 0) {
            if (number < 20) {
                words.append(teensMap.get(number));
            } else {
                words.append(tensMap.get(number / 10));
                if (number % 10 > 0) {
                    words.append(" ").append(unitsMap.get(number % 10));
                }
            }
        }

        return words.toString().trim();
    }

    public static void main(String[] args) {
        int number = 3254;
        System.out.println("Number: " + number);
        System.out.println("In words: " + convert(number));
    }
}
