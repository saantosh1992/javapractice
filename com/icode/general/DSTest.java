package com.icode.general;


import jdk.jfr.SettingControl;

import java.util.*;
import java.util.function.Predicate;

class DataSourceResource {
    private String id;
    private List<String> naturalIds;

    public DataSourceResource(String id, List<String> naturalIds) {
        this.id = id;
        this.naturalIds = naturalIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataSourceResource that = (DataSourceResource) o;
        return Objects.equals(id, that.id) && Objects.equals(naturalIds, that.naturalIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, naturalIds);
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setNaturalIds(List<String> naturalIds) {
        this.naturalIds = naturalIds;
    }

    public List<String> getNaturalIds() {
        return naturalIds;
    }
}
public class DSTest {

    public static void main(String[] args) {

        List<DataSourceResource> dataSourceResources = new ArrayList<>();

        //DataSourceResource ds1 = new DataSourceResource("1", Arrays.asList("R00abc"));
        //DataSourceResource ds2 = new DataSourceResource("2", Arrays.asList("R00abc", "R01def"));
        DataSourceResource ds3 = new DataSourceResource("3", Arrays.asList("R00abc", "R01xyz", "R02mnp"));
        DataSourceResource ds6 = new DataSourceResource("3", Arrays.asList("R00abc", "R01xyz", "R02mnp", "R03abdbd"));
        //DataSourceResource ds5 = new DataSourceResource("3", Arrays.asList("R00abc",  "R02mnpt"));
        DataSourceResource ds7 = new DataSourceResource("3", Arrays.asList("R00abc",  "R03mnptp"));
        //DataSourceResource ds4 = new DataSourceResource("4", Arrays.asList("R00abc", "R01mnc"));
        //dataSourceResources.add(ds1);
        //dataSourceResources.add(ds2);
        dataSourceResources.add(ds3);
        //dataSourceResources.add(ds4);
        //dataSourceResources.add(ds5);
        dataSourceResources.add(ds7);

        String currentNID = "R02abc";
        String higherRankNID = "R03xyz";

        Predicate<String> allRankPredicate = filterPredicate(currentNID, higherRankNID);
        System.out.println("All Predicate:"+allRankPredicate);

            dataSourceResources.removeIf(ds -> ds.getNaturalIds().stream().anyMatch(allRankPredicate));
            System.out.println("After filtering:"+dataSourceResources.size()+"And:"+dataSourceResources.get(0).getNaturalIds());


        System.out.println("Valid natural id:"+validNaturalId("R016dkdfjfajadjajajajajjajajajajajajajajajdh"));

        System.out.println("Unique ID:"+getUniqueId(Optional.empty()));
    }

    private static Predicate<String> filterPredicate(String currNID, String higherRank) {
        int startRankValue = getAssetRankValue(currNID) + 1;
        int higherRankValue = getAssetRankValue(higherRank);
        List<Predicate<String>> rankPredicates = new ArrayList<>();
        while (startRankValue <= higherRankValue) {
            System.out.println("Start rank value:"+startRankValue);
            String rankPrefix = "R0" + startRankValue;
            Predicate<String> predicate = (String str) -> str.startsWith(rankPrefix);
            rankPredicates.add(predicate);
            startRankValue++;
        }
        System.out.println("All Predicate size:"+rankPredicates.size());
        return rankPredicates.stream().reduce(x -> false, Predicate :: or);
    }

    private static int getAssetRankValue(String assetNaturalId) {
        String rankPrefix = assetNaturalId.substring(0, 3);
        if (rankPrefix != null) {
            return Integer.parseInt(rankPrefix.substring(2, 3));
        }
        return 0;
    }


    private static boolean validNaturalId(String naturalId) {
        String regex = "^R0\\d.*";
        return naturalId.matches(regex);
    }

    private static String getUniqueId(Optional<String> externalId) {

       return externalId.map(id -> id.split("\\|\\|")[1]).orElse(null);
    }
}
