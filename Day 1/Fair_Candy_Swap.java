// Problem Link
// https://leetcode.com/problems/fair-candy-swap/


import java.util.*;

class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        Arrays.sort(aliceSizes);
        Arrays.sort(bobSizes);
        int n_Alice = aliceSizes.length;
        int n_Bob = bobSizes.length;
        int aliceIdx = 0;
        int bobIdx = 0;
        int[] ans = { 0, 0 };
        int aliceSum = 0;
        int bobSum = 0;
        for (int val : aliceSizes) {
            aliceSum += val;
        }
        for (int val : bobSizes) {
            bobSum += val;
        }
        while (aliceIdx < n_Alice && bobIdx < n_Bob) {
            if (aliceSum + bobSizes[bobIdx] - aliceSizes[aliceIdx] == bobSum + aliceSizes[aliceIdx]
                    - bobSizes[bobIdx]) {
                ans[0] = aliceSizes[aliceIdx];
                ans[1] = bobSizes[bobIdx];
                return ans;
            }
            if (aliceSum + bobSizes[bobIdx] - aliceSizes[aliceIdx] > bobSum + aliceSizes[aliceIdx] - bobSizes[bobIdx]) {
                aliceIdx++;
            } else {
                bobIdx++;
            }
        }
        return ans;
    }
}
