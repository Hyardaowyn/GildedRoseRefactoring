package com.gildedrose;

final class ItemAdapter implements IItemAdapter {

    private static final int MAX_QUALITY = 50;
    private static final int MIN_QUALITY = 0;
    private static final int EXPIRATION_DATE = 0;
    private final Item item;

    public ItemAdapter(Item item) {
        this.item = item;
    }

    public void increaseQuality(int qualityDifferential) {
        if (item.quality <= MAX_QUALITY) {
            item.quality = item.quality + qualityDifferential;
            if (item.quality > MAX_QUALITY) {
                item.quality = MAX_QUALITY;
            }
        }
    }

    public void decreaseQuality(int qualityDifferential) {
        if (item.quality > MIN_QUALITY) {
            item.quality = item.quality - qualityDifferential;
            if (item.quality < MIN_QUALITY) {
                item.quality = MIN_QUALITY;
            }
        }
    }

    public int getQuality(){
        return item.quality;
    }

    public int getTimeTillExpiry() {
        return item.sellIn;
    }

    public void decreaseTimeTillExpiry() {
        item.sellIn--;
    }

    public boolean isExpired() {
        return item.sellIn < EXPIRATION_DATE;
    }
}
