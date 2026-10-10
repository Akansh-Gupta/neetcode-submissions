class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        // Define the four boundaries of the matrix
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        // Continue while there are rows and columns left to visit
        while (top <= bottom && left <= right) {

            // 1. Traverse the top row from left to right
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++; // Top row is completed

            // 2. Traverse the right column from top to bottom
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--; // Right column is completed

            // 3. Traverse the bottom row from right to left
            // Check that a row still remains
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--; // Bottom row is completed
            }

            // 4. Traverse the left column from bottom to top
            // Check that a column still remains
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++; // Left column is completed
            }
        }

        return result;
    }
}