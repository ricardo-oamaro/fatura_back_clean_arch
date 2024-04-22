package br.com.fatura.core.domain.item;

import java.util.Objects;

public class Item {

    private String id;
    private String date;
    private String description;
    private double value;

    public Item(String id, String date, String description, double value) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.value = value;
    }

    public Item(String date, String description, double value) {
        this.date = date;
        this.description = description;
        this.value = value;
    }

    public Item() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Double.compare(value, item.value) == 0 && Objects.equals(id, item.id) && Objects.equals(date, item.date) && Objects.equals(description, item.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, description, value);
    }
}
