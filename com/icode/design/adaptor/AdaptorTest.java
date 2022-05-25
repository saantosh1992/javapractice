package com.icode.design.adaptor;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class MapAdaptor extends AbstractMap {

    private Map<Integer, Integer> map;

    public MapAdaptor(int[][] array) {
        super();
        map = new HashMap<>();
        for(int[] arr : array) {
            map.put(arr[0], arr[1]);
        }
    }

    @Override
    public Set<Entry<Integer, Integer>> entrySet() {
        return map.entrySet();
    }
}

public class AdaptorTest {
    public static void main(String[] args) {
        int[][] array = {{1,2}, {3,4}, {5,6}};

        MapAdaptor mapAdaptor = new MapAdaptor(array);
        for (Map.Entry<Integer, Integer> entry : mapAdaptor.entrySet()) {
            System.out.println(entry.getKey() +":"+entry.getValue());
        }
    }
}
