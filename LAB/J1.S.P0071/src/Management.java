import java.util.ArrayList;
public class Management {
    ArrayList<Task> list = new ArrayList<Task>();
    void init(){
        list.add(new Task(1, "Code", "Initial", "06-08-2021", 8.5, 10, "Dev", "Lead"));
        list.add(new Task(2, "Test", "Design", "07-08-2021", 13, 16, "Designer", "Manager"));        
        list.add(new Task(3, "Design", "Implement", "10-08-2021", 12, 14, "Developer", "Director"));
    }
    
    public void displayMenu() {
        System.out.println("\n========= Task program =========");
        System.out.println("\t1. Add Task");
        System.out.println("\t2. Delete Task");
        System.out.println("\t3. Display Task");
        System.out.println("\t4. Exit");
        System.out.print("Enter your choice: ");
    }

    public int addTask(String requirementName, String assignee, String reviewer, String taskType, String date, double planFrom, double planTo){
        int id = list.isEmpty() ? 1 :list.get(list.size()-1).getId()+1;
        list.add(new Task(id, taskType, requirementName, date, planFrom, planTo, assignee, reviewer));
        return id;
    }
    
    public void deleteTask(String id){
        list.remove(Integer.parseInt(id));
        System.out.println("Delete Task Successdully!");
    }

    public void  displayDataTasks() {
        if (list.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        
        System.out.println("----------------------------------------- Task ---------------------------------------");
        System.out.printf("%-5s%-15s%-15s%-15s%-15s%-15s%-15s\n","ID", "Name", "Task Type", "Date", "Time", "Assign", "Reviewer");
        for (Task task: list) {

            System.out.printf("%-5d%-15s%-15s%-15s%-15.1f%-15s%-15s\n",
                    task.getId(),
                    task.getRequirementName(),
                    task.getTaskTypeId(),
                    task.getDate(),
                    task.getPlanTo() - task.getPlanFrom(),
                    task.getAssignee(),
                    task.getReviewer()
            );

        }
    }

}
