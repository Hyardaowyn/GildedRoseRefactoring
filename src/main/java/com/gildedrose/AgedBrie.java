package com.gildedrose;

final class AgedBrie implements IUpdatable {
    private final ItemAdapter itemAdapter;

    public AgedBrie(Item item) {
        this.itemAdapter = new ItemAdapter(item);
    }

    @Override
    public void update() {
        itemAdapter.increaseQuality(1);
        itemAdapter.decreaseTimeTillExpiry();
        if (itemAdapter.isExpired()) {
            itemAdapter.increaseQuality(1);
        }
    }

}