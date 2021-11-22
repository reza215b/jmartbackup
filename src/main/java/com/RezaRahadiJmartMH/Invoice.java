package com.RezaRahadiJmartMH;
import com.RezaRahadiJmartMH.dbjson.Serializable;

import java.util.Date;


/**
 * Write a description of class Invoice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Invoice extends Serializable
{
    // instance variables - replace the example below with your own

    public int buyerId;
    public int complaintId;
    public final Date date;
    public int productId;
    public Rating rating;


    protected Invoice(int buyerId, int productId)
    {
        this.buyerId = buyerId;
        this.productId = productId;
        this.date = new Date();
        this.rating = Rating.NONE;
        this.complaintId = -1;
    }

    public double getTotalPay(Product product) {
        return product.price;
    }

    public static enum Status {
        CANCELLED,
        COMPLAINT,
        DELIVERED,
        FAILED,
        FINISHED,
        ON_DELIVERY,
        ON_PROGRESS,
        WAITING_CONFIRMATION
    }

    public static enum Rating {
        BAD,
        GOOD,
        NEUTRAL,
        NONE
    }


}