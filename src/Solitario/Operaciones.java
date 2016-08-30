package Solitario;
import java.util.ArrayList;

public interface Operaciones {
    public abstract int Agregar(ArrayList<Carta> cartas);
    public void Agregar (Carta carta);
    public abstract void sacarCartas(int posicion);    
}