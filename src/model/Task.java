package model;

public class Task extends AbstractTask {
    public enum Status {
        DONE, ONGOING, NOT_STARTED
    }

    private Status status;

    // Constructor (inherits from AbstractTask)
    public Task(String taskId, String taskName, String taskDescription, Status status) {
        super(taskId, taskName, taskDescription);
        this.status = status;
    }

    // Override status getter and setter
    @Override
    public String getStatus() {
        return status.toString();
    }

    @Override
    public void setStatus(String status) {
        try {
            this.status = Status.valueOf(status.toUpperCase().replace(" ", "_"));
        } catch (IllegalArgumentException e) {
            this.status = Status.NOT_STARTED; // Default if invalid
        }
    }
}
