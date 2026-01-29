package Data_Structures_examples.queueexample;

import java.util.LinkedList;
import java.util.Queue;

public class CallCenter {
    private Queue<CustomerCall> waitingcalls;
    private int callsHandled;
    private int nextcallId;

    public CallCenter() {
        this.waitingcalls = new LinkedList<>();;
        this.callsHandled = 0;
        this.nextcallId = 1;
    }


    public void receiveCalls(String customerName, String issue){
        CustomerCall call = new CustomerCall(nextcallId++, customerName, issue);
        waitingcalls.add(call);
        System.out.println("new call receieved: " + call);
        displayCallqueue();
    }

    public void handlingnextCall(String agentName){
        if(waitingcalls.isEmpty()){
            System.out.println("No Calls waiting"+ agentName + "is avaliable");
            return;
        }
        CustomerCall call = waitingcalls.remove();
        callsHandled++;
        System.out.println("Agent " + agentName + "handling call");
        System.out.println("now handling " + call);
        SimulateCallhandling(call.getDuration());
        System.out.println("Call completed");
        displayCallqueue();
    }
    private void SimulateCallhandling(int duration){
        try{
            System.out.println("printing");
            for(int i = 0; i< duration; i++){
                Thread.sleep(200);
                System.out.print("*");
            }
            System.out.println();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public void displayCallqueue(){
        System.out.println("CALL CENTER QUEUE: " );
        System.out.println("CALLS WAITING: " + waitingcalls.size());
        System.out.println("TOTAL CALLS HANDLED: " + callsHandled);
        if(!waitingcalls.isEmpty()){
            System.out.println("CALLS IN WAITING QUEUE: ");
            int position = 1;
            for(CustomerCall call : waitingcalls){
                System.out.println(position++ + "." + call);
            }
        }else {
            System.out.println("NO CALLS WAITING ALL AGENTS ARE AVAILABLE");
        }
        System.out.println();
    }
    public void emergencyCall(String customerName, String issue){
        CustomerCall call = new CustomerCall(nextcallId++, customerName, issue);
        if(waitingcalls instanceof LinkedList){
            ((LinkedList<CustomerCall>) waitingcalls).addFirst(call);
            System.out.println("EMERGENCY RECIEVED: " + call);
            System.out.println("EMERGENCY CALL PLACED AT FRONT OF THE QUEUE: ");
            displayCallqueue();
        }
    }





}
