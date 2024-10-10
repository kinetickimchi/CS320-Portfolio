// Refactored on 10 October 2024

/*
    Author: Kyunghoon Lee
    CS-320: Module 4 Milestone
    Date: 28 September 2024
 */

// Unit tests for TaskService.java


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TaskServiceTest {
    private TaskService taskService;  // Creates TaskService instance for testing

    @BeforeEach
    // Run TaskService before executing each test
    public void setUp() {
        taskService = new TaskService();
    }

    @Test
    @DisplayName("Testing addTask")
    // Testing addTask function
    public void testAddTask() {
        Task task = new Task("12345678", "Submit Assignments", "Submit assignments by Sunday");  // Create a new task with the given parameters

        assertTrue(taskService.addTask(task));  // Does adding the task return true?
        assertEquals(1, taskService.list.size());  // Is the number of tasks in the list correct after addition?
        assertFalse(taskService.addTask(task));  // Does adding the same task (duplicate id) return false?
    }

    @Test
    @DisplayName("Testing addTask with multiple tasks")
    // Testing addTask function with multiple tasks
    public void testAddMultipleTasks() {
        // Create 3 tasks with these parameters
        Task task1 = new Task("1", "Groceries", "Go grocery shopping");
        Task task2 = new Task("2", "Cleaning", "Clean the kitchen");
        Task task3 = new Task("3", "Cooking", "Cook dinner");

        // Add task1, task2, task3 to list
        assertTrue(taskService.addTask(task1));
        assertTrue(taskService.addTask(task2));
        assertTrue(taskService.addTask(task3));

        assertEquals(3, taskService.list.size());  // Are there now 3 tasks in the list?

        // Do the task names at these positions in the array match these expected values?
        assertEquals("Groceries", taskService.list.get(0).getName());
        assertEquals("Cleaning", taskService.list.get(1).getName());
        assertEquals("Cooking", taskService.list.get(2).getName());
    }

    @Test
    @DisplayName("Testing deleteTask")
    // Testing deleteTask function
    public void testDeleteTask() {
        Task task = new Task("12345678", "Submit Assignments", "Submit assignments by Sunday");  // Create a new task with the given parameters

        taskService.addTask(task);  // Add the task
        assertTrue(taskService.deleteTask("12345678"));  // Does this remove the added task with this id?
        assertFalse(taskService.deleteTask("12345678"));  // Does removing a task that has been deleted already return false?
    }

    @Test
    @DisplayName("Testing deleteTask with nonexistent ID")
    // Test deleteTask with nonexistent ID
    public void testDeleteNonExistentTask() {
        assertFalse(taskService.deleteTask("fakeID"));  // When the ID "fakeID" is passed, does this return false?
    }

    @Test
    @DisplayName("Test updateName")
    // Test updating name field with passed id
    public void testUpdateName() {
        Task task = new Task("12345678", "Submit Assignments", "Submit assignments by Sunday");  // Create a new task with the given parameters

        taskService.addTask(task);  // Add the task

        assertTrue(taskService.updateName("12345678", "Do Homework"));  // Update the name field of the task with this id
        assertEquals("Do Homework", taskService.list.get(0).getName());  // Does the task name match the new value?
    }

    @Test
    @DisplayName("Test updateDescription")
    // Test updating description field with passed id
    public void testUpdateDescription() {
        Task task = new Task("12345678", "Submit Assignments", "Submit assignments by Sunday");  // Create a new task with the given parameters

        taskService.addTask(task);  // Add the task

        assertTrue(taskService.updateDescription("12345678", "Finish homework by Sunday"));  // Update the description field of the task with this id
        assertEquals("Finish homework by Sunday", taskService.list.get(0).getDescription());
    }




}