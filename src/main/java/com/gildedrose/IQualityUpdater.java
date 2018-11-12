package com.gildedrose;

interface IQualityUpdater {
    public void increaseQuality(int qualityDifferential);
    public void decreaseQuality(int qualityDifferential);
    public int getQuality();
}
