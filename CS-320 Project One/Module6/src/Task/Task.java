// Dalton Gollihue
// SNHU
// 10/12/2025
// CS-320


package Task;

import java.util.concurrent.atomic.AtomicLong;

public class Task {
	private final String taskID;
	private String taskName;
	private String taskDesc;
	private static AtomicLong idGenerator = new AtomicLong();
	
// Task consists of a name a description and an ID	
	
	public Task(String taskName, String taskDesc) {
		
// Makes sure that the fields have some value, if not, a place holder
		
		this.taskID = String.valueOf(idGenerator.getAndIncrement());
		
		if (taskName == null || taskName.isEmpty()) {
			this.taskName = "NULL";
		} else if (taskName.length() > 20) {
			this.taskName = taskName.substring(0, 20);
		} else {
			this.taskName = taskName;
		}
		
		if (taskDesc == null || taskDesc.isEmpty()) {
			this.taskDesc = "NULL";
		} else if (taskDesc.length() > 50) {
			this.taskDesc = taskDesc.substring(0, 50);
		} else {
			this.taskDesc = taskDesc;
		}
	}
	
// Retrieves the ID and other details	
	
	public String getTaskID() {
		return taskID;
	}
	
	public String getTaskName() {
		return taskName;
	}
	
	public String getTaskDesc() {
		return taskDesc;
	}
	
// Gives task a name
	
	public void setTaskName(String taskName) {
		if (taskName == null || taskName.isEmpty()) {
			this.taskName = "NULL";
		} else if (taskName.length() > 20) {
			this.taskName = taskName.substring(0, 20);
		} else {
			this.taskName = taskName;
		}
	}
	
// Gives task a description	
	
	public void setTaskDesc(String taskDesc) {
		if (taskDesc == null || taskDesc.isEmpty()) {
			this.taskDesc = "NULL";
		} else if (taskDesc.length() > 50) {
			this.taskDesc = taskDesc.substring(0, 50);
		} else {
			this.taskDesc = taskDesc;
		}
	}
}