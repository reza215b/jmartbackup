package com.RezaRahadiJmartMH;

public class PhoneTopUp extends Invoice{
    public String phoneNumber;
    public Invoice.Status status;

    public PhoneTopUp(int buyerId, int productid, String phoneNumber){
        super(buyerId, productid);
        this.phoneNumber = phoneNumber;
    }
    public double getTotalPay(Product product) {
        return product.price;
    }

}
