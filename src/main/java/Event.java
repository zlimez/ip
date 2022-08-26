import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * The Event class is a subclass of Task emulating
 * an event in a real life where there is a date that is
 * tied to the event.
 */
public class Event extends Task {
    public LocalDate date;

    public Event(String taskName) throws IndexOutOfBoundsException, DukeException {
        super(taskName.substring(6, taskName.indexOf(" /at")));
        try {
            this.date = LocalDate.parse(taskName.substring(taskName.indexOf(" /at") + 5));
        } catch (DateTimeParseException e) {
            throw new DukeException("Your date is rubbish");
        }
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + this.date.format(DateTimeFormatter.ofPattern("MMM dd yyyy")) + ")";
    }

    public LocalDate getDate() {
        return this.date;
    }
}
