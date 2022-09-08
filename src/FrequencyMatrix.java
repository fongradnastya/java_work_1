public class FrequencyMatrix extends Matrix{
    public void createMatrix(Matrix matrix) {
        matrixSize = matrix.getMatrixSize();
        this.matrix = new int[matrixSize[0]][matrixSize[1]];
        for (int i = 0; i < matrixSize[0]; i++) {
            for (int j = 0; j < matrixSize[1]; j++) {
                int element = matrix.getElement(i, j);
                int elementFrequency = countElementFrequency(element, matrix);
                this.matrix[i][j] = elementFrequency;
            }
        }
    }
    private int countElementFrequency(int element, Matrix matrix){
        int frequency = 0;
        for( int i = 0; i < matrixSize[0]; i++) {
            for (int j = 0; j < matrixSize[1]; j++) {
                if(matrix.getElement(i, j) == element) frequency++;
            }
        }
        return frequency;
    }
}
