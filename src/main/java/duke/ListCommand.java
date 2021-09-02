package duke;

/**
 * Command that lists all tasks.
 */
public class ListCommand extends Command {
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        return ui.listAllTasks(tasks);
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ListCommand) {
            return true;
        } else {
            return false;
        }
    }
}
