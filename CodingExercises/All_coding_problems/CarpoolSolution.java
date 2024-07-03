import java.util.*;

public class CarpoolSolution {
    public static void main(String[] args) {
        List<CarPool> carPools = Arrays.asList(
            new CarPool(2, 3), 
            new CarPool(4, 6), 
            new CarPool(4, 11), 
            new CarPool(8, 9)
        );
        System.out.println("Maximum number of people in the car at any time: " + findMaxPeopleInCar(carPools));
    }

    public static int findMaxPeopleInCar(List<CarPool> carPools) {
        List<int[]> events = new ArrayList<>();

        // Create events for all start and end times
        for (CarPool carPool : carPools) {
            events.add(new int[]{carPool.startTime, 1});  // Pickup event
            events.add(new int[]{carPool.endTime, -1});   // Drop-off event
        }

        // If the events list is already sorted, we can skip the sorting step
        // Collections.sort(events, (e1, e2) -> {
        //     if (e1[0] != e2[0]) {
        //         return Integer.compare(e1[0], e2[0]);
        //     }
        //     return Integer.compare(e1[1], e2[1]);
        // });

        int currentNumberOfPeople = 0;
        int maximumNumberOfPeople = 0;

        // Traverse through the sorted events to manage the car capacity
        for (int[] event : events) {
            currentNumberOfPeople += event[1]; // Update the current capacity
            maximumNumberOfPeople = Math.max(maximumNumberOfPeople, currentNumberOfPeople);
        }

        return maximumNumberOfPeople;
    }
}

class CarPool {
    int startTime;
    int endTime;

    CarPool(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
