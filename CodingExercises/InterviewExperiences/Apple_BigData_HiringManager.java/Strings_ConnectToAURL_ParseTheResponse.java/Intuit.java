import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class HelloWorld {

    List<Integer> logs = new ArrayList<>();
    List<Long> timestamps = new ArrayList<>();
    Map<Long, String> map = new HashMap<>();

    public List<Integer> parse(String csv_string) {
        String[] rows = csv_string.split(";");

        if (rows.length == 0) return logs;

        for (String row : rows) {
            String[] columns = row.split(",");
            
            try {
                Long timestamp = timeConversion(columns[2]);
                map.put(timestamp, row);
                timestamps.add(timestamp);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return logs;
    }

    private DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH); // Specify your locale

    public long timeConversion(String time) {
        long unixTime = 0;
        dateFormat1.setTimeZone(TimeZone.getTimeZone("GMT+5:30")); // Specify your timezone
        try {
            unixTime = dateFormat1.parse(time).getTime();
            unixTime = unixTime / 1000;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return unixTime;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");

        String csv_string = "1,Error in module 5,2023-03-15T14:20:00Z,high;2,Database connection failed,03/14/2023 16:45,medium;3,Memory leak detected,2023-03-13 17:00:00,critical;4,Failed to load resource,15-Mar-2023 18:30,low;5,User authentication failed,2023-03-16 09:15:00,medium;6,Configuration file missing,2023-03-12T08:20:00Z,high;7,Invalid input data,2023-03-11 10:25:00,low;8,Network latency issues,03/10/2023 11:30,medium;9,Error parsing JSON,2023-03-09T12:35:00Z,critical;10,File not found,03/08/2023 13:40,high;11,API rate limit exceeded,2023-03-07 14:45:00,medium;12,Permission denied,2023-03-06T15:50:00Z,low;13,Service unavailable,03/05/2023 16:55,critical;14,Out of memory,2023-03-04 17:00:00,high;15,Invalid API key,03/03/2023 18:05,medium;16,,,;17,Partial data,,low;18,Corrupted date entry,25-13-2023 00:00,high";

        HelloWorld helloWorld = new HelloWorld();
        helloWorld.parse(csv_string);

        Collections.sort(helloWorld.timestamps);
        for (Long timestamp : helloWorld.timestamps) {
            System.out.println(timestamp);
        }
    }
}
