/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Toan
 */
public class Clock implements Runnable{
    JLabel time;

    public Clock(JLabel time) {
        this.time = time;
    }
    
    @Override
    public void run() {
        while(true){
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm aa");
            time.setText(sdf.format(date));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    
}
