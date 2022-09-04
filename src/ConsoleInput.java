import java.util.Scanner;

public class ConsoleInput {
    private final static Scanner scanner = new Scanner(System.in);
    public static int getInt() {
        int num = 0;
        while (num == 0)
        {
            String line = scanner.nextLine();
            try
            {
                num = Integer.parseInt(line);
                break;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Wrong number format! Please, try again");
            }
        }
        return num;
    }
    public static int getCommand(){

        int command = 0;
        while (command > 3 | command == 0 | command < -1){
            System.out.print("Enter your command: ");
            command = ConsoleInput.getInt();
            if (command > 3 | command == 0 | command < -1) {
                System.out.println("Wrong command!");
            }
        }
        return command;
    }
    public static void close(){
        scanner.close();
    }
}
