package chatbot.commands;

import chatbot.ui.UI;
import chatbot.tasks.Task;
import chatbot.tasks.TaskList;

import java.time.LocalDate;

public class AddDeadline implements Command {
    public String taskName;
    public LocalDate date;

    public AddDeadline(String taskName, LocalDate date) {
        this.taskName = taskName;
        this.date = date;
    }

    @Override
    public void execute(TaskList todos, UI ui) {
        Task deadline = todos.addDeadline(this.taskName, this.date);
        ui.add(deadline, todos.getNumberOfTasks());
    }

    @Override
    public boolean isExit() {
        return false;
    }
}