import java.util.ArrayList;
import java.lang.Math;

public class Recursivo {
    static Lexico cadena;
    static int index;

    public static void S(Lexico _cadena){
        System.out.println("S");
        cadena = _cadena;
        index = 0;
        NoTerminal s1 = new NoTerminal("s1", 0, 0);
        ELO(s1);
        System.out.println(s1.getValor());
    }

    public static void ELO(NoTerminal s1){
       System.out.println("ELO");
        NoTerminal s2 = new NoTerminal("s2", 0, 0);
        EL2(s2);
        ELO_L(s2,s1);
    }

    public static void ELO_L(NoTerminal i1, NoTerminal s1){
        System.out.println("ELO_L");
        if(cadena.darElemento(index).darTipo() == '|'){
            index++;
            NoTerminal s2 = new NoTerminal("s2", 0, 0);
            EL2(s2);
            pRelacional(i1,s2);
            NoTerminal s4 = new NoTerminal("s4", 0, 0);
            procOR(i1,s2,s4);
            ELO_L(s4,s1);
        }else{
            s1.setValorLogico(i1.getValorLogico());
        }
    }
    
    public static void EL2(NoTerminal s1){
        System.out.println("EL2");
        NoTerminal s2 = new NoTerminal("s2", 0, 0);
        ER(s2);
        EL2_L(s2,s1);
    }

    public static void EL2_L(NoTerminal i1, NoTerminal s1){
        System.out.println("EL2_L");
        if(cadena.darElemento(index).darTipo() == '&'){
            index++;
            NoTerminal s2 = new NoTerminal("s2", 0, 0);
            ER(s2);
            pRelacional(i1,s2);
            NoTerminal s4 = new NoTerminal("s4", 0, 0);
            procAND(i1,s2,s4);
            EL2_L(s4,s1);
        }else{
            s1.setValorLogico(i1.getValorLogico());
        }
    }

    public static void ER(NoTerminal s1){
        System.out.println("ER");
        NoTerminal s2 = new NoTerminal("s2", 0, 0);
        E(s2);
        ER_L(s2,s1);
    }

    public static void ER_L(NoTerminal i1, NoTerminal s1){
        System.out.println("ER_L");
        NoTerminal s2 = new NoTerminal("i3", 0, 0);
        OR(s2);
        if(s2.getValor() != 0){
            NoTerminal s3 = new NoTerminal("i4", 0, 0);
            E(s3);
            compare(i1,s2,s3,s1);
        }else{
            s1.setValor(i1.getValor());
        }
    }

    public static void OR(NoTerminal s1){
        System.out.println("OR");
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
        System.out.println("ME");
        if(cadena.darElemento(index).darTipo() == '='){
            index++;
            s1.setValor(1);
        }else{
            s1.setValor(2);
        }
    }

    public static void MA(NoTerminal s1){
        System.out.println("MA");
        if(cadena.darElemento(index).darTipo() == '='){
            index++;
            s1.setValor(3);
        }else{
            s1.setValor(4);
        }
    }

    public static void IG(NoTerminal s1){
        System.out.println("IG");
        if(cadena.darElemento(index).darTipo() == '='){
            index++;
            s1.setValor(5);
        }
    }

    public static void DI(NoTerminal s1){
        System.out.println("DI");
        if(cadena.darElemento(index).darTipo() == '='){
            index++;
            s1.setValor(6);
        }
    }
    
    public static void E(NoTerminal s1){
        System.out.println("E");
        NoTerminal s2 = new NoTerminal("s2", 0, 0);
        T(s2);
        E_L(s2, s1);
    }

    public static void E_L(NoTerminal i1, NoTerminal s1){
        System.out.println("E_L");
        if(cadena.darElemento(index).darTipo() == '-'){
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
            suma(i1,s2,s3);
            E_L(s3,s1);
        }else{
            s1.setValor(i1.getValor());
        }
    }

    public static void T(NoTerminal s1){
        System.out.println("T");
        NoTerminal s2 = new NoTerminal("s2", 0, 0);
        F(s2);
        T_L(s2,s1);
    }

    public static void T_L(NoTerminal i1, NoTerminal s1){
        System.out.println("T_L");
        if(cadena.darTamañoCadena() <= index){
            s1.setValor(i1.getValor());
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
        System.out.println("F_L");
        if(cadena.darElemento(index).darTipo() == '^'){
            index++;
            NoTerminal s2 = new NoTerminal("s2", 0, 0);
            P(s2);
            NoTerminal s3 = new NoTerminal("s3", 0, 0);
            div(i1,s2,s3); 
            F_L(s3,s1);
         }else{
            s1.setValor(i1.getValor());
         }
    }

    public static void F(NoTerminal s1){
        System.out.println("F");
        NoTerminal s2 = new NoTerminal("s2", 0, 0);
        P(s2);
        F_L(s2,s1);
    }


    public static void P(NoTerminal s1){
       System.out.println("P");
        if(cadena.darElemento(index).darTipo() == '('){
            index++;
            ELO(s1);

            if(cadena.darElemento(index).darTipo() == ')'){
                index++;
            }else{
                throw new Error("No hay paréntesis derecho");
            }
        }else if(cadena.darElemento(index).darTipo() == 'i'){
            System.out.println("Entra " + cadena.darElemento(index).darValor());
            s1.setValor(cadena.darElemento(index).darValor());
            index++;
        }
    }

    public static void resta(NoTerminal i1,NoTerminal s2,NoTerminal s3){
        System.out.println("RESTA");
        s3.setValor(i1.getValor()-s2.getValor());
    }

    public static void suma(NoTerminal i1,NoTerminal s2,NoTerminal s3){
        System.out.println("SUMA");
        System.out.println(i1.getValor());
        System.out.println(s2.getValor());
        s3.setValor(i1.getValor()+s2.getValor());
    }

    public static void mult(NoTerminal i1,NoTerminal s2,NoTerminal s3){
        System.out.println("MULT");
        s3.setValor(i1.getValor()*s2.getValor());
    }

    public static void div(NoTerminal i1,NoTerminal s2,NoTerminal s3){
        System.out.println("DIV");
        s3.setValor(i1.getValor()/s2.getValor());
    }

    public static void pow(NoTerminal i1,NoTerminal s2,NoTerminal s3){
        System.out.println("POW");
        s3.setValor(Math.pow(i1.getValor(),s2.getValor()));
    }

    public static void and(NoTerminal i1,NoTerminal s2,NoTerminal s3){
        s3.setRelacional(i1.getValorLogico() && s2.getValorLogico());
    }

    public static void or(NoTerminal i1,NoTerminal s2,NoTerminal s3){
        s3.setRelacional(i1.getValorLogico() || s2.getValorLogico());
    }

    public static void compare(NoTerminal i1,NoTerminal s2,NoTerminal s3,NoTerminal s1){
        double _code = s2.getValor();
        if(_code == 1){ // <=
            s1.setValorLogico(i1.getValor() <= s3.getValor());
            s1.setRelacional(true);
        }else if(_code == 2){ // <
            s1.setValorLogico(i1.getValor() < s3.getValor());
            s1.setRelacional(true);
        }else if(_code == 3){ // >= 
            s1.setValorLogico(i1.getValor() >= s3.getValor());
            s1.setRelacional(true);
        }else if(_code == 4){ // >
            s1.setValorLogico(i1.getValor() > s3.getValor());
            s1.setRelacional(true);
        }else if(_code == 5){ // ==
            s1.setValorLogico(i1.getValor() == s3.getValor());
            s1.setRelacional(true);
        }else if(_code == 6){ // !=
            s1.setValorLogico(i1.getValor() != s3.getValor());
            s1.setRelacional(true);
        }
    }

    public static void pRelacional(NoTerminal i1,NoTerminal i2){
        if(i1.getRelacional() && i2.getRelacional()){
            return;
        }
        throw new Error("expresión no relacional"); 
    }

    public static void procOR(NoTerminal i1,NoTerminal s2,NoTerminal s1){
        s1.setRelacional(true);
        s1.setValorLogico(i1.getValorLogico()||s2.getValorLogico());
    }

    public static void procAND(NoTerminal i1,NoTerminal s2,NoTerminal s1){
        s1.setRelacional(true);
        s1.setValorLogico(i1.getValorLogico()||s2.getValorLogico());
    }

}

