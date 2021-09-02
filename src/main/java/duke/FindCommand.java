package duke;

public class FindCommand extends Command {
    private String keyWord;

    public FindCommand(String keyWord) {
        this.keyWord = keyWord;
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        TaskList result = tasks.find(keyWord);
        return ui.listAllTasks(result);
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof FindCommand) {
            return true;
        } else {
            return false;
        }
    }
}
