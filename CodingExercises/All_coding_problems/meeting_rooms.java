class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        /* Sorting by start time */
        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
        for (int[] interval : intervals) {
            if(minHeap.size()==0){ minHeap.add(interval[1]); }
            else{
            if(interval[0] >= minHeap.peek()){
                minHeap.poll();
            }
            minHeap.add(interval[1]);
            }
        }
        return minHeap.size();
    }
}