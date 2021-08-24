package duke;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Event extends Task {
    protected LocalDate at;

    public Event(String description, String at) {
        super(description);
        try {
            this.at = LocalDate.parse(at);

        } catch (DateTimeParseException e) {
            System.out.println("please enter a valid date");
        }
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at:"
                + at.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ")";
    }

    @Override
    public String getIcon() {
        return "E";
    }

    @Override
    public String getTaskTime() {
        return this.at.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Event) {
            Event event = (Event) obj;
            return event.toString().equals(this.toString());
        } else {
            return false;
        }
    }
}
