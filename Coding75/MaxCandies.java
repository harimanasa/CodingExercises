package CodingExercises.Coding75;

import java.util.ArrayList;
import java.util.List;

class MaxCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxNumberOfCandies = Integer.MIN_VALUE;

        for(int candy: candies){
            if(maxNumberOfCandies<candy)
                maxNumberOfCandies = candy;
        }

        List<Boolean> result = new ArrayList<>();
        for(int candy: candies){
            result.add(candy+extraCandies>=maxNumberOfCandies);
        }

        return result;
    }
}