
package compgrafica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CompGrafica extends JPanel{
   private static Scanner input = new Scanner(System.in);
   private static Scanner color = new Scanner(System.in);
   @Override
public void paint(Graphics g){
    super.paint(g);
  
System.out.println("Medidas de la linea: ");
System.out.println("Digite un valor de 'x0' inicial");
int x0= input.nextInt();
System.out.println("Digite un valor de 'y0' inicial");
int y0= input.nextInt();
System.out.println("Digite un valor de 'x1' final");
int xf=input.nextInt();
System.out.println("Digite un valor de 'y1' final");
int yf=input.nextInt();

//la primera por defecto de color rojo
    g.setColor(Color.red);
    g.drawLine(x0,y0 ,xf ,yf);
    
       
       int n=2;
       while(true){
       System.out.println("Deseas dibujar otra linea?: (Si=t o Si=T)");
       char op= input.next().toLowerCase().charAt(0);
        if(op=='t'){
           int x2,y2,xn,yn;
            System.out.println("Digite un valor de 'x' inicial para la linea "+n);
            x2=input.nextInt();
            System.out.println("Digite un valor de 'y' inicial para la linea "+n);
            y2=input.nextInt();
            System.out.println("Digite un valor de 'x' final para la linea "+n);
            xn=input.nextInt();
            System.out.println("Digite un valor de 'y' final para la linea "+n);
            yn=input.nextInt();
            n++;
            
            
            while(true){
                System.out.println("(Puedes presionar 'P' o 'p' para continuar sin asignar color), por defecto sera de color negro");
                char d=input.next().toLowerCase().charAt(0);
                System.out.println("Que color quieres que tenga tu linea?:"
                        + "disponemos de 5 colores: gris oscuro, anaranjado, verde, negro y azul");
                String tonalidad= color.nextLine().toLowerCase();
                if(tonalidad.equals("gris oscuro")){
                g.setColor(Color.DARK_GRAY);
                g.drawLine(x2, y2, xn, yn);
                }
                else if(tonalidad.equals("anaranjado")){
                g.setColor(Color.ORANGE);
                g.drawLine(x2, y2, xn, yn);
                }
                else if(tonalidad.equals("verde")){
                g.setColor(Color.GREEN);
                g.drawLine(x2, y2, xn, yn);
                }
                else if(tonalidad.equals("azul")){
                g.setColor(Color.BLUE);
                g.drawLine(x2, y2, xn, yn);
                }
                else if(tonalidad.equals("negro")){
                g.setColor(Color.BLACK);
                g.drawLine(x2, y2, xn, yn);
                }
                if(d=='p'){
                break;
                }
            } 
            
                    
           
        }else{
         break;
        }
       }
               }
    
    
    public static void main(String[] args) {
      JFrame ventana= new JFrame("Modos graficos con Java");
      CompGrafica cg= new CompGrafica();
      //Clase  que permite obtener los valores de el largo y ancho de la pantalla
     Dimension tamaño = Toolkit.getDefaultToolkit().getScreenSize();
     
     
      //Se extrajeron los valores para el ancho y largo
      int ajuste_EjeX=tamaño.width;//1366 xD este fue la medida del ancho de la pantalla de mi laptop
      int ajuste_EjeY=tamaño.height;//786 xD este fue la medida del largo de la pantalla de mi laptop
      System.out.println("Las medidas que tu pantalla soporta son: "+"Ancho: "+ajuste_EjeX+" Largo: "+ajuste_EjeY+
              "\n .Solo puedes ajustarla a valores iguales o menores, de lo contrario puede producirse daño en el"
                      + "equipo...");
      
      char opc;
      do{
          System.out.println("Deseas cambiar la resolución de tu pantalla?: PRESIONA 'S' o 's' para continuar con"
                  + "la grafica de la linea: ");
            opc= input.next().toLowerCase().charAt(0);
            
            if(opc=='s'){
                break;
            }
            else{
                System.out.println("Ingrese la nueva medida para el ancho de la ventana: ");
                ajuste_EjeX=input.nextInt();
                System.out.println("Ingrese la nueva medida para el largo de la ventana: ");
                ajuste_EjeY=input.nextInt();
            }
      }while(true);
      
      ventana.add(cg);
      ventana.setSize(ajuste_EjeX, ajuste_EjeY );
      ventana.setLocationRelativeTo(null);
      ventana.setVisible(true);
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
        
    }
    
  
}
	