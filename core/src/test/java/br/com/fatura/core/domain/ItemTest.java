package br.com.fatura.core.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    private Item item;

    @Test
    public void testConstructorWithAllParameters() {
        item = new Item("1", "2021-01-01", "Item 1", 10.0);
        assertEquals("1", item.getId());
        assertEquals("2021-01-01", item.getDate());
        assertEquals("Item 1", item.getDescription());
        assertEquals(10.0, item.getValue());
    }

    @Test
    public void testConstructorWithoutId() {
        item = new Item("2021-01-01", "Item 1", 10.0);
        assertNull(item.getId());
        assertEquals("2021-01-01", item.getDate());
        assertEquals("Item 1", item.getDescription());
        assertEquals(10.0, item.getValue());
    }

    @Test
    public void testEmptyConstructor() {
        item = new Item();
        assertNull(item.getId());
        assertNull(item.getDate());
        assertNull(item.getDescription());
        assertEquals(0.0, item.getValue());
    }


}