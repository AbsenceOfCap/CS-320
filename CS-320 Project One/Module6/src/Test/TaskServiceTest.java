// Dalton Gollihue
// SNHU
// 10/12/2025
// CS-320


package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import Task.Task;
import Task.TaskService;

class TaskServiceTest {

// Tests changing the name by checking it
	
	@Test
	@DisplayName("Test to Update task name")
	@Order(1)
	void testUpdateTaskName() {
		TaskService service = new TaskService();
		service.addTask("Task Name", "Description");

// Dynamically grabs ID
		
		String id = service.taskList.get(0).getTaskID();

		service.updateTaskName("Updated Task Name", id);
		service.displayTaskList();

		assertEquals("Updated Task Name", service.getTask(id).getTaskName(), "Task name was not updated.");
	}

// Tests description by seeing if it gets updated
	
	@Test
	@DisplayName("Test to Update task description.")
	@Order(2)
	void testUpdateTaskDesc() {
		TaskService service = new TaskService();
		service.addTask("Task Name", "Description");

		String id = service.taskList.get(0).getTaskID();

		service.updateTaskDesc("New Description", id);
		service.displayTaskList();

		assertEquals("New Description", service.getTask(id).getTaskDesc(), "Task description was not updated.");
	}

// Tests to see if the number of tasks get decreased
	
	@Test
	@DisplayName("Test to ensure that service correctly deletes tasks.")
	@Order(5)
	void testDeleteContact() {
		TaskService service = new TaskService();
		service.addTask("Task Name", "Description");

		String id = service.taskList.get(0).getTaskID();

		service.deleteTask(id);
		ArrayList<Task> taskListEmpty = new ArrayList<Task>();
		service.displayTaskList();

		assertEquals(taskListEmpty, service.taskList, "The contact was not deleted.");
	}

// Sees if the task can be added, by checking the value
	
	@Test
	@DisplayName("Test to ensure that service can add a task.")
	@Order(6)
	void testAddContact() {
		TaskService service = new TaskService();
		service.addTask("Task Name", "Description");

		String id = service.taskList.get(0).getTaskID();

		service.displayTaskList();
		assertNotNull(service.getTask(id), "Task was not added correctly.");
	}
}