import org.jetbrains.annotations.Nullable;
import java.util.Scanner;

/**
 * Класс ConsoleInput содержит статические методы для считывания пользовательских данных из консоли
 */
public class ConsoleInput {
    /**
     *
     */
    private final static Scanner scanner = new Scanner(System.in);

    /**
     * Метод getIntString считывает строку, содержащую одно число типа int
     * @return number - считанное целое число
     */
    public static int getIntString() {
        int number = 0;
        while (number == 0)
        {
            if(scanner.hasNext()){
                String line = scanner.nextLine();
                try
                {
                    number = Integer.parseInt(line);
                    break;
                }
                catch (NumberFormatException e)
                {
                    System.out.println("Wrong number format!");
                    return 0;
                }
            }
        }
        return number;
    }

    /**
     * Метод getCommand считывает комманду из консоли
     * @return - комманда в виде числа типа int
     */
    public static int getCommand(){
        System.out.print("Enter your command: ");
        return ConsoleInput.getIntString();
    }
    public static int getSize(char axis){
        int number = 0;
        while(number < 1){
            System.out.printf("Please, enter %c matrix size: ", axis);
            number = getIntString();
            if(number < 1){
                System.out.println("This value should be positive!");
            }
        }
        return number;
    }
    /**
     * Метод getMatrix считывает из консоли набор записанных в виде матрицы чисел
     * @param sizeX - количество чисел в строке
     * @param sizeY - количество чисел в столбце
     * @return array - двумерный массив из считанных значений
     */
    public static int[] @Nullable [] getMatrix(int sizeX, int sizeY){
        System.out.println("Enter your matrix here:");
        int[][] array = new int[sizeX][sizeY];
        for(int y = 0; y < sizeY; y++){
            for(int x = 0; x < sizeX; x++){
                if (scanner.hasNextInt()){
                    array[x][y] = scanner.nextInt();
                }
                else {
                    if(scanner.hasNext()){
                        scanner.nextLine();
                    }
                    System.out.println("Wrong matrix format!");
                    return null;
                }
            }
        }
        scanner.nextLine();
        return array;
    }

    /**
     * Метод close закрывает Scanner
     */
    public static void close(){
        scanner.close();
    }
}
