package CodingExercises.CodingExercises.InterviewExperiences.Oracle_ADBSTeam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class Implement_Tail_Command {

    public static void tail(String fileName, int n) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            Deque<String> deque = new ArrayDeque<>();
            String line;
            while ((line = reader.readLine()) != null) {
                if (deque.size() == n) {
                    deque.removeFirst(); // Efficient removal from the front
                }
                deque.addLast(line); // Efficient addition to the end
            }
            for (String l : deque) {
                System.out.println(l);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java Tail <file_name> [number_of_lines]");
            return;
        }

        String fileName = args[0];
        int numberOfLines = (args.length > 1) ? Integer.parseInt(args[1]) : 10;

        tail(fileName, numberOfLines);
    }
}
