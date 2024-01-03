class Solution {
   
   //P.S: Before anytime you think logicnis failing, check if you are running for-loop with proper condition i.e., [i<=n]. Manytimes by mistake you might do just [i<n] and it fails.

    public int fib(int n) {
        int[] lookUpTable = new int[n+1];
        for(int i=0; i<=n; i++){
            lookUpTable[i] = -1; //Default initiation
        }
        return fib(n, lookUpTable);
    }
    private int fib(int n, int[] lookUpTable){
        if(lookUpTable[n]!=-1) return lookUpTable[n];
        if(n<=1) lookUpTable[n]=n;
        else lookUpTable[n] = fib(n-1, lookUpTable) + fib(n-2, lookUpTable);
        return lookUpTable[n];
    }

    private int anotherOptimalFib(int n){
        if(n<=1) return n;
        int last = 1;
        int secondLast = 0;
        int current = 1;
        for(int i=2; i<=n; i++){
            current = last + secondLast;
            secondLast = last;
            last = current;
        }
        return current;
    }
}