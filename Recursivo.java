import java.util.ArrayList;

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
             //resta()
             E_L(s2,s1);
         }else if(cadena.darElemento(index).darTipo() == '+'){
            index++;
            NoTerminal s2 = new NoTerminal("s2", 0, 0);
            T(s2);
            //suma()
            E_L(s2,s1);
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
             // mult 
             T_L(s2,s1);
         }else if(cadena.darElemento(index).darTipo() == '/'){
            index++;
            NoTerminal s2 = new NoTerminal("s2", 0, 0);
            F(s2);
            // div()
            T_L(s2,s1);
        }
    }

    public static void F_L(NoTerminal i1, NoTerminal s1){
        if(cadena.darTamañoCadena() >= index){
            s1.setValorLogico(i1.getValorLogico());
         }else if(cadena.darElemento(index).darTipo() == '^'){
             index++;
             NoTerminal s2 = new NoTerminal("s2", 0, 0);
             P(s2);
             // exp()
             F_L(s2,s1);
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
}

