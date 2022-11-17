import java.util.ArrayList;
import java.util.List;

public class GenericList {
    public static void main(String[] args) {
        // 创建一个只想保存字符串的list集合
        List<String> strList = new ArrayList();
        //添加元素
        strList.add("Hello");
        strList.add("World");
        //添加一个Integer类型的元素
       // strList.add(5); // 报错，不能添加Integer类型的元素
        //输出List
        strList.forEach(str-> System.out.println((str.length())));
    }
}
