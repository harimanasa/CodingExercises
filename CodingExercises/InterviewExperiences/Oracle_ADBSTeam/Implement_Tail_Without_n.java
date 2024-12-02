package CodingExercises.CodingExercises.InterviewExperiences.Oracle_ADBSTeam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class Implement_Tail_Without_n {

    public static void tail(String fileName) {
        final int LINES_TO_READ = 10;  // Fixed number of lines to read
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            Deque<String> deque = new ArrayDeque<>();
            String line;
            while ((line = reader.readLine()) != null) {
                if (deque.size() == LINES_TO_READ) { // Decision Point
                    deque.removeFirst();
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
        if (args.length < 1) { // Decision Point
            System.out.println("Usage: java Tail <file_name>");
            return;
        }

        String fileName = args[0];

        tail(fileName);
    }
}
