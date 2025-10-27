// Dalton Gollihue
// SNHU
// 10/12/2025
// CS-320


package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Task.Task;

class TaskTest {

// Makes sure that the length doesn't get longer than 10 characters 	
	
	@Test
	@DisplayName("Task ID cannot have more than 10 characters")
	void testTaskIDWithMoreThanTenCharacters() {
		Task task = new Task("Name", "Description");
		if (task.getTaskID().length() > 10) {
			fail("Task ID has more than 10 characters.");
		}
	}

// Makes sure that the task name doesn't surpass 20 characters	
	
	@Test
	@DisplayName("Task Name cannot have more than 20 characters")
	void testTaskNameWithMoreThanTwentyCharacters() {
		Task task = new Task("SampleSampleSample", "Description");
		if (task.getTaskName().length() > 20) {
			fail("Task Name has more than 20 characters.");
		}
	}

// Tests to see if the description doesn't pass 50 characters	
	
	@Test
	@DisplayName("Task Description cannot have more than 50 characters")
	void testTaskDescWithMoreThanFiftyCharacters() {
		Task task = new Task("Name", "Sample Sample Sample Sample" 
				+ "Sample Sample Sample Sample" 
				+ "Sample Sample Sample Sample"
				+ "Sample Sample Sample Sample");
		if (task.getTaskDesc().length() > 50) {
			fail("Task Description has more than 50 characters.");
		}
	}

// Tests to see that the task field has information	
	
	@Test
	@DisplayName("Task Name shall not be null")
	void testTaskNameNotNull() {
		Task task = new Task(null, "Description");
		assertNotNull(task.getTaskName(), "Task Name was null.");
	}
	
// Tests to see that the task field has information	
	
	@Test
	@DisplayName("Task Description shall not be null")
	void testTaskDescNotNull() {
		Task task = new Task("Name", null);
		assertNotNull(task.getTaskDesc(), "Task Description was null.");
	}
}