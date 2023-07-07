package poe;

import javax.swing.JOptionPane;

public class POE {

    public static void main(String[] args) {
// part 1
// creating an account:         
        String firstName = JOptionPane.showInputDialog("Please enter your first name: "); // (Farrel, 2018)
        String surname = JOptionPane.showInputDialog("Please enter your surname: "); // (Farrel, 2018)

        login b1 = new login();
        boolean registration = false;
        boolean loggedIn = false;

//loop for checking the registration
        while (!registration) {  //(Farrell, 2019)
            String username = JOptionPane.showInputDialog("Please enter your username: ");
            String password = JOptionPane.showInputDialog("Please enter your password: ");

            registration = b1.registerUser(username, password).equals("User registered!!");

            JOptionPane.showMessageDialog(null, b1.registerUser(username, password));
        }

        while (!loggedIn) {  //(Farrell, 2019)
            String username = JOptionPane.showInputDialog("Please enter your username: ");
            String password = JOptionPane.showInputDialog("Please enter your password: ");

            loggedIn = b1.loginUser(username, password);

            JOptionPane.showMessageDialog(null, b1.returnLoginStatus(loggedIn, firstName, surname));
        }

// start of part 2
        JOptionPane.showMessageDialog(null, "Hello, Welcome to EasyKanban");

        Object[] options1 = {"Add Tasks", "Show Report", "Quit"}; // (tenorsax, 2012)
        var selectedOption = JOptionPane.showOptionDialog(null,
                "Select an option",
                "Select an option",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options1,
                null);

        tasks taskManager = new tasks();

        while (selectedOption != 2) { //(Farrell, 2019)
            if (selectedOption == 0) {
                int tasksNumber = Integer.parseInt(JOptionPane.showInputDialog("How many tasks do you wish to enter?"));

                taskManager.size(tasksNumber);

                for (int i = 0; i < tasksNumber; i++) {
                    String TaskName = JOptionPane.showInputDialog("Please enter the task name");
                    String TaskDescription = JOptionPane.showInputDialog("Please enter the task description");
                    String DeveloperDetails = JOptionPane.showInputDialog("Please enter the developer details");
                    int TaskNumber = i;
                    int TaskDuration = Integer.parseInt(JOptionPane.showInputDialog("Please enter task duration"));

                    Object[] options2 = {"To do", "Doing", "Done"};
                    var statuses = JOptionPane.showOptionDialog(null,
                            "Select an option",
                            "Select an option",
                            JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            options2,
                            null);

                    String myTaskStatus = null;

                    if (statuses == 0) { //(Farrell, 2019)
                        myTaskStatus = options2[0].toString();
                    } else if (statuses == 1) {
                        myTaskStatus = options2[1].toString();
                    } else if (statuses == 2) {
                        myTaskStatus = options2[2].toString();
                    }

                    taskManager.addTask(TaskName, TaskDescription, DeveloperDetails, myTaskStatus, TaskNumber, TaskDuration);
                    JOptionPane.showMessageDialog(null, "Task added successfully.");
                }
// start of  part 3
            } else if (selectedOption == 1) {
                Object[] reportOptions = {"Tasks with status Done", "Longest duration task", "Search by Task Name", "Search by Developer", "Delete a Task", "View All Tasks", "Go Back"};
                var reportOption = JOptionPane.showOptionDialog(null,
                        "Select an option",
                        "Select an option",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        reportOptions,
                        null);

                if (reportOption == 0) { // (tenorsax, 2012)
                    String report = taskManager.getTasksByStatus("Done");
                    JOptionPane.showMessageDialog(null, report, "Tasks with status Done", JOptionPane.INFORMATION_MESSAGE);
                } else if (reportOption == 1) {
                    String taskWithLongestDuration = taskManager.getLongestDurationTask();
                    JOptionPane.showMessageDialog(null, taskWithLongestDuration, "Longest duration task", JOptionPane.INFORMATION_MESSAGE);
                } else if (reportOption == 2) {
                    String taskName = JOptionPane.showInputDialog("Enter the Task Name to search for:");
                    String taskSearchResult = taskManager.searchByTaskName(taskName);
                    JOptionPane.showMessageDialog(null, taskSearchResult, "Search Result", JOptionPane.INFORMATION_MESSAGE);
                } else if (reportOption == 3) {
                    String developerName = JOptionPane.showInputDialog("Enter the Developer's name to search for:");
                    String developerTasks = taskManager.getTasksByDeveloper(developerName);
                    JOptionPane.showMessageDialog(null, developerTasks, "Tasks assigned to " + developerName, JOptionPane.INFORMATION_MESSAGE);
                } else if (reportOption == 4) {
                    String taskName = JOptionPane.showInputDialog("Enter the Task Name to delete:");
                    boolean deleted = taskManager.deleteTask(taskName);
                    if (deleted) {
                        JOptionPane.showMessageDialog(null, "Task deleted successfully.", "Delete a Task", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Task not found.", "Delete a Task", JOptionPane.ERROR_MESSAGE);
                    }
                } else if (reportOption == 5) {
                    String allTasks = taskManager.getAllTasks();
                    JOptionPane.showMessageDialog(null, allTasks, "All Tasks", JOptionPane.INFORMATION_MESSAGE);
                }
            }

            selectedOption = JOptionPane.showOptionDialog(null, // (tenorsax, 2012)
                    "Select an option",
                    "Select an option",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    options1,
                    null);
        }
    }
}

/*
tenorsax. 2012. Java: Custom Buttons in showInputDialog. [online]
Available at: https://stackoverflow.com/questions/13334198/java-custom-buttons-in-showinputdialog [Accessed 30 May 2023]

Farrell, J. 2019. Java Programming. 9th Ed. Boston: Cengage.
 */
