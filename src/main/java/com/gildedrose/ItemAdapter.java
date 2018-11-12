package com.gildedrose;

import java.util.MissingFormatArgumentException;

final class ItemAdapter implements IItemAdapter {

    private static final int MAX_QUALITY = 50;
    private static final int MIN_QUALITY = 0;
    private static final int EXPIRATION_DATE = 0;
    private final Item item;

    public ItemAdapter(Item item) {
        this.item = item;
    }

    public void addToQuality(int qualityDifferential){
        if(qualityDifferential>0 && item.quality < MAX_QUALITY){
            increaseQuality(qualityDifferential);
        }
        if(qualityDifferential<0 && item.quality > MIN_QUALITY) {
            decreaseQuality(-qualityDifferential);
        }
    }

    private void increaseQuality(int qualityDifferential) {
            item.quality = item.quality + qualityDifferential;
            if (item.quality > MAX_QUALITY) {
                item.quality = MAX_QUALITY;
            }
    }

    private void decreaseQuality(int qualityDifferential) {
            item.quality = item.quality - qualityDifferential;
            if (item.quality < MIN_QUALITY) {
                item.quality = MIN_QUALITY;
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
