package com.gildedrose;
import static org.junit.Assert.*;

import org.approvaltests.Approvals;
import org.junit.Ignore;
import org.junit.Test;

public class GildedRoseTest {

    @Test
    @Ignore
    public void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("fixme", app.items[0].name);
    }

    @Test
    public void goldenMasterTest() {
        String [] args = {};
        Approvals.verify(stringRepresentationOfRun(args));
    }

    private String stringRepresentationOfRun(String[] args) {
        StringBuilder output = new StringBuilder();
        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6) };

        GildedRose app = new GildedRose(items);

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            output.append("-------- day " + i + " --------").append("\r");
            output.append("name, sellIn, quality").append("\r");
            for (Item item : items) {
                output.append(item).append("\r");
            }
            app.updateQuality();
        }
        return output.toString();
    }
}
