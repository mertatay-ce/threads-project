package threadprojesi;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class QueueThreads extends Thread{

    public QueueThreads() {
        girisThread.start();
        cikisThread.start();
    }

    
    
    
    
    
    Thread girisThread =new Thread(new Runnable() {
        @Override
        public void run() {
        synchronized(Queue.kilit2){    
            while(true){
                Random rand=new Random();
                int sayi=rand.nextInt(10)+1;
                int gidilecek=rand.nextInt(4)+1;
                Queue.queue.add(new Queue(0, gidilecek, sayi));
         
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(QueueThreads.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }  
        }
    });
    Thread cikisThread =new Thread(new Runnable() {
        @Override
        public void run() {
            while(true){
                Random rand=new Random();
                int sayi=rand.nextInt(4)+1;
                int bulunulan=rand.nextInt(4)+1;
                if(Queue.katlar[bulunulan]>sayi){
                    Queue.queue.add(new Queue(bulunulan, 0, sayi));
                
                }
            
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(QueueThreads.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    });
    
    
}
