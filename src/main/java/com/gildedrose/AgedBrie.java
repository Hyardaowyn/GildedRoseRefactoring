package com.gildedrose;

final class AgedBrie implements IUpdatable {
    private final ItemAdapter itemAdapter;

    public AgedBrie(Item item) {
        this.itemAdapter = new ItemAdapter(item);
    }

    @Override
    public void update() {
        itemAdapter.decreaseTimeTillExpiry();
        int qualityDifferential = calculateQualityDifferential(itemAdapter);
        itemAdapter.increaseQuality(qualityDifferential);
    }

    private int calculateQualityDifferential(IItemAdapter itemAdapter){
        return itemAdapter.isExpired()? 2:1;
    }

}