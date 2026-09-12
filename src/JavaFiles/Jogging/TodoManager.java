package JavaFiles.Jogging;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TodoManager {
    private static final String File_Name = "tasks.txt";
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        ensureFileExists();
        while(true){
            System.out.println("\n--- To-Do List Manager ---");
            System.out.println("1. Add a task");
            System.out.println("2. View all tasks");
            System.out.println("3. Mark a task as done");
            System.out.println("4. Delete a task");
            System.out.println("5. Exit");
            System.out.println("Choose a option: ");
            String choice = sc.nextLine();
            switch (choice){
                case "1":
                    addTask(sc);
                    break;
                case "2":
                    viewTasks();
                    break;
                case "3":
                    updateTask(sc,true);
                    break;

                case "4":
                    updateTask(sc,false);
                    break;

                case "5":
                    System.out.println("GoodBye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        }
    }
    private static void ensureFileExists() {
        File file = new File(File_Name);
        try {
            if(!file.createNewFile())
            {
                System.out.println("Created file: " + File_Name);
            }
        }catch (IOException errors){
            System.out.println("Error creating file: " + errors.getMessage());
        }
    }

    private static void addTask(Scanner sc) {
        System.out.println("Enter task description: ");
        String description = sc.nextLine();
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(File_Name,true))) {
        writer.write(description + "| pending");
        writer.newLine();
            System.out.println("Task added.");
        } catch (IOException errored) {
            System.out.println("Write error: " + errored.getMessage());
        }

    }

    private static void viewTasks() {
        try(BufferedReader reader = new BufferedReader(new FileReader(File_Name))){
            String line;
            int i = 1;
            System.out.println("\n-- Tasks ---");
            while((line = reader.readLine()) != null){
                System.out.println(i + "." + line);
                i++;
            }
            if(i == 1){
                System.out.println("No tasks found.");
            }
        } catch (IOException exception) {
            System.out.println("Read Error: " + exception.getMessage());
        }
    }

    private static void updateTask(Scanner sc, boolean markDone) {
        List<String> tasks = new ArrayList<>();

        // Read all tasks
        try(BufferedReader reader = new BufferedReader(new FileReader(File_Name))){
            String line;
            while((line = reader.readLine()) != null){
                tasks.add(line);
            }
        } catch (IOException handling) {
            System.out.println("Read error: " + handling.getMessage());
        }
        if(tasks.isEmpty()){
            System.out.println("no Tasks avaliable.");
            return;
        }
        viewTasks();
        System.out.println("Enter task Number: ");
        try {
            int index = Integer.parseInt(sc.nextLine());
            if(index < 0 || index >= tasks.size()){
                System.out.println("Invalid task number.");
                return;
            }
            if(markDone){
                String task = tasks.get(index).split("\\|")[0].trim();
                tasks.set(index, task + "| done");
                System.out.println("Task marked as done.");
            }
            else {
                tasks.remove(index);
                System.out.println("Task deleted.");
            }
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(File_Name))){
            for(String t: tasks){
                writer.write(t);
                writer.newLine();
            }
        }catch (NumberFormatException e){
            System.out.println("Please enter a valid number.");
        } catch (IOException handlers) {
            System.out.println("Write error: " + handlers.getMessage());
        }
    }
}
