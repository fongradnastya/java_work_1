import java.util.Random;

public class Matrix {
    int[] matrixSize;
    int[][] matrix = null;
    public Matrix () {
        matrixSize = new int[]{0, 0};
    }
    public void userSize(){
        System.out.println("Please, enter x matrix size:");
        matrixSize[0] = ConsoleInput.getIntString();
        System.out.println("Please, enter y matrix size:");
        matrixSize[1] = ConsoleInput.getIntString();
    }
    public void userMatrix(){
        matrix = null;
        userSize();
        while (matrix == null){
            matrix = ConsoleInput.getMatrix(matrixSize[0], matrixSize[1]);
        }
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
    public int getElement(int posX, int posY){
        return matrix[posX][posY];
    }
    public void printMatrix(){
        System.out.println("Your matrix:");
        for(int y = 0; y < matrixSize[1]; y++){
            for (int x = 0; x < matrixSize[0]; x++){
                System.out.printf("%d  ", matrix[x][y]);
            }
            System.out.println("");
        }
    }
}
