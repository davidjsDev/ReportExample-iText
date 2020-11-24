package com.davidjsdev.model;

public class ItemSale {
    private double quantity;
    private String description;
    private double priceUnit;
    private double amount;

    public ItemSale(){

    }

    public ItemSale(double quantity, String description, double priceUnit) {
        this.quantity = quantity;
        this.description = description;
        this.priceUnit = priceUnit;
        this.amount = quantity * priceUnit;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(double priceUnit) {
        this.priceUnit = priceUnit;
    }

    public double getAmount() {
        return amount;
    }


    @Override
    public String toString() {
        return "ItemSale{" +
                "quantity='" + quantity + '\'' +
                ", description='" + description + '\'' +
                ", priceUnit='" + priceUnit + '\'' +
                ", amount='" + amount + '\'' +
                '}' + "\n";
    }
}
