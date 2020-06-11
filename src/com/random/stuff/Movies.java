package com.random.stuff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Movies implements Comparable<Movies>{
    
    private String name;
    private int rating;
    private int views;
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public int compareTo(Movies o) {
        return  o.rating -this.rating ;
    }

    public Movies(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Movies [name=" + name + ", rating=" + rating + ", views=" + views + "]";
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public Movies(String name, int rating, int views) {
        this.name = name;
        this.rating = rating;
        this.views = views;
    }

    
}
class ViewCompare implements Comparator<Movies>{

    @Override
    public int compare(Movies o1, Movies o2) {
        return o2.getViews() - o1.getViews();
    }
    
}
class Test{
    public static void main(String[] args) {
        Movies m1 = new Movies("one", 1, 22);
        Movies m2 = new Movies("two", 2, 11);
        List<Movies> movieList = new ArrayList<>();
        movieList.add(m1);
        movieList.add(m2);
        Collections.sort(movieList);
        movieList.stream().forEach(System.out::println);
        Collections.sort(movieList, new ViewCompare());
        movieList.stream().forEach(System.out::println);

    }
}