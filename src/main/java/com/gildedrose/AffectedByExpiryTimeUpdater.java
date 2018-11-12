package com.gildedrose;

public class AffectedByExpiryTimeUpdater implements IExpiryTimeUpdater {
    @Override
    public void updateDaysTillExpiry(Item item) {
        item.sellIn--;
    }
}
