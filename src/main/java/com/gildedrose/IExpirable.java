package com.gildedrose;

interface IExpirable {
    public int getTimeTillExpiry();

    public void decreaseTimeTillExpiry();

    public boolean isExpired();

}
