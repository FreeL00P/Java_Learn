import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/27 21:03    since 1.0.0
 */
public class Homework {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class<?> cls = Class.forName("PrivateTest");
        Field field = cls.getDeclaredField("name");
        Object o = cls.newInstance();
        field.setAccessible(true);
        field.set(o,"cxk");
        Method getName = cls.getMethod("getName");
        Object invoke = getName.invoke(o);
        System.out.println(invoke);


    }
}
class PrivateTest{
    private String name="helloKitty";

    public String getName() {
        return name;
    }
}