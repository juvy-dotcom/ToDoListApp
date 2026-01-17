package model;

public abstract class AbstractTask {
    private String taskId;
    private String taskName;
    private String taskDescription;

    // Default constructor
    public AbstractTask() {
        this.taskId = "";
        this.taskName = "";
        this.taskDescription = "";
    }

    // Parameterized constructor
    public AbstractTask(String taskId, String taskName, String taskDescription) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
    }

    // Normal getters and setters
    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    // Abstract methods for status (to be implemented by subclasses)
    public abstract String getStatus();
    public abstract void setStatus(String status);
}
