package duke;

/**
 * The task object.
 */
public class Task {
    protected String description;
    protected boolean isDone;

    public Task() {
        this.description = "";
        this.isDone = false;
    }

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Marks this task as done.
     */
    public void done() {
        this.isDone = true;
    }

    /**
     * Returns the task status icon.
     *
     * @return Icon indicating whether this task is done or not.
     */
    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    /**
     * Returns task status.
     *
     * @return Integer with 1 indicating task has been done and 0 has not been done.
     */
    public int getStatus() {
        return isDone ? 1 : 0;
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }

    /**
     * Shows this task's description.
     *
     * @return The task description.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Shows the time that the task will happen.
     *
     * @return The task's deadline or data.
     */
    public String getTaskTime() {
        return "";
    }

    /**
     * Returns this task's icon.
     *
     * @return This task's icon.
     */
    public String getIcon() {
        return "";
    }
}
