import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;

public class ScheduleManager {
    private static ScheduleManager instance;
    private List<Task> tasks;
    private List<Observer> observers;
    private static final Logger LOGGER = Logger.getLogger(ScheduleManager.class.getName());

    private ScheduleManager() {
        tasks = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public static synchronized ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    private void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public boolean addTask(Task task) {
        if (isConflicting(task)) {
            notifyObservers("Task conflicts with existing task.");
            return false;
        }
        tasks.add(task);
        Collections.sort(tasks, Comparator.comparing(Task::getStartTime));
        LOGGER.log(Level.INFO, "Task added: " + task.getDescription());
        return true;
    }

    public boolean removeTask(String description) {
        boolean removed = tasks.removeIf(task -> task.getDescription().equals(description));
        if (removed) {
            LOGGER.log(Level.INFO, "Task removed: " + description);
        }
        return removed;
    }

    public List<Task> viewTasks() {
        return new ArrayList<>(tasks);
    }

    private boolean isConflicting(Task newTask) {
        for (Task task : tasks) {
            if (newTask.getStartTime().isBefore(task.getEndTime()) && 
                newTask.getEndTime().isAfter(task.getStartTime())) {
                return true;
            }
        }
        return false;
    }

    public boolean editTask(String oldDescription, Task newTask) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getDescription().equals(oldDescription)) {
                if (isConflicting(newTask) && !newTask.getStartTime().equals(tasks.get(i).getStartTime())) {
                    notifyObservers("Edit conflicts with existing task.");
                    return false;
                }
                tasks.set(i, newTask);
                Collections.sort(tasks, Comparator.comparing(Task::getStartTime));
                LOGGER.log(Level.INFO, "Task edited: " + oldDescription + " to " + newTask.getDescription());
                return true;
            }
        }
        return false;
    }

    public boolean markTaskCompleted(String description) {
        for (Task task : tasks) {
            if (task.getDescription().equals(description)) {
                task.setCompleted(true);
                LOGGER.log(Level.INFO, "Task marked as completed: " + description);
                return true;
            }
        }
        return false;
    }

    public List<Task> viewTasksByPriority(String priority) {
        List<Task> priorityTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getPriority().equalsIgnoreCase(priority)) {
                priorityTasks.add(task);
            }
        }
        return priorityTasks;
    }
}