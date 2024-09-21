import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        setupLogger();

        ScheduleManager scheduleManager = ScheduleManager.getInstance();
        ConsoleObserver consoleObserver = new ConsoleObserver();
        scheduleManager.addObserver(consoleObserver);

        while (true) {
            try {
                printMenu();
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        addTask(scheduleManager);
                        break;
                    case 2:
                        removeTask(scheduleManager);
                        break;
                    case 3:
                        viewTasks(scheduleManager);
                        break;
                    case 4:
                        editTask(scheduleManager);
                        break;
                    case 5:
                        markTaskCompleted(scheduleManager);
                        break;
                    case 6:
                        viewTasksByPriority(scheduleManager);
                        break;
                    case 7:
                        System.out.println("Exiting the application.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                LOGGER.log(Level.SEVERE, "Error in main loop", e);
            }
        }
    }

    private static void setupLogger() {
        try {
            FileHandler fileHandler = new FileHandler("astronaut_scheduler.log", true);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
            LOGGER.addHandler(fileHandler);
        } catch (Exception e) {
            System.out.println("Error setting up logger: " + e.getMessage());
        }
    }

    private static void printMenu() {
        System.out.println("\nAstronaut Daily Schedule Organizer");
        System.out.println("1. Add Task");
        System.out.println("2. Remove Task");
        System.out.println("3. View Tasks");
        System.out.println("4. Edit Task");
        System.out.println("5. Mark Task as Completed");
        System.out.println("6. View Tasks by Priority");
        System.out.println("7. Exit");
        System.out.print("Enter your choice (1-7): ");
    }

    private static void addTask(ScheduleManager scheduleManager) {
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        System.out.print("Enter start time (HH:mm): ");
        String startTime = scanner.nextLine();
        System.out.print("Enter end time (HH:mm): ");
        String endTime = scanner.nextLine();
        System.out.print("Enter priority (High/Medium/Low): ");
        String priority = scanner.nextLine();

        try {
            Task task = TaskFactory.createTask(description, startTime, endTime, priority);
            if (scheduleManager.addTask(task)) {
                System.out.println("Task added successfully.");
            } else {
                System.out.println("Failed to add task.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void removeTask(ScheduleManager scheduleManager) {
        System.out.print("Enter task description to remove: ");
        String description = scanner.nextLine();
        if (scheduleManager.removeTask(description)) {
            System.out.println("Task removed successfully.");
        } else {
            System.out.println("Task not found.");
        }
    }

    private static void viewTasks(ScheduleManager scheduleManager) {
        List<Task> tasks = scheduleManager.viewTasks();
        if (tasks.isEmpty()) {
            System.out.println("No tasks scheduled for the day.");
        } else {
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }

    private static void editTask(ScheduleManager scheduleManager) {
        System.out.print("Enter task description to edit: ");
        String oldDescription = scanner.nextLine();
        System.out.print("Enter new task description: ");
        String newDescription = scanner.nextLine();
        System.out.print("Enter new start time (HH:mm): ");
        String startTime = scanner.nextLine();
        System.out.print("Enter new end time (HH:mm): ");
        String endTime = scanner.nextLine();
        System.out.print("Enter new priority (High/Medium/Low): ");
        String priority = scanner.nextLine();

        try {
            Task newTask = TaskFactory.createTask(newDescription, startTime, endTime, priority);
            if (scheduleManager.editTask(oldDescription, newTask)) {
                System.out.println("Task edited successfully.");
            } else {
                System.out.println("Failed to edit task. Task not found or conflict detected.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void markTaskCompleted(ScheduleManager scheduleManager) {
        System.out.print("Enter task description to mark as completed: ");
        String description = scanner.nextLine();
        if (scheduleManager.markTaskCompleted(description)) {
            System.out.println("Task marked as completed.");
        } else {
            System.out.println("Task not found.");
        }
    }

    private static void viewTasksByPriority(ScheduleManager scheduleManager) {
        System.out.print("Enter priority level to view tasks (High/Medium/Low): ");
        String priority = scanner.nextLine();
        List<Task> tasks = scheduleManager.viewTasksByPriority(priority);
        if (tasks.isEmpty()) {
            System.out.println("No tasks found for the specified priority.");
        } else {
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }
}