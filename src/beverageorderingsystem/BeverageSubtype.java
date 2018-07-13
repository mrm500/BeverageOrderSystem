package beverageorderingsystem;

import java.util.List;

public class BeverageSubtype {

    private String beverageSubtypeName;
    private double tax;

    public BeverageSubtype(String beverageSubtypeName, double tax) {
        this.beverageSubtypeName = beverageSubtypeName;
        this.tax = tax;
    }

    public String getBeverageSubtypeName() {
        return beverageSubtypeName;
    }

    public double getTax() {
        return tax;
    }
    public void setTax(double tax) {
        this.tax = tax;
    }
}
