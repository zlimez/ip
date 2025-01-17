package chatbot.ui;

import java.util.List;
import java.util.Set;

import chatbot.exceptions.DukeException;
import chatbot.tasks.Task;

/**
 * The class is responsible for generating the response to a user input return the result to the
 * GUI for display.
 */
public class Response {
    public static final String SLEEPING = "You said bye already, I am resting now. "
            + "Restart, if you wish wish to talk again.";
    private static final String EMOJI = "<_>";

    public String greet() {
        return "Yes? I'm Zlimez~~ \nWhat can I possibly do for you?\n >>>^<<<";
    }

    /**
     * The method determines the response after users query for all tasks in the todo list.
     *
     * @param tasks the list containing all the tasks.
     */
    public String listAll(List<Task> tasks) {
        if (tasks.isEmpty()) {
            return "You are the least productive person I have seen.";
        }
        return String.format("Really? If you are so forgetful...\n%s", list(tasks));
    }

    /**
     * The method determines the response after users query for tasks in the todo list on the specified date.
     *
     * @param tasks the list containing the relevant tasks.
     */
    public String listTaskOn(List<Task> tasks) {
        if (tasks != null) {
            return String.format("These are your tasks for that day\n%s", list(tasks));
        } else {
            return "Well you are a lazy bum, you have nothing on the day";
        }
    }

    /**
     * The method determines the response after users query for tasks in the todo list with the specified tag.
     *
     * @param tasks the list containing the relevant tasks.
     */
    public String listTaskWith(List<Task> tasks) {
        if (tasks != null) {
            return String.format("These are your tasks with the given tag\n%s", list(tasks));
        } else {
            return "You have no tasks with this tag";
        }
    }

    /**
     * The method determines the response after users query for tasks that contain a given keyword.
     *
     * @param tasks the list containing the relevant tasks.
     */
    public String listFound(List<Task> tasks) {
        if (!tasks.isEmpty()) {
            return "These are the tasks that match your incomplete description\n" + list(tasks);
        } else {
            return "You like to search for nothing and waste time huh?";
        }
    }

    private StringBuffer list(List<Task> tasks) {
        StringBuffer todos = new StringBuffer();
        for (int i = 1; i <= tasks.size(); i++) {
            todos.append(String.format("\t%d. %s\n", i, tasks.get(i - 1)));
        }

        return todos;
    }

    /**
     * The method determines the response after a user requests for all tags from the todo list.
     *
     * @param tags the list containing all tags.
     */
    public String listAllTags(Set<String> tags) {
        if (tags.isEmpty()) {
            return "You have no tags, no belonging in life.";
        }

        int index = 1;
        StringBuffer sb = new StringBuffer("These are all the tags you gave so far\n");
        for (String tag : tags) {
            sb.append(String.format("\t%d. %s\n", index, tag));
            index++;
        }
        return sb.toString();
    }


    /**
     * The method determines the response after a specific task has been added and the new todo list status.
     *
     * @param target the task added.
     * @param numberOfTasks the number of tasks after the addition.
     */
    public String add(Task target, int numberOfTasks) {
        return String.format("I've ADDED this task for you %s\n\t%s\nWala now you have %d tasks in the list.",
                EMOJI, target, numberOfTasks);
    }

    /**
     * The method determines the response after the specific task has been removed and the new todo list status.
     *
     * @param target the task removed.
     * @param numberOfTasks the number of tasks after the deletion.
     */
    public String delete(Task target, int numberOfTasks) {
        return String.format("YES, I've removed this task for YOU:\n\t%s\nWala now you have %d tasks in the list.",
                target, numberOfTasks);
    }

    /**
     * The method determines the response after the specified task has been marked.
     *
     * @param target the task marked as complete.
     */
    public String unmark(Task target) {
        return String.format("-_-, I've unmarked this task for YOU AGAIN:\n\t%s", target);
    }

    /**
     * The method determines the response after the specified task has been unmarked.
     *
     * @param target the task marked as incomplete.
     */
    public String mark(Task target) {
        return String.format("Wellz, I've marked this task for YOU:\n\t%s", target);
    }

    /**
     * The method determines the response when an exception occurs due to user misuse.
     *
     * @param e the exceptions raised.
     */
    public String reprimand(DukeException e) {
        return e.getMessage();
    }

    /**
     * The method determines the response when the user closes the session.
     */
    public String bye() {
        return "Bye. zzz FINALLY~~" + " " + EMOJI;
    }
}
