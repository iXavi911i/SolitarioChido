package Solitario;
import java.util.ArrayList;

public class PilaDeMesa extends Pilas{
    
    public PilaDeMesa(int x, int y, int pilas){
        super(x,y,pilas);
    }

    public int Agregar(ArrayList<Carta>  carta){            
        int cambiar=0;        
        if(cartas.size()==0){        
            if(carta.get(carta.size()-1).getNum()==13){                                                   
                carta.get(carta.size()-1).setPila(pila);                
                // System.out.println("rey sin tamaño");
                cartas.add(carta.get(carta.size()-1));                
                cambiar=carta.size();                
            }   
            else{
                for(int i=carta.size()-2;i>=0;i--){   
                    System.out.println("rey con tamaño" + carta.get(i).getNum());                                                                 
                    if(carta.get(i).getNum() == carta.get(i+1).getNum()+1 && carta.get(i).getColor()!=carta.get(i+1).getColor()){
                        if(carta.get(i).getNum()==13){
                            int tamaño = carta.size();                                                        
                            for(int j = i; j<tamaño;j++){
                                carta.get(j).setPila(pila);
                                System.out.println(pila);
                                cartas.add(carta.get(j));                                                                                      
                            }                                                        
                            cambiar = i+1;   
                            break; 
                        }
                    }
                    else
                        break;       
                }
            }
        }
        else{
            Carta ultimaCarta= cartas.get(cartas.size()-1);                        
            Carta cartita = carta.get(carta.size()-1);                        
            if(ultimaCarta.getNum() == cartita.getNum()+1 && ultimaCarta.getColor()!=cartita.getColor()){                      
                cartita.setPila(pila);
                cartas.add(cartita);                               
                cambiar =carta.size();                              
            }                         
            else {                            
                for(int i=carta.size()-2;i>=0;i--){                                                                    
                    if(carta.get(i).getNum() == carta.get(i+1).getNum()+1 && carta.get(i).getColor()!=carta.get(i+1).getColor()){                                                                             
                        if(ultimaCarta.getNum() == carta.get(i).getNum()+1 && ultimaCarta.getColor()!=carta.get(i).getColor()){                                         
                            int tamaño = carta.size();                            
                            for(int j = i; j<tamaño;j++){
                                carta.get(j).setPila(pila);
                                //System.out.println("hola" + pila);
                                cartas.add(carta.get(j));                                                            
                            }                                                        
                            cambiar = i+1;                                                         
                            break;                                                  
                        }                                             
                    }
                    else
                        break;
                }                            
            }                                    
        }        
        return cambiar;    
    }

    public void sacarCartas(int posicion){
        int tamaño = cartas.size();
        for(int i=posicion-1; i<tamaño;i++){
            cartas.remove(posicion-1);
        }
        if(cartas.size()>0)        
            cartas.get(cartas.size()-1).setesReverso(false);
    }
}