package com.gildedrose;

enum Label {
    SULFURAS("Sulfuras, Hand of Ragnaros"),
    AGED_BRIE("Aged Brie"),
    BACKSTAGE("Backstage passes to a TAFKAL80ETC concert");


    private final String value;

    Label(String value) {
        this.value = value;
    }

    public boolean matches(String name){
        return this.value.equals(name);
    }
}
