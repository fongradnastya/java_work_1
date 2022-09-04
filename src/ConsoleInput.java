import java.util.Scanner;

public class ConsoleInput {
    public static int getInt(Scanner myScanner) {
        int num = 0;
        while (num == 0)
        {
            String line = myScanner.nextLine();
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
}
