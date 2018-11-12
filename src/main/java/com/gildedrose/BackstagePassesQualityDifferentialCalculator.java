package com.gildedrose;

public class BackstagePassesQualityDifferentialCalculator implements  ICanCalculateQualityDifferential{

    private static final int BACKSTAGE_PASS_FIRST_QUALITY_INCREASE_THRESHOLD = 10;
    private static final int BACKSTAGE_PASS_SECOND_QUALITY_INCREASE_THRESHOLD = 5;

    @Override
    public int calculateQualityDifferential(IItemAdapter itemAdapter) {
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
