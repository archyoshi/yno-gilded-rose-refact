package com.gildedrose;

import static com.gildedrose.Label.*;

class GildedRose {
    private static final int QUALITY_MAX_CAP = 50;
    private static final int QUALITY_FIRST_CAP = 10;
    private static final int QUALITY_SECOND_CAP = 5;
    final Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    void updateQuality() {
        for (Item item : items) {
            if (SULFURAS.matches(item.name)) {
            } else if (AGED_BRIE.matches(item.name)) {
                increaseQualityOf(item);
                decreaseSellInOf(item);
                if (item.sellIn < 0) {
                    increaseQualityOf(item);
                }

            } else if (BACKSTAGE.matches(item.name)) {
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

            } else {
                decreaseQualityOf(item);
                decreaseSellInOf(item);
                if (item.sellIn < 0) {
                    decreaseQualityOf(item);
                }

            }
        }
    }

    private void decreaseSellInOf(Item item) {
        item.sellIn -= 1;
    }

    private void increaseQualityOf(Item item) {
        if (item.quality < QUALITY_MAX_CAP) {
            item.quality += 1;
        }
    }

    private void decreaseQualityOf(Item item) {
        if (item.quality > 0) {
            item.quality -= 1;
        }
    }

}