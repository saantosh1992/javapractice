package com.icode.general;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Data {
    String name;
    List<String> naturalIds;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setNaturalIds(List<String> naturalIds) {
        this.naturalIds = naturalIds;
    }

    public List<String> getNaturalIds() {
        return naturalIds;
    }
}

public class ListValueCompare {
    public static void main(String[] args) {

        Data data = new Data();
        data.setName("abc");
        List<String> naturalIds = new ArrayList<>();
        naturalIds.add("R01a");
        naturalIds.add("R01a");
        naturalIds.add("R00x");
        naturalIds.add("R01b");
        data.setNaturalIds(naturalIds);
        List<String> prevLatestIds = new ArrayList<>();
        prevLatestIds.add("R01b");
        prevLatestIds.add("R01c");
        updateData(data, prevLatestIds);

    }

    private static void updateData(Data data, List<String> prevLatestIds) {

        List<String> existingIds = data.getNaturalIds();

        List<String> intersect = existingIds.stream()
                .filter(prevLatestIds::contains)
                .collect(Collectors.toList());
        System.out.println("Intersection:"+intersect);

        List<String> union = Stream.concat(existingIds.stream(), prevLatestIds.stream())
                .distinct()
                .sorted((String str1, String str2) -> str2.substring(0,3).compareTo(str1.substring(0,3)))
                .collect(Collectors.toList());
        String higherNat = union.stream()
                .max(Comparator.comparing((String str) -> str.substring(0, 3)).reversed())
                        .orElse("");

        System.out.println("Higher natural Ids:"+higherNat);

        System.out.println("Union:"+union);
    }
}
