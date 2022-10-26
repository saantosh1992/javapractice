package com.icode.general;

import java.util.ArrayList;
import java.util.List;

class DataSource {
    private int id;
    private List<String> naturalIds;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setNaturalIds(List<String> naturalIds) {
        this.naturalIds = naturalIds;
    }

    public List<String> getNaturalIds() {
        return naturalIds;
    }

    @Override
    public String toString() {
        return "DataSource{" +
                "id=" + id +
                ", naturalIds=" + naturalIds +
                '}';
    }
}

public class NaturalIDSort {

    public static void main(String[] args) {
        DataSource ds = new DataSource();
        List<String> nIds = new ArrayList<>();
        nIds.add("R00");
        nIds.add("R01b");
        nIds.add("R01c");
        nIds.add("R01a");
        nIds.add("R01m");
        nIds.add("R02");
        ds.setNaturalIds(nIds);
        ds.setId(100);

        System.out.println("Before:"+ds);
        List<String> naturalIds = ds.getNaturalIds();
        naturalIds.sort((str1, str2) -> str2.substring(0, 3).compareTo(str1.substring(0, 3)));

        System.out.println("After:"+ds);
    }

}
