/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Solitario;

/**
 *
 * @author Xavi
 */
public class FachadaCarta{
     public void nuevaCarta(Pilas[] pila) {  
        if(pila[1].tamaño()>0){
        pila[0].Agregar(pila[1].cartas);
        pila[1].cartas.clear();
        pila[1].Agregar(pila[0].cartas);
        pila[0].sacarCartas(0);
        System.out.println(pila[1].cartas.get(0).getesReverso());
        }
    } 
}
