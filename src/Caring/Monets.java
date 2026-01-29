package Caring;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Monets {
    public static void main(String[] args) {
        ArrayList<Integer> lists = new ArrayList<>();
        lists.add(50);
        lists.add(40);
        lists.add(39);
        lists.sort(null);
        // 50, 40 ,39
        // 39, 40, 50 null asending order
        Collections.sort(lists,Collections.reverseOrder());// descending order
        System.out.println(lists);

    }
}
