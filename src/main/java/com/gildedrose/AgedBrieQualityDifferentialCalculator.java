package com.gildedrose;

public class AgedBrieQualityDifferentialCalculator implements ICanCalculateQualityDifferential {
    @Override
    public int calculateQualityDifferential(IItemAdapter itemAdapter) {
        return itemAdapter.isExpired()? 2:1;
    }
}
