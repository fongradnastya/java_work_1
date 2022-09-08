import java.util.Scanner;

public class ConsoleInput {
    private final static Scanner scanner = new Scanner(System.in);
    public static int getInt(){
        int item = 0;
        if (scanner.hasNextInt()){
            item = scanner.nextInt();
        }
        return item;
    }
    public static int getIntString() {
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
        System.out.print("Enter your command: ");
        return ConsoleInput.getInt();
    }

    public static int[][] getMatrix(int sizeX, int sizeY){
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
        return array;
    }

    public static void close(){
        scanner.close();
    }
}
