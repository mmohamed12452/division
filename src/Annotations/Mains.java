package Annotations;

public class Mains {
    @Deprecated
    static void oldMethod(){
        System.out.println("The method is outdated!!!!!");
    }

    public static void main(String[] args) {
        oldMethod();
    }
}
