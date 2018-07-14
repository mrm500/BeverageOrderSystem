package beverageorderingsystem;

import java.util.ArrayList;
import java.util.List;

public class BeverageSubCategory {

    private BeverageSubtype beverageSubtype;
    private double tax;
    private List<Item> itemList = new ArrayList<>();

    public BeverageSubCategory(BeverageSubtype beverageSubtype, double tax){
        this.beverageSubtype = beverageSubtype;
        this.tax = tax;
    }
    public BeverageSubCategory(BeverageSubtype beverageSubtype, double tax, List<Item> itemList){
        this.beverageSubtype = beverageSubtype;
        this.tax = tax;
        this.itemList.addAll(itemList);
    }
    public BeverageSubtype getBeverageSubtype() {
        return beverageSubtype;
    }
    public void addItem(Item item){
        this.itemList.add(item);
    }
    public void removeItem(Item item){
        this.itemList.remove(item);
    }

    public void addItems(List<Item> itemList) {
        this.itemList.addAll(itemList);
    }

    public List<Item> getItems() {
        return itemList;
    }
    public int size(){
        return itemList.size();
    }

    public double getTax() {
        return tax;
    }
}
