import java.util.Scanner;

enum Status {
    EMPTY,
    FILLED,
    CALCULATED,

}
public class Application {
    static Status status = Status.EMPTY;
    public static void main(String[] args) {
        Matrix matrix = new Matrix();
        Matrix calculation = null;
        boolean end = false;
        while (! end){
            int command = getCommand();
            System.out.println(command);
            switch (command) {
                case 1: {
                    matrix.randomMatrix();
                    matrix.printMatrix();
                    status = Status.FILLED;
                    System.out.println(1);
                    break;
                }
                case 2: {
                    if (status == Status.FILLED){
                        System.out.println(2);
                        status = Status.CALCULATED;
                    }
                    break;
                }
                case 3: {
                    if (status == Status.CALCULATED){
                        System.out.println(3);
                    }
                    break;
                }
                case -1: {
                    end = true;
                    break;
                }
            }
        }
    }
    public static void printMenu(){
        System.out.println("Print 1 to input a new matrix");
        System.out.println("Print 2 to calculate elements frequency");
        System.out.println("Print 3 to output the calculation");
        System.out.println("Print -1 to exit");
    }
    public static int getCommand(){
        Scanner scanner = new Scanner(System.in);
        int command = 0;
        while (command > 3 | command == 0 | command < -1){
            System.out.print("Enter your command: ");
            command = ConsoleInput.getInt(scanner);
            if (command > 3 | command == 0 | command < -1) {
                System.out.println("Wrong command!");
            }
        }
        scanner.close();
        return command;
    }
}