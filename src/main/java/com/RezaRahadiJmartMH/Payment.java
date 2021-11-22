package com.RezaRahadiJmartMH;
import java.util.Date;
import java.util.ArrayList;

public class Payment extends Invoice
{
    // instance variables - replace the example below with your own
    public ArrayList<Record> history = new ArrayList<>();
    public int productCount;
    public Shipment shipment;

    static class Record {
        public final Date date;
        public String message;
        public Status status;

        public Record(Status status, String message) {
            this.date = new Date();
            this.status = status;
            this.message = message;
        }
    }


    public Payment(int buyerId,int productId,int productCount, Shipment shipment)
    {
        super(buyerId, productId);
        this.productCount = productCount;
        this.shipment = shipment;
    }

    public double getTotalPay(Product product){
        return product.price;
    }
}
