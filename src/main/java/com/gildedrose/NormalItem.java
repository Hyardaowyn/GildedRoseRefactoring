package com.gildedrose;

final class NormalItem implements IUpdatable {

    private final IItemAdapter itemAdapter;

    public NormalItem(Item item) {
        this.itemAdapter = new ItemAdapter(item);
    }

    @Override
    public void update() {
        itemAdapter.decreaseTimeTillExpiry();
        int qualityDifferential = calculateQualityDifferential(itemAdapter);
        itemAdapter.addToQuality(qualityDifferential);
    }

    private int calculateQualityDifferential(IItemAdapter itemAdapter){
        return itemAdapter.isExpired()? -2:-1;
    }
}
