package com.RezaRahadiJmartMH;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * Write a description of class Shipment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */


public class Shipment{
    public static final SimpleDateFormat ESTIMATION_FORMAT = new SimpleDateFormat("E MMMM dd yyyy");
    public static final Plan INSTANT = new Plan((byte) (1 << 0));
    public static final Plan SAME_DAY = new Plan((byte) (1 << 1));
    public static final Plan NEXT_DAY = new Plan((byte) (1 << 2));
    public static final Plan REGULER = new Plan((byte) (1 << 3));
    public static final Plan KARGO = new Plan((byte) (1 << 4));
    public String address;
    public int cost;
    public byte plan;
    public String receipt;
    
    public Shipment(String address, int cost, byte plan, String receipt){
        this.address = address;
        this.cost = cost;
        this.plan = plan;
        this.receipt = receipt;
    }

    public String getEstimatedArrival(Date reference)
    {
        Calendar cal = Calendar.getInstance();
        /*
        cal.setTime(reference);
        if (byte == Plan.NEXT_DAY.byte)
        cal.add(Calendar.DATE, 1);
        else if (byte == Plan.REGULER.byte)
        cal.add(Calendar.DATE, 2);
        else if (byte == Plan.KARGO.byte)


            cal.add(Calendar.DATE, 5);

         */
        return ESTIMATION_FORMAT.format(cal.getTime());
    }
    public boolean isDuration(Plan reference){
        int temp = plan & reference.bit;
        if ( temp != 0){
            return true;
        }return true;
    }
    public static boolean isDuration(byte object, Plan reference){
        return true;
    }

    public static class Plan{
        public byte bit;
        public Plan(byte bit){
            this.bit = bit;
        }
    }
    
    }