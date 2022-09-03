import java.util.Scanner;

public class InputMatrix {
    public static int getInt() {
        int num = 0;
        while(num == 0){
            System.out.print("Input a number: ");
            try(Scanner in = new Scanner(System.in)){
                if (in.hasNextInt()) {
                    num = in.nextInt();
                } else {
                    System.out.println("Вы ввели не целое число");
                }
            }
            catch (NumberFormatException ex) {
                System.out.println("Wrong format. Please, try again");
            }
        }
        System.out.printf("Your number: %d \n", num);
        return num;
    }
}
