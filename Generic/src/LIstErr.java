import java.util.ArrayList;
import java.util.List;

public class LIstErr {
    public static void main(String[] args) {
        // Create a list of strings
        List strlist = new ArrayList();
        // add some strings to the list
        strlist.add("Hello");
        strlist.add("World");
        //add a inrger to the list
        strlist.add(1);
        // print the list
        strlist.forEach(str->System.out.println(((String)str).length()));// ERROR  java.lang.Integer cannot be cast to java.lang.String

    }
}
