package com.gildedrose;

final class UpdatableFactory {

    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";


    IUpdatable create(Item item) {
        switch (item.name) {
            case SULFURAS:
                return new CustomItem(new ItemAdapter(item, new QualityUpdater(),new UnaffectedByExpiryTimeUpdater()), new SulfurasQualityDifferentialCalculator());
            case AGED_BRIE:
                return new CustomItem(new ItemAdapter(item, new QualityUpdater(), new AffectedByExpiryTimeUpdater()), new AgedBrieQualityDifferentialCalculator());
            case BACKSTAGE_PASSES:
                return new CustomItem(new ItemAdapter(item, new QualityUpdater(), new AffectedByExpiryTimeUpdater()), new BackstagePassesQualityDifferentialCalculator());
            default:
                return new CustomItem(new ItemAdapter(item, new QualityUpdater(), new AffectedByExpiryTimeUpdater()), new NormalQualityDifferentialCalculator());
        }
    }

}
