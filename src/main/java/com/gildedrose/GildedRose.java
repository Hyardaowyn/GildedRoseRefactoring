package com.gildedrose;

class GildedRose {
    Item[] items;
    private static final updatableFactory updatableFactory = new updatableFactory();

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updatableFactory.create(item).update();
        }
    }

}