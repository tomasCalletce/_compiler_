import java.util.ArrayList;
import java.lang.Math;

public class Recursivo {
    static Lexico cadena;
    static int index;

    public static void S(Lexico _cadena){
        cadena = _cadena;
        index = 0;
        NoTerminal s1 = new NoTerminal("s1", 0, 0);
        ELO(s1);
    }

    public static void ELO(NoTerminal s1){
        NoTerminal s2 = new NoTerminal("s2", 0, 0);
        EL2(s2);
        ELO_L(s2,s1);
    }

    public static void ELO_L(NoTerminal i1, NoTerminal s1){
        if(cadena.darTamañoCadena() >= index){
            s1.setValorLogico(i1.getValorLogico());
        }
        else if(cadena.darElemento(index).darTipo() == '|'){
            index++;
            NoTerminal s2 = new NoTerminal("s2", 0, 0);
            EL2(s2);
            // pRelacional();
            // procOR()
            ELO_L(s2,s1);
        }else{

        }
    }
    
    public static void EL2(NoTerminal s1){
        NoTerminal s2 = new NoTerminal("s2", 0, 0);
        ER(s2);
        EL2_L(s2,s1);
    }

    public static void EL2_L(NoTerminal i1, NoTerminal s1){
        if(cadena.darTamañoCadena() >= index){
            s1.setValorLogico(i1.getValorLogico());
         }else if(cadena.darElemento(index).darTipo() == '&'){
             index++;
             NoTerminal s2 = new NoTerminal("s2", 0, 0);
             ER(s2);
             // pRelacional();
             // procOR()
             EL2_L(s2,s1);
         }
    }

    public static void ER(NoTerminal s1){
        NoTerminal s2 = new NoTerminal("s2", 0, 0);
        E(s2);
        ER_L(s2,s1);
    }

    public static void ER_L(NoTerminal i1, NoTerminal s1){
        NoTerminal i3 = new NoTerminal("i3", 0, 0);
        NoTerminal i4 = new NoTerminal("i4", 0, 0);
        OR(i4);
        E(i3);
        // compare 
        // darle valor a il y s1
    }

    public static void OR(NoTerminal s1){
        if(cadena.darElemento(index).darTipo() == '<'){
            index++;
            ME(s1);
        }else if(cadena.darElemento(index).darTipo() == '>'){
            index++;
            MA(s1);
        }else if(cadena.darElemento(index).darTipo() == '='){
            index++;
            IG(s1);
        }else if(cadena.darElemento(index).darTipo() == '!'){
            index++;
            DI(s1);
        }
    }  
    
    public static void ME(NoTerminal s1){
        if(cadena.darElemento(index).darTipo() == '='){
            index++;
            s1.setValor(1);
        }else{
            s1.setValor(2);
        }
    }

    public static void MA(NoTerminal s1){
        if(cadena.darElemento(index).darTipo() == '='){
            index++;
            s1.setValor(3);
        }else{
            s1.setValor(4);
        }
    }

    public static void IG(NoTerminal s1){
        if(cadena.darElemento(index).darTipo() == '='){
            index++;
            s1.setValor(5);
        }
    }

    public static void DI(NoTerminal s1){
        if(cadena.darElemento(index).darTipo() == '='){
            index++;
            s1.setValor(6);
        }
    }
    
    public static void E(NoTerminal s1){
        NoTerminal s2 = new NoTerminal("s2", 0, 0);
        T(s2);
        E_L(s2, s1);
    }

    public static void E_L(NoTerminal i1, NoTerminal s1){
        if(cadena.darTamañoCadena() >= index){
            s1.setValorLogico(i1.getValorLogico());
         }else if(cadena.darElemento(index).darTipo() == '-'){
             index++;
             NoTerminal s2 = new NoTerminal("s2", 0, 0);
             T(s2);
             NoTerminal s3 = new NoTerminal("s3", 0, 0);
             resta(i1,s2,s3);
             E_L(s3,s1);
         }else if(cadena.darElemento(index).darTipo() == '+'){
            index++;
            NoTerminal s2 = new NoTerminal("s2", 0, 0);
            T(s2);
            NoTerminal s3 = new NoTerminal("s3", 0, 0);
            resta(i1,s2,s3);
            E_L(s3,s1);
        }
    }

    public static void T(NoTerminal s1){
        NoTerminal s2 = new NoTerminal("s2", 0, 0);
        F(s2);
        T_L(s2,s1);
    }

    public static void T_L(NoTerminal i1, NoTerminal s1){
        if(cadena.darTamañoCadena() >= index){
            s1.setValorLogico(i1.getValorLogico());
         }else if(cadena.darElemento(index).darTipo() == '*'){
            index++;
            NoTerminal s2 = new NoTerminal("s2", 0, 0);
            F(s2);
            NoTerminal s3 = new NoTerminal("s3", 0, 0);
            mult(i1,s2,s3); 
            T_L(s3,s1);
         }else if(cadena.darElemento(index).darTipo() == '/'){
            index++;
            NoTerminal s2 = new NoTerminal("s2", 0, 0);
            F(s2);
            NoTerminal s3 = new NoTerminal("s3", 0, 0);
            div(i1,s2,s3); 
            T_L(s3,s1);
        }
    }

    public static void F_L(NoTerminal i1, NoTerminal s1){
        if(cadena.darTamañoCadena() >= index){
            s1.setValorLogico(i1.getValorLogico());
         }else if(cadena.darElemento(index).darTipo() == '^'){
            index++;
            NoTerminal s2 = new NoTerminal("s2", 0, 0);
            P(s2);
            NoTerminal s3 = new NoTerminal("s3", 0, 0);
            div(i1,s2,s3); 
            F_L(s3,s1);
         }
    }

    public static void F(NoTerminal s1){
        NoTerminal s2 = new NoTerminal("s2", 0, 0);
        P(s2);
        F_L(s2,s1);
    }


    public static void P(NoTerminal s1){
        if(cadena.darElemento(index).darTipo() == '('){
            index++;
            ELO(s1);
        }else if(cadena.darElemento(index).darTipo() == 'i'){
            s1.setValor(cadena.darElemento(index).darValor());
        }
    }

    public static void resta(NoTerminal i1,NoTerminal s2,NoTerminal s3){
        s3.setValor(i1.getValor()-s2.getValor());
    }

    public static void suma(NoTerminal i1,NoTerminal s2,NoTerminal s3){
        s3.setValor(i1.getValor()-s2.getValor());
    }

    public static void mult(NoTerminal i1,NoTerminal s2,NoTerminal s3){
        s3.setValor(i1.getValor()*s2.getValor());
    }

    public static void div(NoTerminal i1,NoTerminal s2,NoTerminal s3){
        s3.setValor(i1.getValor()/s2.getValor());
    }

    public static void pow(NoTerminal i1,NoTerminal s2,NoTerminal s3){
        s3.setValor(Math.pow(i1.getValor(),s2.getValor()));
    }

    public static void and(NoTerminal i1,NoTerminal s2,NoTerminal s3){
        s3.setRelacional(i1.getValorLogico() && s2.getValorLogico());
    }

    public static void or(NoTerminal i1,NoTerminal s2,NoTerminal s3){
        s3.setRelacional(i1.getValorLogico() || s2.getValorLogico());
    }
}

