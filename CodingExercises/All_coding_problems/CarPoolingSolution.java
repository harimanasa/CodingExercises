import java.util.*;

public class CarPoolingSolution {
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
        List<int[]> intervals = new ArrayList<>();
        for (CarPool carPool : carPools) {
            intervals.add(new int[]{carPool.startTime, carPool.endTime});
        }

        // Assuming the intervals are already sorted by start time
        // If not, uncomment the following line to sort the intervals
        // Collections.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        LinkedList<int[]> result = new LinkedList<>();
        int currentNumberOfPeople = 0;
        int maximumNumberOfPeople = 0;

        for (int[] interval : intervals) {
            while (!result.isEmpty() && interval[0] >= result.getFirst()[1]) {
                result.removeFirst();
                currentNumberOfPeople--;
            }

            result.addLast(interval);
            currentNumberOfPeople++;
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
