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
            if (item.name.equals(SULFURAS)) {
                // do nothing
            } else {
                if (!item.name.equals(AGED_BRIE)
                        && !item.name.equals(BACKSTAGE_PASSES)) {
                    decreaseQuality(item);
                } else {
                    increaseQuality(item);
                    increaseBackstagePassValueInFinalDays(item);
                }

                item.sellIn = item.sellIn - 1;

                if (item.sellIn < EXPIRATION_DATE) {
                    if (item.name.equals(AGED_BRIE)) {
                        increaseQuality(item);
                    } else {
                        if (item.name.equals(BACKSTAGE_PASSES)) {
                            item.quality = MIN_QUALITY;
                        } else {
                                decreaseQuality(item);
                        }
                    }
                }
            }
        }
    }

    private void increaseBackstagePassValueInFinalDays(Item item) {
        if (item.name.equals(BACKSTAGE_PASSES)) {
            if (item.sellIn <= BACKSTAGE_PASS_FIRST_QUALITY_INCREASE_THRESHOLD) {
                increaseQuality(item);
            }

            if (item.sellIn <= BACKSTAGE_PASS_SECOND_QUALITY_INCREASE_THRESHOLD) {
                increaseQuality(item);
            }
        }
    }
}