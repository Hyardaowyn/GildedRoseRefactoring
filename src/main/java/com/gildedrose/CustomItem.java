package com.gildedrose;

public class CustomItem implements IUpdatable{

    private final IItemAdapter itemAdapter;
    private final ICanCalculateQualityDifferential qualityDifferentialCalculator;
    private final IQualityUpdater qualityUpdater;
    private final IExpiryTimeUpdater expiryTimeUpdater;
    private final Item item;

    public CustomItem(Item item, IQualityUpdater qualityUpdater, IExpiryTimeUpdater expiryTimeUpdater, IItemAdapter itemAdapter, ICanCalculateQualityDifferential qualityDifferentialCalculator) {
        this.itemAdapter = itemAdapter;
        this.qualityDifferentialCalculator = qualityDifferentialCalculator;
        this.item = item;
        this.qualityUpdater = qualityUpdater;
        this.expiryTimeUpdater = expiryTimeUpdater;
    }

    @Override
    public void update() {
        updateDaysTillExpiry();
        final int qualityDifferential = qualityDifferentialCalculator.calculateQualityDifferential(itemAdapter);
        addToQuality(qualityDifferential);
    }

    private void addToQuality (int qualityDifferential){
        qualityUpdater.addToQuality(item, qualityDifferential);
    }

    private void updateDaysTillExpiry(){
        expiryTimeUpdater.updateDaysTillExpiry(item);
    }
}
