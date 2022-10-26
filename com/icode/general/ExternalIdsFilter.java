package com.icode.general;

import java.util.HashSet;
import java.util.Set;

public class ExternalIdsFilter {

    public static void main(String[] args) {

        Set<String> externalIds = new HashSet<>();
        externalIds.add("ASSET_SHORT_UNIQUE_ID||123457-abcd");
        externalIds.add("ID||123457-abcd-na");
        externalIds.add("HREF||123457-abcd-pa");

        String assetShortId = getAssetShortId(externalIds);
        System.out.println(assetShortId);
    }

    private static String getAssetShortId(Set<String> externalIds) {

        String keyValueAssetId = externalIds.stream().filter( e -> e.contains("ASSET_SHORT_UNIQUE_ID")).findFirst().orElse(null);

        if (keyValueAssetId != null && !keyValueAssetId.isBlank()) {

         return keyValueAssetId.split("\\|\\|")[1];
        }
        return null;
    }
}
