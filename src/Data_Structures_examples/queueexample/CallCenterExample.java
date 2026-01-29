package Data_Structures_examples.queueexample;

public class CallCenterExample {
    public static void main(String[] args) {
        CallCenter center = new CallCenter();
        center.receiveCalls("Mohamed", "debugging issue");
        center.receiveCalls("John", "technical support");
        center.receiveCalls("mike", "mobile difficulty");
        center.receiveCalls("Kenny", "laptop difficulty");
        center.handlingnextCall("Agent tracy");
        center.handlingnextCall("Agent David");
        center.receiveCalls("SamSpedy","laptop tecnicality");
        center.handlingnextCall("Agent Mama OJO");
        center.emergencyCall("emergency", "service outage");
        center.handlingnextCall("Papa Femi OJO");
        center.handlingnextCall("Agent don");
        center.handlingnextCall("Agent car");
    }
}
