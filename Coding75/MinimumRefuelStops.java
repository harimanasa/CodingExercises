import java.util.*;

class MinimumRefuelStops {
    public static int minRefuelStops(int target, int startFuel, int[][] stations) {
        // If starting fuel is already greater or equal to target, no need to refuel
        if (startFuel >= target) {
            return 0;
        }
        // Create a max heap to store the fuel capacities of stations in
        // such a way that maximum fuel capacity is at the top of the heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // Initialize variables for loop
        int i = 0;
        int n = stations.length;
        int stops = 0;
        int maxDistance = startFuel;
        // Loop until the car reach the target or the car is out of fuel
        while (maxDistance < target) {
            // If there are still stations and the next one is within range, add its fuel capacity to the max heap
            if (i < n && stations[i][0] <= maxDistance) {
                maxHeap.add(stations[i][1]); //Adding stations in the current traveling limits
                i++;
            }
            // If there are no more stations and we can't reach the target, return -1
            else if (maxHeap.isEmpty()) {
                return -1;
            }
            // Otherwise, fill up at the station with the highest fuel capacity and increment stops
            else {
                maxDistance += maxHeap.poll();
                stops++;
            }
        }
        // Return the number of stops taken
        return stops;
    }

    // Driver Code
    public static void main(String[] args) {
        int[] target = {120, 15, 570, 1360};
        int[] startFuel = {10, 3, 140, 380};
        int[][][] stations = {
                            {{10, 60},{20, 25},{30, 30},{60, 40}},
                            {{2, 5},{3, 1},{6, 3},{12,6 }},
                            {{140, 200}, {160, 130}, {310, 200}, {330, 250}},
                            {{310, 160}, {380, 620}, {700, 89}, {850, 190}, {990, 360}}
                            };
        for(int i=0;i<target.length;i++){
            System.out.print(i+1);
            System.out.println(".\tStations: "+Arrays.deepToString(stations[i]));
            System.out.println("\tTarget fuel: "+target[i]);
            System.out.println("\tStart fuel: "+startFuel[i]);
            System.out.println("\tMinimum number of Refueling stops: "+minRefuelStops(target[i], startFuel[i],stations[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

    }
}

/**
 * 
 * Solution
This problem can be solved using the greedy algorithm, since the car has to reach the destination using a minimum number of refueling stops. This means that the car needs a maximum fuel amount at any point. The idea is to make optimal choices by selecting the fuel station with the maximum fuel capacity at each step to reach the target distance with the minimum number of refueling stops.

To cater to the problem of selecting the maximum fuel value, we can use the max-heap to keep track of fuel capacity for refueling because the top of the max-heap will always have the highest fuel value. Therefore we can take the highest fuel value from the top of the max-heap to reach the target by using the minimum number of refueling stops.

Note: We’ll implement the heap using the PriorityQueue class.

To implement this methodology, we will create a function, minRefuelStops. The steps of the function are given below:

1. If the starting fuel is greater than or equal to the target distance, return 0. It means no extra fuel is required, and the car can reach the target using the starting fuel.

2. Otherwise, iterate until the maximum distance is less than the target, and the car is not out of fuel:

    1) If we have a fuel station that can be used to refuel, and the vehicle has enough fuel to reach it, add the refueling station to the max-heap.

    2) If the max-heap contains no fuel stations, the vehicle can’t reach the target, and the function returns -1. In simpler words, the car doesn’t have enough fuel to reach the target even after stopping at all the fuel stations.

    3) Otherwise, if the max-heap has fuel stations and the vehicle doesn’t have enough fuel to go to the next station, the vehicle refuels from the fuel station with the maximum fuel value. After refueling, we remove the fuel value of this refueling station from the max-heap and also increment the number of stops.

3. After executing the loop, the function returns the total number of refueling stops required to reach the target distance.
 */