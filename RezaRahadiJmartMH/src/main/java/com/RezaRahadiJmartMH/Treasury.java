package com.RezaRahadiJmartMH;


/**
 * Write a description of class PriceTag here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Treasury
{
    public static final double BOTTOM_FEE = 1000.0;
    public static final double BOTTOM_PRICE = 20000.0;
    public static final double COMMISSION_MULTIPLIER = 0.05;

    public static double getAdjustedPrice(){
        return getDiscountedPrice() + getAdminFee();
    }
    
    public static double getAdminFee(){
        if ( getDiscountedPrice() < BOTTOM_PRICE){
            return BOTTOM_FEE;
        }
        else{
            return getDiscountedPrice() * 0.05;
        }
        
    }
    
    private static double getDiscountedPrice(){
        /*
        if (discount > 100.0f){
            return 100.0f;
        }
        else if (discount == 100.0f){
            return 0.0f;
        }
        else {
            return price - (price * discount/100);

         */
        return 0.0f;
        }
    }
