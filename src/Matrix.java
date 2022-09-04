import java.util.Scanner;
import java.util.Random;
public class Matrix {
    private final int[] matrixSize;
    private int[][] matrix;
    public Matrix () {
        matrixSize = new int[]{0, 0};
    }
    private int getInt(Scanner myScanner) {
        int num = 0;
        while (num == 0)
        {
            System.out.print("Number: ");
            String line = myScanner.nextLine();
            try
            {
                num = Integer.parseInt(line);
                break;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Wrong number format! Please, try again");
            }
        }
        System.out.printf("Your number: %d \n", num);
        return num;
    }
    public void userSize(){
        Scanner input = new Scanner(System.in);
        System.out.println("Please, enter x matrix size");
        matrixSize[0] = getInt(input);
        System.out.println("Please, enter y matrix size");
        matrixSize[1] = getInt(input);
        input.close();
    }
    public void randomSize(Random random) {
        matrixSize[0] = random.nextInt(15);
        matrixSize[1] = random.nextInt(15);
    }
    public void randomMatrix() {
        Random random = new Random();
        randomSize(random);
        matrix = new int[matrixSize[0]][matrixSize[1]];
        for( int i = 0; i < matrixSize[0]; i++){
            for (int j = 0; j < matrixSize[1]; j++){
                matrix[i][j] = random.nextInt(500);
            }
        }
    }
    public int[] getMatrixSize(){
        return matrixSize;
    }

    public void printMatrix(){
        for( int i = 0; i < matrixSize[0]; i++){
            for (int j = 0; j < matrixSize[1]; j++){
                System.out.printf("%d  ", matrix[i][j]);
            }
            System.out.println("");
        }
    }

}
