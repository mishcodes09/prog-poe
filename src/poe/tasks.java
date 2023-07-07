package poe;

public class tasks {

//(Farrell, 2019)
    private static int totalHours;
    private String TaskName, TaskDescription, DeveloperDetails, TaskID, TaskStatus;
    private int TaskNumber, TaskDuration;

    String[] taskNameArr; //(Farrell, 2019)
    String[] taskDescriptionArr;
    String[] developerDeetsArr;
    String[] statusArr;
    int[] taskNumberArr;
    int[] durationArr;
    int count = 0;

    public tasks(String TaskName, String TaskDescription, String DeveloperDetails, String TaskStatus, int TaskNumber, int TaskDuration) {
        this.TaskName = TaskName; //(Farrell, 2019)
        this.TaskDescription = TaskDescription;
        this.DeveloperDetails = DeveloperDetails;
        this.TaskID = createTaskID(DeveloperDetails, TaskNumber, TaskName);
        this.TaskStatus = TaskStatus;
    }

    public tasks() { //(Farrell, 2019)
    }

    public void addTask(String TaskName, String TaskDescription, String DeveloperDetails, String TaskStatus, int TaskNumber, int TaskDuration) {
        taskNameArr[count] = TaskName;
        taskDescriptionArr[count] = TaskDescription;
        developerDeetsArr[count] = DeveloperDetails;
        statusArr[count] = TaskStatus;
        taskNumberArr[count] = TaskNumber;
        durationArr[count] = TaskDuration;

        count++;
    }

    public void size(int i) {
        statusArr = new String[i];
        taskNameArr = new String[i];
        developerDeetsArr = new String[i];
        taskDescriptionArr = new String[i];
        durationArr = new int[i];
        taskNumberArr = new int[i];
    }

    public boolean checkTaskDescription(String taskDescription) { // (davidalayachew, 2022)
        boolean length = false;
        length = taskDescription.length() <= 50;
        return length;
    }

    public String createTaskID(String developerDetails, int taskNumber, String taskName) { //(Farrell, 2019)
        String taskId = "";
        taskId = taskId + taskName.substring(0, 2)
                + ":" + taskNumber + ":" + developerDetails.substring(developerDetails.indexOf(" ") - 3, developerDetails.indexOf(" "));
        return taskId.toUpperCase();
    }

    public String printTaskDetails() { //baeldang, 2023
        String output = "";
        output += "Task Name: " + TaskName + "\n";
        output += "Task Number: " + TaskNumber + "\n";
        output += "Task Description: " + TaskDescription + "\n";
        output += "Developer Details : " + DeveloperDetails + "\n";
        output += "Task Duration : " + TaskDuration + "\n";
        output += "TaskID : " + getTaskID() + "\n";
        output += "Task Status :" + TaskStatus + "\n";

        return output;
    }

    public int returnTotalHours() {
        totalHours = TaskDuration + totalHours;
        return totalHours;
    }

    public String getTaskID() {
        return TaskID;
    }

    public String getTasksByStatus(String status) {
        StringBuilder report = new StringBuilder(); //(GeeksForGeeks,2020)
        for (int i = 0; i < count; i++) {
            if (statusArr[i].equalsIgnoreCase(status)) { //ykaganovich, 2010
                report.append("Developer: ").append(developerDeetsArr[i]).append("\n");
                report.append("Task Name: ").append(taskNameArr[i]).append("\n");
                report.append("Task Duration: ").append(durationArr[i]).append(" hours").append("\n\n");
            }
        }
        return report.toString();
    }

    public String getLongestDurationTask() {
        int maxDuration = 0;
        int maxDurationIndex = -1;

        for (int i = 0; i < count; i++) {
            if (durationArr[i] > maxDuration) {
                maxDuration = durationArr[i];
                maxDurationIndex = i;
            }
        }

        if (maxDurationIndex != -1) {
            return "Developer: " + developerDeetsArr[maxDurationIndex] + "\n"
                    + "Task Duration: " + maxDuration + " hours";
        } else {
            return "No tasks found.";
        }
    }

    public String searchByTaskName(String taskName) {
        StringBuilder searchResult = new StringBuilder();
        for (int i = 0; i < count; i++) { //ykaganovich, 2010
            if (taskNameArr[i].equalsIgnoreCase(taskName)) {
                searchResult.append("Task Name: ").append(taskNameArr[i]).append("\n");
                searchResult.append("Developer: ").append(developerDeetsArr[i]).append("\n");
                searchResult.append("Task Status: ").append(statusArr[i]).append("\n\n");
            }
        }
        if (searchResult.length() > 0) {
            return searchResult.toString();
        } else {
            return "No tasks found with the given Task Name.";
        }
    }

    public String getTasksByDeveloper(String developerName) {
        StringBuilder tasksByDeveloper = new StringBuilder(); //ykaganovich, 2010
        for (int i = 0; i < count; i++) {
            if (developerDeetsArr[i].equalsIgnoreCase(developerName)) {
                tasksByDeveloper.append("Task Name: ").append(taskNameArr[i]).append("\n");
                tasksByDeveloper.append("Task Status: ").append(statusArr[i]).append("\n\n");
            }
        }
        if (tasksByDeveloper.length() > 0) {
            return tasksByDeveloper.toString();
        } else {
            return "No tasks found assigned to the given Developer.";
        }
    }

    public boolean deleteTask(String taskName) {
        for (int i = 0; i < count; i++) {
            if (taskNameArr[i].equalsIgnoreCase(taskName)) {
                // Shift elements to fill the gap
                for (int j = i; j < count - 1; j++) {
                    taskNameArr[j] = taskNameArr[j + 1];
                    taskDescriptionArr[j] = taskDescriptionArr[j + 1];
                    developerDeetsArr[j] = developerDeetsArr[j + 1];
                    statusArr[j] = statusArr[j + 1];
                    taskNumberArr[j] = taskNumberArr[j + 1];
                    durationArr[j] = durationArr[j + 1];
                }
                count--;
                return true;
            }
        }
        return false;
    }

    public String getAllTasks() {
        StringBuilder allTasks = new StringBuilder();  //(GeeksForGeeks, 2020)
        for (int i = 0; i < count; i++) {
            allTasks.append("Task Name: ").append(taskNameArr[i]).append("\n");
            allTasks.append("Developer: ").append(developerDeetsArr[i]).append("\n");
            allTasks.append("Task Duration: ").append(durationArr[i]).append(" hours").append("\n");
            allTasks.append("Task Status: ").append(statusArr[i]).append("\n\n");
        }
        if (allTasks.length() > 0) {
            return allTasks.toString();
        } else {
            return "No tasks found.";
        }
    }
}

/*
davidalayachew. 2022. Using loops in JOptionPane. [online] 
Available at: https://stackoverflow.com/questions/72247986/using-loops-in-joptionpane [Accessed 9 may 2023]

Farrell, J. 2019. Java Programming. 9th Ed. Boston: Cengage.

baeldang. 2023. Adding a Newline Character to a String in Java. [online] 
Available at https://www.baeldung.com/java-string-newline.[Accessed 5 July 2023]

ykaganovich. 2010. Why use append() instead of + [duplicate][online] Available at: https://stackoverflow.com/a/4337467 [accessed 5 July 2023]

geeksforgeeks. 2020. Stringbuilder Class in Java. [online] 
Available at: https://www.geeksforgeeks.org/stringbuilder-class-in-java-with-examples/. [accessed 5 ju;y 2023]
*/
