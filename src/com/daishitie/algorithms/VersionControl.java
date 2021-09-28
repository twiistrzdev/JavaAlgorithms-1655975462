package com.daishitie.algorithms;

/**
 * Version Control using Binary Search
 *
 * It is not difficult to see that this could be solved using a classic
 * algorithm - Binary search. Let us see how the search space could be
 * halved each time below.
 *
 * Scenario #1: isBadVersion(mid) => false
 *
 *  1 2 3 4 5 6 7 8 9
 *  G G G G G G B B B       G = Good, B = Bad
 *  |       |       |
 * left    mid    right
 *
 * Let us look at the first scenario above where
 * 'isBadVersion(mid) ⇒ false'. We know that all versions
 * preceding and including mid are all good. So we set
 * 'left = mid + 1' to indicate that the new search space
 * is the interval '[mid+1,right]' (inclusive).
 *
 * Scenario #2: isBadVersion(mid) => true
 *
 *  1 2 3 4 5 6 7 8 9
 *  G G G B B B B B B       G = Good, B = Bad
 *  |       |       |
 * left    mid    right
 *
 * The only scenario left is where 'isBadVersion(mid) ⇒ true'.
 * This tells us that mid may or may not be the first bad version,
 * but we can tell for sure that all versions after mid can be discarded.
 * Therefore, we set 'right = mid' as the new search space of
 * interval '[left,mid]' (inclusive).
 */
public class VersionControl {
    public static int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    /**
     * Sample isBadVersion checker
     * @param n n is the version need to check
     */
    public static boolean isBadVersion(int n) {
        return n == 1 ||
                n == 2 ||
                n == 4 ||
                n == 6;
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(1));
        System.out.println(firstBadVersion(3));
        System.out.println(firstBadVersion(4));
    }
}
