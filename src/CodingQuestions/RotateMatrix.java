package src.CodingQuestions;
/*
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.



Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]
Example 2:


Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 */
public class RotateMatrix {
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int level = 0;level < n/2;level++) {
            int first = level; // this is useless initialization
            int last = n-level-1;
            for(int i = first;i<last;i++) {
                int offset = i-first;
                int firstVal = matrix[first][i];

                matrix[level][i] = matrix[last-offset][level];
                matrix[last-offset][level] = matrix[last][last-offset];
                matrix[last][last-offset] = matrix[level+offset][last];
                matrix[level+offset][last] = firstVal;

            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };


        rotate(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(); // Move to the next line after each row
        }
    }
}
/**
Think of how pointers will flow in the level rows.
 Copy elements anticlockwise when rotating clockwise.

 Define offset = i-level

 A = (level, i) [In top Row]
 B = (last-offset, level) [In Left col]
 C = (last, level-offset) [In bottom col]
 D = (level+offset, last) [In right col]
 */
