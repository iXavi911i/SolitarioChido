package Solitario;

import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JOptionPane;

public class Solitario_InterfazGrafica extends javax.swing.JFrame implements ActionListener,
                                            MouseMotionListener, MouseListener {
    Carta[] cartas ;
    private Pilas[] pila;
    
    public Solitario_InterfazGrafica() {     
        getContentPane().setBackground(new java.awt.Color(0, 102, 51));
        initComponents();   
        jLayeredPane1.addMouseMotionListener(this);
        jLayeredPane1.addMouseListener(this);
        pila = new Pilas[13];
        pila[0] = new PiladeBaraja(0,0); // esquina sup izquierda, cartas de reserva
        pila[1] = new PilaDeDescarte(90,1); // cartas para mostrar de una en una
        pila[2] = new PilaDePalos(220,0,2); // primer cuadrante de colocar cartas
        pila[3] = new PilaDePalos(310,0,3); // segundo cuadrante de colocar cartas
        pila[4] = new PilaDePalos(400,0,4); // tercer cuadrante de colocar cartas
        pila[5] = new PilaDePalos(490,0,5); // cuarto cuadrante de colocar cartas
        pila[6] = new PilaDeMesa(0,140,6); // resto de pilas para acomodo de cartas en juego
        pila[7] = new PilaDeMesa(80,140,7);
        pila[8] = new PilaDeMesa(160,140,8);
        pila[9] = new PilaDeMesa(240,140,9);
        pila[10] = new PilaDeMesa(320,140,10);        
        pila[11] = new PilaDeMesa(400,140,11);
        pila[12] = new PilaDeMesa(480,140,12);
        IniciaJuego();
    }
    public void IniciaJuego(){
        String ruta;
        int palo;
        int valor;
        boolean pilaInvalida=false;
        int enPila=0;
        cartas = new Carta[52];
        int nCarta;
        for(int i=0;i<52;i++){
            do{
                nCarta=(int)Math.floor(Math.random()*52);
              }
            while(cartas[nCarta]!=null);
            pilaInvalida=false;
            while(!pilaInvalida){
                enPila=(int)Math.floor(Math.random()*13);
                if(enPila==0||enPila==1||enPila>5)
                    pilaInvalida=enPila==0?((pila[0].tamaño())<23):enPila==1?((pila[1].tamaño())<1):((pila[enPila].tamaño())<(enPila-5));
            }
            palo=(nCarta<13?1:nCarta<26?2:nCarta<39?3:4);
            valor=(nCarta+(nCarta<13?1:nCarta<26?-12:nCarta<39?-25:-38));
            ruta = "C:/Users/ArelyGuadalupe/Documents/NetBeansProjects/Solitario_PatronesDiseño/src/mazo/palo"+palo+"_"+valor+".JPG";
            cartas[nCarta] = new Carta(palo,(palo==1||palo==3?1:2),valor,!(enPila==0?false:enPila==1?true:(pila[enPila].cartas.size()==(enPila-6))),ruta,enPila);
            cartas[nCarta].setSize(75,98);              
            jLayeredPane1.add(cartas[nCarta]);         
            jLayeredPane1.moveToFront(cartas[nCarta]);
            pila[enPila].Agregar(cartas[nCarta]);
            cartas[nCarta].setLocation(pila[enPila].getPosicionX(),
            pila[enPila].getPosicionY()+((enPila==0||enPila==1?0:20)*pila[enPila].tamaño()));
            cartas[nCarta].addMouseMotionListener(this);
            cartas[nCarta].addMouseListener(this); 
        }                
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 577, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1)
                .addContainerGap())
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
            java.util.logging.Logger.getLogger(Solitario_InterfazGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Solitario_InterfazGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Solitario_InterfazGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Solitario_InterfazGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Solitario_InterfazGrafica().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane jLayeredPane1;
    // End of variables declaration//GEN-END:variables
  
    private void nuevaCarta() {  
        if(pila[1].tamaño()>0){
        pila[0].Agregar(pila[1].cartas);
        pila[1].cartas.clear();
        pila[1].Agregar(pila[0].cartas);
        pila[0].sacarCartas(0);
        System.out.println(pila[1].cartas.get(0).getesReverso());
        actualizaCartas(1);
        actualizaCartas(0);
        }
    }      
    
    public void moverClick(int pilas1, int pilas2) {   
        int pila1 =pilas1;
        int pila2 =pilas2;
        System.out.println(pilas1);
        Carta carta;
        carta = pila[pila1].cartas.get(pila[pila1].tamaño()-1);
        int cambiar;
        cambiar= pila[pila2].Agregar(pila[pila1].cartas);
        if(cambiar<1) {
            for(int i=0;i<pila[carta.getPila()].tamaño();i++){
                carta = pila[carta.getPila()].cartas.get(i);
                if(!carta.getesReverso()){
                    jLayeredPane1.moveToFront(carta);
                    carta.setLocation(pila[carta.getPila()].getPosicionX(), pila[carta.getPila()].getPosicionY()+((carta.getPila()<6?0:20)*(i+1)));            
                    carta.repaint(); 
                }
            }
        }
        else{
            if(pila[pila2].tamaño()>0)           
                actualizaCartas(pila2);
            pila[pila1].sacarCartas(cambiar); 
            
            if(pila[pila1].tamaño()>0)           
                actualizaCartas(pila1);
                           
           for(int i=0;i<pila[carta.getPila()].tamaño();i++){ 
                carta = pila[carta.getPila()].cartas.get(i);
                if(!carta.getesReverso()){
                    jLayeredPane1.moveToFront(carta);
                    carta.setLocation(pila[carta.getPila()].getPosicionX(), pila[carta.getPila()].getPosicionY()+((carta.getPila()<6?0:20)*(i+1)));            
                    carta.repaint(); 
                }
            }
        }  
    }   
            
    public void bajarClick(int pilaBajar){ 
        int pilas =pilaBajar;
        int tamaño;        
        tamaño= pila[pilas].Agregar(pila[1].cartas);
        if(tamaño<1){
            actualizaCartas(1);
        }
        else{
            pila[1].cartas.clear();
            if(pila[0].tamaño()>0){            
                pila[1].Agregar(pila[0].cartas);          
                pila[0].sacarCartas(0);
            }
            if(pila[pilas].tamaño()>0)
                actualizaCartas(pilas);
            if(pila[1].tamaño()>0)
                actualizaCartas(1);
        }
    }    
        
    public void actualizaCartas(int pila1){
        Carta carta;
        System.out.println("actualiza pila " + pila1) ;
        carta=pila[pila1].cartas.get(pila[pila1].tamaño()-1);
        jLayeredPane1.moveToFront(carta);   
        carta.setLocation(pila[carta.getPila()].getPosicionX(), pila[carta.getPila()].getPosicionY()+((carta.getPila()<6?0:20)*pila[carta.getPila()].tamaño()));        
        carta.repaint();
    }
    
    public void hasGanado(){
        if(pila[2].tamaño()==13&&pila[3].tamaño()==13&&pila[4].tamaño()==13&&pila[5].tamaño()==13){
            JOptionPane.showMessageDialog(null,"FELICIDADES  !!!HAS GANADO!!!");
        }
    }
    
    @Override
    public void mouseDragged(MouseEvent e) { 
        if(e.getComponent() instanceof Carta){        
            Carta cartita = (Carta)e.getComponent();         
            if(cartita.getesReverso())
                return;
            int posicion =pila[cartita.getPila()].cartas.indexOf(cartita); 
            for(int i=posicion;i<pila[cartita.getPila()].tamaño();i++){
                cartita = pila[cartita.getPila()].cartas.get(i);
                jLayeredPane1.moveToFront(cartita);                           
                cartita.repaint();                    
                cartita.setLocation(cartita.getLocation().x+e.getX()-30,cartita.getLocation().y + e.getY()-40);        
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(!(e.getComponent() instanceof Carta)) 
            return;        
        Carta tmpCard = (Carta)e.getComponent();
        int pila=tmpCard.getPila();
        if(pila==0)
            nuevaCarta();
        else{
            System.out.println("subir con doble click " + pila);
            textSubir(pila);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getComponent() instanceof Carta){
            Carta cartita = (Carta)e.getComponent();
            int posicionX = cartita.location().x ;
            int posicionY = cartita.location().y;
            if(posicionX >=490 && posicionY>=0 && posicionY<140)
               System.out.println("pila0");
            else if(posicionX>=400 && posicionY>=0 && posicionY<140){                   
                if(cartita.getPila()==1)
                    mouseClicked(e);
            }
            else if(posicionX<=270 && posicionY>=0 && posicionY<150){
                System.out.println("subir");
                textSubir(cartita.getPila());
            }        
            else if( posicionX<79 && posicionY>=140){
                if(cartita.getPila()==6)
                    mouseClicked(e);
                else if(cartita.getPila()==1){
                    System.out.println("0 igual a 0");
                    bajarClick(6);
                }   
               else 
                    moverClick(cartita.getPila(),6);  
            }
            else if(posicionX>=80 && posicionX<159 && posicionY>=140){
                if(cartita.getPila()==7)
                    mouseClicked(e);
                else if(cartita.getPila()==1)
                    bajarClick(7);
                else 
                    moverClick(cartita.getPila(),7);                              
            }
            else if(posicionX>=159 && posicionX<239 && posicionY>=140){
                if(cartita.getPila()==8)
                   mouseClicked(e);
                else if(cartita.getPila()==1)
                    bajarClick(8);
                else 
                    moverClick(cartita.getPila(),8);                              
            }
            else if(posicionX>=240 && posicionX<319 && posicionY>=140){            
                if(cartita.getPila()==9)
                    mouseClicked(e);
               else if(cartita.getPila()>5)
                    moverClick(cartita.getPila(),9);           
               else if(cartita.getPila()==1)
                    bajarClick(9);
            }       
            else if(posicionX>=320 && posicionX<399 && posicionY>=140){
                if(cartita.getPila()==10)
                    mouseClicked(e);
                else if(cartita.getPila()>5)
                    moverClick(cartita.getPila(),10);           
                else if(cartita.getPila()==1)
                    bajarClick(10);
            }            
            else if(posicionX>=400 && posicionX<479 && posicionY>=140){               
                if(cartita.getPila()==11)
                    mouseClicked(e);
                else if(cartita.getPila()>5)
                    moverClick(cartita.getPila(),11);           
                else if(cartita.getPila()==1)
                    bajarClick(11);
            }
            else if(posicionX>=480 && posicionY>=140){     
                if(cartita.getPila()==12)
                    mouseClicked(e);
                else if(cartita.getPila()>5)
                    moverClick(cartita.getPila(),12);                               
                else if(cartita.getPila()==1)
                    bajarClick(12);
            }
            else
                actualizaCartas(cartita.getPila());
        }
    }

    private void textSubir(int pilaSubir) {                           
        int pilas =pilaSubir;
        int result=0;
        Carta carta;
        if (pilas==1)     
            carta= pila[1].cartas.get(0);
        else
            carta= pila[pilas].cartas.get(pila[pilas].tamaño()-1);
        if(pila[2].tamaño()<1 && pila[3].tamaño()<1 && pila[4].tamaño()<1 && pila[5].tamaño()<1){
            if(pilas==1)
                result= pila[2].Agregar(pila[1].cartas);
            else           
                result=pila[2].Agregar(pila[pilas].cartas);
        }
        else{        
            for(int i=0; i<4;i++){             
                if(pila[i+2].tamaño()<1){         
                    if(pilas==1)                    
                        result= pila[i+2].Agregar(pila[1].cartas);   
                    else
                        result= pila[i+2].Agregar(pila[pilas].cartas); 
                    break;            
                }           
                else if(pila[i+2].cartas.get(0).getPalo()==carta.getPalo()){        
                    if(pilas==1)          
                        result= pila[i+2].Agregar(pila[1].cartas); 
                    else                    
                        result= pila[i+2].Agregar(pila[pilas].cartas);              
                    break;            
                }        
            }
        }
        if(result<1){
            if(pila[2].tamaño()>0)
                actualizaCartas(2);
            else if (pila[3].tamaño()>0)
                actualizaCartas(3);                    
            else if (pila[4].tamaño()>0)
                actualizaCartas(4);
            else if (pila[5].tamaño()>0)
                actualizaCartas(5);
                actualizaCartas(pilas);
        }
        else{
            if(pilas==1){                            
                pila[1].cartas.clear();  
                if(pila[0].tamaño()>0){                
                    pila[1].Agregar(pila[0].cartas);
                    pila[0].sacarCartas(0);
                    actualizaCartas(1);                    
                    if(pila[2].tamaño()>0)
                        actualizaCartas(2);
                    else if (pila[3].tamaño()>0)
                        actualizaCartas(3);                    
                    else if (pila[4].tamaño()>0)
                        actualizaCartas(4);
                    else if (pila[5].tamaño()>0)
                        actualizaCartas(5);
                }
            }
            else{
                pila[pilas].sacarCartas(pila[pilas].tamaño());
                if(pila[2].tamaño()>0)
                    actualizaCartas(2);
                if (pila[3].tamaño()>0)
                    actualizaCartas(3);                    
                if (pila[4].tamaño()>0)
                    actualizaCartas(4);
                if (pila[5].tamaño()>0)
                    actualizaCartas(5);
                if (pila[pilas].tamaño()>0)
                    actualizaCartas(pilas);
            }
        }
        hasGanado();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}