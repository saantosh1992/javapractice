package com.icode.general;

import java.util.*;
import java.util.stream.Collectors;

public class SortHashMapByValue {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        map.put("One", 10);
        map.put("Two", 8);
        map.put("Three", 2);
        map.put("Four", 12);

        sortMap(map);
        sortMapUsingStream(map);
    }

    private static void sortMapUsingStream(Map<String, Integer> map) {

       Map<String, Integer> sortedMap =  map.entrySet()
                .stream()
                .sorted((e1, e2) -> e1.getValue().compareTo(e2.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println("Sort using stream");
        System.out.println(sortedMap);
    }

    private static void sortMap(Map<String, Integer> map) {

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());

        Collections.sort(entryList, (e1, e2) -> e1.getValue().compareTo(e2.getValue()));
        Map<String, Integer> sortedValueMap = new LinkedHashMap<>();

        for(Map.Entry<String, Integer> entry : entryList) {
            sortedValueMap.put(entry.getKey(), entry.getValue());
        }

        System.out.println(sortedValueMap);
    }
}
