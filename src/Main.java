import menu.MainMenu;
import fileProcessors.FileProcessor;


import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // test input: C:\Users\Radostin\Desktop\FileProcessingApplication\test.txt

        FileProcessor fileProcessor = null;
        String input = "";
        Scanner scanner = new Scanner(System.in);
        boolean flag = false;

        while (!flag) {
            try {
                input = scanner.nextLine();
                fileProcessor = new FileProcessor(input);
                fileProcessor.read();
                flag = true;
            } catch (FileNotFoundException e) {
                System.out.println("No such file found, please try again!");
            }
        }

        MainMenu.menu(fileProcessor);






    }
}

