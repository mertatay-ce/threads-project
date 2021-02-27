
package threadprojesi;


import java.util.Vector;


public class Queue {
    int gidilecek,bulunulan,gelen;
    public static Vector<Queue> queue=new Vector<>();
    public static int[] katlar={0,0,0,0,0};
    static Object kilit1=new Object();
    static Object kilit2=new Object();
     static Object kilit3=new Object();
         static Object kilit4=new Object();
    public Queue(int bulunulan, int gidilecek, int gelen) {
        this.gidilecek = gidilecek;
        this.bulunulan = bulunulan;
        this.gelen = gelen;
    }
    public static void Yazdir(){
    
    for(int i=0;i<queue.size();i++){
        System.out.print("["+queue.get(i).bulunulan+","+queue.get(i).gidilecek+","+queue.get(i).gelen+"]");
    }
        System.out.println("");
    }

    public static int KuyrukSayisi(){
    //    Yazdir();
        synchronized(kilit3){
    int count=0;
    for(int i=0;i<queue.size();i++){

        count+=queue.get(i).gelen;
    }
    return count;
        }
    }
   
}
