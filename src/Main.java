public class Main {
    public static void main(String[] args) {
        Matrix matrix = new Matrix();
        matrix.userSize();
        int[] size = matrix.getMatrixSize();
        System.out.printf("%d:%d", size[0], size[1]);
    }

}