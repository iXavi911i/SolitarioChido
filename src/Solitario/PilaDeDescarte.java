package Solitario;
import java.util.ArrayList;

public  class PilaDeDescarte extends Pilas{
      
    public PilaDeDescarte(int x, int y){
        super(x,y,1);
    }

    public int Agregar(ArrayList<Carta> carta) {
        Carta cartita = carta.get(0);
        cartita.setesReverso(false);
        cartita.setPila(1);
        cartas.add(cartita);
        return 1;
    }

    @Override
    public void sacarCartas(int posicion) {
        if(tamaño()>0)
            cartas.remove(0);
    }
}
