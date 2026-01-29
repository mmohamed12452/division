package Data_Structures_examples.queueexample;

import java.util.Random;

public class CustomerCall {
    private int callId;
    private String customerName;
    private String issue;
    private int duration;

    public CustomerCall(int callId, String customerName, String issue) {
        this.callId = callId;
        this.customerName = customerName;
        this.issue = issue;
        this.duration = new Random().nextInt(10)+1;
    }

    public int getCallId() {
        return callId;
    }

    public String getIssue() {
        return issue;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getDuration() {
        return duration;
    }
    @Override
    public String toString() {
        return String.format("Call #%d: %s - %s (%d min)",callId,customerName,issue,duration);
    }

}
