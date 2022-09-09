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

    private boolean hasElement(int[] array, int element){
        for(int i = 0; i < array.length; i++){
            if(array[i] == element){
                return true;
            }
        }
        return false;
    }

    public int[] createFrequencyArray(Matrix matrix, int size) {
        int[] frequencyArray = new int[size];
        int array_id = 0;
        boolean changed = false;
        int currentMax = maxFrequency;
        while (currentMax > 0 && array_id < size) {
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
            if (!changed) {
                currentMax--;
            }
            changed = false;
        }
        return Arrays.copyOfRange(frequencyArray, 0, array_id);
    }
    public int[] leastFrequencyArray(Matrix matrix, int size){
        int[] frequencyArray = new int[size];
        int array_id = 0;
        boolean changed = false;
        int currentMin = 0;
        while (currentMin <= maxFrequency && array_id < size) {
            for (int i = 0; i < matrixSize[0]; i++) {
                for (int j = 0; j < matrixSize[1]; j++) {
                    if (this.matrix[i][j] == currentMin) {
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
            if (!changed) {
                currentMin++;
            }
            changed = false;
        }
        return Arrays.copyOfRange(frequencyArray, 0, array_id);
    }
}
