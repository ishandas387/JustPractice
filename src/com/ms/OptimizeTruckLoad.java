package com.ms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class OptimizeTruckLoad {
    /**
     * List<List<Integer>> will be the locations cordinates of packages Distance of
     * package x^2+y^2 Int allocation size M is the max number of package a truck
     * can carry
     * 
     * @param args
     */
    public static void main(String[] args) {

        List<List<Integer>> locationList = new ArrayList<>();
        locationList.add(Arrays.asList(1, 2));
        locationList.add(Arrays.asList(4, -2));
        locationList.add(Arrays.asList(1, -1));
        locationList.add(Arrays.asList(15, -1));
        locationList.add(Arrays.asList(1, 2));
        locationList.add(Arrays.asList(4, -2));
        locationList.add(Arrays.asList(1, -1));
        locationList.add(Arrays.asList(15, -1));
        locationList.add(Arrays.asList(15, -1));
        locationList.add(Arrays.asList(4, -7));
        locationList.add(Arrays.asList(4, -7));
        locationList.add(Arrays.asList(1, 2));
        locationList.add(Arrays.asList(4, -2));
        locationList.add(Arrays.asList(1, -1));
        locationList.add(Arrays.asList(15, -1));
        locationList.add(Arrays.asList(15, -1));
        locationList.add(Arrays.asList(4, -7));
        locationList.add(Arrays.asList(4, -7));
        locationList.add(Arrays.asList(4, -7));
        locationList.add(Arrays.asList(4, -7));
        locationList.add(Arrays.asList(4, -7)); locationList.add(Arrays.asList(4, -7)); locationList.add(Arrays.asList(4, -7)); locationList.add(Arrays.asList(4, -7));
        locationList.add(Arrays.asList(1, 9));
        locationList.add(Arrays.asList(1, -1));
        int capacity = 3;
        Long time = System.currentTimeMillis();
        List<List<Integer>> itemsToPick = getTheItemsThatAreCloser(locationList, capacity);
        System.out.println(itemsToPick);
        System.out.println(System.currentTimeMillis()-time);

    }

    private static List<List<Integer>> getTheItemsThatAreCloser(List<List<Integer>> locationList, int capacity) {

        Map<Integer, Double> mapOfIndexAndDistance = new LinkedHashMap<>();
        for (int j = 0; j < locationList.size(); j++) {

            mapOfIndexAndDistance.put(j, locationList.get(j).stream().mapToDouble(i -> i * i).sum());
        }
        // arrange map bassed on sorted values
        System.out.println(mapOfIndexAndDistance);
        mapOfIndexAndDistance = mapOfIndexAndDistance.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

        System.out.println(mapOfIndexAndDistance);
        Iterator<Entry<Integer, Double>> e = mapOfIndexAndDistance.entrySet().iterator();
        int k =0;
        List<List<Integer>> locationList2 = new ArrayList<>();
        while( k < capacity){
            if(e.hasNext()){
                locationList2.add(locationList.get(e.next().getKey()));
            }
            k +=1;
        }

        return locationList2;
    }
}