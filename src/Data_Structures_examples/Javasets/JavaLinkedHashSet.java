package Data_Structures_examples.Javasets;

import java.util.LinkedHashSet;

public class JavaLinkedHashSet {
    public static void main(String[] args) {
        LinkedHashSet<String> swim = new LinkedHashSet<>();
        swim.add("Todd");
        swim.add("franklin");
        swim.add("Leon");
        swim.add("Wanda");
        swim.add("Lando");
        System.out.println(swim);
        System.out.println(swim.contains("Todd"));
        System.out.println(swim.remove("leon"));
        swim.clear();
    }
}
