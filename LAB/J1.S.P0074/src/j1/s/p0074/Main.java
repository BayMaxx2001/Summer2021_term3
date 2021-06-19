package j1.s.p0074;

public class Main {

    public static void main(String[] args) {
        Validator validator = new Validator();
        Matrix matrix = new Matrix();
        int type, row1, column1, row2, column2;
        while (true) {
            System.out.println("=======Calculator program=======");
            System.out.println("1. Addition Matrix");
            System.out.println("2. Subtraction Matrix");
            System.out.println("3. Multiplication Matrix");
            System.out.println("4. Quit");

            //Input type
            type = validator.validateInput("Your choice: ", 1, 4);
            if (type == 1) {
                System.out.println("-------- Addtion --------");
            }
            if (type == 2) {
                System.out.println("-------- Subtraction --------");
            }
            if (type == 3) {
                System.out.println("-------- Multiplication --------");
            }
            if (type == 4) {
                System.out.println("GOOD BYE!");
                break;
            }

            //Input Matrix1
            row1 = validator.validateInput("Enter Row Matrix 1:", 1, 1000);
            column1 = validator.validateInput("Enter Column Matrix 1:", 1, 1000);
            int[][] matrix1 = new int[row1][column1];
            for (int i = 0; i <= row1 - 1; i++) {
                for (int j = 0; j <= column1 - 1; j++) {
                    matrix1[i][j] = validator.validateInput("Enter Matrix1[" + (i + 1) + "][" + (j + 1) + "]:", -1000000, 1000000);
                }
            }

            // Input Matrix 2    
            //row
            while (true) {
                row2 = validator.validateInput("Enter Row Matrix 2:", 1, 1000);
                if ((type == 1 || type == 2) && row2 != row1) {
                    System.err.println("Row of matrix 1 and matrix 2 must be equal ");
                    continue;
                } else if (type == 3 && row2 != column1) {
                    System.err.println("Column of matrix 1 must be equal Row of matrix 2");
                    continue;
                }
                break;
            }
            //column
            while (true) {
                column2 = validator.validateInput("Enter Column Matrix 2:", 1, 1000);
                if ((type == 1 || type == 2) && column1 != column2) {
                    System.err.println("Column of matrix 1 and matrix 2 must be equal ");
                    continue;
                }
                break;
            }
            int[][] matrix2 = new int[row2][column2];
            for (int i = 0; i <= row2 - 1; i++) {
                for (int j = 0; j <= column2 - 1; j++) {
                    matrix2[i][j] = validator.validateInput("Enter Matrix2[" + (i + 1) + "][" + (j + 1) + "]:", -1000000, 1000000);
                }
            }

            // display operator 
            int[][] result = new int[row1][column2];
            System.out.println("-------- Result --------");
            matrix.displayMatrix(matrix1);
            switch (type) {
                case 1:
                    System.out.println("+");
                    result = matrix.addtionMatrix(matrix1, matrix2);
                    break;
                case 2:
                    System.out.println("-");
                    result = matrix.subtractionMatrix(matrix1, matrix2);
                    break;
                case 3:
                    result = matrix.multiplicationMatrix(matrix1, matrix2);
                    System.out.println("*");
                    break;
                default:
                    System.out.println("GOOD BYE!");
            }

            matrix.displayMatrix(matrix2);
            System.out.println("=");
            // In ket qua
            matrix.displayMatrix(result);

        }
    }

}
