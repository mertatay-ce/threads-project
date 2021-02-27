
package threadprojesi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.Timer;


public class Ekran extends javax.swing.JFrame implements ActionListener{

    Timer timer=new Timer(200,this);
    QueueThreads queueThreads=new QueueThreads();
    Asansor asansor=new Asansor();
    Asansor asansor2=new Asansor();
    Asansor asansor3=new Asansor();
    Asansor asansor4=new Asansor();
    Asansor asansor5=new Asansor();
    
    DefaultListModel asn1Model=new DefaultListModel();
    public Ekran() {
        initComponents();
        asansor.setAktif();
        timer.start();
        Kontrol.start();
     
        
    }

      Thread Kontrol=new Thread(new Runnable() {
        @Override
        public void run() {
            while(true){
                synchronized(Queue.kilit3){
                    int kuyrukSayisi=0;
                    Vector<Queue> kuyruk=(Vector<Queue>) Queue.queue.clone();
                        for(int i=0;i<kuyruk.size();i++){

                    kuyrukSayisi+=kuyruk.get(i).gelen;
                        }   
                //    System.out.println("Kuyruk Sayısı"+Queue.KuyrukSayisi());
                    if(kuyrukSayisi>20){
                        if(asansor4.getAktif()){
                            asansor5.setAktif();
                          
                        }else if(asansor3.getAktif()){
                            asansor4.setAktif();
                        }else if(asansor2.getAktif()){
                            asansor3.setAktif();

                        }else if(asansor.getAktif()){
                            asansor2.setAktif();
                        }

                    }else if(kuyrukSayisi<10){
                        if(asansor5.getAktif()){
                            asansor5.setAktif();
                        }else if(asansor4.getAktif()){
                            asansor4.setAktif();
                        }else if(asansor3.getAktif()){
                            asansor3.setAktif();

                        }else if(asansor2.getAktif()){
                            asansor2.setAktif();
                        }


                    }
                }
            
            }
        }});
            
            
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Queue_KatlarSayilariText = new javax.swing.JLabel();
        QueueText = new javax.swing.JLabel();
        asansorText2 = new javax.swing.JLabel();
        asansorText3 = new javax.swing.JLabel();
        asansorText4 = new javax.swing.JLabel();
        asansorText5 = new javax.swing.JLabel();
        asansorText1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Queue_KatlarSayilariText.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        Queue_KatlarSayilariText.setText("Kat0:All::Queue:    - Kat1:All:32:Queue ......................................................                                            Toplam:All:534:Queue:23");

        QueueText.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        QueueText.setText("Queue:");

        asansorText2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        asansorText2.setText("Asansör 1");

        asansorText3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        asansorText3.setText("Asansör 1");

        asansorText4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        asansorText4.setText("Asansör 1");

        asansorText5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        asansorText5.setText("Asansör 1");

        asansorText1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        asansorText1.setText("Asansör 1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Queue_KatlarSayilariText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(asansorText1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(asansorText2, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(asansorText3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(asansorText4, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(asansorText5, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(101, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(QueueText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(QueueText, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Queue_KatlarSayilariText, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(asansorText2, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(asansorText3, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(asansorText4, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(asansorText1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(asansorText5, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ekran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ekran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ekran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ekran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ekran().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel QueueText;
    private javax.swing.JLabel Queue_KatlarSayilariText;
    private javax.swing.JLabel asansorText1;
    private javax.swing.JLabel asansorText2;
    private javax.swing.JLabel asansorText3;
    private javax.swing.JLabel asansorText4;
    private javax.swing.JLabel asansorText5;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        String S="";
        int[] kuyruk={0,0,0,0,0};
    
        S+="Queue [simdi,hedef,sayi] :";
       
        for(Queue i:Queue.queue){
        S+="["+i.bulunulan+","+i.gidilecek+","+i.gelen+"]";
          kuyruk[i.bulunulan]+=i.gelen;
        }
        
        QueueText.setText(S);
        S="Kuyruk ve Kat Sayıları: ";
        S+="| 0.floor::Queue"+kuyruk[0]+" | ";
        S+="1.floor:All:"+Queue.katlar[1]+":Queue:"+kuyruk[1]+" | ";
        S+="2.floor:All:"+Queue.katlar[2]+":Queue:"+kuyruk[2]+" | ";
        S+="3.floor:All:"+Queue.katlar[3]+":Queue:"+kuyruk[3]+" | ";
        S+="4.floor:All:"+Queue.katlar[4]+":Queue:"+kuyruk[4]+" |";
        S+="\t Toplam:All:"+(Queue.katlar[1]+Queue.katlar[2]+Queue.katlar[3]+Queue.katlar[4])+":Queue:"+Queue.KuyrukSayisi();
        Queue_KatlarSayilariText.setText(S);
        // KUYRUK GÜNCELLEME SONU
        // asansor1
       S="<html><table>";
       S+="<tr><th>Asansör No:</th><td>1</td></tr>";
       S+="<tr><th>Aktif :</th><td>"+asansor.aktif+"</td></tr>";
       S+="<tr><th>Müşteri Sayısı:</th><td>"+asansor.musteriSayisi()+"</td></tr>";
       S+="<tr><th>Kat:</th><td>"+asansor.floor+"</td></tr>";
       if(asansor.yon){
       S+="<tr><th>Yön:</th><td>Yukarı</td></tr>";
       }else{
       S+="<tr><th>Yön:</th><td>Aşağı</td></tr>";
       }
       int[] musteri1 ={0,0,0,0,0};
       for(AsansorMusteri i:asansor.Musteri){
           musteri1[i.gidilecek]+=i.sayi;
       }
       String M="";
       for(int i=0;i<5;i++){
        M+="["+i+","+musteri1[i]+"] ";   
       }
       S+="<tr><th>Müşteriler:</th><td>"+M+"</td></tr>";
       S+="</table></html>";
        asansorText1.setText(S);
        // asansor1 son
        
        
           // asansor2
       S="<html><table>";
       S+="<tr><th>Asansör No:</th><td>2</td></tr>";
       S+="<tr><th>Aktif :</th><td>"+asansor2.aktif+"</td></tr>";
       S+="<tr><th>Müşteri Sayısı:</th><td>"+asansor2.musteriSayisi()+"</td></tr>";
       S+="<tr><th>Kat:</th><td>"+asansor2.floor+"</td></tr>";
       if(asansor2.yon){
       S+="<tr><th>Yön:</th><td>Yukarı</td></tr>";
       }else{
       S+="<tr><th>Yön:</th><td>Aşağı</td></tr>";
       }
       int[] musteri2={0,0,0,0,0};
       for(AsansorMusteri i:asansor2.Musteri){
           musteri2[i.gidilecek]+=i.sayi;
       }
        M="";
       for(int i=0;i<5;i++){
        M+="["+i+","+musteri2[i]+"] ";   
       }
       S+="<tr><th>Müşteriler:</th><td>"+M+"</td></tr>";
       S+="</table></html>";
        asansorText2.setText(S);
        // asansor2 son   
        
                   // asansor3
       S="<html><table>";
       S+="<tr><th>Asansör No:</th><td>3</td></tr>";
       S+="<tr><th>Aktif :</th><td>"+asansor3.aktif+"</td></tr>";
       S+="<tr><th>Müşteri Sayısı:</th><td>"+asansor3.musteriSayisi()+"</td></tr>";
       S+="<tr><th>Kat:</th><td>"+asansor3.floor+"</td></tr>";
       if(asansor3.yon){
       S+="<tr><th>Yön:</th><td>Yukarı</td></tr>";
       }else{
       S+="<tr><th>Yön:</th><td>Aşağı</td></tr>";
       }
       int[] musteri3={0,0,0,0,0};
       for(AsansorMusteri i:asansor3.Musteri){
           musteri3[i.gidilecek]+=i.sayi;
       }
        M="";
       for(int i=0;i<5;i++){
        M+="["+i+","+musteri3[i]+"] ";   
       }
       S+="<tr><th>Müşteriler:</th><td>"+M+"</td></tr>";
       S+="</table></html>";
        asansorText3.setText(S);
        // asansor3 son  
        
                         // asansor4
       S="<html><table>";
       S+="<tr><th>Asansör No:</th><td>4</td></tr>";
       S+="<tr><th>Aktif :</th><td>"+asansor4.aktif+"</td></tr>";
       S+="<tr><th>Müşteri Sayısı:</th><td>"+asansor4.musteriSayisi()+"</td></tr>";
       S+="<tr><th>Kat:</th><td>"+asansor4.floor+"</td></tr>";
       if(asansor4.yon){
       S+="<tr><th>Yön:</th><td>Yukarı</td></tr>";
       }else{
       S+="<tr><th>Yön:</th><td>Aşağı</td></tr>";
       }
       int[] musteri4={0,0,0,0,0};
       for(AsansorMusteri i:asansor4.Musteri){
           musteri4[i.gidilecek]+=i.sayi;
       }
        M="";
       for(int i=0;i<5;i++){
        M+="["+i+","+musteri4[i]+"] ";   
       }
       S+="<tr><th>Müşteriler:</th><td>"+M+"</td></tr>";
       S+="</table></html>";
        asansorText4.setText(S);
        // asansor4 son
        
       // asansor5
       S="<html><table>";
       S+="<tr><th>Asansör No:</th><td>5</td></tr>";
       S+="<tr><th>Aktif :</th><td>"+asansor5.aktif+"</td></tr>";
       S+="<tr><th>Müşteri Sayısı:</th><td>"+asansor5.musteriSayisi()+"</td></tr>";
       S+="<tr><th>Kat:</th><td>"+asansor5.floor+"</td></tr>";
       if(asansor5.yon){
       S+="<tr><th>Yön:</th><td>Yukarı</td></tr>";
       }else{
       S+="<tr><th>Yön:</th><td>Aşağı</td></tr>";
       }
       int[] musteri5={0,0,0,0,0};
       for(AsansorMusteri i:asansor4.Musteri){
           musteri5[i.gidilecek]+=i.sayi;
       }
        M="";
       for(int i=0;i<5;i++){
        M+="["+i+","+musteri5[i]+"] ";   
       }
       S+="<tr><th>Müşteriler:</th><td>"+M+"</td></tr>";
       S+="</table></html>";
        asansorText5.setText(S);
        // asansor5 son
        
    }
}
