// Refactored on 10 October 2024

/*
    Author: Kyunghoon Lee
    CS-320: Module 4 Milestone
    Date: 28 September 2024
 */

// TaskService.java class

import java.util.ArrayList;

public class TaskService {

    ArrayList<Task> list = new ArrayList<Task>();

    // addTask function (IDs must be unique)
    public boolean addTask(Task task) {  // Create Task and pass task object
        for (Task t : list) {  // for each task t in the list
            if (task.getId().equalsIgnoreCase(t.getId())) {  // if a matching task ID is found
                return false;  // it is a duplicate ID, do not add
            }
        }
        // if an ID match does not exist, add to the list
        list.add(task);
        return true;
    }

    // deleteTask function
    public boolean deleteTask(String id) {
        return list.removeIf(task -> task.getId().equalsIgnoreCase(id));  // remove task associated with ID if match is found
    }

    // Separate functions to update name and description fields, to only take in the necessary information
    public boolean updateName(String id, String name) {
        for (Task task : list) {  // for each task in the list
            if (task.getId().equalsIgnoreCase(id)) {  // if the passed id matches an id in the list
                if (name != null && name.length() < 20) {  // if the task name is valid
                    task.setName(name);  // update the task name to passed name
                }
            }
        }
        return true;  // if id match is not found
    }

    public boolean updateDescription(String id, String description) {
        for (Task task : list) {  // for each task in the list
            if (task.getId().equalsIgnoreCase(id)) {  // if the passed id matches an id in the list
                if (description != null && description.length() < 50) {  // if the task description is valid
                    task.setDescription(description);  // update the task description to passed description
                }
            }
        }
        return true;  // if id match is not found
    }

}
