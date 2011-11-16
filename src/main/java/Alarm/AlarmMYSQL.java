/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Alarm;

import Database.UsersSQL;
import com.manuwebdev.mirageobjectlibrary.Alarm.Alarm;
import com.manuwebdev.mirageobjectlibrary.Authentication.User;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author manuel
 */
public class AlarmMYSQL {
    
    /**
     * Adds Alarm to MYSQL server
     * 
     * @param conn Connection to MYSQL Server
     * @param a Alarm Object to add to database
     */
    public static void addAlarm(Connection conn,Alarm a){
        
        try {
            PreparedStatement p=conn.prepareStatement("INSERT INTO ALARMS (ALARMHOUR,ALARMMINUTE,USER,MESSAGE,ALARMSECOND) VALUES(?,?,?,?,?)");
            p.setInt(1, a.getAlarmHour());
            p.setInt(2, a.getAlarmMinute());
            p.setString(3,a.getAlarmUser().getUserName());
            p.setString(4, a.getAlarmMessage());
            p.setInt(5, 0);
            p.executeUpdate();
            System.out.println("Alarm added by "+a.getAlarmUser().getUserName());
            } catch (SQLException ex) {
            Logger.getLogger(AlarmMYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Returns an ArrayList which contains Alarms that
     * trigger at the hour specified.
     * 
     * @param conn Connection to MYSQL Server
     * @param Hour Hour of Alarms to be requested
     * @return ArrayList with alarms
     */
    public static ArrayList<Alarm> getAlarmsByHour(Connection conn,int Hour){
        System.out.println("Alarms Requested By Hour");
        ArrayList<Alarm> a=new ArrayList<Alarm>();
        Alarm alarm;
        try {
            PreparedStatement p=conn.prepareStatement("SELECT * FROM ALARMS WHERE HOUR=?");
            p.setInt(1, Hour);
            ResultSet r=p.executeQuery();
            while(r.next()){
                int AlarmHour=r.getInt("ALARMHOUR");
                int AlarmMinute=r.getInt("ALARMMINUTE");
                User u=UsersSQL.getUserObject(r.getString("USER"), conn);
                String Message=r.getString("MESSAGE");
                
                alarm=new Alarm(AlarmHour,AlarmMinute,Message,u);
                
                a.add(alarm);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlarmMYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }
    
    /**
     * Returns an ArrayList which contains Alarms that
     * trigger at the hour specified and were created 
     * by the specified User.
     * 
     * @param conn Connection to MYSQL Server
     * @param Hour Hour of Alarms to be requested
     * @param user User of Alarms to be requested
     * @return ArrayList with alarms
     * @return 
     */
    public static ArrayList<Alarm> getAlarmsByHourAndUser(Connection conn,int Hour,User user){
        System.out.println("Alarms Requested By Hour");
        ArrayList<Alarm> a=new ArrayList<Alarm>();
        Alarm alarm;
        try {
            PreparedStatement p=conn.prepareStatement("SELECT * FROM ALARMS WHERE HOUR=? AND USER=?");
            p.setInt(1, Hour);
            p.setString(2, user.getUserName());
            ResultSet r=p.executeQuery();
            while(r.next()){
                int AlarmHour=r.getInt("ALARMHOUR");
                int AlarmMinute=r.getInt("ALARMMINUTE");
                User u=UsersSQL.getUserObject(r.getString("USER"), conn);
                String Message=r.getString("MESSAGE");
                
                alarm=new Alarm(AlarmHour,AlarmMinute,Message,u);
                
                a.add(alarm);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlarmMYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }
}
