package project;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Task {
    private String description;
    private boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return isDone;
    }

    public void markDone() {
        isDone = true;
    }
}

class TodoList {
    private ArrayList<Task> tasks = new ArrayList<>();

    public void addTask(String description) {
        Task task = new Task(description);
        tasks.add(task);
        System.out.println("Task added successfully: " + description);
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            System.out.println("Task List:");
            for (int i = 0; i < tasks.size(); i++) {
                Task task = tasks.get(i);
                System.out.println((i + 1) + ". " + task.getDescription() + " [Status: " +
                        (task.isDone() ? "Done" : "Pending") + "]");
            }
        }
    }

    public void markTaskDone(int index) {
        if (index >= 0 && index < tasks.size()) {
            Task task = tasks.get(index);
            if (!task.isDone()) {
                task.markDone();
                System.out.println("Task marked as done: " + task.getDescription());
            } else {
                System.out.println("Task is already marked as done.");
            }
        } else {
            System.out.println("Invalid task index.");
        }
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            Task removedTask = tasks.remove(index);
            System.out.println("Task removed successfully: " + removedTask.getDescription());
        } else {
            System.out.println("Invalid task index.");
        }
    }
}

public class ToDoApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TodoList todoList = new TodoList();

        while (true) {
            System.out.println("\nTo-Do List Application");
            System.out.println("1. Add Task");
            System.out.println("2. List Tasks");
            System.out.println("3. Mark Task as Done");
            System.out.println("4. Remove Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        System.out.print("Enter task description: ");
                        String description = scanner.nextLine();
                        todoList.addTask(description);
                        break;
                    case 2:
                        todoList.listTasks();
                        break;
                    case 3:
                        System.out.print("Enter the task index to mark as done: ");
                        int doneIndex = scanner.nextInt();
                        todoList.markTaskDone(doneIndex - 1);
                        break;
                    case 4:
                        System.out.print("Enter the task index to remove: ");
                        int removeIndex = scanner.nextInt();
                        todoList.removeTask(removeIndex - 1);
                        break;
                    case 5:
                        System.out.println("Exiting the To-Do List Application. Goodbye!");
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
    }
}
