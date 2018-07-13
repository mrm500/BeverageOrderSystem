package beverageorderingsystem;


public class BeverageSubtype implements Comparable<BeverageSubtype> {

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

    @Override
    public int compareTo(BeverageSubtype o) {
        return this.beverageSubtypeName.compareTo(o.getBeverageSubtypeName());
    }
}
