package Solitario;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JLayeredPane;

public class Juego extends JLayeredPane{
    public void paint(Graphics g){
        g.setColor(new Color(119,184,255,90));
        g.fillRect(45,25,75,98);
    }
}