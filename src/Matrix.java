import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Random;

/**
 * Класс Matrix реализует методы для создания случайных и пользовательских матриц и их обработки
 */
public class Matrix {
    private int[] matrixSize;
    private int[][] matrix = null;

    private int maxFrequency = 0;
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
    /**
     * Метод createFrequencyMatrix создаёт матрицу с элементами. равными частоте элементов исходной матрицы
     * @param matrix - исходная матрица для подсчёта частоты
     */
    public void createFrequencyMatrix(@NotNull Matrix matrix) {
        matrixSize = matrix.getMatrixSize();
        this.matrix = new int[matrixSize[0]][matrixSize[1]];
        for (int i = 0; i < matrixSize[0]; i++) {
            for (int j = 0; j < matrixSize[1]; j++) {
                int element = matrix.getElement(i, j);
                int elementFrequency = countElementFrequency(element, matrix);
                if(elementFrequency > maxFrequency){
                    maxFrequency = elementFrequency;
                }
                this.matrix[i][j] = elementFrequency;
            }
        }
    }

    /**
     * Метод countElementFrequency вычисляет количество повторений данного элемента внутри матрицы
     * @param element - заданный элемент типа int
     * @param matrix - объект типа Matrix, внутри которого осуществляется поиск
     * @return frequency - число повторений данного элемента
     */
    private int countElementFrequency(int element, Matrix matrix){
        int frequency = 0;
        for( int i = 0; i < matrixSize[0]; i++) {
            for (int j = 0; j < matrixSize[1]; j++) {
                if(matrix.getElement(i, j) == element) frequency++;
            }
        }
        return frequency;
    }

    /**
     * Метод hasElement проверяет наличие элемента в массиве
     * @param array - одномерный массив типа int[]
     * @param element - значение проверяемого элемента
     * @return - true, если элемент найден;
     *           false, в обратном случае
     */
    private boolean hasElement(int[] array, int element){
        for(int i = 0; i < array.length; i++){
            if(array[i] == element){
                return true;
            }
        }
        return false;
    }

    /**
     * Метод createFrequencyArray оздаёт массив наиболее или наименее часто встречающихся элементов матрицы
     * @param matrix - исходная матрица элементов
     * @param size - размер будующего массива
     * @param isTheMost - true, если ищем наиболее часто встречающиеся элементы;
     *      *             false, в обратном случае
     * @return - массив выбранных элементов
     */
    public int[] createFrequencyArray(Matrix matrix, int size, boolean isTheMost) {
        int[] frequencyArray = new int[size];
        int array_id = 0;
        boolean changed = false;
        int currentMax = isTheMost ? maxFrequency : 0;
        while (array_id < size) {
            for (int i = 0; i < matrixSize[0]; i++) {
                for (int j = 0; j < matrixSize[1]; j++) {
                    if (this.matrix[i][j] == currentMax) {
                        int element = matrix.getElement(i, j);
                        if (! hasElement(frequencyArray, element)) {
                            if(array_id < size){
                                frequencyArray[array_id] = element;
                                array_id++;
                                changed = true;
                            }
                            else {
                                return frequencyArray;
                            }
                        }

                    }
                }
            }
            if (isTheMost){
                if (!changed) currentMax--;
                if (currentMax < 1) break;
            }
            else{
                if (!changed) currentMax++;
                if (currentMax > maxFrequency) break;
            }
            changed = false;
        }
        return Arrays.copyOfRange(frequencyArray, 0, array_id);
    }
    public void printFrequencyArray(boolean isHigh, int[] array){
        if(isHigh) System.out.print("The most frequent elements: ");
        else System.out.print("The least frequent elements: ");
        for(int i = 0; i < array.length; i++){
            System.out.printf("%d ", array[i]);
        }
        System.out.println("");
    }
}
