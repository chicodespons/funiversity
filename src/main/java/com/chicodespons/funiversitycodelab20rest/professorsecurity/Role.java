package com.chicodespons.funiversitycodelab20rest.professorsecurity;

import java.util.List;

public enum Role {

    ADMIN(List.of(Feature.GET_ALL_PROFESSORS)),
    NORMAL(List.of());

    private final List<Feature> featureList;

    Role(List<Feature> featureList) {
        this.featureList = featureList;
    }

    public List<Feature> getFeatureList() {
        return featureList;
    }

    public boolean containsFeature(Feature feature) {
        return featureList.contains(feature);
    }
}
