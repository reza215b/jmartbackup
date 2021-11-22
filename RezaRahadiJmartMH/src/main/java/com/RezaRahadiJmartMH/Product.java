package com.RezaRahadiJmartMH;


/**
 * Write a description of class Product here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Product
{
    // instance variables - replace the example below with your own
   public int accountId;
   public ProductCategory category;
   public boolean conditionUsed;
   public double discount;
   public String name;
   public double price;
   public byte shipmentPlans;
   public int weight;

    public static enum ProductCategory{
        BOOK, KITCHEN, ELECTRONIC, FASHION, GAMING, GADGET, MOTHERCARE,
        COSMETICS, HEALTHCARE, FURNITURE, JEWELRY, TOYS, FNB, STATIONERY,
        SPORTS, AUTOMOTIVE, PETCARE, ART_CRAFT, CARPENTRY, MISCELLANEOUS, 
        PROPERTY, TRAVEL, WEDDING
        }
    
    public Product(int accountId, String name, int weight, boolean conditionUsed, double price, double discount, ProductCategory category, byte shipmentPlans)
    {
        this.accountId = accountId;
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.price = price;
        this.discount = discount;
        this.category = category;
        this.shipmentPlans = shipmentPlans;
    }

    public String toString() {
        return 
        "Name: " + this.name +
        "\nWeight: " + this.weight +
        "\nconditionUsed: " + this.conditionUsed +
        /*"\npriceTag: " + this.priceTag + */
        "\ncategory: " + this.category;
        /*"\nstoreId: " + this.storeId; */
    }
}
