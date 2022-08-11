package ru.aikamsoft.entity;

import java.util.LinkedHashMap;
import java.util.Map;

public class CustomerPurchases{
    private Customer customer;
    private final Map<Product, Integer> customerPurchasesPerProducts = new LinkedHashMap<>();

    private int customerTotalExpenses = 0;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Map<Product, Integer> getCustomerPurchasesPerProducts() {
        return customerPurchasesPerProducts;
    }

    public void countCustomerTotalExpenses(){
        for(Map.Entry<Product, Integer> entry : customerPurchasesPerProducts.entrySet()){
            customerTotalExpenses += entry.getValue();
        }
    }

    public int getCustomerTotalExpenses() {
        return customerTotalExpenses;
    }
}
