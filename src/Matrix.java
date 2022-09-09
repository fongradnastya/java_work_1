import java.util.Random;

/**
 * Класс Matrix реализует методы для создания случайных и пользовательских матриц
 */
public class Matrix {
    int[] matrixSize;
    int[][] matrix = null;
    public Matrix () {
        matrixSize = new int[]{0, 0};
    }

    /**
     * Метод userSize инициализирует поле matrixSize пользовательским значением
     */
    public void userSize(){
        matrixSize[0] = ConsoleInput.getSize('x');
        matrixSize[1] = ConsoleInput.getSize('y');
    }

    /**
     * Метод userMatrix создаёт матрицу из пользовательских значений
     */
    public void userMatrix(){
        matrix = null;
        userSize();
        while (matrix == null){
            matrix = ConsoleInput.getMatrix(matrixSize[0], matrixSize[1]);
        }
    }

    /**
     * Метод randomSize инициализирует поле matrixSize случайным значением
     * @param random - объект класса Random
     */
    private void randomSize(Random random) {
        matrixSize[0] = random.nextInt(15) + 1;
        matrixSize[1] = random.nextInt(15) + 1;
    }

    /**
     * Метод randomMatrix создаёт матрицу из случайных значений
     */
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

    /**
     * Метод getMatrixSize возвращает текущий размер матрицы
     * @return matrixSize - массив из двух целочисленных элементов
     */
    public int[] getMatrixSize(){
        return matrixSize;
    }

    /**
     * Метод getElement возвращает один из элементов матрицы
     * @param posX - позиция элемента в строке
     * @param posY - позиция элемента в столбце
     * @return int значение элемента матрицы
     */
    public int getElement(int posX, int posY){
        return matrix[posX][posY];
    }

    /**
     * Метод printMatrix печатает текущую матрицу в консоль
     */
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
