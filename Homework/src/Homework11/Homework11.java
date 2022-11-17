package Homework11;

public class Homework11 {
    public static void main(String[] args) {
        //向上转型
        Person person=new Student();
        person.eat();
        person.run();
       // person.study();
        //向下转型
        Student student=(Student) person;
        student.eat();
        student.run();
        student.study();

    }
}
