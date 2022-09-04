public class FrequencyMatrix extends Matrix{
    private int[][] matrix;
    public Matrix createMatrix(Matrix matrix) {
        int[] size = matrix.getMatrixSize();
        this.matrix = new int[size[0]][size[1]];
        for (int i = 0; i < size[0]; i++) {
            for (int j = 0; j < size[1]; j++) {
                int element = matrix.getElement(size[0], size[1]);
                int elementFrequency = countElementFrequency(element);
                frequencyMatrix[i][j] = elementFrequency;
            }
        }
    }
    private int countElementFrequency(int element){
        int frequency = 0;
        for( int i = 0; i < matrixSize[0]; i++) {
            for (int j = 0; j < matrixSize[1]; j++) {
                if(matrix[i][j] == element) frequency++;
            }
        }
        return frequency;
    }
}
