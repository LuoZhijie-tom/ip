package duke;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * class that interact with the file used to store tasks.
 */
public class Storage {
    private String filePath;

    /**
     * Constructor for Storage.
     *
     * @param filePath Path to duke storage file.
     */
    public Storage(String filePath) {
        this.filePath = filePath;
        File dukeFile = new File(filePath);
        File directory = dukeFile.getParentFile();
        if (!directory.exists()) {
            directory.mkdir();
        }
        try {
            if (!dukeFile.exists()) {
                dukeFile.createNewFile();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * adds new tasks to the file.
     *
     * @param task Task that is going to be added.
     */
    public void addTaskToFile(Task task) {
        try {
            FileWriter fileWriter = new FileWriter(filePath, true);
            fileWriter.write(task.getIcon() + "&&" + task.getStatus() + "&&" + task.getDescription()
                    + "&&" + task.getTaskTime() + "\n");
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Converts the string representation of task to task object.
     *
     * @param taskString String representation of task read from file.
     * @return Task object.
     * @throws DukeException Exception that duke bot can throw.
     */
    public static Task convertTaskStringToTask(String taskString) throws Exception {
        int pointer = 0;
        String[] newTask = taskString.split("&&");
        String taskType = newTask[0];
        pointer += taskType.length() + 2;
        String status = newTask[1];
        pointer += status.length() + 2;
        String taskDescription = newTask[2];
        pointer += taskDescription.length() + 2;
        String taskTime = taskString.substring(pointer);
        Task task;
        switch(taskType) {
        case "T":
            task = new ToDo(taskDescription);
            break;
        case "D":
            task = new Deadline(taskDescription, taskTime);
            break;
        case "E":
            task = new Event(taskDescription, taskTime);
            break;
        default:
            throw new DukeException("Can't understand the task icon '" + taskType + "'");
        }
        if (status.equals("1")) {
            task.done();
        }
        return task;
    }

    /**
     * Converts all tasks derived from the storage file to TaskList.
     *
     * @return TaskList that includes all tasks in the file.
     */
    public TaskList convertFileToTaskList() throws Exception {
        TaskList taskList = new TaskList(new ArrayList<Task>());
        File dukeFile = new File(filePath);
        try {
            Scanner scan = new Scanner(dukeFile);
            while (scan.hasNext()) {
                String taskString = scan.nextLine();
                Task task = convertTaskStringToTask(taskString);
                taskList.add(task);
            }
        } catch (Exception e) {
            throw new Exception("Can't understand data in the duke file. "
                    + "Detail information: "
                    + e.getMessage());
        }
        return taskList;
    }

    /**
     * Updates the file with the new TaskList.
     *
     * @param taskList New TaskList.
     */
    public void convertTaskListToFile(TaskList taskList) {
        try {
            FileWriter clearFile = new FileWriter(filePath);
            clearFile.write("");
            clearFile.close();
            for (int i = 0; i < taskList.size(); i++) {
                addTaskToFile(taskList.get(i));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
