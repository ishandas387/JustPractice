package com.random.stuff;

public class A {
    public static final String type ="A";
    public void lol(){
        System.out.println("lolA");
    }

}

class B extends A{
    public static final String type = "B";
    public void lol(){
        System.out.println("lolB");
    }

    public static void main(String[] args) {
        B b =  new B();
        b.lol();
        System.out.println(B.type);

        A a = new A();
        System.out.println(a.equals(b));
        //System.out.println(instanceOf);
    }
}