package com.gildedrose;

final class NormalItem implements IUpdatable {

    private final IItemAdapter itemAdapter;

    public NormalItem(Item item) {
        this.itemAdapter = new ItemAdapter(item);
    }

    @Override
    public void update() {
        itemAdapter.decreaseQuality(1);
        itemAdapter.decreaseTimeTillExpiry();
        if (itemAdapter.isExpired()) {
            itemAdapter.decreaseQuality(1);
        }
    }
}
