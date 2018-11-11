package com.gildedrose;

class GildedRose {
    private static final int MAX_QUALITY = 50;
    private static final int MIN_QUALITY = 0;
    private static final int BACKSTAGE_PASS_FIRST_QUALITY_INCREASE_THRESHOLD = 10;
    private static final int BACKSTAGE_PASS_SECOND_QUALITY_INCREASE_THRESHOLD = 5;

    private static final int EXPIRATION_DATE = 0;

    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
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

    public void updateQuality() {
        for (Item item : items) {
            switch (item.name) {
                case SULFURAS:
                    // do nothing
                    break;
                case AGED_BRIE:
                    increaseQuality(item);
                    decreaseTimeUntilExpiry(item);
                    if (isPastExpirationDate(item)) {
                        increaseQuality(item);
                    }
                    break;
                case BACKSTAGE_PASSES:
                    increaseBackstagePassValueInFinalDays(item);
                    decreaseTimeUntilExpiry(item);
                    if (isPastExpirationDate(item)) {
                        item.quality = MIN_QUALITY;
                    }
                    break;
                default:
                    decreaseQuality(item);
                    decreaseTimeUntilExpiry(item);
                    if (isPastExpirationDate(item)) {
                        decreaseQuality(item);
                    }

            }
        }
    }

    private void decreaseTimeUntilExpiry(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private boolean isPastExpirationDate(Item item) {
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