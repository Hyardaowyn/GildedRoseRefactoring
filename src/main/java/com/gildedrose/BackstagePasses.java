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
        itemAdapter.decreaseTimeTillExpiry();
        final int qualityDifferential = calculateQualityDifferential(itemAdapter);
        if(qualityDifferential>=0){
            itemAdapter.increaseQuality(qualityDifferential);
        }else {
            itemAdapter.decreaseQuality(-qualityDifferential);
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

    private int calculateQualityDifferential(IItemAdapter itemAdapter){
        if(itemAdapter.getTimeTillExpiry()>=BACKSTAGE_PASS_FIRST_QUALITY_INCREASE_THRESHOLD){
            return 1;
        }
        if(itemAdapter.getTimeTillExpiry()>=BACKSTAGE_PASS_SECOND_QUALITY_INCREASE_THRESHOLD){
            return 2;
        }
        if(!itemAdapter.isExpired()){
            return 3;
        }else{
            return -itemAdapter.getQuality();
        }
    }
}
