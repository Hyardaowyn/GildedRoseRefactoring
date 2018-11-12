package com.gildedrose;

public class QualityUpdater implements IQualityUpdater {

    private static final int MAX_QUALITY = 50;
    private static final int MIN_QUALITY = 0;

    public void addToQuality(Item item, int qualityDifferential){
        if(qualityDifferential>0 && item.quality < MAX_QUALITY){
            increaseQuality(item,qualityDifferential);
        }
        if(qualityDifferential<0 && item.quality > MIN_QUALITY) {
            decreaseQuality(item,-qualityDifferential);
        }
    }

    private void increaseQuality(Item item, int qualityDifferential) {
        item.quality = item.quality + qualityDifferential;
        if (item.quality > MAX_QUALITY) {
            item.quality = MAX_QUALITY;
        }
    }

    private void decreaseQuality(Item item, int qualityDifferential) {
        item.quality = item.quality - qualityDifferential;
        if (item.quality < MIN_QUALITY) {
            item.quality = MIN_QUALITY;
        }
    }
}
