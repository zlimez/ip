package chatbot.commands;

import chatbot.exceptions.DukeException;
import chatbot.tasks.Task;
import chatbot.tasks.TaskList;
import chatbot.ui.Response;
import chatbot.ui.UI;

/**
 * Represents the command to be executed by the chatbot which marks
 * the specified task in the todo list as incomplete.
 */
public class Unmark implements Command {
    private final int target;

    public Unmark(int target) {
        this.target = target;
    }

    @Override
    public void execute(TaskList todos, UI ui) {
        try {
            Task unmarked = todos.unmarkTask(this.target);
            ui.unmark(unmarked);
        } catch (DukeException e) {
            ui.reprimand(e);
        }
    }

    @Override
    public String execute(TaskList todos, Response resp) {
        try {
            Task unmarked = todos.unmarkTask(this.target);
            return resp.unmark(unmarked);
        } catch (DukeException e) {
            return resp.reprimand(e);
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
