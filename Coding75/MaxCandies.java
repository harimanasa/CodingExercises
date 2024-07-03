import java.util.ArrayList;
import java.util.List;

class MaxCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        // Find the maximum number of candies any kid currently has
        int maxCandies = 0;
        for (int candy : candies) {
            if (candy > maxCandies) {
                maxCandies = candy;
            }
        }

        // Create a list to store the result
        List<Boolean> result = new ArrayList<>();
        for (int candy : candies) {
            // Check if giving the current kid all extra candies makes their total the highest
            result.add(candy + extraCandies >= maxCandies);
        }

        return result;
    }

    // public static void main(String[] args) {
    //     Solution solution = new Solution();
        
    //     // Example 1
    //     int[] candies1 = {7, 3, 9, 2, 4};
    //     int extraCandies1 = 5;
    //     System.out.println(solution.kidsWithCandies(candies1, extraCandies1)); // [true, false, true, false, true]

    //     // Example 2
    //     int[] candies2 = {5, 8, 6, 4, 2};
    //     int extraCandies2 = 3;
    //     System.out.println(solution.kidsWithCandies(candies2, extraCandies2)); // [true, true, true, false, false]

    //     // Example 3
    //     int[] candies3 = {1, 2, 3, 4, 5};
    //     int extraCandies3 = 4;
    //     System.out.println(solution.kidsWithCandies(candies3, extraCandies3)); // [true, true, true, true, true]
    // }
}
