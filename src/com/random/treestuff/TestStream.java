package com.random.treestuff;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestStream {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        Map<Integer, Integer> collected = 
        IntStream.range(0, arr.length)
                 .boxed()
                 .collect(Collectors.toMap(i -> arr[i], i -> i));

        System.out.println(collected);
    }
}
