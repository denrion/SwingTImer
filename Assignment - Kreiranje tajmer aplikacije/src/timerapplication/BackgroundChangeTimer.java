package timerapplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackgroundChangeTimer {

    private Timer t;
    private Timer t1;
    private JFrame window;
    private int interval;
    private long delay;
    private Color chosenColor;

    public void startTimer(JFrame window, int interval, long delay, Color chosenColor) {
        t = new Timer(interval, (ActionEvent e) -> {
            window.setVisible(true);
        });
        t.setInitialDelay((int) delay);
        t.setRepeats(false);
        t.start();

        t1 = new Timer(interval, new ActionListener() {
            boolean white = false;

            @Override
            public void actionPerformed(ActionEvent e) {
                window.getContentPane().setBackground(white ? Color.WHITE : chosenColor);
                white = !white;
            }
        });
        t1.start();
    }

    public void stopTimer(Timer t, Timer t1) {
        if (t.isRunning()) {
            t.stop();
        } 
        if (t1.isRunning()) {
            t1.stop();
        } 
    }

    public Timer getT() {
        return t;
    }

    public Timer getT1() {
        return t1;
    }

    public JFrame getWindow() {
        return window;
    }

    public int getInterval() {
        return interval;
    }

    public long getDelay() {
        return delay;
    }

    public Color getChosenColor() {
        return chosenColor;
    }
}
