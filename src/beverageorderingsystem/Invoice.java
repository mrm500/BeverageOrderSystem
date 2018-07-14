package beverageorderingsystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Invoice {
    private List<Order> orders = new ArrayList<>();
    private double total = 0;
    private double tax = 0;
    private double net = 0;
    private void addOrder(Order order){
        for (Order temp: orders){
            if (temp.equals(order)) {
                temp.addQuantity(1);
                return;
            }
        }
        this.orders.add(order);
    }

    public void placeOrder(Cafe cafe,String order){
        List<String> ordersString = Arrays.asList(order.split(","));
        List<Integer> orders = new ArrayList<>();
        for (String s : ordersString)
            orders.add(Integer.parseInt(s));

        int counter = 0;
        for (Integer orderNumber : orders) {
            for (BeverageCategory beverageCategory : cafe.getBeverages()) {
                if (counter + beverageCategory.size() >= orderNumber){
                    for (BeverageSubCategory beverageSubCategory : beverageCategory.getBeverageSubCategories()){
                        if (counter + beverageSubCategory.size() >= orderNumber){
                            // Index out of bound exception.
                            addOrder(new Order(beverageSubCategory.getItems().get(orderNumber-counter-1),1, beverageSubCategory.getTax()));
                            break;
                        }
                        counter += beverageSubCategory.size();
                    }
                    break;
                }
                counter += beverageCategory.size();
            }
        }
        calcPrice();
    }
    private void calcPrice(){
        for (Order order : orders){
            this.total += order.getQuantity()*order.getItem().getPrice();
            this.tax += order.getQuantity()*order.getItem().getPrice()*order.getTax()/100;
        }
        this.net = this.total + this.tax;
    }
    public void printBill(){
        System.out.println("\n\n---------------------------------------------");
        System.out.printf("\n%4s\t%-15s\t%10s\t%6s\n","No","Item","Quantity","Price");
        for (int i = 0; i < this.orders.size(); i++){
            System.out.printf("%4d\t%-15s\t%10d\t%6.2f\n",i+1,orders.get(i).getItem().getItemName(),orders.get(i).getQuantity(),orders.get(i).getQuantity()*orders.get(i).getItem().getPrice());
        }
        System.out.println("\n---------------------------------------------");
        System.out.printf("%22s%20.2f\n","Total",this.total);
        System.out.printf("%22s%20.2f\n","Tax",this.tax);
        System.out.println("---------------------------------------------");
        System.out.printf("%22s%20.2f\n","Net",this.net);
    }
}
