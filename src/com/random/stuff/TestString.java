package com.random.stuff;

public class TestString {

    class Employee{
        private int id =10;
        public int getId(){
            return id;
        }
    }

    class Manager extends Employee{
        int id = 20;
        public int getId(){
            return id;
        }
    }
    public static void main(String[] args) {
        String s = "blue";
        String s2 = null;
        String s3 = new String("blue");
        System.out.println("blue".equals(s)); //true
        System.out.println("blue" == s); //true
        System.out.println(s3 == s); //false
        System.out.println(s.equals(s2)); //false
        System.out.println(s3.hashCode()==s.hashCode()); //true
        //System.out.println(s2.equals(s));

        TestString ts = new TestString();

        Employee e = ts.new Employee();
        Employee m = ts.new Manager();

        System.out.println(e.getId());
        System.out.println(m.getId());

    }
}
