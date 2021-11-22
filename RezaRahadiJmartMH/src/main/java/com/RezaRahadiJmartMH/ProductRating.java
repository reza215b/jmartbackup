package com.RezaRahadiJmartMH;


/**
 * Write a description of class ProductRating here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ProductRating
{
    private long total;
    private long count;
    
    public ProductRating()
    {
        total = 0;
        count = 0;
    }

    public double getAverage()
    {
        if (count > 0){
        double average = total / count;
        return average;
        }
        else{
            return 0;
        }
    }
    
    public long getCount(){
        return count;
    }
    
    public long getTotal(){
        return total;
    }

    public void insert(int rating){
        total = rating + total;
        count = count + 1;
    }
}
