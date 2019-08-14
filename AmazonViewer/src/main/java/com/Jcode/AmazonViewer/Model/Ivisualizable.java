package com.Jcode.AmazonViewer.Model;
import java.util.Date;

public interface Ivisualizable {

    // startToSee
    // stopToSee
    // Date = return value ; 
    // dataI = initial date ;  dataF = final date

    // declaration of methods
    Date startToSee(Date dateI);
    void stopToSee(Date dateI, Date dateF);

}