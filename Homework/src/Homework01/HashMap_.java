package Homework01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"all"})
public class HashMap_ {
    public static void main(String[] args) {
        HashMap HashMap = new HashMap();
        HashMap.put("jack",650);
        HashMap.put("tom",1200);
        HashMap.put("smith",2900);

        HashMap.put("jack",2600);
        Set keySet=HashMap.keySet();
        for (Object set:keySet) {
            HashMap.put(set,(Integer)HashMap.get(set)+100);
            System.out.println(set);
        }
        for (Object set:keySet) {
            System.out.println();
        }
        Set entrySet = HashMap.entrySet();
        for (Object entry:entrySet) {
            Map.Entry entry1 =(Map.Entry) entry;
            entry1.setValue((Integer)entry1.getValue()+100);
            System.out.println(entry1.getKey()+""+entry1.getValue());
        }
        Iterator iterator =entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry=(Map.Entry) iterator.next();
            System.out.println(entry.getKey()+""+entry.getValue());
        }

    }
}
