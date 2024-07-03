
class FirstBadVersion {
    public static int v;

    static boolean isBadVersion(int s) {
        return s >= v;
    }

    static int[] firstBadVersion(int n) {
        int[] result = new int[2];
        int first = 1;
        int last = n;
        int calls = 0;

        while (first <= last) {
            int mid = first + (last - first) / 2;

            if (isBadVersion(mid)) {
                last = mid - 1;
            } else {
                first = mid + 1;
            }

            calls += 1;
        }

        result[0] = first;
        result[1] = calls;
        return result;
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