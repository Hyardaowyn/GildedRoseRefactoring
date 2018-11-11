package com.gildedrose;

final class updatableFactory {

    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";


    IUpdatable create(Item item) {
        switch (item.name) {
            case SULFURAS:
                // do nothing
                return new Sulfuras(item);
            case AGED_BRIE:
                return new AgedBrie(item);
            case BACKSTAGE_PASSES:
                return new BackstagePasses(item);
            default:
                return new NormalItem(item);
        }
    }

}
