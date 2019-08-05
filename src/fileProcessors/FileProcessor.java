package fileProcessors;

import repository.Repository;
import repository.RepositoryImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;



public class FileProcessor {
    private Repository repository;
    private String filePath;


    public FileProcessor(String filePath) {
        this.repository = new RepositoryImpl();
        this.filePath = filePath;
    }
    public LinkedHashMap<Integer, ArrayList<String>> getRepository(){
        return this.repository.getRepository();
    }



    public void read() throws FileNotFoundException {
        File file = new File(this.filePath);

        Scanner scanner = new Scanner(file);
        int i = 0;
        while(scanner.hasNextLine()){
            ArrayList<String> line = new ArrayList<>
                    (Arrays.asList(scanner.nextLine().split("\\s+")));
            this.repository.getRepository().put(i, line);
            i++;
        }

    }

    public boolean validate(){
        File file = new File(filePath);
        Scanner scanner = null;
        int lineN = 1;
        boolean flag = true;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            if(line.equals("")){
                break;
            }

            if(line.charAt(0) == ' ') {
                System.out.printf("Line %d, character %d is not allowed!%n"
                        , lineN, line.indexOf(line.charAt(0)));
                flag = false;
            }else if (line.charAt(0) == '0'){
                System.out.printf("Line %d, character %d number starts with zero!%n"
                        , lineN, line.indexOf(line.charAt(0)));
                flag = false;
            }

            for (int i = 0; i < line.length() ; i++) {
                if(!Character.isDigit(line.charAt(i))
                        && line.charAt(i) != ' '){
                    System.out.printf("Line %d, character %d is not allowed!%n",
                            lineN, i);
                    flag = false;
                }else if(i+1 != line.length()
                        && line.charAt(i) == ' '
                        && line.charAt(i+1) == '0'){
                    System.out.printf("Line %d, character %d number starts with zero!%n",
                            lineN, i+1);
                    flag = false;
                }

            }


            lineN++;
        }
        return flag;
    }

    public void write(){
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(this.filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        LinkedHashMap<Integer, ArrayList<String>> listLinkedHashMap = this.getRepository();

        for (ArrayList<String> i:
             listLinkedHashMap.values()) {
            for (String str:
                 i) {
                if (printWriter != null) {
                    printWriter.print(str + " ");
                }
            }
            if (printWriter != null) {
                printWriter.println();
            }

        }
        if (printWriter != null) {
            printWriter.close();
        }
    }












}
