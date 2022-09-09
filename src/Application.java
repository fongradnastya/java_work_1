/**
 * Status содержит возможные состояния приложения
 */
enum Status {
    EMPTY,
    FILLED,
    CALCULATED,
}

/**
 * Класс Application содержит основные методы приложения
 */
public class Application {
    static Status status = Status.EMPTY;

    /**
     * Метод main - точка входа в программу. Он содержит главный цикл приложения
     * @param args - аргументы, переданные при запуске приложения
     */
    public static void main(String[] args) {
        Matrix matrix = new Matrix();
        FrequencyMatrix calculation = new FrequencyMatrix();
        boolean end = false;
        printMenu();
        while (! end){
            int command = ConsoleInput.getCommand();
            switch (command) {
                case 1: {
                    chooseInputMode(matrix);
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
                    else{
                        System.out.println("No original matrix yet!");
                    }
                    break;
                }
                case 3: {
                    if (status == Status.CALCULATED){
                        calculation.printMatrix();
                    }
                    else{
                        System.out.println("No frequent matrix yet!");
                    }
                    break;
                }
                case 4, 5: {
                    boolean isHigh = command == 4;
                    if (status == Status.CALCULATED){
                        System.out.println("Please, enter a number of elements");
                        int number = ConsoleInput.getPositiveNumber();
                        int[] array = calculation.createFrequencyArray(matrix, number, isHigh);
                        if(isHigh) System.out.print("The most frequent elements: ");
                        else System.out.print("The least frequent elements: ");
                        for(int i = 0; i < array.length; i++){
                            System.out.printf("%d ", array[i]);
                        }
                        System.out.println("");
                    }
                    else{
                        System.out.println("No frequent matrix yet!");
                    }
                    break;
                }
                case 6: {
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

    /**
     * Метод chooseInputMode позволяет создать матрицу одним из двух способов:
     * используя данные из консоли или случайные числа
     * @param matrix - объект типа Matrix, который необходимо заполнить значениями
     */
    public static void chooseInputMode(Matrix matrix){
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

    /**
     * Метод printMenu выводит в консоль меню пользователя
     */
    public static void printMenu(){
        System.out.println("-------------------MENU---------------------");
        System.out.println("Type 1 to input a new matrix");
        System.out.println("Type 2 to calculate elements frequency");
        System.out.println("Type 3 to output the calculation");
        System.out.println("Type 4 to print the most frequent elements");
        System.out.println("Type 5 to print the least frequent elements");
        System.out.println("Type 6 to show the menu");
        System.out.println("Type -1 to exit");
        System.out.println("---------------------------------------------");
    }
}