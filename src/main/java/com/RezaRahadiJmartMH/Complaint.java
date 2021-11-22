package com.RezaRahadiJmartMH;
import com.RezaRahadiJmartMH.dbjson.Serializable;

import java.util.Date;

public class Complaint extends Serializable
{
    // instance variables - replace the example below with your ow
    public String desc;
    public Date date;

    public Complaint(String desc){
    this.desc = desc;
    }

    public String toString(){
        return
        "date = " +date+
        "desc = " +this.desc;
    }
}
