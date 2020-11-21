package org.gogo.week02;

public class IntegerAndInt {

    public static void main(String[] args) {
        Integer integer = new Integer(99);
        int i = 99;
        // integer 自动拆箱，比的是值
        System.out.println(integer == i);
        Integer integer1 = new Integer(99);
        // integer integer1，比引用
        System.out.println(integer == integer1);
        Integer integer2 = 99;
        // integer integer2，比引用 integer2指向常量池
        System.out.println(integer == integer2);

        Integer integer3 = new Integer(199);
        int i1 = 199;
        // integer3自动拆箱，比值
        System.out.println(integer3 == i1);
        int i2 = 199;
        // i1 i2直接比值
        System.out.println(i1 == i2);
        Integer integer4 = 99;
        Integer integer5 = 199;
        Integer integer6 = 199;
        // integer4 integer2，也是比引用，integer2 integer4均指向常量池，两个引用一样的，常量池范围 -127 ～ 128
        System.out.println(integer4 == integer2);
        // integer5超过常量池范围 并且两个值也是不同的false
        System.out.println(integer4 == integer5);
        // integer5 integer6 超过常量池大小了，各自开辟新的内存空间，比引用
        System.out.println(integer5 == integer6);
    }
}
