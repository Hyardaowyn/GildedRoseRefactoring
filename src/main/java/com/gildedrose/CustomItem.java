package com.gildedrose;

public class CustomItem implements IUpdatable{

    private final IItemAdapter itemAdapter;
    private final ICanCalculateQualityDifferential qualityDifferentialCalculator;

    public CustomItem(IItemAdapter itemAdapter, ICanCalculateQualityDifferential qualityDifferentialCalculator) {
        this.itemAdapter = itemAdapter;
        this.qualityDifferentialCalculator = qualityDifferentialCalculator;
    }

    @Override
    public void update() {
        itemAdapter.updateDaysTillExpiry();
        final int qualityDifferential = qualityDifferentialCalculator.calculateQualityDifferential(itemAdapter);
        itemAdapter.addToQuality(qualityDifferential);
    }
}
