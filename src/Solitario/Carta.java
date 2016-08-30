package Solitario;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;

public class Carta extends Canvas{
    private int palo; // valores 1 corazones, 2 espadas, 3 diamantes y 4 treboles
    private int color; // valores 1=rojo, 2=negro
    private int num; // valores del 1 al 13
    private boolean reverso; // indica si la carta esta volteada o de reverso
    private String rutas;
    private int pila;
    private boolean primera=true;
  
    public Carta(int palo, int color, int num,boolean reverso,String ruta, int pilas){
        this.palo=palo;
        this.color=color;
        this.num=num;
        this.reverso=reverso;
        this.rutas=ruta;
        this.pila=pilas;
    }
  
    public void setPalo(int palo){
        this.palo = palo;
    }

    public int getPalo(){
        return palo;
    }

    public void setNum(int num){
        this.num = num;
    }

    public int getNum(){
        return num;
    }

    public void setColor(int color){
        this.color = color;
    }

    public int getColor(){
        return color;
    }

    public void setesReverso(boolean reverso){
        this.reverso = reverso;
    }

    public boolean getesReverso(){
        return reverso;
    }
    
    public void paint(Graphics g){
        if(reverso){
            g.drawImage(Toolkit.getDefaultToolkit().getImage("C:/Users/ArelyGuadalupe/Documents/NetBeansProjects/Solitario_PatronesDiseño/src/mazo/reverso.JPG"),1,1,73,96,this);
        }
        else{
            g.drawImage(Toolkit.getDefaultToolkit().getImage(rutas),1,1,73,96,this);
        }
        g.setColor(Color.BLACK);
        g.drawRect(0,0,74,97);
    } 

    public void setPila(int pilas){ 
        pila=pilas;
    }   
    
    public int getPila(){
        return pila;
    }   

    public String getRuta(){
        return rutas;
    }
}