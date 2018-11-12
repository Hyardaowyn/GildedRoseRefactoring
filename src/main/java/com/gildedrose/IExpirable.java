package com.gildedrose;

interface IExpirable {
    public int getTimeTillExpiry();

    public int getQuality();

    public void updateDaysTillExpiry();

    public boolean isExpired();

}
