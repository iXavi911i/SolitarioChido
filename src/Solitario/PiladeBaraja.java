package Solitario;
import java.util.ArrayList;

public class PiladeBaraja extends Pilas{
           
    public PiladeBaraja(int x, int y){
        super(x,y,0);
    }
   
    public void sacarCartas(int cambiar) {
        if(tamaño()>0)
        {
           cartas.remove(0);
        }
    }
   
    public int Agregar(ArrayList<Carta> carta) {
        int num =carta.size();
        Carta cartita = carta.get(num-1);
        cartita.setesReverso(true);
        cartita.setPila(0);
        cartas.add(cartita);
        return num;
    }
  
}
