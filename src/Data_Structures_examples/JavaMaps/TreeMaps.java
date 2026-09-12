package Data_Structures_examples.JavaMaps;

import java.util.TreeMap;

public class TreeMaps {
    public static void main(String[] args) {
        TreeMap<String, String> names = new TreeMap<>();
        names.put("john", "henry");
        names.put("lil macks", "Tiller");
        names.put("Bobby", "Trey Songz");
        System.out.println(names.get("lil macks"));
        names.remove("john");
        System.out.println(names.size());
        for(String i : names.keySet()){
            System.out.println(i);
        }
        System.out.println(names);
    }
}
