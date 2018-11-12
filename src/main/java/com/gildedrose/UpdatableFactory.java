package com.gildedrose;

final class UpdatableFactory {

    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String CONJURED = "Conjured";

    IUpdatable create(Item item) {
        ITEM_CATEGORY category = ITEM_CATEGORY.getItemCategory(item.name);
        switch (category) {
            case SULFURAS:
                return new CustomItem(item, new QualityUpdater(), new UnaffectedByExpiryTimeUpdater(), new ItemAdapter(item), new SulfurasQualityDifferentialCalculator());
            case AGED_BRIE:
                return new CustomItem(item, new QualityUpdater(), new AffectedByExpiryTimeUpdater(), new ItemAdapter(item), new AgedBrieQualityDifferentialCalculator());
            case BACKSTAGE_PASSES:
                return new CustomItem(item, new QualityUpdater(), new AffectedByExpiryTimeUpdater(), new ItemAdapter(item), new BackstagePassesQualityDifferentialCalculator());
            case CONJURED:
                return new CustomItem(item, new QualityUpdater(), new AffectedByExpiryTimeUpdater(), new ItemAdapter(item), new ConjuredQualityDifferentialCalculator
                        (new NormalQualityDifferentialCalculator()));
            default:
                return new CustomItem(item, new QualityUpdater(), new AffectedByExpiryTimeUpdater(), new ItemAdapter(item), new NormalQualityDifferentialCalculator());
        }
    }

    private enum ITEM_CATEGORY {
        AGED_BRIE("Aged Brie"),
        BACKSTAGE_PASSES("Backstage passes to a TAFKAL80ETC concert"),
        SULFURAS("Sulfuras, Hand of Ragnaros"),
        CONJURED("Conjured"),
        NORMAL(""),
        ;

        private String categoryName;

        private ITEM_CATEGORY(String categoryName) {
            this.categoryName = categoryName;
        }

        static ITEM_CATEGORY getItemCategory(String name) {
            for (ITEM_CATEGORY category : ITEM_CATEGORY.values()) {
                if (name.contains(category.categoryName)) {
                    return category;
                }
            }
            return NORMAL;
        }

    }

}
