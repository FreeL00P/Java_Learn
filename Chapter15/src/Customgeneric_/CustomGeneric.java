package Customgeneric_;

public class CustomGeneric {
    public static void main(String[] args) {

    }
}
//tiger 后面泛型 所以我们把tiger称为自定义泛型
//泛型标识符可以有多个
//普通成员可以使用泛型(属性,方法)
//
class Tiger<T,R,M>{
    T t;//属性使用泛型
    R r;
    M m;
    String name;
    //泛型数组不能被初始化
    //数组在new的时候 不能确定 T的类型 就无法开辟内存空间
    // T[] ts=new T[8];

    public Tiger(T t, R r, M m, String name) { //方法使用泛型
        this.t = t;
        this.r = r;
        this.m = m;
        this.name = name;
    }
    //静态方法在;类加载时 对象还没有创建 泛型需要类创建后才执行
    //所以如果静态方法和静态属性使用了泛型 就无法完成初始化
    // public static void m1(T t){}//
}

