public class LC_59 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int half = n/2;
        int offset = 0;
        int number = 1;

        for(int loop = 1; loop <= half; loop++){
            for(int i = offset; i <= (n - 1) - offset - 1; i++){
                matrix[offset][i] = number++;
            }
            for(int i = offset; i <= (n - 1) - offset - 1; i++){
                matrix[i][n - 1 - offset] = number++;
            }
            for(int i = n - 1 - offset; i >= offset + 1; i--){
                matrix[n - 1 - offset][i] = number++;
            }
            for(int i = n - 1 - offset; i >= offset + 1; i--){
                matrix[i][offset] = number++;
            }
            offset++;
        }

        if (n % 2 != 0){
            matrix[half][half] = n * n;
        }

        return matrix;
    }

    public static void main(String args[]){
        int[][] matrix = new LC_59().generateMatrix(4);

        for (int i = 0; i < matrix.length; i++) {
            // Loop through the columns for each row
            for (int j = 0; j < matrix[i].length; j++) {
                // Print each element, followed by a space
                System.out.print(matrix[i][j] + " ");
            }
            // Print a new line after each row
            System.out.println();
        }
    }
}
