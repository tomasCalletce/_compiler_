package iterative;
import lexico.*;

import java.util.ArrayList;
import java.lang.Math;

public class Iterative {
    static int index;
    static ArrayList<NoTerminal> stack;

    public static void iterative(Lexico cadena){
        while(index < cadena.darTamañoCadena()){
            Elemento el = cadena.darElemento(index);
            if(stack.size() == 0 && el.darTipo() == '¬');
            NoTerminal topStack = stack.get(stack.size()-1);
            switch(topStack.getNombre()){
                case "procOR":
                    //
                break;
                case "procAND":
                    //
                break;
                case "pRelación ":
                    //
                break;
                case "suma":
                    //
                break;
                case "resta":
                    //
                break;
                case "mul":
                    //
                break;
                case "div":
                    //
                break;
                case "exp":
                    //
                break;
                case "S":
                    switch(el.darTipo()){
                        case 'i':
                            n1();
                        break;
                        case '(':
                            n1();
                        break;
                        default:
                            System.out.println("ERR STACK: " + topStack + "ERR CADENA: " + el);
                    }
                break;
                case "ELO":
                    switch(el.darTipo()){
                        case 'i':
                            n2();
                        break;
                        case '(':
                            n2();
                        break;
                        default:
                            System.out.println("ERR STACK: " + topStack + "ERR CADENA: " + el);
                    }
                break;
                case "EL2":
                    switch(el.darTipo()){
                        case 'i':
                            n5();
                        break;
                        case '(':
                            n5();
                        break;
                        default:
                            System.out.println("ERR STACK: " + topStack + "ERR CADENA: " + el);
                    }
                break;
                case "ELOL":
                    switch(el.darTipo()){
                        case '|':
                            n3();
                        break;
                        case ')':
                            n4();
                        break;
                        case '¬':
                            n4();
                        break;
                        default:
                            System.out.println("ERR STACK: " + topStack + "ERR CADENA: " + el);
                    }
                break;
                case "EL2L":
                    switch(el.darTipo()){
                        case '|':
                            n7();
                        break;
                        case '&':
                            n6();
                        break;
                        case ')':
                            n7();
                        break;
                        case '¬':
                            n7();
                        break;
                        default:
                            System.out.println("ERR STACK: " + topStack + "ERR CADENA: " + el);
                    }
                break;
                case "ER":
                    switch(el.darTipo()){
                        case 'i':
                            n8();
                        break;
                        case '(':
                            n8();
                        break;
                        default:
                            System.out.println("ERR STACK: " + topStack + "ERR CADENA: " + el);
                    }
                break;
                case "ERL":
                    switch(el.darTipo()){
                        case '<':
                            n9();
                        break;
                        case '>':
                            n9();
                        break;
                        case '=':
                            n9();
                        break;
                        case '!':
                            n9();
                        break;
                        case '|':
                            n10();
                        break;
                        case '&':
                            n10();
                        break;
                        case ')':
                            n10();
                        break;
                        case '¬':
                            n10();
                        break;
                        default:
                            System.out.println("ERR STACK: " + topStack + "ERR CADENA: " + el);
                    }
                break;
                case "OR":
                    switch(el.darTipo()){
                        case '<':
                            n11();
                        break;
                        case '>':
                            n14();
                        break;
                        case '=':
                            n17();
                        break;
                        case '!':
                            n19();
                        break;
                        default:
                            System.out.println("ERR STACK: " + topStack + "ERR CADENA: " + el);
                    }
                break;
                case "E":
                    switch(el.darTipo()){
                        case 'i':
                            n21();
                        break;
                        case '(':
                            n21();
                        break;
                        default:
                            System.out.println("ERR STACK: " + topStack + "ERR CADENA: " + el);
                    }
                break;
                case "ME":
                    switch(el.darTipo()){
                        case 'i':
                            n13();
                        break;
                        case '=':
                            n12();
                        break;
                        case '(':
                            n13();
                        break;
                        default:
                            System.out.println("ERR STACK: " + topStack + "ERR CADENA: " + el);
                    }
                break;
                case "MA":
                    switch(el.darTipo()){
                        case 'i':
                            n16();
                        break;
                        case '=':
                            n15();
                        break;
                        case '(':
                            
                        break;
                        default:
                            System.out.println("ERR STACK: " + topStack + "ERR CADENA: " + el);
                    }
                break;
                case "IG":
                    switch(el.darTipo()){
                        case '=':
                            
                        break;
                        default:
                            System.out.println("ERR STACK: " + topStack + "ERR CADENA: " + el);
                    }
                break;
                case "DI":
                    switch(el.darTipo()){
                        case '=':
                            
                        break;
                        default:
                            System.out.println("ERR STACK: " + topStack + "ERR CADENA: " + el);
                    }
                break;
                case "EL":
                    switch(el.darTipo()){
                        case '+':

                        break;
                        case '-':
                            
                        break;
                        case '<':
                            
                        break;
                        case '>':
                            
                        break;
                        case '=':
                            
                        break;
                        case '!':
                            
                        break;
                        case '|':
                            
                        break;
                        case '&':
                            
                        break;
                        case ')':
                            
                        break;
                        case '¬':
                            
                        break;
                        default:
                            System.out.println("ERR STACK: " + topStack + "ERR CADENA: " + el);
                    }
                break;
                case "T":
                    switch(el.darTipo()){
                        case 'i':
                            
                        break;
                        case '(':
                            
                        break;
                        default:
                            System.out.println("ERR STACK: " + topStack + "ERR CADENA: " + el);
                    }
                break;
                case "TL":
                    switch(el.darTipo()){
                        case '+':

                        break;
                        case '-':
                            
                        break;
                        case '*':
                            
                        break;
                        case '/':
                            
                        break;
                        case '>':
                            
                        break;
                        case '<':
                            
                        break;
                        case '=':
                            
                        break;
                        case '!':
                            
                        break;
                        case '|':
                            
                        break;
                        case '&':
                            
                        break;
                        case ')':
                            
                        break;
                        case '¬':
                            
                        break;
                        default:
                            System.out.println("ERR STACK: " + topStack + "ERR CADENA: " + el);
                    }
                break;
                case "P":
                    switch(el.darTipo()){
                        case 'i':
                            
                        break;
                        case '(':
                            
                        break;
                        default:
                            System.out.println("ERR STACK: " + topStack + "ERR CADENA: " + el);
                    }
                break;
                case "PL":
                    switch(el.darTipo()){
                        case '+':

                        break;
                        case '-':
                            
                        break;
                        case '*':
                            
                        break;
                        case '/':
                            
                        break;
                        case '>':
                            
                        break;
                        case '<':
                            
                        break;
                        case '=':
                            
                        break;
                        case '^':
                            
                        break;
                        case '!':
                            
                        break;
                        case '|':
                            
                        break;
                        case '&':
                            
                        break;
                        case ')':
                            
                        break;
                        case '¬':
                            
                        break;
                        default:
                            System.out.println("ERR STACK: " + topStack + "ERR CADENA: " + el);
                    }
                break;
                case "F":
                    switch(el.darTipo()){
                        case 'i':
                            
                        break;
                        case '(':
                            
                        break;
                        default:
                            System.out.println("ERR STACK: " + topStack + "ERR CADENA: " + el);
                    }
                break;
            }
        }
    }

    
    public static void n1(){
        stack.remove(stack.size()-1);
        stack.add(new NoTerminal("RESPUESTA",stack.size(),0.0));
        
        stack.add(new NoTerminal("ELO",stack.size() - 1,0.0));
    }
    

    public static void n2(){
        stack.remove(stack.size()-1);
        stack.add(new NoTerminal("ELO_L",stack.size(),0.0));
        stack.add(new NoTerminal("EL2",stack.size(),0.0));
    }

    public static void n3(){
        stack.remove(stack.size()-1);
        stack.add(new NoTerminal("ELO_L",stack.size(),0.0));
        stack.add(new NoTerminal("procOR",stack.size(),0.0));
    }

    public static void n4(){
        stack.remove(stack.size()-1);
    }

    public static void n5(){
        stack.remove(stack.size()-1);
        stack.add(new NoTerminal("ELO_L",stack.size(),0.0));
        stack.add(new NoTerminal("procOR",stack.size(),0.0));
    }

    public static void n6(){

    }

    public static void n7(){

    }
    
    public static void n8(){

    }

    public static void n9(){

    }

    public static void n10(){

    }
    
    public static void n11(){

    }

    public static void n12(){

    }
    
    public static void n13(){

    }

    public static void n14(){

    }

    public static void n15(){

    }

    public static void n16(){

    }

    public static void n17(){

    }

    public static void n18(){

    }

    public static void n19(){

    }
    
    public static void n20(){

    }

    public static void n21(){

    }

    public static void n22(){

    }

    public static void n23(){

    }

    public static void n24(){

    }

    public static void n25(){

    }
    
    public static void n26(){

    }

    public static void n27(){

    }

    public static void n28(){

    }

    public static void n29(){

    }
    
    public static void n30(){

    }

    public static void n31(){

    }

    public static void n32(){

    }

}
