package com.gildedrose;

public class ConjuredQualityDifferentialCalculator implements ICanCalculateQualityDifferential {

    private final ICanCalculateQualityDifferential normalQualityDifferentialCalculator;

    @Override
    public int calculateQualityDifferential(IItemAdapter itemAdapter) {
        return normalQualityDifferentialCalculator.calculateQualityDifferential(itemAdapter)*2;
    }

    public ConjuredQualityDifferentialCalculator(ICanCalculateQualityDifferential normalQualityDifferentialCalculator) {
        this.normalQualityDifferentialCalculator = normalQualityDifferentialCalculator;
    }
}
