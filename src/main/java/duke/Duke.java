package duke;

public class Duke {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Duke(String filePath) {
        this.storage = new Storage(filePath);
        this.tasks = storage.convertFileToTaskList();
        this.ui = new Ui();
    }

    public void run() {
        ui.greet();
        boolean isExit = false;
        Parser parser = new Parser(" ");
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                Command c = parser.parse(fullCommand);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
            } catch (DukeException e) {
                ui.showError(e.getMessage());
            }
        }
    }


    public static void main(String[] args) {
        new Duke("data/tasks.txt").run();
    }
}
