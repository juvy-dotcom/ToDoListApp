package controller;

import java.util.ArrayList;
import java.util.List;
import model.AbstractTask;

public class TaskManager {
    private final List<AbstractTask> tasks;
    private int nextTaskId;

    public TaskManager() {
        tasks = new ArrayList<>();
        nextTaskId = 1;
    }

    // Add a task
    public void addTask(AbstractTask task) {
        tasks.add(task);
    }

    // Remove a task by ID
    public boolean removeTask(String taskId) {
        return tasks.removeIf(task -> task.getTaskId().equals(taskId));
    }

    // Get all tasks
    public List<AbstractTask> getTasks() {
        return new ArrayList<>(tasks); // Return a copy to prevent external modification
    }

    // Generate next task ID
    public String generateTaskId() {
        return String.valueOf(nextTaskId++);
    }

    // Update task status (for future use, e.g., editing)
    public boolean updateTaskStatus(String taskId, String status) {
        for (AbstractTask task : tasks) {
            if (task.getTaskId().equals(taskId)) {
                task.setStatus(status);
                return true;
            }
        }
        return false;
    }
}
