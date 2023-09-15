package Sidtacphi.Parser;

import java.util.Objects;
import java.util.Scanner;

import Sidtacphi.Task.TaskList;
import Sidtacphi.Task.TaskType;

import Sidtacphi.Exception.SidException;

public class Parser {
    private Parser() {
    }

    /**
     * The method for reading inputs for the bot.
     */
    public static void readInputs(TaskList taskList) {
        Scanner scan = new Scanner(System.in);
        System.out.print("\nYou: ");
        String input = "";
        while (true) { 
            try {
                input = scan.nextLine().trim();
                if (Objects.equals(input, "bye")) {
                    break;
                } else if (Objects.equals(input, "list")) {
                    taskList.showTaskList();
                } else if (input.startsWith("mark")) {
                    taskList.markTaskAs(true, input);
                } else if (input.startsWith("unmark")) {
                    taskList.markTaskAs(false, input);
                } else if (input.startsWith("todo")) {
                    taskList.addTask(TaskType.TODO, input);
                } else if (input.startsWith("event")) {
                    taskList.addTask(TaskType.EVENT, input);
                } else if (input.startsWith("deadline")) {
                    taskList.addTask(TaskType.DEADLINE, input);
                } else if (input.startsWith("delete")) {
                    taskList.deleteTask(input);
                } else {
                    throw new SidException("\"" + input + "\" is not a valid command.");
                }
                System.out.print("\nYou: ");
            } catch (SidException e) {
                    System.out.print("\n");
                    System.out.println(e.getMessage());
                    System.out.print("\nYou: ");
            }
        }
        scan.close();
    }
}
