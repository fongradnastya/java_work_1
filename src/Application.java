
enum Status {
    EMPTY,
    FILLED,
    CALCULATED,

}
public class Application {
    static Status status = Status.EMPTY;
    public static void main(String[] args) {
        Matrix matrix = new Matrix();
        FrequencyMatrix calculation = new FrequencyMatrix();
        boolean end = false;
        printMenu();
        while (! end){
            int command = ConsoleInput.getCommand();
            switch (command) {
                case 1: {
                    getInputMode(matrix);
                    matrix.printMatrix();
                    status = Status.FILLED;
                    break;
                }
                case 2: {
                    if (status == Status.FILLED){
                        calculation.createMatrix(matrix);
                        System.out.println("Frequency matrix was successfully created");
                        status = Status.CALCULATED;
                    }
                    break;
                }
                case 3: {
                    if (status == Status.CALCULATED){
                        calculation.printMatrix();
                    }
                    break;
                }
                case 4: {
                    printMenu();
                }
                case -1: {
                    end = true;
                    ConsoleInput.close();
                    break;
                }
                default: {
                    System.out.println("Wrong command!");
                }
            }
        }
    }
    public static void getInputMode(Matrix matrix){
        System.out.println("Type 1 to enter a matrix into the console");
        System.out.println("Type 2 to create a random matrix");
        int command = 0;
        while(command < 1 || command > 2){
            command = ConsoleInput.getCommand();
            switch (command) {
                case 1: {
                    matrix.userMatrix();
                    break;
                }
                case 2: {
                    matrix.randomMatrix();
                    break;
                }
                default: {
                    System.out.println("Wrong command!");
                }
            }
        }
    }
    public static void printMenu(){
        System.out.println("Type 1 to input a new matrix");
        System.out.println("Type 2 to calculate elements frequency");
        System.out.println("Type 3 to output the calculation");
        System.out.println("Type 4 to print the most frequent elements");
        System.out.println("Type 5 to print the least frequent elements");
        System.out.println("Type 6 to show the menu");
        System.out.println("Type -1 to exit");
    }
}