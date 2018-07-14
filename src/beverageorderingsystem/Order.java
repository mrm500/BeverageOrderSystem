package beverageorderingsystem;

import java.util.List;

public class Order {

    private Item item;
    private int quantity;
    private double tax;

    public Order(Item item, int quantity, double tax){
        this.item = item;
        this.quantity = quantity;
        this.tax = tax;
    }
    public Item getItem() {
        return item;
    }
    public int getQuantity() {
        return quantity;
    }
    public double getTax() {
        return tax;
    }
    void addQuantity(int quantity){
        this.quantity += quantity;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (!(obj instanceof Order))
            return false;
        if (this.getItem().equals(((Order) obj).getItem()))
            return true;
        return false;
    }
}
