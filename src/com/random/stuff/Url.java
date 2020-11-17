package com.random.stuff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Url {
    public static void main(String[] args) {
            
    String[] inputs = {"https://www.yahoo.com/", 
    "http://www.yahoo.com/" ,
    "https://www.yahoo.com/news/",
    "https://sports.yahoo.com/",
    "https://techcrunch.com/startups/",
    "https://www.huffingtonpost.com/",
    "https://www.huffingtonpost.co.uk/",
    "https://www.huffingtonpost.co.uk/entry/brexit-secretary?utm_hp_ref=uk-politics",
    "https://developer.github.com/apps/building-oauth-apps/",
    "https://developer.github.com/v3/",
    "https://developer.github.com:8080/v3/"};
        
        /*
        Output: ["www.yahoo.com 3", "sports.yahoo.com 1", "techcrunch.com 1", "www.huffingtonpost.com 1", "www.huffingtonpost.co.uk 2", "developer.github.com 3"]
        */

        String[] inputs2 = {"www.yahoo.com", 
        "www.yahoo.com" };
        List<String> inputList = Arrays.asList(inputs2);
        

        List<String> result = process(inputList);

        for(String s: result){
            System.out.println(s);
        }
    }

    private static List<String> process(List<String> urls) {

        Map<String, Integer> urlCountMap = new HashMap<>();
        List<String> result = new ArrayList<>();
        
        // replace all http:// https:// as we dont need it
        // after replacing get the first index of / and substring it as we just need the domain.
        // then add it to the count map with getOrDefault
        // iterate the map and add to the result list with domain and freq
        
        urls.forEach(url -> {
          
          url = url.replaceAll("http://","");
          System.out.println(" -- "+url);
          url = url.replaceAll("https://","");
          System.out.println(" -- "+url);

          int index = url.indexOf(":");
            if(index == -1){
                 index = url.indexOf("/");

            }
            if(index != -1){
                url = url.substring(0,index);
              }
          urlCountMap.put(url, urlCountMap.getOrDefault(url, 0) +1);
        });
        
        //Map<String, Long> collect = urls.stream().map(url -> inputProcessor(url)).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        
        urlCountMap.forEach((key,value) -> {
          result.add(key+" "+value);
        });
        
        
        return result; 
    }

    private static String inputProcessor(String url){
        url = url.replaceAll("http://","");
        System.out.println(" -- "+url);
        url = url.replaceAll("https://","");
        System.out.println(" -- "+url);

        int index = url.indexOf(":");
          if(index == -1){
               index = url.indexOf("/");

          }
        
        url = url.substring(0,index);

        return url;
    }
}
