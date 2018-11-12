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
        itemAdapter.addToQuality(qualityDifferential);
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