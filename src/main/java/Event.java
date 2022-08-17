public class Event extends Task {
    public String date;

    public Event(String taskName) throws IndexOutOfBoundsException {
        super(taskName.substring(6, taskName.indexOf(" /at")));
        this.date = taskName.substring(taskName.indexOf(" /at") + 5);
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + this.date + ")";
    }
}
