package com.gildedrose;

final class Sulfuras implements IUpdatable {

    ItemAdapter itemAdapter;

    public Sulfuras(Item item) {
        this.itemAdapter = new ItemAdapter(item);
    }

    @Override
    public void update() {
        // do nothing
    }
}
