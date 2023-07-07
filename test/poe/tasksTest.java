/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package poe;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lab_services_student
 */
public class tasksTest {

    String[] developerDeets = {"Mike Smith", "Edward Harrison", "Samantha Paulson", "Glenda Oberholzer"};
    String[] taskNames = {"Create Login", "Create Add Features", "Create Reports", "Add Arrays"};
    String[] taskId = {"CR:0:IKE", "CR:1:ARD", "CR:2:THA", "AD:3:NDA"};

    String[] taskNameArr;
    String[] taskDescriptionArr;
    String[] developerDeetsArr;
    String[] statusArr;
    int[] taskNumberArr;
    int[] durationArr;
    int count = 0;

    public tasksTest() {
    }

    @Test
    public void testAddTask() {
        System.out.println("addTask");
        String TaskName = "Task 1";
        String TaskDescription = "Description 1";
        String DeveloperDetails = "Developer 1";
        String TaskStatus = "To do";
        int TaskNumber = 1;
        int TaskDuration = 10;
        tasks instance = new tasks();

        instance.size(1); // Set the size of the arrays

        instance.addTask(TaskName, TaskDescription, DeveloperDetails, TaskStatus, TaskNumber, TaskDuration);

        // Assert the values in the arrays
        assertEquals(TaskName, instance.taskNameArr[0]);
        assertEquals(TaskDescription, instance.taskDescriptionArr[0]);
        assertEquals(DeveloperDetails, instance.developerDeetsArr[0]);
        assertEquals(TaskStatus, instance.statusArr[0]);
        assertEquals(TaskNumber, instance.taskNumberArr[0]);
        assertEquals(TaskDuration, instance.durationArr[0]);

        assertEquals(1, instance.count); // Assert the count value
    }

    @Test
    public void testSize() {
        System.out.println("size");
        int i = 0;
        tasks instance = new tasks();
        instance.size(i);
    }

    @Test
    public void testCheckTaskDescription() {
        System.out.println("checkTaskDescription");
        String taskDescription = "lllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllll";
        tasks instance = new tasks();
        boolean expResult = false;
        boolean result = instance.checkTaskDescription(taskDescription);
        assertEquals(expResult, result);
    }

    @Test
    public void testCheckTaskDescriptionTrue() {
        System.out.println("checkTaskDescription");
        String taskDescription = "lllllllllllllll";
        tasks instance = new tasks();
        boolean expResult = true;
        boolean result = instance.checkTaskDescription(taskDescription);
        assertEquals(expResult, result);
    }

    @Test
    public void testCreateTaskID() {
        System.out.println("createTaskID");

        for (int i = 0; i < 3; i++) {
//            String developerDetails = developerDeets[i];
//            System.out.print("developer details: " + developerDetails + " ");

            String taskName = taskNames[i];
            tasks instance = new tasks(taskNames[i], "", developerDeets[i], "", i, 0);
            String expResult = taskId[i];

            assertEquals(expResult, instance.getTaskID());
        }
    }

    @Test
    public void testPrintTaskDetails() {
        System.out.println("printTaskDetails");

        tasks instance = new tasks();
    }

    @Test
    public void testReturnTotalHours() {
        System.out.println("returnTotalHours");
        tasks instance = new tasks();
        int expResult = 0;
        int result = instance.returnTotalHours();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetTaskID() {
        System.out.println("getTaskID");
        tasks instance = new tasks();
        String expResult = "";
        String result = instance.getTaskID();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetTasksByStatus() {
        System.out.println("getTasksByStatus");
        String status = "";
        tasks instance = new tasks();
        String expResult = "";
        String result = instance.getTasksByStatus(status);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetLongestDurationTask() {
        System.out.println("getLongestDurationTask");
        tasks instance = new tasks();
        String expResult = "";
        String result = instance.getLongestDurationTask();
        assertEquals(expResult, result);
    }

    @Test
    public void testSearchByTaskName() {
        System.out.println("searchByTaskName");
        String taskName = "";
        tasks instance = new tasks();
        String expResult = "";
        String result = instance.searchByTaskName(taskName);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetTasksByDeveloper() {
        System.out.println("getTasksByDeveloper");
        String developerName = "";
        tasks instance = new tasks();
        String expResult = "";
        String result = instance.getTasksByDeveloper(developerName);
        assertEquals(expResult, result);
    }

    @Test
    public void testDeleteTask() {
        System.out.println("deleteTask");
        String taskName = "";
        tasks instance = new tasks();
        boolean expResult = false;
        boolean result = instance.deleteTask(taskName);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetAllTasks() {
        System.out.println("getAllTasks");
        tasks instance = new tasks();

        instance.size(2); // Set the size of the arrays

        // Add tasks to the arrays
        instance.addTask("Task 1", "Description 1", "Developer 1", "To do", 1, 10);
        instance.addTask("Task 2", "Description 2", "Developer 2", "Doing", 2, 5);

        String expResult = "Task Name: Task 1\nDeveloper: Developer 1\nTask Duration: 10 hours\nTask Status: To do\n\n"
                + "Task Name: Task 2\nDeveloper: Developer 2\nTask Duration: 5 hours\nTask Status: Doing\n\n";
        String result = instance.getAllTasks();
        assertEquals(expResult, result);
    }

}
