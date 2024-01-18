import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Presence1{
     public static void main(String[] args){
        System.out.println("It worked!");
        ScheduledExecutorService Myexecutor = Executors.newScheduledThreadPool(1);
        Myexecutor.scheduleAtFixedRate(() -> {
                        try{
            String mySoundFilePath = "/Users/paulpeng/Downloads/ThomasPresence.wav";
            File soundfile = new File(mySoundFilePath); 
            if(!soundfile.exists()){
                System.out.println("File not found: " + mySoundFilePath);
                return;
            }
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundfile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            Thread.sleep(clip.getMicrosecondLength() / 1000);
            clip.close();
            audioInputStream.close();
            } catch (UnsupportedAudioFileException | LineUnavailableException 
            | IOException | InterruptedException e) {
                e.printStackTrace();
        }
}, 0, 3, TimeUnit.MINUTES);
    }
}