import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"all"})
public class TestMap {
    public static void main(String[] args) {
        HashMap hashMap=new HashMap();
        hashMap.put(1,new Employee("1", "尼彩", 12344));
        hashMap.put(2,new Employee("2", "mack", 123));
        hashMap.put(3, new Employee("3", "free", 18999));
        Set keySet = hashMap.keySet();
        for (Object key:keySet){
            Employee o = (Employee) hashMap.get(key);
            if (o.getSal()>18000){
                System.out.println(key+"----"+hashMap.get(key));
            }
        }
        System.out.println("===============");
        Iterator iterator = keySet.iterator();
        while (iterator.hasNext()) {
            Object key =  iterator.next();
            Employee o = (Employee) hashMap.get(key);
            if (o.getSal()>18000){
                System.out.println(key+"----"+hashMap.get(key));
            }

        }
        System.out.println("===============");
        Set entrySet = hashMap.entrySet();
        for (Object entry:entrySet) {
            Map.Entry entry1=(Map.Entry) entry;
            Employee employee=(Employee) entry1.getValue();
            if (employee.getSal()>18000){
                System.out.println(entry1.getKey()+"----"+entry1.getValue());
            }
        }


    }
}
class Employee{
    private String id;
    private String name;
    private double sal;

    public Employee(String id, String name, double sal) {
        this.id = id;
        this.name = name;
        this.sal = sal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sal=" + sal +
                '}';
    }
}
