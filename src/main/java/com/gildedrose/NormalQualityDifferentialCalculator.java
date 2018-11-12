package com.gildedrose;

public class NormalQualityDifferentialCalculator implements  ICanCalculateQualityDifferential {

    @Override
    public int calculateQualityDifferential(IItemAdapter itemAdapter) {
        return itemAdapter.isExpired()? -2:-1;
    }
}
