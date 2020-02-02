package com.lrucache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTest {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        Map<Integer, Integer> mapVehicleNoAndOwner = new LinkedHashMap<>(2,0.75f,true);
		
		mapVehicleNoAndOwner.put(1, 1000);
		mapVehicleNoAndOwner.put(2, 2000);
		mapVehicleNoAndOwner.put(3, 3000);
		mapVehicleNoAndOwner.put(4, 4000);
        mapVehicleNoAndOwner.put(5, 5000);
        
        mapVehicleNoAndOwner.forEach((key, value) -> {
			System.out.println("Key:"+ key + ", Value:" + value);
        });		
        
        System.out.println(mapVehicleNoAndOwner.get(2));
        System.out.println(mapVehicleNoAndOwner.get(4));
        
        System.out.println(mapVehicleNoAndOwner.get(5));
        mapVehicleNoAndOwner.forEach((key, value) -> {
			System.out.println("Key:"+ key + ", Value:" + value);
        });		
        
    }
}