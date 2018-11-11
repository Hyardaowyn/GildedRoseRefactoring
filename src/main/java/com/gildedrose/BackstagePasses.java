package com.gildedrose;

public class BackstagePasses implements IUpdatable {
    private static final int EXPIRATION_DATE = 0;
    private static final int MAX_QUALITY = 50;
    private static final int MIN_QUALITY = 0;
    private static final int BACKSTAGE_PASS_FIRST_QUALITY_INCREASE_THRESHOLD = 10;
    private static final int BACKSTAGE_PASS_SECOND_QUALITY_INCREASE_THRESHOLD = 5;
    Item item;

    public BackstagePasses(Item item) {
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
        increaseBackstagePassValueInFinalDays(item);
        decreaseTimeUntilExpiry(item);
        if (isExpired(item)) {
            item.quality = MIN_QUALITY;
        }
    }

    private void decreaseTimeUntilExpiry(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private boolean isExpired(Item item) {
        return item.sellIn < EXPIRATION_DATE;
    }

    private void increaseBackstagePassValueInFinalDays(Item item) {
        increaseQuality(item);
        if (item.sellIn <= BACKSTAGE_PASS_FIRST_QUALITY_INCREASE_THRESHOLD) {
            increaseQuality(item);
        }

        if (item.sellIn <= BACKSTAGE_PASS_SECOND_QUALITY_INCREASE_THRESHOLD) {
            increaseQuality(item);
        }

    }
}
