//package SimpleClock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class SimpleClock extends JFrame {
    
        Calendar calendar;
        SimpleDateFormat timeFormat;
        SimpleDateFormat dayFormat;
        SimpleDateFormat dateFormat;
    
        JLabel timeLabel;
        JLabel dayLabel;
        JLabel dateLabel;
        String time;
        String day;
        String date;
//since simple clock extends Jframe create new instance
        SimpleClock() {
            //set a layout,dimension and title
            //ensure Xbutton works
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setTitle("Digital Clock");
            this.setLayout(new FlowLayout());
            this.setSize(1000, 500);
            this.setResizable(false);
            JPanel panel=new JPanel();
            JButton button=new JButton("SWITCH");
    
            timeFormat = new SimpleDateFormat("hh:mm:ss a");

            dayFormat=new SimpleDateFormat("EEEE");
            dateFormat=new SimpleDateFormat("dd MMMMM, yyyy");
            timeLabel = new JLabel();
            timeLabel.setFont(new Font("SANS_SERIF", Font.PLAIN, 59));
            timeLabel.setBackground(Color.BLACK);
            timeLabel.setForeground(Color.WHITE);
            timeLabel.setOpaque(true);
            dayLabel=new JLabel();
            dayLabel.setFont(new Font("Ink Free",Font.BOLD,34));
    
            dateLabel=new JLabel();
            dateLabel.setFont(new Font("Ink Free",Font.BOLD,30));

            button.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(timeFormat.toPattern().equals("hh:mm:ss a"))
                    {
                        timeFormat.applyPattern("HH:mm:ss a");
                    }else {
                        timeFormat.applyPattern("hh:mm:ss a");
                    }
                }

            });
    
            this.add(timeLabel);
            this.add(dayLabel);
            this.add(dateLabel);
            panel.add(button);
            this.add(panel);
            this.setVisible(true);
    
            setTimer();
        }
    
        public void setTimer() {
            while (Thread.currentThread().isAlive()) {
                time = timeFormat.format(Calendar.getInstance().getTime());
                timeLabel.setText(time);

                time = timeFormat.format(Calendar.getInstance().getTime());
                timeLabel.setText(time);

                day = dayFormat.format(Calendar.getInstance().getTime());
                dayLabel.setText(day);
    
                date = dateFormat.format(Calendar.getInstance().getTime());
                dateLabel.setText(date);
    
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.getStackTrace();
                }
            }
        }
        public static void main(String[] args) {
            new SimpleClock();
        }
    }
