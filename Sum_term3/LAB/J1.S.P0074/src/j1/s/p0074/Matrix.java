package j1.s.p0074;

public class Matrix {

    public int[][] addtionMatrix(int[][] matrix1, int[][] matrix2) {
        int row = matrix1.length;
        int column = matrix1[0].length;
        int[][] matrixResult = new int[row][column];
        for (int i = 0; i <= row - 1; i++) {
            for (int j = 0; j <= column - 1; j++) {
                matrixResult[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return matrixResult;
    }

    public int[][] subtractionMatrix(int[][] matrix1, int[][] matrix2) {
        int row = matrix1.length;
        int column = matrix1[0].length;
        int[][] matrixResult = new int[row][column];
        for (int i = 0; i <= row -1 ; i++) {
            for (int j = 0; j <= column - 1; j++) {
                matrixResult[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return matrixResult;
    }
    
    public int[][] multiplicationMatrix(int[][] matrix1, int[][] matrix2) {
        int row1 = matrix1.length;
        int column2 = matrix2[0].length;
        int column1 = matrix1[0].length;
        int[][] matrixResult = new int[row1][column2];
        for (int i = 0; i <= row1 - 1; i++) {
            for (int j = 0; j <= column2 - 1; j++) {
                for (int k = 0; k <= column1 - 1; k++) {
                    matrixResult[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return matrixResult;
    }

    public void displayMatrix(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        
        for (int i = 0; i <= row - 1; i++) {
            for (int j = 0; j <= column - 1; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }
    }
}
