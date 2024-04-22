import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class RelojAntonio extends JLabel implements Serializable {

    private Timer timer;
    private LocalTime localTime;
    private boolean formato12_24;
    private boolean alarma;
    private int horaAlarma;
    private int minutoAlarma;
    private String mensajeAlarma;

    private TimerTask task;


    public RelojAntonio() {
        this.formato12_24=true;
        this.localTime=LocalTime.now();
        this.alarma=true;
        this.horaAlarma=0;
        this.minutoAlarma=0;
        this.mensajeAlarma="Ya es hora de levantarse";

    }

    public RelojAntonio(Timer timer, LocalTime localTime, boolean formato12_24, boolean alarma, int horaAlarma, int minutoAlarma, String mensajeAlarma) {
        this.timer = timer;
        this.localTime = localTime;
        this.formato12_24 = formato12_24;
        this.alarma=alarma;
        this.horaAlarma=horaAlarma;
        this.minutoAlarma=minutoAlarma;
        this.mensajeAlarma=mensajeAlarma;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public LocalTime getLocalTime() {
        return localTime;
    }

    public void setLocalTime(LocalTime localTime) {
        this.localTime = localTime;
    }

    public boolean isFormato12_24() {
        return formato12_24;
    }

    public void setFormato12_24(boolean formato12_24) {
        this.formato12_24 = formato12_24;
    }

    public boolean isAlarma() {
        return alarma;
    }

    public void setAlarma(boolean alarma) {
        this.alarma = alarma;
    }

    public int getHoraAlarma() {
        return horaAlarma;
    }

    public void setHoraAlarma(int horaAlarma) {
        this.horaAlarma = horaAlarma;
    }

    public int getMinutoAlarma() {
        return minutoAlarma;
    }

    public void setMinutoAlarma(int minutoAlarma) {
        this.minutoAlarma = minutoAlarma;
    }

    public String getMensajeAlarma() {
        return mensajeAlarma;
    }

    public void setMensajeAlarma(String mensajeAlarma) {
        this.mensajeAlarma = mensajeAlarma;
    }

    public TimerTask getTask() {
        return task;
    }

    public void setTask(TimerTask task) {
        this.task = task;
    }

    public void IniciarReloj(){
        timer=new Timer();
        task=new TimerTask() {
            @Override
            public void run() {
                setFont(new Font("Arial",Font.BOLD,16));

                setForeground(Color.BLUE);
                localTime=LocalTime.now();
                if (localTime.getHour()==horaAlarma && localTime.getMinute()==minutoAlarma && alarma){
                    Alarma();
                }else{
                    setText(""+new Date());
                }
            }
        };
        timer.schedule(task,0,1000);


    }

    public void PararReloj(){
        task.cancel();
    }

    public void Alarma(){
        setText(new Date()+"  "+mensajeAlarma);

    }
}
