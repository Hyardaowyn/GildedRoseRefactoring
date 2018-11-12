package com.gildedrose;

import java.util.MissingFormatArgumentException;

final class ItemAdapter implements IItemAdapter {

    private static final int EXPIRATION_DATE = 0;
    private final Item item;

    public ItemAdapter(Item item) {
        this.item = item;
    }

    public int getQuality() {
        return item.quality;
    }

    public int getTimeTillExpiry() {
        return item.sellIn;
    }

    public boolean isExpired() {
        return item.sellIn < EXPIRATION_DATE;
    }
}
