
class FirstBadVersion {
    /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

    public int firstBadVersion(int n) {
        int low = 0;
        int high = n;

        while(low<=high){
            int mid = low + (high-low)/2;

            if(isBadVersion(mid)==true){ //left
                if(isBadVersion(mid-1) == false) {
                    return mid; //answer found
                }
                else high = mid-1;
            } else{
                if(isBadVersion(mid) == false){
                    low = mid+1;
                }
            }
        }
        return -1;
    }

}

/**
 * 
 * Solution summary
To recap, the solution to this problem can be divided into the following parts:

1. Assign two pointers at the IDs of the first and last versions.

2. Calculate the mid and check if that mid version is bad.

3. If the mid version is bad, search for the first bad version in the first half of the range of versions.

4. If the mid version is good, search in the second half of the range of versions.

5. Repeat the steps to check the mid version and to divide the range of versions in two until the first and last converge.
 */