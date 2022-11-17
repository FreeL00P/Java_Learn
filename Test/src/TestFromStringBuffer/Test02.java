package TestFromStringBuffer;

import java.util.Locale;
import java.util.Scanner;

public class Test02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name=scanner.next();
    }
    public static void  str(String name){
        String[] names=name.split(" ");
        if(names.length==2){
            System.out.println(names[1]+names[0].toUpperCase().charAt(0));
        }else {
            System.out.println(names[1]+names[0].toUpperCase().charAt(0));
        }
    }
}
