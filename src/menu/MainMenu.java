package menu;

import fileProcessors.FileProcessor;

import java.util.InputMismatchException;
import java.util.Scanner;

public  class MainMenu {

    public static void menu(FileProcessor fileProcessor) {
        int menuChoice;
        Scanner scanner = new Scanner(System.in);

            System.out.println(
                    "\nWellcome please chose one of the following:\n" +
                            "   1) Validate file data.\n" +
                            "   2) Switch two lines.\n" +
                            "   3) Switch number at specific index in one line with a number with specific index from another line.\n" +
                            "   4) Save your file.\n" +
                            "   5) Insert a number to a curtain position.\n" +
                            "   6) Read a number.\n" +
                            "   7) Update a number.\n" +
                            "   8) Delete a number.\n" +
                            "   0) Exit.");


            menuChoice = Integer.parseInt(scanner.nextLine());
            switch (menuChoice) {
                case 0:
                    System.out.println("Closing...");
                    break;
                case 1:
                    if (!fileProcessor.validate()) {
                        System.out.println("Invalid input file!");
                        break;
                    } else {
                        menu(fileProcessor);
                    }

                case 2:
                    if (fileProcessor.validate()) {

                        System.out.println("\nEnter the the indexes of the lines you want to switch in format <first_line_index> <second_line_index> :");
                        try {
                            Switch switcher = new Switch(scanner.nextInt(), scanner.nextInt(), fileProcessor.getRepository());
                            scanner.nextLine();
                            switcher.switchIt();
                            System.out.println("Line switch successful!");
                            menu(fileProcessor);
                        } catch (InputMismatchException ex) {
                            System.out.println("You must enter only numbers!");
                            menu(fileProcessor);
                        } catch (IndexOutOfBoundsException | NullPointerException ex) {
                            System.out.println("Not existing index!");
                            menu(fileProcessor);
                        }

                    }else {
                        System.out.println("Invalid input file!");
                    }
                    break;
                case 3:
                    if (fileProcessor.validate()) {
                        System.out.println("\nEnter the the indexes of the numbers you want to switch\n" +
                                "in format <first_line_index> <first_line_number_index> <second_line_index> <second_line_number_index> :");
                        try {
                            NumberSwitch numberSwitch = new NumberSwitch(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), fileProcessor.getRepository());
                            numberSwitch.switchIt();
                            scanner.nextLine();
                            System.out.println("Switch successful!");
                            menu(fileProcessor);
                        } catch (InputMismatchException ex) {
                            System.out.println("You must enter only numbers!");
                            menu(fileProcessor);
                        } catch (IndexOutOfBoundsException | NullPointerException ex) {
                            System.out.println("Not existing index!");
                            menu(fileProcessor);
                        }

                    }else {
                        System.out.println("Invalid input file!");
                    }


                    break;
                case 4:
                    if (fileProcessor.validate()) {
                        fileProcessor.write();
                        System.out.println("File saved successfully!");
                        menu(fileProcessor);
                    }else {
                        System.out.println("Invalid input file!");
                    }
                    break;
                case 5:
                    System.out.println("\n Enter the the indexes of the number you want to view\n" +
                            "in format <first_line_index> <first_line_number_index> :");
                    if (fileProcessor.validate()) {
                        try {
                            Insert insert = new Insert(scanner.nextInt(), scanner.nextInt(), fileProcessor.getRepository());
                            insert.insert(scanner.next());
                            scanner.nextLine();
                            menu(fileProcessor);
                        } catch (InputMismatchException ex) {
                            System.out.println("You must enter only numbers!");
                            menu(fileProcessor);
                        } catch (IndexOutOfBoundsException | NullPointerException ex) {
                            System.out.println("Not existing index!");
                            menu(fileProcessor);
                        }

                    }else {
                        System.out.println("Invalid input file!");
                    }
                    break;
                case 6:
                    System.out.println("\nEnter the the indexes of the number you want to insert\n" +
                            "in format <line_index> <line_number_index> <number to be inserted> :");
                    if (fileProcessor.validate()) {
                        try {
                            NumberRead numberRead = new NumberRead(scanner.nextInt(), scanner.nextInt(), fileProcessor.getRepository());
                            numberRead.read();
                            scanner.nextLine();
                            System.out.println("Insert successful!");
                            menu(fileProcessor);
                        } catch (InputMismatchException ex) {
                            System.out.println("You must enter only numbers!");
                            menu(fileProcessor);
                        } catch (IndexOutOfBoundsException | NullPointerException ex) {
                            System.out.println("Not existing index!");
                            menu(fileProcessor);
                        }

                    }else {
                        System.out.println("Invalid input file!");
                    }
                    break;
                case 7:
                    System.out.println("\nEnter the the indexes of the number you want to update\n" +
                            "in format <line_index> <line_number_index> <number to be set> :");
                    if (fileProcessor.validate()) {
                        try {
                            ModifyNumber modifyNumber = new ModifyNumber(scanner.nextInt(), scanner.nextInt(), fileProcessor.getRepository());
                            modifyNumber.update(scanner.next());
                            scanner.nextLine();
                            System.out.println("Update successful!");
                            menu(fileProcessor);
                        } catch (InputMismatchException ex) {
                            System.out.println("You must enter only numbers!");
                            menu(fileProcessor);
                        } catch (IndexOutOfBoundsException | NullPointerException ex) {
                            System.out.println("Not existing index!");
                            menu(fileProcessor);
                        }
                    }else {
                        System.out.println("Invalid input file!");
                    }
                    break;
                case 8:
                    System.out.println("\nEnter the the indexes of the number you want to delete\n" +
                            "in format <line_index> <line_number_index> :");
                    if (fileProcessor.validate()) {
                        try {
                            Remove remove = new Remove(scanner.nextInt(), scanner.nextInt(), fileProcessor.getRepository());
                            remove.delete();
                            scanner.nextLine();
                            System.out.println("Delete successful!");
                            menu(fileProcessor);
                        } catch (InputMismatchException ex) {
                            System.out.println("You must enter only numbers!");
                            menu(fileProcessor);
                        } catch (IndexOutOfBoundsException | NullPointerException ex) {
                            System.out.println("Not existing index!");
                            menu(fileProcessor);
                        }
                    }else {
                        System.out.println("Invalid input file!");
                    }
                    break;

                default:
                    System.out.println("Invalid command!");
                    menu(fileProcessor);

            }
    }

}


