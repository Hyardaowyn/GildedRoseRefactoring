package com.gildedrose;

import java.util.MissingFormatArgumentException;

final class ItemAdapter implements IItemAdapter {

    private static final int EXPIRATION_DATE = 0;
    private final IQualityUpdater qualityUpdater;
    private final IExpiryTimeUpdater expiryTimeUpdater;
    private final Item item;

    public ItemAdapter(Item item, IQualityUpdater qualityUpdater, IExpiryTimeUpdater expiryTimeUpdater) {
        this.item = item;
        this.qualityUpdater = qualityUpdater;
        this.expiryTimeUpdater = expiryTimeUpdater;
    }

    public void addToQuality(int qualityDifferential) {
        qualityUpdater.addToQuality(item, qualityDifferential);
    }

    public int getQuality() {
        return item.quality;
    }

    public int getTimeTillExpiry() {
        return item.sellIn;
    }

    public void updateDaysTillExpiry() {
        expiryTimeUpdater.updateDaysTillExpiry(item);
    }

    public boolean isExpired() {
        return item.sellIn < EXPIRATION_DATE;
    }
}
