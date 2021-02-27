package threadprojesi;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Asansor {
   Vector<AsansorMusteri> Musteri=new Vector<>();
   int floor=0;
   boolean yon=true,aktif;
    public Asansor() {
        aktif=false;
        asansorThread.start();
    }
        
        Thread asansorThread=new Thread(new Runnable() {
        @Override
        public void run() {
            while(true){
                        // Müşteri indir başı
                   if(aktif  || musteriSayisi()>0){     
                       for(int i=0;i<Musteri.size();i++){
                           
                           if(Musteri.get(i).gidilecek==floor){
                             Queue.katlar[floor]+=Musteri.get(i).sayi;
                             Musteri.remove(i);
                           }

                       }
                       
                       
                }       
                        // Müşteri indir sonu



                        // Müşteri al başı
                if(aktif){
                     synchronized(Queue.kilit1){
                         
                       if(Queue.queue.size()>0){
                       
                        for(int i =0;i<Queue.queue.size();i++){
                            if(floor==Queue.queue.get(i).bulunulan && Queue.queue.get(i).gelen+musteriSayisi()<=10){
                                Musteri.add(new AsansorMusteri(Queue.queue.get(i).gidilecek,Queue.queue.get(i).gelen));
                                if(floor!=0){
                                    Queue.katlar[floor]-=Queue.queue.get(i).gelen;
                                }
                                
                                Queue.queue.remove(i);
                                
                            }
                            if(musteriSayisi()==10){
                            break;
                            }

                        }
                 
                     }
                    }
             }        
                        // Müşteri al sonu


                        // Yön belirle başı
                        
           if(aktif  || musteriSayisi()>0){                 
                            boolean VarMi=false;
                            for(AsansorMusteri i:Musteri){
                                if(i.gidilecek>floor){
                                    VarMi=true;
                                }
                             }
                            synchronized(Queue.kilit3){
                                   Vector<Queue> kuyruk=(Vector<Queue>) Queue.queue.clone();
                            if(kuyruk.size()>0){
                                for(int i=0;i<kuyruk.size();i++){
                                    if(kuyruk.get(i).gidilecek>floor && kuyruk.get(i).gelen>0){
                                        VarMi=true;
                                    }
                                }
                            }
                            }
                            if(floor<0){
                                floor=0;
                                yon=true;
                            }
                           if(yon){
                               if(floor==4){
                               floor--;
                               yon=false;
                               }else if(VarMi){
                               floor++;
                               yon=true;
                               }else{
                               floor--;
                               yon=false;
                                }
                           
                           }else{
                               if(floor==0){
                               floor++;
                               yon=true;
                               
                               }else{
                               floor--;
                               yon=false;
                               }
                           
                           
                           
                           }
           }            
                        // Yön belirle sonu


                        // katlar arası geçiş süresi
                    try {

                        Thread.sleep(200);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Asansor.class.getName()).log(Level.SEVERE, null, ex);
                    }


           } 
        }
    });
        int musteriSayisi(){
            int count=0;
            for(AsansorMusteri i : Musteri){
            count+= i.sayi;
            }
        
            return count;
        }
        public boolean getAktif(){
        return aktif;
        }
        public void setAktif(){
        
        if(aktif){
        aktif=false;
        }else{
        aktif=true;
        }
        
        }
}
