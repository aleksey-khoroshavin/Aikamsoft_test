package ru.aikamsoft.result;

import ru.aikamsoft.entity.Customer;
import ru.aikamsoft.entity.CustomerPurchases;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class StatResult extends Result{

    private int totalDays;

    private List<CustomerPurchases> customersPurchases;

    private int totalExpenses = 0;

    private double avgExpenses;

    public StatResult(){
        super();
        setType("stat");
    }

    public int getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(int totalDays) {
        this.totalDays = totalDays;
    }

    public int getTotalExpenses() {
        return totalExpenses;
    }

    public void countTotalExpenses(){
        for(CustomerPurchases customerPurchases : customersPurchases){
            totalExpenses += customerPurchases.getCustomerTotalExpenses();
        }
    }

    public void setTotalExpenses(int totalExpenses) {
        this.totalExpenses = totalExpenses;
    }

    public void countAvgExpenses(){
        avgExpenses = totalExpenses/(double) customersPurchases.size();
    }

    public double getAvgExpenses() {
        BigDecimal decimal = BigDecimal.valueOf(avgExpenses);
        BigDecimal rounded = decimal.setScale(2, RoundingMode.HALF_EVEN);
        return rounded.doubleValue();
    }

    public void setAvgExpenses(double avgExpenses) {
        this.avgExpenses = avgExpenses;
    }

    public List<CustomerPurchases> getCustomersPurchases() {
        return customersPurchases;
    }

    public void setCustomersPurchases(List<CustomerPurchases> customersPurchases) {
        this.customersPurchases = customersPurchases;
    }
}
