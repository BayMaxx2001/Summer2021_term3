
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Management manager = new Management();
        manager.init();
        while(true){
            manager.displayMenu();
            int choice = Valadition.checkInputLimit(1, 4);
            switch(choice){
                case 1:
//                  inputAdd;
                    System.out.println("------------Add Task---------------");
                    String requirementName = Valadition.checkInputString("Requirement Name: ");
                    String taskType = Valadition.checkInputTaskType("Task Type: ");
                    String date = Valadition.checkInputDate("Date: ");
                    System.out.print("From: ");
                    double planFrom = Valadition.checkInputPlan(8.0, 17.0, "Plan From must be 8.0, 8.5, ..., 17.5");
                    System.out.print("To: ");
                    double planTo = Valadition.checkInputPlan(planFrom + 0.5, 17.5, "Plan To must be more than plan from " + planFrom + " and must be less than or equal 17.5");
                    String assignee = Valadition.checkInputString("Assignee: ");
                    String reviewer = Valadition.checkInputString("Reviewer: ");
        
                    manager.addTask(requirementName, assignee, reviewer, taskType, date, planFrom, planTo);
                    System.out.println("Add Task Successfully!");
                    break;  
                case 2:
//                  inputDelete
                    if (manager.list.isEmpty()) {
                        System.err.println("List empty!!!");
                        return;
                    }
                    System.out.println("---------Delete Task------");
                    System.out.print("Enter id: ");
                    int findId = Valadition.checkInputLimit(1, manager.list.size()) - 1;
                    manager.deleteTask(""+findId);
                    break;
                case 3:
                    manager.displayDataTasks();
                    break;
                case 4:
                    return;
            }
        }
        
    }
    
}
