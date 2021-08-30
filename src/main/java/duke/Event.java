package duke;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    protected LocalDateTime from;
    protected LocalDateTime to;

    /**
     * Constructor for event.
     *
     * @param description Description of event.
     * @param at Event time.
     */
    public Event(String description, String at) {
        super(description);
        String[] fromTo = at.split("--");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        String from = fromTo[0];
        String to = fromTo[1];
        this.from = LocalDateTime.parse(from, formatter);
        this.to = LocalDateTime.parse(to, formatter);
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at:"
                + from.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))
                + " -- "
                + to.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) + ")";
    }

    @Override
    public String getIcon() {
        return "E";
    }

    @Override
    public String getTaskTime() {
        return from.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"))
                + "--"
                + to.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));
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
