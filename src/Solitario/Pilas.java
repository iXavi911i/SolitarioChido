package Solitario;
import java.util.ArrayList;

public abstract  class Pilas implements Operaciones{
    protected ArrayList<Carta> cartas;
    protected int pila;
    private int posicionX;
    private int posicionY;

    public Pilas(int x, int y,int pilas){    
        cartas = new ArrayList<Carta>(); //Arreglo de Cartas del tipo Carta
        pila=pilas;
        posicionX = x;
        posicionY = y;
    }
        
    public int tamaño(){    
        int numero =0;
        if(cartas!=null)
            numero =cartas.size();
        return numero;
    }
    
    public String imprimir(){
        int i=0;
        String cadena="<html>";
        Carta carta;
        while(i<cartas.size())
        {
            carta= cartas.get(i);
            cadena = cadena + " <br>  "+ TipoCarta(carta.getesReverso()==true?5:carta.getPalo(),carta.getNum()) + "</br>";
            i=i+1;
        }
        return cadena + "</html>";
    }
    
    public String TipoCarta(int palo,int valor){
        String cadena;
          switch (palo)
          {
              case 1:
                  cadena = valor + " corazones";
                  break;
              case 2:
                  cadena= valor + " espadas";
                  break;
              case 3:
                  cadena = valor + " diamantes";
                  break;
              case 4:
                  cadena = valor + " treboles";
                  break;
              default: cadena="?";
          }
        return cadena;
    }

    public void Agregar(Carta cartita){
            cartas.add(cartita);
    }

    public  void sacarCartas(int posicion){}
    
      public void setPosicioX(int p)
  {
      posicionX = p;
  }
  
  public int getPosicionX(){
      return posicionX;
  }
  
  public void setPosicionY(int n){
      posicionY = n;
  }
  
  public int getPosicionY()
  {
      return posicionY;
  }
}