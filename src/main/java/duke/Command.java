package duke;

/**
 * Abstract class representing commands.
 */
public abstract class Command {
    /**
     * Executes the command.
     *
     * @param tasks   Up to date TaskList.
     * @param ui      User interaction class.
     * @param storage Class that store tasks.
     */
    public abstract String execute(TaskList tasks, Ui ui, Storage storage);

    /**
     * indicates whether the command is to exit duke bot.
     *
     * @return A boolean value indicating whether the command is to exit duke bot.
     */
    public abstract boolean isExit();
}
