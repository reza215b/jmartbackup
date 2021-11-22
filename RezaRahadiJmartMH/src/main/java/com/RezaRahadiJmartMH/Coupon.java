package com.RezaRahadiJmartMH;


import com.RezaRahadiJmartMH.dbjson.Serializable;

/**
 * Write a description of class Coupon here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Coupon extends Serializable
{
    public static enum Type{
        DISCOUNT, REBATE;
    }
    public final int code;
    public final double cut;
    public final double minimum;
    public final String name;
    public final Type type;
    private boolean used;

    public Coupon(String name, int code, Type type, double cut, double minimum)
    {
        this.name = name;
        this.code = code;
        this.type = type;
        this.cut = cut;
        this.minimum = minimum;
    }
    public double apply(double price, double discount){
        /*
        used = true;
        if(this.type == Type.DISCOUNT){
            return (pricetag.getAdjustedPrice() - (pricetag.getAdjustedPrice()*(cut/100)));
        }else{
            return (pricetag.getAdjustedPrice()- cut);
         */
        return 0.0f;
        }

    public boolean canApply(double price, double discount){
        /*
         if ((pricetag.getAdjustedPrice() >= minimum) && (used = false)){
             return true;
            }
            else{
                return false;
            }
         */
        return false;
        }
    
    public boolean isUsed(){
        return used;
    }

}
