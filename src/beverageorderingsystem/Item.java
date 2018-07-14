package beverageorderingsystem;

public class Item {

    private String itemName;
    private double price;

    public Item(String itemName, double price){
        this.itemName = itemName;
        this.price = price;
    }
    public String getItemName() {
        return itemName;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public double getPrice() {
        return price;
    }

    public String getInfo() {
        return itemName + " - Rs" + price;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (!(obj instanceof Item))
            return false;
        Item item = (Item) obj;
        if (this.itemName.equals(item.itemName) && this.price == item.price)
            return true;
        return false;
    }
}
