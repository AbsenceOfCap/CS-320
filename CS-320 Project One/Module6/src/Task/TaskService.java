// Dalton Gollihue
// SNHU
// 10/12/2025
// CS-320


package Task;

import java.util.ArrayList;

public class TaskService {

// List that stores tasks, with all the information, so that we can call back on it for other applications	
	
	public ArrayList<Task> taskList = new ArrayList<Task>();

// Code to show us the list, along with relevant information	
	
	public void displayTaskList() {
		for (int counter = 0; counter < taskList.size(); counter++) {
			System.out.println("\t Task ID: " + taskList.get(counter).getTaskID());
			System.out.println("\t Task Name: " + taskList.get(counter).getTaskName());
			System.out.println("\t Task Description: " + taskList.get(counter).getTaskDesc());
		}
	}

// Add task logic
	
	public void addTask(String taskName, String taskDesc) {
		Task task = new Task(taskName, taskDesc);
		taskList.add(task);
	}

// Checks to search for duplicate information
	
	public Task getTask(String taskID) {
		Task task = new Task(null, null);
		for (int counter = 0; counter < taskList.size(); counter++) {
			if (taskList.get(counter).getTaskID().contentEquals(taskID)) {
				task = taskList.get(counter);
			}
		}
		return task;
	}

// Delete functions

	public void deleteTask(String taskID) {
		for (int counter = 0; counter < taskList.size(); counter++) {
			if (taskList.get(counter).getTaskID().equals(taskID)) {
				taskList.remove(counter);
				break;
			}
			if (counter == taskList.size() - 1) {
				System.out.println("Task ID: " + taskID + " not found.");
			}
		}
	}

// Change task name through taskID
	
	public void updateTaskName(String updatedString, String taskID) {
		for (int counter = 0; counter < taskList.size(); counter++) {
			if (taskList.get(counter).getTaskID().equals(taskID)) {
				taskList.get(counter).setTaskName(updatedString);
				break;
			}
			if (counter == taskList.size() - 1) {
				System.out.println("Task ID: " + taskID + " not found.");
			}
		}
	}

// Change task description
	
	public void updateTaskDesc(String updatedString, String taskID) {
		for (int counter = 0; counter < taskList.size(); counter++) {
			if (taskList.get(counter).getTaskID().equals(taskID)) {
				taskList.get(counter).setTaskDesc(updatedString);
				break;
			}
			if (counter == taskList.size() - 1) {
				System.out.println("Task ID: " + taskID + " not found.");
			}
		}
	}
}