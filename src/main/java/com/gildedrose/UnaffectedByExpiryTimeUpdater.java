package com.gildedrose;

final class UnaffectedByExpiryTimeUpdater implements IExpiryTimeUpdater {

    @Override
    public void updateDaysTillExpiry(Item item) {
        // unaffected  by expiry time so no effect on sellIn
    }
}
