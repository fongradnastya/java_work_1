import java.util.Arrays;

/**
 * Класс FrequencyMatrix наследуется от Matrix и содержит методы для подсчёта встречаемости символов
 * исходной матрицы
 */
public class FrequencyMatrix extends Matrix{
    private int maxFrequency = 0;

    /**
     * Метод createMatrix создаёт матрицу с элементами. равными частоте элементов исходной матрицы
     * @param matrix - исходная матрица для подсчёта частоты
     */
    public void createMatrix(Matrix matrix) {
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

    public int[] createFrequencyArray(Matrix matrix, int counter) {
        int[] frequencyArray = new int[counter];
        int array_id = 0;
        boolean changed = false;
        int current = maxFrequency;
        while (counter > 0 && current > 0 && array_id < counter) {
            for (int i = 0; i < matrixSize[0]; i++) {
                for (int j = 0; j < matrixSize[1]; j++) {
                    if (this.matrix[i][j] == current) {
                        if (array_id == 0 || frequencyArray[array_id - 1] != matrix.getElement(i, j)) {
                            frequencyArray[array_id] = matrix.getElement(i, j);
                            array_id++;
                            counter--;
                            changed = true;
                        }

                    }
                }
            }
            if (!changed) {
                current--;
            }
            changed = false;
        }
        return Arrays.copyOfRange(frequencyArray, 0, array_id);
    }
}
