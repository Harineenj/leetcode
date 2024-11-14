import java.util.*;

public class Solution {
    public long maximumValueSum(int[][] board) {
        long res = Long.MIN_VALUE;
        int numRows = board.length;
        int numCols = board[0].length;

        // Store the top 3 values and their column indices for each row
        List<int[]>[] topValues = new ArrayList[numRows];

        for (int i = 0; i < numRows; i++) {
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
            for (int j = 0; j < numCols; j++) {
                pq.offer(new int[]{board[i][j], j});
                if (pq.size() > 3) pq.poll();
            }
            topValues[i] = new ArrayList<>(pq);
        }

        // Iterate through all combinations of 3 distinct rows
        for (int r1 = 0; r1 < numRows - 2; r1++) {
            for (int r2 = r1 + 1; r2 < numRows - 1; r2++) {
                for (int r3 = r2 + 1; r3 < numRows; r3++) {
                    // Check all combinations of the top 3 values from these rows
                    for (int[] v1 : topValues[r1]) {
                        for (int[] v2 : topValues[r2]) {
                            if (v1[1] == v2[1]) continue;  // Ensure columns are distinct
                            for (int[] v3 : topValues[r3]) {
                                if (v3[1] == v1[1] || v3[1] == v2[1]) continue;
                                long sum = (long) v1[0] + v2[0] + v3[0];
                                res = Math.max(res, sum);
                            }
                        }
                    }
                }
            }
        }

        return res;
    }
}