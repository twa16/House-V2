/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Time;



import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Manuel
 */
public class Time {



    public static String getMinuteString(){
       Date todaysDate = new java.util.Date();
        SimpleDateFormat formatter = new SimpleDateFormat("mm");
        String formattedDate = formatter.format(todaysDate);
        String MinuteString;
        return formattedDate;
   }
    
    public static int getMinuteInteger(){
       Date todaysDate = new java.util.Date();
        SimpleDateFormat formatter = new SimpleDateFormat("mm");
        String formattedDate = formatter.format(todaysDate);
        int Minute=Integer.parseInt(formattedDate);
        return Minute;
    }
    
    public static int getHourInteger(){
        int Hour12=12;
        int Hour;
        Date todaysDate = new java.util.Date();
        SimpleDateFormat formatter = new SimpleDateFormat("HH");
        String formattedDate = formatter.format(todaysDate);
        Hour=Integer.parseInt(formattedDate);
        switch(Hour){
            case 0: Hour12=12;break;
            case 1: Hour12=1;break;
            case 2: Hour12=2;break;
            case 3: Hour12=3;break;
            case 4: Hour12=4;break;
            case 5: Hour12=5;break;
            case 6: Hour12=6;break;
            case 7: Hour12=7;break;
            case 8: Hour12=8;break;
            case 9: Hour12=9;break;
            case 10: Hour12=10;break;
            case 11: Hour12=11;break;
            case 12: Hour12=12;break;
            case 13: Hour12=1;break;
            case 14: Hour12=2;break;
            case 15: Hour12=3;break;
            case 16: Hour12=4;break;
            case 17: Hour12=5;break;
            case 18: Hour12=6;break;
            case 19: Hour12=7;break;
            case 20: Hour12=8;break;
            case 21: Hour12=9;break;
            case 22: Hour12=10;break;
            case 23: Hour12=11;break;
        }
    return Hour12;
    }

    public static int getHourInteger24(){
        int Hour;
        Date todaysDate = new java.util.Date();
        SimpleDateFormat formatter = new SimpleDateFormat("HH");
        String formattedDate = formatter.format(todaysDate);
        Hour=Integer.parseInt(formattedDate);
        return Hour;
    }

    public static String getHourString(){
        String Hour12="12";
        int Hour;
        Date todaysDate = new java.util.Date();
        SimpleDateFormat formatter = new SimpleDateFormat("HH");
        String formattedDate = formatter.format(todaysDate);
        Hour=Integer.parseInt(formattedDate);
        switch(Hour){
            case 0: Hour12="twelve";break;
            case 1: Hour12="1";break;
            case 2: Hour12="2";break;
            case 3: Hour12="3";break;
            case 4: Hour12="4";break;
            case 5: Hour12="5";break;
            case 6: Hour12="6";break;
            case 7: Hour12="7";break;
            case 8: Hour12="8";break;
            case 9: Hour12="9";break;
            case 10: Hour12="ten";break;
            case 11: Hour12="eleven";break;
            case 12: Hour12="twelve";break;
            case 13: Hour12="1";break;
            case 14: Hour12="2";break;
            case 15: Hour12="3";break;
            case 16: Hour12="4";break;
            case 17: Hour12="5";break;
            case 18: Hour12="6";break;
            case 19: Hour12="7";break;
            case 20: Hour12="8";break;
            case 21: Hour12="9";break;
            case 22: Hour12="ten";break;
            case 23: Hour12="eleven";break;
        }
    return Hour12;
    }
    public static String getTimeStamp(){
        return getHourInteger24()+String.valueOf(getMinuteInteger());
    }
}
