package com.gildedrose;

public class NormalItem implements IUpdatable {

    Item item;

    private static final int EXPIRATION_DATE = 0;
    private static final int MAX_QUALITY = 50;
    private static final int MIN_QUALITY = 0;

    public NormalItem(Item item) {
        this.item = item;
    }

    private static void increaseQuality(Item item) {
        if (item.quality < MAX_QUALITY) {
            item.quality = item.quality + 1;
        }
    }

    private static void decreaseQuality(Item item) {
        if (item.quality > MIN_QUALITY) {
            item.quality = item.quality - 1;
        }
    }

    @Override
    public void update() {
        decreaseQuality(item);
        decreaseTimeUntilExpiry(item);
        if (isExpired(item)) {
            decreaseQuality(item);
        }

    }

    private void decreaseTimeUntilExpiry(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private boolean isExpired(Item item) {
        return item.sellIn < EXPIRATION_DATE;
    }
}
