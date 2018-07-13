import beverageorderingsystem.*;
public class Main {
    public static void main(String[] args){

        Cafe cafe = new Cafe();
        cafe.addBeverages(new BeverageCategory(BeverageType.HOT_BEVERAGE, new BeverageSubtype("Coffee", 18)));
        cafe.addItemToBeverageSubtype(BeverageType.HOT_BEVERAGE,"Coffee" , new Item("Cappuccino",50));
        cafe.addItemToBeverageSubtype(BeverageType.HOT_BEVERAGE,"Coffee", new Item("Expresso",30));


        cafe.addBeverages(new BeverageCategory(BeverageType.COLD_BEVERAGE));
        cafe.addBeverageSubtype(BeverageType.COLD_BEVERAGE, new BeverageSubtype("Cold-Drinks", 21));
        cafe.addItemToBeverageSubtype(BeverageType.COLD_BEVERAGE, "Cold-Drinks", new Item("Pepsi", 45));
    }
}
