package duke;

/**
 * Command that mark certain task as done.
 */
public class MarkAsDoneCommand extends Command {
    private int doneListIndex;//index in the list

    public MarkAsDoneCommand(int doneListIndex){
        this.doneListIndex = doneListIndex;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage){
        tasks.get(doneListIndex).done();
        storage.convertTaskListToFile(tasks);
        ui.markAsDone(tasks.get(doneListIndex));
    }

    @Override
    public boolean isExit(){
        return false;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof MarkAsDoneCommand){
            @SuppressWarnings("have checked obj is MarkAsDoneCommand, can safely parse")
            MarkAsDoneCommand temp = (MarkAsDoneCommand)obj;
            return temp.doneListIndex == this.doneListIndex
                    ?true
                    :false;
        } else {
            return false;
        }
    }
}
