package com.gildedrose;

final class BackstagePasses implements IUpdatable {

    private static final int BACKSTAGE_PASS_FIRST_QUALITY_INCREASE_THRESHOLD = 10;
    private static final int BACKSTAGE_PASS_SECOND_QUALITY_INCREASE_THRESHOLD = 5;
    private final IItemAdapter itemAdapter;

    public BackstagePasses(Item item) {
        this.itemAdapter = new ItemAdapter(item);
    }

    @Override
    public void update() {
        increaseBackstagePassValueInFinalDays(itemAdapter);
        itemAdapter.decreaseTimeTillExpiry();
        if (itemAdapter.isExpired()) {
            int qualityDifferential = itemAdapter.getQuality();
            itemAdapter.decreaseQuality(qualityDifferential);
        }
    }

    private void increaseBackstagePassValueInFinalDays(IItemAdapter itemAdapter) {
        itemAdapter.increaseQuality(1);
        if (itemAdapter.getTimeTillExpiry() <= BACKSTAGE_PASS_FIRST_QUALITY_INCREASE_THRESHOLD) {
            itemAdapter.increaseQuality(1);
        }

        if (itemAdapter.getTimeTillExpiry() <= BACKSTAGE_PASS_SECOND_QUALITY_INCREASE_THRESHOLD) {
            itemAdapter.increaseQuality(1);
        }
    }
}
