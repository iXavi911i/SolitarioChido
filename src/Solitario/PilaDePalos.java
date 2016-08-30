package Solitario;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PilaDePalos extends Pilas{

    public PilaDePalos(int x, int y, int pilas) {
        super(x, y, pilas);
    }
    
    public int Agregar(ArrayList<Carta>  carta){
        Carta ultimaCarta;                          
        Carta cartita = carta.get(carta.size()-1); 
        if((cartas.size()<1)){     
            if(cartita.getNum()==1){   
                cartita.setPila(pila);
                cartas.add(cartita);
                return 1;
            }            
        }
        else {
            ultimaCarta= cartas.get(cartas.size()-1); 
            if((ultimaCarta.getNum() == cartita.getNum()-1 && ultimaCarta.getColor()==cartita.getColor())){          
                cartita.setPila(pila);
                cartas.add(cartita);
                return 1;        
            }        
            else             
                return 0;
        }
        return 0;
    }
   
    public String imprimir(){
        int i=0;
        String cadena="<html>";
        if(cartas.size()>0){                
            Carta carta;                            
            carta= cartas.get(cartas.size()-1);
            cadena = cadena + " <br>  "+TipoCarta(carta.getPalo(),carta.getNum()) + "</br>";                            
        }
        return cadena + "</html>";
    }

    public void sacarCartas(int posicion){
        int tamaño = cartas.size();                 
        cartas.remove(posicion-1);
    }
    //ukwgudausd 
}