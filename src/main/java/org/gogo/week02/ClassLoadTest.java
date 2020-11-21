package org.gogo.week02;

public class ClassLoadTest extends Parent {
    /**
     * 结论：
     * 类加载时，如果父类未加载，先进性加载父类
     * 静态代码块是在类加载时候加载
     * 只有new的时候才会加载普通代码块和构造器，并且普通代码块优先于构造器加载
     *
     * 综上所述：执行顺序是 父类静态代码块-》子类静态代码块-》父类普通代码块-》父类构造器-》子类普通代码块-》子类构造器
     */


    public ClassLoadTest() {
        System.out.println("子类构造器执行了");
    }
    static {
        System.out.println("子类静态代码块执行了");
    }
    {
        System.out.println("子类代码块执行了");
    }

    public static void main(String[] args) {
        ClassLoadTest test;
    }
}

class Parent {

    public Parent() {
        System.out.println("父类构造器执行了");
    }
    static {
        System.out.println("父类静态代码块执行了");
    }
    {
        System.out.println("父类代码块执行了");
    }
}