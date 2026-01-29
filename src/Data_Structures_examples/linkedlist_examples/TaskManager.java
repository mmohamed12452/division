package Data_Structures_examples.linkedlist_examples;

import java.util.LinkedList;

public class TaskManager {
    public static void main(String[] args) {
        LinkedList<String> taskList  = new LinkedList<>();
        System.out.println("************ adding task ************" );
        taskList.add("go to the gym");
        taskList.addFirst("go grocery shopping");
        taskList.addLast("prepare presentation");
        taskList.add(1, "doing the dishes");

        System.out.println("current tasks: " + taskList); // view all the tasks as linkedlist
        System.out.println("total task: " + taskList.size()); // the number of size linkedlist

        System.out.println("*************** accessing tasks: ****************");
        System.out.println("First task: " + taskList.getFirst()); // obtain the first task
        System.out.println("Last task: " + taskList.getLast());  // obtain the second task
        System.out.println("Task at index 2: " + taskList.get(2)); // get the element from specific index


        System.out.println("************** Checking if tasks exist ***********");
        System.out.println("check go to gym: " + taskList.contains("go to gym")); // checking if gym exist in the list.

        System.out.println("************** Remove tasks: ************** ");
        System.out.println("remove first task: " + taskList.removeFirst()); // removes the first task from the list
        System.out.println("Remove last task : " + taskList.removeLast()); // removes the last task from the list
        System.out.println("Remove go to gym : " + taskList.remove("go to gym")); // removes the go to gym from this list

        System.out.println("Remaining tasks after removal : " + taskList);

        // iterating task using the enhanced for loop
        for (String task : taskList){
            System.out.println("-" + task);
        }
        System.out.println("************* Clearing all tasks **************");
        taskList.clear(); // clears all the nodes
        System.out.println("Is task List empty" + taskList.isEmpty());
        System.out.println("************** final tasklist: **************");
        System.out.println("Tasks available:  " + taskList);

    }
}
