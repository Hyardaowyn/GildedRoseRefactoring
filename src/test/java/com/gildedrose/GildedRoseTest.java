package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This class tests the GildedRose implementation.
 * The tests are grouped per product and then per item property.
 * Tests for negative item qualities have also been included.
 */
public class GildedRoseTest {

    private static final int longBeforeExpirationDate = 85;
    private static final int beforeExpirationDate = 1;
    private static final int expirationDate = 0;
    private static final int afterExpirationDate = -1;
    private static final int longAfterExpirationDate = -75;

    private static final int negativeQuality = -3;
    private static final int minimumQuality = 0;
    private static final int positiveQuality = 1;
    private static final int maxQuality = 50;

    private Item[] items;

    // normal item

    @Test
    public void updateQuality_normalItem_correctName() {
        GildedRose app = createGildedRoseWithOneItem("normalItem", 0, 0);

        app.updateQuality();

        assertEquals("normalItem", app.items[0].name);
    }

    @Test
    public void updateQuality_normalItemLongBeforeExpirationDate_sellInOneLess() {
        GildedRose app = createGildedRoseWithOneItem("normalItem", longBeforeExpirationDate, 0);

        app.updateQuality();

        assertEquals(longBeforeExpirationDate - 1, app.items[0].sellIn);
    }

    @Test
    public void updateQuality_normalItemBeforeExpirationDate_sellInOneLess() {
        GildedRose app = createGildedRoseWithOneItem("normalItem", beforeExpirationDate, 0);

        app.updateQuality();

        assertEquals(beforeExpirationDate - 1, app.items[0].sellIn);
    }

    @Test
    public void updateQuality_normalItemOnExpirationDate_sellInOneLess() {
        GildedRose app = createGildedRoseWithOneItem("normalItem", expirationDate, 0);

        app.updateQuality();

        assertEquals(expirationDate - 1, app.items[0].sellIn);
    }

    @Test
    public void updateQuality_normalItemAfterExpirationDate_sellInOneLess() {
        GildedRose app = createGildedRoseWithOneItem("normalItem", afterExpirationDate, 0);

        app.updateQuality();

        assertEquals(afterExpirationDate - 1, app.items[0].sellIn);
    }

    @Test
    public void updateQuality_normalItemLongAfterExpirationDate_sellInOneLess() {
        GildedRose app = createGildedRoseWithOneItem("normalItem", longAfterExpirationDate, 0);

        app.updateQuality();

        assertEquals(longAfterExpirationDate - 1, app.items[0].sellIn);
    }

    // quality before expiration date

    @Test
    public void updateQuality_normalItemLongBeforeExpirationDateAndNegativeQuality_qualityNotChanged() {
        GildedRose app = createGildedRoseWithOneItem("normalItem", longBeforeExpirationDate, negativeQuality);

        app.updateQuality();

        assertEquals(negativeQuality, app.items[0].quality);
    }

    @Test
    public void updateQuality_normalItemBeforeExpirationDateAndNegativeQuality_qualityNotChanged() {
        GildedRose app = createGildedRoseWithOneItem("normalItem", beforeExpirationDate, negativeQuality);

        app.updateQuality();

        assertEquals(negativeQuality, app.items[0].quality);
    }

    @Test
    public void updateQuality_normalItemBeforeExpirationDateAndPositiveQualityThatIsStrictlyLessThanMaximum_qualityDecreasedByOne() {
        GildedRose app = createGildedRoseWithOneItem("normalItem", beforeExpirationDate, positiveQuality);

        app.updateQuality();

        assertEquals(positiveQuality - 1, app.items[0].quality);
    }

    @Test
    public void updateQuality_normalItemBeforeExpirationDateAndMaximumPositiveQuality_qualityDecreasedByOne() {
        GildedRose app = createGildedRoseWithOneItem("normalItem", beforeExpirationDate, maxQuality);

        app.updateQuality();

        assertEquals(maxQuality - 1, app.items[0].quality);
    }

    // quality on expiration date

    @Test
    public void updateQuality_normalItemOnExpirationDateWithQualityOneMoreThanMinimum_qualityDecreasedToMinimum() {
        GildedRose app = createGildedRoseWithOneItem("normalItem", expirationDate, minimumQuality + 1);

        app.updateQuality();

        assertEquals(minimumQuality, app.items[0].quality);
    }

    @Test
    public void updateQuality_normalItemOnExpirationDateWithMaxQuality_qualityDecreasedByTwo() {
        GildedRose app = createGildedRoseWithOneItem("normalItem", expirationDate, maxQuality);

        app.updateQuality();

        assertEquals(maxQuality - 2, app.items[0].quality);
    }

    // quality after expiration date

    @Test
    public void updateQuality_normalItemAfterExpirationDateWithQualityOneMoreThanMinimum_qualityDecreasedToMinimum() {
        GildedRose app = createGildedRoseWithOneItem("normalItem", afterExpirationDate, minimumQuality + 1);

        app.updateQuality();

        assertEquals(minimumQuality, app.items[0].quality);
    }

    @Test
    public void updateQuality_normalItemAfterExpirationDateWithOneLessThanMaxQuality_qualityDecreasedByTwo() {
        GildedRose app = createGildedRoseWithOneItem("normalItem", afterExpirationDate, maxQuality - 1);

        app.updateQuality();

        assertEquals(maxQuality - 3, app.items[0].quality);
    }

    @Test
    public void updateQuality_normalItemAfterExpirationDateWithMaxQuality_qualityDecreasedByTwo() {
        GildedRose app = createGildedRoseWithOneItem("normalItem", afterExpirationDate, maxQuality);

        app.updateQuality();

        assertEquals(maxQuality - 2, app.items[0].quality);
    }

    @Test
    public void updateQuality_normalItemAfterExpirationDateWithHigherThanMaxQuality_qualityDecreasedByTwo() {
        GildedRose app = createGildedRoseWithOneItem("normalItem", afterExpirationDate, maxQuality + 5);

        app.updateQuality();

        assertEquals(maxQuality + 3, app.items[0].quality);
    }

    // aged brie

    @Test
    public void updateQuality_agedBrie_correctName() {
        GildedRose app = createGildedRoseWithOneItem("Aged Brie", 0, 0);

        app.updateQuality();

        assertEquals("Aged Brie", app.items[0].name);
    }

    @Test
    public void updateQuality_agedBrieLongBeforeExpirationDate_sellInOneLess() {
        GildedRose app = createGildedRoseWithOneItem("Aged Brie", longBeforeExpirationDate, 0);

        app.updateQuality();

        assertEquals(longBeforeExpirationDate - 1, app.items[0].sellIn);
    }

    @Test
    public void updateQuality_agedBrieBeforeExpirationDate_sellInOneLess() {
        GildedRose app = createGildedRoseWithOneItem("Aged Brie", beforeExpirationDate, 0);

        app.updateQuality();

        assertEquals(beforeExpirationDate - 1, app.items[0].sellIn);
    }

    @Test
    public void updateQuality_agedBrieOnExpirationDate_sellInOneLess() {
        GildedRose app = createGildedRoseWithOneItem("Aged Brie", expirationDate, 0);

        app.updateQuality();

        assertEquals(expirationDate - 1, app.items[0].sellIn);
    }

    @Test
    public void updateQuality_agedBrieAfterExpirationDate_sellInOneLess() {
        GildedRose app = createGildedRoseWithOneItem("Aged Brie", afterExpirationDate, 0);

        app.updateQuality();

        assertEquals(afterExpirationDate - 1, app.items[0].sellIn);
    }

    @Test
    public void updateQuality_agedBrieLongAfterExpirationDate_sellInOneLess() {
        GildedRose app = createGildedRoseWithOneItem("Aged Brie", longAfterExpirationDate, 0);

        app.updateQuality();

        assertEquals(longAfterExpirationDate - 1, app.items[0].sellIn);
    }

    // quality before expiration date

    @Test
    public void updateQuality_agedBrieLongBeforeExpirationDateAndNegativeQuality_qualityIncreasedByOne() {
        GildedRose app = createGildedRoseWithOneItem("Aged Brie", longBeforeExpirationDate, negativeQuality);

        app.updateQuality();

        assertEquals(negativeQuality + 1, app.items[0].quality);
    }

    @Test
    public void updateQuality_agedBrieBeforeExpirationDateAndNegativeQuality_qualityIncreasedByOne() {
        GildedRose app = createGildedRoseWithOneItem("Aged Brie", beforeExpirationDate, negativeQuality);

        app.updateQuality();

        assertEquals(negativeQuality + 1, app.items[0].quality);
    }

    @Test
    public void updateQuality_agedBrieBeforeExpirationDateAndPositiveQualityThatIsStrictlyLessThanMaximum_qualityIncreasedByOne() {
        GildedRose app = createGildedRoseWithOneItem("Aged Brie", beforeExpirationDate, positiveQuality);

        app.updateQuality();

        assertEquals(positiveQuality + 1, app.items[0].quality);
    }

    @Test
    public void updateQuality_agedBrieBeforeExpirationDateAndMaximumPositiveQuality_qualityNotIncreased() {
        GildedRose app = createGildedRoseWithOneItem("Aged Brie", beforeExpirationDate, maxQuality);

        app.updateQuality();

        assertEquals(maxQuality, app.items[0].quality);
    }

    @Test
    public void updateQuality_agedBrieBeforeExpirationDateAndQualityHigherThanMaximumPositiveQuality_qualityNotIncreased() {
        GildedRose app = createGildedRoseWithOneItem("Aged Brie", beforeExpirationDate, maxQuality + 2);

        app.updateQuality();

        assertEquals(maxQuality + 2, app.items[0].quality);
    }

    // quality on expiration date

    @Test
    public void updateQuality_agedBrieOnExpirationDateWithPositiveQuality_qualityIncreasedByTwo() {
        GildedRose app = createGildedRoseWithOneItem("Aged Brie", expirationDate, positiveQuality);

        app.updateQuality();

        assertEquals(positiveQuality + 2, app.items[0].quality);
    }

    @Test
    public void updateQuality_agedBrieOnExpirationDateWithMaxQuality_qualityNotIncreased() {
        GildedRose app = createGildedRoseWithOneItem("Aged Brie", expirationDate, maxQuality);

        app.updateQuality();

        assertEquals(maxQuality, app.items[0].quality);
    }

    // quality after expiration date

    @Test
    public void updateQuality_agedBrieAfterExpirationDateWithPositiveQuality_qualityIncreasedByTwo() {
        GildedRose app = createGildedRoseWithOneItem("Aged Brie", afterExpirationDate, positiveQuality);

        app.updateQuality();

        assertEquals(positiveQuality + 2, app.items[0].quality);
    }

    @Test
    public void updateQuality_agedBrieAfterExpirationDateWithOneLessThanMaxQuality_maxQuality() {
        GildedRose app = createGildedRoseWithOneItem("Aged Brie", afterExpirationDate, maxQuality - 1);

        app.updateQuality();

        assertEquals(maxQuality, app.items[0].quality);
    }

    @Test
    public void updateQuality_agedBrieAfterExpirationDateWithMaxQuality_qualityNotIncreased() {
        GildedRose app = createGildedRoseWithOneItem("Aged Brie", afterExpirationDate, maxQuality);

        app.updateQuality();

        assertEquals(maxQuality, app.items[0].quality);
    }

    @Test
    public void updateQuality_agedBrieAfterExpirationDateWithHigherThanMaxQuality_higherThanMaxQualityButNotIncreased() {
        GildedRose app = createGildedRoseWithOneItem("Aged Brie", afterExpirationDate, maxQuality + 5);

        app.updateQuality();

        assertEquals(maxQuality + 5, app.items[0].quality);
    }

    // sulfuras


    @Test
    public void updateQuality_sulfuras_correctName() {
        GildedRose app = createGildedRoseWithOneItem("Sulfuras, Hand of Ragnaros", 0, 0);

        app.updateQuality();

        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
    }

    @Test
    public void updateQuality_sulfurasLongBeforeExpirationDate_noEffectOnSellInDate() {
        GildedRose app = createGildedRoseWithOneItem("Sulfuras, Hand of Ragnaros", longBeforeExpirationDate, 0);

        app.updateQuality();

        assertEquals(longBeforeExpirationDate, app.items[0].sellIn);
    }

    @Test
    public void updateQuality_sulfurasBeforeExpirationDate_noEffectOnSellInDate() {
        GildedRose app = createGildedRoseWithOneItem("Sulfuras, Hand of Ragnaros", beforeExpirationDate, 0);

        app.updateQuality();

        assertEquals(beforeExpirationDate, app.items[0].sellIn);
    }

    @Test
    public void updateQuality_sulfurasOnExpirationDate_noEffectOnSellInDate() {
        GildedRose app = createGildedRoseWithOneItem("Sulfuras, Hand of Ragnaros", expirationDate, 0);

        app.updateQuality();

        assertEquals(expirationDate, app.items[0].sellIn);
    }

    @Test
    public void updateQuality_sulfurasAfterExpirationDate_noEffectOnSellInDate() {
        GildedRose app = createGildedRoseWithOneItem("Sulfuras, Hand of Ragnaros", afterExpirationDate, 0);

        app.updateQuality();

        assertEquals(afterExpirationDate, app.items[0].sellIn);
    }

    @Test
    public void updateQuality_sulfurasLongAfterExpirationDate_noEffectOnSellInDate() {
        GildedRose app = createGildedRoseWithOneItem("Sulfuras, Hand of Ragnaros", longAfterExpirationDate, 0);

        app.updateQuality();

        assertEquals(longAfterExpirationDate, app.items[0].sellIn);
    }

    // quality before expiration date

    @Test
    public void updateQuality_sulfurasLongBeforeExpirationDateAndNegativeQuality_noEffectOnQuality() {
        GildedRose app = createGildedRoseWithOneItem("Sulfuras, Hand of Ragnaros", longBeforeExpirationDate, negativeQuality);

        app.updateQuality();

        assertEquals(negativeQuality, app.items[0].quality);
    }

    @Test
    public void updateQuality_sulfurasBeforeExpirationDateAndNegativeQuality_noEffectOnQuality() {
        GildedRose app = createGildedRoseWithOneItem("Sulfuras, Hand of Ragnaros", beforeExpirationDate, negativeQuality);

        app.updateQuality();

        assertEquals(negativeQuality, app.items[0].quality);
    }

    @Test
    public void updateQuality_sulfurasBeforeExpirationDateAndPositiveQualityThatIsStrictlyLessThanMaximum_noEffectOnQuality() {
        GildedRose app = createGildedRoseWithOneItem("Sulfuras, Hand of Ragnaros", beforeExpirationDate, positiveQuality);

        app.updateQuality();

        assertEquals(positiveQuality, app.items[0].quality);
    }

    @Test
    public void updateQuality_sulfurasBeforeExpirationDateAndMaximumPositiveQuality_noEffectOnQuality() {
        GildedRose app = createGildedRoseWithOneItem("Sulfuras, Hand of Ragnaros", beforeExpirationDate, maxQuality);

        app.updateQuality();

        assertEquals(maxQuality, app.items[0].quality);
    }

    // quality on expiration date

    @Test
    public void updateQuality_sulfurasOnExpirationDateWithPositiveQuality_noEffectOnQuality() {
        GildedRose app = createGildedRoseWithOneItem("Sulfuras, Hand of Ragnaros", expirationDate, positiveQuality);

        app.updateQuality();

        assertEquals(positiveQuality, app.items[0].quality);
    }

    @Test
    public void updateQuality_sulfurasOnExpirationDateWithMaxQuality_noEffectOnQuality() {
        GildedRose app = createGildedRoseWithOneItem("Sulfuras, Hand of Ragnaros", expirationDate, maxQuality);

        app.updateQuality();

        assertEquals(maxQuality, app.items[0].quality);
    }

    // quality after expiration date

    @Test
    public void updateQuality_sulfurasAfterExpirationDateWithPositiveQuality_noEffectOnQuality() {
        GildedRose app = createGildedRoseWithOneItem("Sulfuras, Hand of Ragnaros", afterExpirationDate, positiveQuality);

        app.updateQuality();

        assertEquals(positiveQuality, app.items[0].quality);
    }

    @Test
    public void updateQuality_sulfurasAfterExpirationDateWithOneLessThanMaxQuality_noEffectOnQuality() {
        GildedRose app = createGildedRoseWithOneItem("Sulfuras, Hand of Ragnaros", afterExpirationDate, maxQuality - 1);

        app.updateQuality();

        assertEquals(maxQuality - 1, app.items[0].quality);
    }

    @Test
    public void updateQuality_sulfurasAfterExpirationDateWithMaxQuality_noEffectOnQuality() {
        GildedRose app = createGildedRoseWithOneItem("Sulfuras, Hand of Ragnaros", afterExpirationDate, maxQuality);

        app.updateQuality();

        assertEquals(maxQuality, app.items[0].quality);
    }

    @Test
    public void updateQuality_sulfurasAfterExpirationDateWithHigherThanMaxQuality_noEffectOnQuality() {
        GildedRose app = createGildedRoseWithOneItem("Sulfuras, Hand of Ragnaros", afterExpirationDate, maxQuality + 5);

        app.updateQuality();

        assertEquals(maxQuality + 5, app.items[0].quality);
    }

    // backstage passes
    
    @Test
    public void updateQuality_backstagePasses_correctName() {
        GildedRose app = createGildedRoseWithOneItem("Backstage passes to a TAFKAL80ETC concert", 0, 0);

        app.updateQuality();

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
    }

    @Test
    public void updateQuality_backstagePassesLongBeforeExpirationDate_sellInDateDecreasedByOne() {
        GildedRose app = createGildedRoseWithOneItem("Backstage passes to a TAFKAL80ETC concert", longBeforeExpirationDate, 0);

        app.updateQuality();

        assertEquals(longBeforeExpirationDate-1, app.items[0].sellIn);
    }

    @Test
    public void updateQuality_backstagePassesBeforeExpirationDate_sellInDateDecreasedByOne() {
        GildedRose app = createGildedRoseWithOneItem("Backstage passes to a TAFKAL80ETC concert", beforeExpirationDate, 0);

        app.updateQuality();

        assertEquals(beforeExpirationDate-1, app.items[0].sellIn);
    }

    @Test
    public void updateQuality_backstagePassesOnExpirationDate_sellInDateDecreasedByOne() {
        GildedRose app = createGildedRoseWithOneItem("Backstage passes to a TAFKAL80ETC concert", expirationDate, 0);

        app.updateQuality();

        assertEquals(expirationDate-1, app.items[0].sellIn);
    }

    @Test
    public void updateQuality_backstagePassesAfterExpirationDate_sellInDateDecreasedByOne() {
        GildedRose app = createGildedRoseWithOneItem("Backstage passes to a TAFKAL80ETC concert", afterExpirationDate, 0);

        app.updateQuality();

        assertEquals(afterExpirationDate-1, app.items[0].sellIn);
    }

    @Test
    public void updateQuality_backstagePassesLongAfterExpirationDate_sellInDateDecreasedByOne() {
        GildedRose app = createGildedRoseWithOneItem("Backstage passes to a TAFKAL80ETC concert", longAfterExpirationDate, 0);

        app.updateQuality();

        assertEquals(longAfterExpirationDate-1, app.items[0].sellIn);
    }

    // quality before expiration date

    @Test
    public void updateQuality_backstagePasses11DaysBeforeExpirationDateAndNegativeQuality_qualityIncreasedByOne() {
        GildedRose app = createGildedRoseWithOneItem("Backstage passes to a TAFKAL80ETC concert", 11, negativeQuality);

        app.updateQuality();

        assertEquals(negativeQuality+1, app.items[0].quality);
    }

    @Test
    public void updateQuality_backstagePasses11DaysBeforeExpirationDateAndPositiveQuality_qualityIncreasedByOne() {
        GildedRose app = createGildedRoseWithOneItem("Backstage passes to a TAFKAL80ETC concert", 11, positiveQuality);

        app.updateQuality();

        assertEquals(positiveQuality+1, app.items[0].quality);
    }

    @Test
    public void updateQuality_backstagePasses11DaysBeforeExpirationDateAndPositiveQualityOneLessThanMaxQuality_qualityIncreasedToMaxQuality() {
        GildedRose app = createGildedRoseWithOneItem("Backstage passes to a TAFKAL80ETC concert", 11, maxQuality -1);

        app.updateQuality();

        assertEquals(maxQuality, app.items[0].quality);
    }

    @Test
    public void updateQuality_backstagePasses11DaysBeforeExpirationDateAndMaxQuality_noEffectOnQuality() {
        GildedRose app = createGildedRoseWithOneItem("Backstage passes to a TAFKAL80ETC concert", 11, maxQuality);

        app.updateQuality();

        assertEquals(maxQuality, app.items[0].quality);
    }

    @Test
    public void updateQuality_backstagePasses10DaysBeforeExpirationDateAndNegativeQuality_qualityIncreasedByTwo() {
        GildedRose app = createGildedRoseWithOneItem("Backstage passes to a TAFKAL80ETC concert", 10, negativeQuality);

        app.updateQuality();

        assertEquals(negativeQuality+2, app.items[0].quality);
    }

    @Test
    public void updateQuality_backstagePasses10DaysBeforeExpirationDateAndPositiveQuality_qualityIncreasedByTwo() {
        GildedRose app = createGildedRoseWithOneItem("Backstage passes to a TAFKAL80ETC concert", 10, positiveQuality);

        app.updateQuality();

        assertEquals(positiveQuality+2, app.items[0].quality);
    }

    @Test
    public void updateQuality_backstagePasses10DaysBeforeExpirationDateAndPositiveQualityOneLessThanMaxQuality_qualityIncreasedToMaxQuality() {
        GildedRose app = createGildedRoseWithOneItem("Backstage passes to a TAFKAL80ETC concert", 10, maxQuality -1);

        app.updateQuality();

        assertEquals(maxQuality, app.items[0].quality);
    }

    @Test
    public void updateQuality_backstagePasses10DaysBeforeExpirationDateAndMaxQuality_noEffectOnQuality() {
        GildedRose app = createGildedRoseWithOneItem("Backstage passes to a TAFKAL80ETC concert", 10, maxQuality);

        app.updateQuality();

        assertEquals(maxQuality, app.items[0].quality);
    }

    @Test
    public void updateQuality_backstagePasses9DaysBeforeExpirationDateAndNegativeQuality_qualityIncreasedByTwo() {
        GildedRose app = createGildedRoseWithOneItem("Backstage passes to a TAFKAL80ETC concert", 9, negativeQuality);

        app.updateQuality();

        assertEquals(negativeQuality+2, app.items[0].quality);
    }

    @Test
    public void updateQuality_backstagePasses9DaysBeforeExpirationDateAndPositiveQuality_qualityIncreasedByTwo() {
        GildedRose app = createGildedRoseWithOneItem("Backstage passes to a TAFKAL80ETC concert", 9, positiveQuality);

        app.updateQuality();

        assertEquals(positiveQuality+2, app.items[0].quality);
    }

    @Test
    public void updateQuality_backstagePasses9DaysBeforeExpirationDateAndPositiveQualityOneLessThanMaxQuality_qualityIncreasedToMaxQuality() {
        GildedRose app = createGildedRoseWithOneItem("Backstage passes to a TAFKAL80ETC concert", 9, maxQuality -1);

        app.updateQuality();

        assertEquals(maxQuality, app.items[0].quality);
    }

    @Test
    public void updateQuality_backstagePasses9DaysBeforeExpirationDateAndMaxQuality_noEffectOnQuality() {
        GildedRose app = createGildedRoseWithOneItem("Backstage passes to a TAFKAL80ETC concert", 9, maxQuality);

        app.updateQuality();

        assertEquals(maxQuality, app.items[0].quality);
    }

    @Test
    public void updateQuality_backstagePasses6DaysBeforeExpirationDateAndNegativeQuality_qualityIncreasedByTwo() {
        GildedRose app = createGildedRoseWithOneItem("Backstage passes to a TAFKAL80ETC concert", 6, negativeQuality);

        app.updateQuality();

        assertEquals(negativeQuality+2, app.items[0].quality);
    }

    @Test
    public void updateQuality_backstagePasses6DaysBeforeExpirationDateAndPositiveQuality_qualityIncreasedByTwo() {
        GildedRose app = createGildedRoseWithOneItem("Backstage passes to a TAFKAL80ETC concert", 6, positiveQuality);

        app.updateQuality();

        assertEquals(positiveQuality+2, app.items[0].quality);
    }

    @Test
    public void updateQuality_backstagePasses6DaysBeforeExpirationDateAndPositiveQualityOneLessThanMaxQuality_qualityIncreasedToMaxQuality() {
        GildedRose app = createGildedRoseWithOneItem("Backstage passes to a TAFKAL80ETC concert", 6, maxQuality -1);

        app.updateQuality();

        assertEquals(maxQuality, app.items[0].quality);
    }

    @Test
    public void updateQuality_backstagePasses6DaysBeforeExpirationDateAndMaxQuality_noEffectOnQuality() {
        GildedRose app = createGildedRoseWithOneItem("Backstage passes to a TAFKAL80ETC concert", 6, maxQuality);

        app.updateQuality();

        assertEquals(maxQuality, app.items[0].quality);
    }

    @Test
    public void updateQuality_backstagePasses5DaysBeforeExpirationDateAndNegativeQuality_qualityIncreasedByThree() {
        GildedRose app = createGildedRoseWithOneItem("Backstage passes to a TAFKAL80ETC concert", 5, negativeQuality);

        app.updateQuality();

        assertEquals(negativeQuality+3, app.items[0].quality);
    }

    @Test
    public void updateQuality_backstagePasses5DaysBeforeExpirationDateAndPositiveQuality_qualityIncreasedByThree() {
        GildedRose app = createGildedRoseWithOneItem("Backstage passes to a TAFKAL80ETC concert", 5, positiveQuality);

        app.updateQuality();

        assertEquals(positiveQuality+3, app.items[0].quality);
    }

    @Test
    public void updateQuality_backstagePasses5DaysBeforeExpirationDateAndPositiveQualityOneLessThanMaxQuality_qualityIncreasedToMaxQuality() {
        GildedRose app = createGildedRoseWithOneItem("Backstage passes to a TAFKAL80ETC concert", 5, maxQuality -1);

        app.updateQuality();

        assertEquals(maxQuality, app.items[0].quality);
    }

    @Test
    public void updateQuality_backstagePasses5DaysBeforeExpirationDateAndMaxQuality_noEffectOnQuality() {
        GildedRose app = createGildedRoseWithOneItem("Backstage passes to a TAFKAL80ETC concert", 5, maxQuality);

        app.updateQuality();

        assertEquals(maxQuality, app.items[0].quality);
    }

    @Test
    public void updateQuality_backstagePasses4DaysBeforeExpirationDateAndNegativeQuality_qualityIncreasedByThree() {
        GildedRose app = createGildedRoseWithOneItem("Backstage passes to a TAFKAL80ETC concert", 4, negativeQuality);

        app.updateQuality();

        assertEquals(negativeQuality+3, app.items[0].quality);
    }

    @Test
    public void updateQuality_backstagePasses4DaysBeforeExpirationDateAndPositiveQuality_qualityIncreasedByThree() {
        GildedRose app = createGildedRoseWithOneItem("Backstage passes to a TAFKAL80ETC concert", 4, positiveQuality);

        app.updateQuality();

        assertEquals(positiveQuality+3, app.items[0].quality);
    }

    @Test
    public void updateQuality_backstagePasses4DayBeforeExpirationDateAndPositiveQualityOneLessThanMaxQuality_qualityIncreasedToMaxQuality() {
        GildedRose app = createGildedRoseWithOneItem("Backstage passes to a TAFKAL80ETC concert", 4, maxQuality -1);

        app.updateQuality();

        assertEquals(maxQuality, app.items[0].quality);
    }

    @Test
    public void updateQuality_backstagePasses4DaysBeforeExpirationDateAndMaxQuality_noEffectOnQuality() {
        GildedRose app = createGildedRoseWithOneItem("Backstage passes to a TAFKAL80ETC concert", 4, maxQuality);

        app.updateQuality();

        assertEquals(maxQuality, app.items[0].quality);
    }

    @Test
    public void updateQuality_backstagePasses1DayBeforeExpirationDateAndNegativeQuality_qualityIncreasedByThree() {
        GildedRose app = createGildedRoseWithOneItem("Backstage passes to a TAFKAL80ETC concert", 1, negativeQuality);

        app.updateQuality();

        assertEquals(negativeQuality+3, app.items[0].quality);
    }

    @Test
    public void updateQuality_backstagePasses1DayBeforeExpirationDateAndPositiveQuality_qualityIncreasedByThree() {
        GildedRose app = createGildedRoseWithOneItem("Backstage passes to a TAFKAL80ETC concert", 1, positiveQuality);

        app.updateQuality();

        assertEquals(positiveQuality+3, app.items[0].quality);
    }

    @Test
    public void updateQuality_backstagePasses1DayBeforeExpirationDateAndPositiveQualityOneLessThanMaxQuality_qualityIncreasedToMaxQuality() {
        GildedRose app = createGildedRoseWithOneItem("Backstage passes to a TAFKAL80ETC concert", 1, maxQuality -1);

        app.updateQuality();

        assertEquals(maxQuality, app.items[0].quality);
    }

    @Test
    public void updateQuality_backstagePasses1DayBeforeExpirationDateAndMaxQuality_noEffectOnQuality() {
        GildedRose app = createGildedRoseWithOneItem("Backstage passes to a TAFKAL80ETC concert", 1, maxQuality);

        app.updateQuality();

        assertEquals(maxQuality, app.items[0].quality);
    }

    // quality on expiration date

    @Test
    public void updateQuality_backstagePassesOnExpirationDateAndNegativeQuality_qualityIncreasedByThree() {
        GildedRose app = createGildedRoseWithOneItem("Backstage passes to a TAFKAL80ETC concert", 0, negativeQuality);

        app.updateQuality();

        assertEquals(negativeQuality+3, app.items[0].quality);
    }

    @Test
    public void updateQuality_backstagePassesOnExpirationDateAndPositiveQuality_minimumQuality() {
        GildedRose app = createGildedRoseWithOneItem("Backstage passes to a TAFKAL80ETC concert", 0, positiveQuality);

        app.updateQuality();

        assertEquals(minimumQuality, app.items[0].quality);
    }

    @Test
    public void updateQuality_backstagePassesOnExpirationDateAndPositiveQualityOneLessThanMaxQuality_minimumQuality() {
        GildedRose app = createGildedRoseWithOneItem("Backstage passes to a TAFKAL80ETC concert", 0, maxQuality -1);

        app.updateQuality();

        assertEquals(minimumQuality, app.items[0].quality);
    }

    @Test
    public void updateQuality_backstagePassesOnExpirationDateAndMaxQuality_minimumQuality() {
        GildedRose app = createGildedRoseWithOneItem("Backstage passes to a TAFKAL80ETC concert", 0, maxQuality);

        app.updateQuality();

        assertEquals(minimumQuality, app.items[0].quality);
    }

    // quality after expiration date

    @Test
    public void updateQuality_backstagePassesAfterExpirationDateWithNegativeQuality_minimumQuality() {
        GildedRose app = createGildedRoseWithOneItem("Backstage passes to a TAFKAL80ETC concert", afterExpirationDate, negativeQuality);

        app.updateQuality();

        assertEquals(minimumQuality, app.items[0].quality);
    }

    @Test
    public void updateQuality_backstagePassesAfterExpirationDateWithPositiveQuality_minimumQuality() {
        GildedRose app = createGildedRoseWithOneItem("Backstage passes to a TAFKAL80ETC concert", afterExpirationDate, positiveQuality);

        app.updateQuality();

        assertEquals(minimumQuality, app.items[0].quality);
    }

    @Test
    public void updateQuality_backstagePassesAfterExpirationDateWithOneLessThanMaxQuality_minimumQuality() {
        GildedRose app = createGildedRoseWithOneItem("Backstage passes to a TAFKAL80ETC concert", afterExpirationDate, maxQuality - 1);

        app.updateQuality();

        assertEquals(minimumQuality, app.items[0].quality);
    }

    @Test
    public void updateQuality_backstagePassesAfterExpirationDateWithMaximumQuality_minimumQuality() {
        GildedRose app = createGildedRoseWithOneItem("Backstage passes to a TAFKAL80ETC concert", afterExpirationDate, maxQuality);

        app.updateQuality();

        assertEquals(minimumQuality, app.items[0].quality);
    }

    @Test
    public void updateQuality_backstagePassesAfterExpirationDateWithHigherThanMaxQuality_minimumQuality() {
        GildedRose app = createGildedRoseWithOneItem("Backstage passes to a TAFKAL80ETC concert", afterExpirationDate, maxQuality + 5);

        app.updateQuality();

        assertEquals(minimumQuality, app.items[0].quality);
    }
    
    // conjured item
    @Test
    public void updateQuality_conjuredItem_correctName() {
        GildedRose app = createGildedRoseWithOneItem("ConjuredItem", 0, 0);

        app.updateQuality();

        assertEquals("ConjuredItem", app.items[0].name);
    }

    @Test
    public void updateQuality_conjuredItemLongBeforeExpirationDate_sellInOneLess() {
        GildedRose app = createGildedRoseWithOneItem("ConjuredItem", longBeforeExpirationDate, 0);

        app.updateQuality();

        assertEquals(longBeforeExpirationDate - 1, app.items[0].sellIn);
    }

    @Test
    public void updateQuality_conjuredItemBeforeExpirationDate_sellInOneLess() {
        GildedRose app = createGildedRoseWithOneItem("ConjuredItem", beforeExpirationDate, 0);

        app.updateQuality();

        assertEquals(beforeExpirationDate - 1, app.items[0].sellIn);
    }

    @Test
    public void updateQuality_conjuredItemOnExpirationDate_sellInOneLess() {
        GildedRose app = createGildedRoseWithOneItem("ConjuredItem", expirationDate, 0);

        app.updateQuality();

        assertEquals(expirationDate - 1, app.items[0].sellIn);
    }

    @Test
    public void updateQuality_conjuredItemAfterExpirationDate_sellInOneLess() {
        GildedRose app = createGildedRoseWithOneItem("ConjuredItem", afterExpirationDate, 0);

        app.updateQuality();

        assertEquals(afterExpirationDate - 1, app.items[0].sellIn);
    }

    @Test
    public void updateQuality_conjuredItemLongAfterExpirationDate_sellInOneLess() {
        GildedRose app = createGildedRoseWithOneItem("ConjuredItem", longAfterExpirationDate, 0);

        app.updateQuality();

        assertEquals(longAfterExpirationDate - 1, app.items[0].sellIn);
    }

    // quality before expiration date

    @Test
    public void updateQuality_conjuredItemLongBeforeExpirationDateAndNegativeQuality_qualityNotChanged() {
        GildedRose app = createGildedRoseWithOneItem("ConjuredItem", longBeforeExpirationDate, negativeQuality);

        app.updateQuality();

        assertEquals(negativeQuality, app.items[0].quality);
    }

    @Test
    public void updateQuality_conjuredItemBeforeExpirationDateAndNegativeQuality_qualityNotChanged() {
        GildedRose app = createGildedRoseWithOneItem("ConjuredItem", beforeExpirationDate, negativeQuality);

        app.updateQuality();

        assertEquals(negativeQuality, app.items[0].quality);
    }

    @Test
    public void updateQuality_conjuredItemBeforeExpirationDateAndAQualityOfOne_zeroQuality() {
        GildedRose app = createGildedRoseWithOneItem("ConjuredItem", beforeExpirationDate, 1);

        app.updateQuality();

        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void updateQuality_conjuredItemBeforeExpirationDateWithQualityThreeMoreThanMinimum_qualityDecreasedByTwo() {
        GildedRose app = createGildedRoseWithOneItem("ConjuredItem", beforeExpirationDate, minimumQuality + 3);

        app.updateQuality();

        assertEquals(minimumQuality + 1, app.items[0].quality);
    }

    @Test
    public void updateQuality_conjuredItemBeforeExpirationDateAndMaximumPositiveQuality_qualityDecreasedByTwo() {
        GildedRose app = createGildedRoseWithOneItem("ConjuredItem", beforeExpirationDate, maxQuality);

        app.updateQuality();

        assertEquals(maxQuality - 2, app.items[0].quality);
    }

    // quality on expiration date

    @Test
    public void updateQuality_conjuredItemOnExpirationDateWithQualityOneMoreThanMinimum_qualityDecreasedToMinimum() {
        GildedRose app = createGildedRoseWithOneItem("ConjuredItem", expirationDate, minimumQuality + 1);

        app.updateQuality();

        assertEquals(minimumQuality, app.items[0].quality);
    }

    @Test
    public void updateQuality_conjuredItemOnExpirationDateWithMaxQuality_qualityDecreasedByFour() {
        GildedRose app = createGildedRoseWithOneItem("ConjuredItem", expirationDate, maxQuality);

        app.updateQuality();

        assertEquals(maxQuality - 4, app.items[0].quality);
    }

    // quality after expiration date

    @Test
    public void updateQuality_conjuredItemAfterExpirationDateWithQualityOneMoreThanMinimum_qualityDecreasedToMinimum() {
        GildedRose app = createGildedRoseWithOneItem("ConjuredItem", afterExpirationDate, minimumQuality + 1);

        app.updateQuality();

        assertEquals(minimumQuality, app.items[0].quality);
    }

    @Test
    public void updateQuality_conjuredItemAfterExpirationDateWithOneLessThanMaxQuality_qualityDecreasedByFour() {
        GildedRose app = createGildedRoseWithOneItem("ConjuredItem", afterExpirationDate, maxQuality - 1);

        app.updateQuality();

        assertEquals(maxQuality - 5, app.items[0].quality);
    }

    @Test
    public void updateQuality_conjuredItemAfterExpirationDateWithMaxQuality_qualityDecreasedByFour() {
        GildedRose app = createGildedRoseWithOneItem("ConjuredItem", afterExpirationDate, maxQuality);

        app.updateQuality();

        assertEquals(maxQuality - 4, app.items[0].quality);
    }

    @Test
    public void updateQuality_conjuredItemAfterExpirationDateWithHigherThanMaxQuality_qualityDecreasedByFour() {
        GildedRose app = createGildedRoseWithOneItem("ConjuredItem", afterExpirationDate, maxQuality + 5);

        app.updateQuality();

        assertEquals(maxQuality + 1, app.items[0].quality);
    }


    // helper methods

    private GildedRose createGildedRoseWithOneItem(String itemName, int daysTillExpirationDate, int itemQuality) {
        items = new Item[]{new Item(itemName, daysTillExpirationDate, itemQuality)};
        return new GildedRose(items);
    }
    
}