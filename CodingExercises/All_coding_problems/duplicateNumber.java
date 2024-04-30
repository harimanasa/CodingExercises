class Solution{    
     public int findDuplicate(int[] arr) {
        int tortoise = arr[0];
        int hare = arr[arr[0]];

        while (hare != tortoise)
        {
            tortoise = arr[tortoise];
            hare = arr[arr[hare]];
            //System.out.println(arr[tortoise] + " " + arr[hare]);
        }
        

        hare = 0;
        while (tortoise != hare)
        {
            tortoise = arr[tortoise];
            hare = arr[hare];
            //System.out.println("again " + arr[tortoise] + " " + arr[hare]);
        }
        
        return hare;
    }
}