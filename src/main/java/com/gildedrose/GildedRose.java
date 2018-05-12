package com.gildedrose;

class GildedRose {
    private static final int MAX_QUALITY = 50;
    private static final int QUALITY_FIRST_CAP = 10;
    private static final int QUALITY_SECOND_CAP = 5;
    private static final String AGED_BRIE = "Aged Brie";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    final Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    void updateQuality() {
        for (Item item : items) {
            switch (item.name) {

                case SULFURAS:
                    break;

                case AGED_BRIE:
                    increaseQualityOf(item);
                    decreaseSellInOf(item);
                    if (item.sellIn < 0) {
                        increaseQualityOf(item);
                    }
                    break;

                case BACKSTAGE:
                    increaseQualityOf(item);
                    if (item.sellIn <= QUALITY_FIRST_CAP) {
                        increaseQualityOf(item);
                    }

                    if (item.sellIn <= QUALITY_SECOND_CAP) {
                        increaseQualityOf(item);
                    }

                    decreaseSellInOf(item);

                    if (item.sellIn < 0) {
                        item.quality = 0;
                    }
                    break;

                default:
                    decreaseQualityOf(item);
                    decreaseSellInOf(item);
                    if (item.sellIn < 0) {
                        decreaseQualityOf(item);
                    }
                    break;
            }
        }
    }

    private void decreaseSellInOf(Item item) {
        item.sellIn -= 1;
    }

    private void increaseQualityOf(Item item) {
        if (item.quality < MAX_QUALITY) {
            item.quality += 1;
        }
    }

    private void decreaseQualityOf(Item item) {
        if (item.quality > 0) {
            item.quality -= 1;
        }
    }

}