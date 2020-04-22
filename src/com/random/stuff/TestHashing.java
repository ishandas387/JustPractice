package com.random.stuff;

import java.util.*;
class TestHashing{
    public static void main(String[] args) {
        String s = new String("tests");
        String s1 = "tests";
        String s2 = new String("tests");
        System.out.println(s.hashCode() +"--"+s1.hashCode());

        System.out.println(s == s2);
        System.out.println(s == s1);

        System.out.println(s.equals(s2));
        System.out.println(s.equals(s1));
        Car c1 = new Car(1, "bmw", "m1");
        Car c2 = new Car(2,"merc","z1");
    
        List<Car> list = new ArrayList<>();
        list.add(c2);
        list.add(c1);
        list.forEach(c -> System.out.println(c.getBrand()));

        Collections.sort(list);

        
        list.forEach(c -> System.out.println(c.getBrand()));

    }



}

class Car implements Comparable<Car>{
    private int id;
    private String name;
    private String brand;

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((brand == null) ? 0 : brand.hashCode());
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Car other = (Car) obj;
        if (brand == null) {
            if (other.brand != null)
                return false;
        } else if (!brand.equals(other.brand))
            return false;
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public int compareTo(Car c) {
        return this.getBrand().compareTo(c.getBrand()); 
    }

    public Car(int id, String name, String brand) {
        this.id = id;
        this.name = name;
        this.brand = brand;
    }

    class carNameComparator implements Comparator<Car>{

        @Override
        public int compare(Car c1, Car c2) {
            return c1.getName().compareTo(c2.getName());
        }
        
    }
    
}