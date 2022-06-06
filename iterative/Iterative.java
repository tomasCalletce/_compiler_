package iterative;

import lexico.*;

import java.util.ArrayList;
import java.lang.Math;

public class Iterative {
    static int index;
    static ArrayList<NoTerminal> stack = new ArrayList<NoTerminal>();
    static Lexico cadena;

    public static void iterative(Lexico _cadena) {
        cadena = _cadena;
        stack.add(new NoTerminal("S", stack.size(), 0.0));

        while (index < cadena.darTamañoCadena()) {
            Elemento el = cadena.darElemento(index);
            if (stack.size() == 0 && el.darTipo() == '¬')
                break;
            NoTerminal topStack = stack.get(stack.size() - 1);
            switch (topStack.getNombre()) {
                case "resultado":
                    resultado();
                    break;
                case "procOR":
                    procOR();
                    break;
                case "procAND":
                    procAND();
                    break;
                case "pRelacional":
                    pRelacion();
                    break;
                case "pComparar":
                    pComparar();
                    break;
                case "suma":
                    suma();
                    break;
                case "resta":
                    resta();
                    break;
                case "mul":
                    mul();
                    break;
                case "div":
                    div();
                    break;
                case "exp":
                    exp();
                    break;
                case "avance":
                    avance();
                    break;
                case "S":
                    switch (el.darTipo()) {
                        case 'i':
                            n1();
                            break;
                        case '(':
                            n1();
                            break;
                        default:
                            throw new Error("ERR STACK: " + topStack.getNombre() + " ERR CADENA: " + el.darTipo());
                    }
                    break;
                case "ELO":
                    switch (el.darTipo()) {
                        case 'i':
                            n2();
                            break;
                        case '(':
                            n2();
                            break;
                        default:
                            throw new Error("ERR STACK: " + topStack.getNombre() + " ERR CADENA: " + el.darTipo());
                    }
                    break;
                case "EL2":
                    switch (el.darTipo()) {
                        case 'i':
                            n5();
                            break;
                        case '(':
                            n5();
                            break;
                        default:
                            throw new Error("ERR STACK: " + topStack.getNombre() + " ERR CADENA: " + el.darTipo());
                    }
                    break;
                case "ELOL":
                    switch (el.darTipo()) {
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
                            throw new Error("ERR STACK: " + topStack.getNombre() + " ERR CADENA: " + el.darTipo());
                    }
                    break;
                case "EL2L":
                    switch (el.darTipo()) {
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
                            throw new Error("ERR STACK: " + topStack.getNombre() + " ERR CADENA: " + el.darTipo());
                    }
                    break;
                case "ER":
                    switch (el.darTipo()) {
                        case 'i':
                            n8();
                            break;
                        case '(':
                            n8();
                            break;
                        default:
                            throw new Error("ERR STACK: " + topStack.getNombre() + " ERR CADENA: " + el.darTipo());
                    }
                    break;
                case "ERL":
                    switch (el.darTipo()) {
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
                            throw new Error("ERR STACK: " + topStack.getNombre() + " ERR CADENA: " + el.darTipo());
                    }
                    break;
                case "OR":
                    switch (el.darTipo()) {
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
                            throw new Error("ERR STACK: " + topStack.getNombre() + " ERR CADENA: " + el.darTipo());
                    }
                    break;
                case "E":
                    switch (el.darTipo()) {
                        case 'i':
                            n21();
                            break;
                        case '(':
                            n21();
                            break;
                        default:
                            throw new Error("ERR STACK: " + topStack.getNombre() + " ERR CADENA: " + el.darTipo());
                    }
                    break;
                case "ME":
                    switch (el.darTipo()) {
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
                            throw new Error("ERR STACK: " + topStack.getNombre() + " ERR CADENA: " + el.darTipo());
                    }
                    break;
                case "MA":
                    switch (el.darTipo()) {
                        case 'i':
                            n16();
                            break;
                        case '=':
                            n15();
                            break;
                        case '(':
                            n16();
                            break;
                        default:
                            throw new Error("ERR STACK: " + topStack.getNombre() + " ERR CADENA: " + el.darTipo());
                    }
                    break;
                case "IG":
                    switch (el.darTipo()) {
                        case '=':
                            n18();
                            break;
                        default:
                            throw new Error("ERR STACK: " + topStack.getNombre() + " ERR CADENA: " + el.darTipo());
                    }
                    break;
                case "DI":
                    switch (el.darTipo()) {
                        case '=':
                            n20();
                            break;
                        default:
                            throw new Error("ERR STACK: " + topStack.getNombre() + " ERR CADENA: " + el.darTipo());
                    }
                    break;
                case "EL":
                    switch (el.darTipo()) {
                        case '+':
                            n22();
                            break;
                        case '-':
                            n23();
                            break;
                        case '<':
                            n24();
                            break;
                        case '>':
                            n24();
                            break;
                        case '=':
                            n24();
                            break;
                        case '!':
                            n24();
                            break;
                        case '|':
                            n24();
                            break;
                        case '&':
                            n24();
                            break;
                        case ')':
                            n24();
                            break;
                        case '¬':
                            n24();
                            break;
                        default:
                            throw new Error("ERR STACK: " + topStack.getNombre() + " ERR CADENA: " + el.darTipo());
                    }
                    break;
                case "T":
                    switch (el.darTipo()) {
                        case 'i':
                            n25();
                            break;
                        case '(':
                            n25();
                            break;
                        default:
                            throw new Error("ERR STACK: " + topStack.getNombre() + " ERR CADENA: " + el.darTipo());
                    }
                    break;
                case "TL":
                    switch (el.darTipo()) {
                        case '+':
                            n28();
                            break;
                        case '-':
                            n28();
                            break;
                        case '*':
                            n26();
                            break;
                        case '/':
                            n27();
                            break;
                        case '>':
                            n28();
                            break;
                        case '<':
                            n28();
                            break;
                        case '=':
                            n28();
                            break;
                        case '!':
                            n28();
                            break;
                        case '|':
                            n28();
                            break;
                        case '&':
                            n28();
                            break;
                        case ')':
                            n28();
                            break;
                        case '¬':
                            n28();
                            break;
                        default:
                            throw new Error("ERR STACK: " + topStack.getNombre() + " ERR CADENA: " + el.darTipo());
                    }
                    break;
                case "F":
                    switch (el.darTipo()) {
                        case 'i':
                            n29();
                            break;
                        case '(':
                            n29();
                            break;
                        default:
                            throw new Error("ERR STACK: " + topStack.getNombre() + " ERR CADENA: " + el.darTipo());
                    }
                    break;
                case "FL":
                    switch (el.darTipo()) {
                        case '+':
                            n31();
                            break;
                        case '-':
                            n31();
                            break;
                        case '*':
                            n31();
                            break;
                        case '/':
                            n31();
                            break;
                        case '^':
                            n30();
                            break;
                        case '>':
                            n31();
                            break;
                        case '<':
                            n31();
                            break;
                        case '=':
                            n31();
                            break;
                        case '!':
                            n31();
                            break;
                        case '|':
                            n31();
                            break;
                        case '&':
                            n31();
                            break;
                        case ')':
                            n31();
                            break;
                        case '¬':
                            n31();
                            break;
                        default:
                            throw new Error("ERR STACK: " + topStack.getNombre() + " ERR CADENA: " + el.darTipo());
                    }
                    break;
                case "P":
                    switch (el.darTipo()) {
                        case 'i':
                            n33();
                            break;
                        case '(':
                            n32();
                            break;
                        default:
                            throw new Error("ERR STACK: " + topStack.getNombre() + " ERR CADENA: " + el.darTipo());
                    }
                    break;
            }
        }
    }

    public static void n1() {
        pop();
        stack.add(new NoTerminal("resultado", stack.size(), 0.0));
        stack.add(new NoTerminal("ELO", stack.size() - 1, 0.0));
    }

    public static void n2() {
        NoTerminal ELO = pop();
        stack.add(new NoTerminal("i1", stack.size(), 0.0));
        stack.add(new NoTerminal("ELOL", ELO.getDirec(), 0.0));
        stack.add(new NoTerminal("EL2", stack.size() - 2, 0.0));
    }

    public static void n3() {
        NoTerminal ELOL = pop();
        NoTerminal i1 = pop();
        stack.add(new NoTerminal("i6", stack.size(), 0.0)); // 0
        stack.add(new NoTerminal("ELOL", ELOL.getDirec(), 0.0)); // 1
        stack.add(new NoTerminal("i4", stack.size(), 0.0)); // 2
        stack.get(stack.size() - 1).copyValues(i1);
        stack.add(new NoTerminal("i5", stack.size(), 0.0)); // 3
        stack.add(new NoTerminal("procOR", stack.size() - 4, 0.0)); // 4
        stack.add(new NoTerminal("i2", stack.size(), 0.0)); // 5
        stack.get(stack.size() - 1).copyValues(i1);
        stack.add(new NoTerminal("i3", stack.size() - 3, 0.0)); // 6
        stack.add(new NoTerminal("pRelacional", stack.size(), 0.0)); // 7
        stack.add(new NoTerminal("EL2", stack.size() - 2, 0.0)); // 8
        index++;
    }

    public static void n4() {
        NoTerminal ELOL = stack.get(stack.size() - 1);
        NoTerminal i1 = stack.get(stack.size() - 2);
        ELOL.copyValues(i1);
        pop();
        pop();
    }

    public static void n5() {
        NoTerminal EL2 = pop();
        stack.add(new NoTerminal("i1", stack.size(), 0.0));
        stack.add(new NoTerminal("EL2L", EL2.getDirec(), 0.0));
        stack.add(new NoTerminal("ER", stack.size() - 2, 0.0));
    }

    public static void n6() {
        NoTerminal EL2L = pop();
        NoTerminal i1 = pop();
        stack.add(new NoTerminal("i6", stack.size(), 0.0)); // 0
        stack.add(new NoTerminal("EL2L", EL2L.getDirec(), 0.0)); // 1
        stack.add(new NoTerminal("i4", stack.size(), 0.0)); // 2
        stack.get(stack.size() - 1).copyValues(i1);
        stack.add(new NoTerminal("i5", stack.size(), 0.0)); // 3
        stack.add(new NoTerminal("procAND", stack.size() - 4, 0.0)); // 4
        stack.add(new NoTerminal("i2", stack.size(), 0.0)); // 5
        stack.get(stack.size() - 1).copyValues(i1);
        stack.add(new NoTerminal("i3", stack.size() - 3, 0.0)); // 6
        stack.add(new NoTerminal("pRelacional", stack.size(), 0.0)); // 7
        stack.add(new NoTerminal("ER", stack.size() - 2, 0.0)); // 8
        index++;
    }

    public static void n7() {
        NoTerminal EL2L = stack.get(stack.size() - 1);
        NoTerminal i1 = stack.get(stack.size() - 2);
        EL2L.copyValues(i1);
        pop();
        pop();
    }

    public static void n8() {
        NoTerminal ER = pop();
        stack.add(new NoTerminal("i1", stack.size(), 0.0));
        stack.add(new NoTerminal("ERL", ER.getDirec(), 0.0));
        stack.add(new NoTerminal("E", stack.size() - 2, 0.0));
    }

    public static void n9() {
        NoTerminal ERL = pop();
        NoTerminal i1 = pop();
        stack.add(new NoTerminal("i2", stack.size(), 0.0));
        stack.get(stack.size() - 1).copyValues(i1);
        stack.add(new NoTerminal("i3", stack.size(), 0.0));
        stack.add(new NoTerminal("i4", stack.size(), 0.0));
        stack.add(new NoTerminal("pComparar", ERL.getDirec(), 0.0));
        stack.add(new NoTerminal("E", stack.size() - 3, 0.0));
        stack.add(new NoTerminal("OR", stack.size() - 3, 0.0));
    }

    public static void n10() {
        NoTerminal ERL = stack.get(stack.size() - 1);
        NoTerminal i1 = stack.get(stack.size() - 2);
        ERL.copyValues(i1);
        pop();
        pop();
    }

    public static void n11() {
        NoTerminal OR = pop();
        stack.add(new NoTerminal("ME", OR.getDirec(), 0.0));
        index++;
    }

    public static void n12() {
        NoTerminal ME = stack.get(stack.size() - 1);
        ME.setValor(1);
        pop();
        index++;
    }

    public static void n13() {
        NoTerminal ME = stack.get(stack.size() - 1);
        ME.setValor(2);
        pop();
    }

    public static void n14() {
        NoTerminal OR = pop();
        stack.add(new NoTerminal("MA", OR.getDirec(), 0.0));
        index++;
    }

    public static void n15() {
        NoTerminal MA = stack.get(stack.size() - 1);
        MA.setValor(3);
        pop();
        index++;
    }

    public static void n16() {
        NoTerminal MA = stack.get(stack.size() - 1);
        MA.setValor(4);
        pop();
    }

    public static void n17() {
        NoTerminal OR = pop();
        stack.add(new NoTerminal("IG", OR.getDirec(), 0.0));
        index++;
    }

    public static void n18() {
        NoTerminal IG = stack.get(stack.size() - 1);
        IG.setValor(5);
        pop();
        index++;
    }

    public static void n19() {
        NoTerminal OR = pop();
        stack.add(new NoTerminal("DI", OR.getDirec(), 0.0));
        index++;
    }

    public static void n20() {
        NoTerminal DI = stack.get(stack.size() - 1);
        DI.setValor(6);
        pop();
        index++;
    }

    public static void n21() {
        NoTerminal E = pop();
        stack.add(new NoTerminal("i1", stack.size(), 0.0));
        stack.add(new NoTerminal("EL", E.getDirec(), 0.0));
        stack.add(new NoTerminal("T", stack.size() - 2, 0.0));
    }

    public static void n22() {
        NoTerminal EL = pop();
        NoTerminal i1 = pop();
        stack.add(new NoTerminal("i4", stack.size(), 0.0));
        stack.add(new NoTerminal("EL", EL.getDirec(), 0.0));
        stack.add(new NoTerminal("i2", stack.size(), 0.0));
        stack.get(stack.size() - 1).copyValues(i1);
        stack.add(new NoTerminal("i3", stack.size(), 0.0));
        stack.add(new NoTerminal("suma", stack.size() - 4, 0.0));
        stack.add(new NoTerminal("T", stack.size() - 2, 0.0));
        index++;
    }

    public static void n23() {
        NoTerminal EL = pop();
        NoTerminal i1 = pop();
        stack.add(new NoTerminal("i4", stack.size(), 0.0));
        stack.add(new NoTerminal("EL", EL.getDirec(), 0.0));
        stack.add(new NoTerminal("i2", stack.size(), 0.0));
        stack.get(stack.size() - 1).copyValues(i1);
        stack.add(new NoTerminal("i3", stack.size(), 0.0));
        stack.add(new NoTerminal("resta", stack.size() - 4, 0.0));
        stack.add(new NoTerminal("T", stack.size() - 2, 0.0));
        index++;
    }

    public static void n24() {
        NoTerminal EL = stack.get(stack.size() - 1);
        NoTerminal i1 = stack.get(stack.size() - 2);
        EL.copyValues(i1);
        pop();
        pop();
    }

    public static void n25() {
        NoTerminal T = pop();
        stack.add(new NoTerminal("i1", stack.size(), 0.0));
        stack.add(new NoTerminal("TL", T.getDirec(), 0.0));
        stack.add(new NoTerminal("F", stack.size() - 2, 0.0));
    }

    public static void n26() {
        NoTerminal TL = pop();
        NoTerminal i1 = pop();
        stack.add(new NoTerminal("i4", stack.size(), 0.0));
        stack.add(new NoTerminal("TL", TL.getDirec(), 0.0));
        stack.add(new NoTerminal("i2", stack.size(), 0.0));
        stack.get(stack.size() - 1).copyValues(i1);
        stack.add(new NoTerminal("i3", stack.size(), 0.0));
        stack.add(new NoTerminal("mul", stack.size() - 4, 0.0));
        stack.add(new NoTerminal("F", stack.size() - 2, 0.0));
        index++;
    }

    public static void n27() {
        NoTerminal TL = pop();
        NoTerminal i1 = pop();
        stack.add(new NoTerminal("i4", stack.size(), 0.0));
        stack.add(new NoTerminal("TL", TL.getDirec(), 0.0));
        stack.add(new NoTerminal("i2", stack.size(), 0.0));
        stack.get(stack.size() - 1).copyValues(i1);
        stack.add(new NoTerminal("i3", stack.size(), 0.0));
        stack.add(new NoTerminal("div", stack.size() - 4, 0.0));
        stack.add(new NoTerminal("F", stack.size() - 2, 0.0));
        index++;
    }

    public static void n28() {
        NoTerminal TL = stack.get(stack.size() - 1);
        NoTerminal i1 = stack.get(stack.size() - 2);
        TL.copyValues(i1);
        pop();
        pop();
    }

    public static void n29() {
        NoTerminal F = pop();
        stack.add(new NoTerminal("i1", stack.size(), 0.0));
        stack.add(new NoTerminal("FL", F.getDirec(), 0.0));
        stack.add(new NoTerminal("P", stack.size() - 2, 0.0));
    }

    public static void n30() {
        NoTerminal FL = pop();
        NoTerminal i1 = pop();
        stack.add(new NoTerminal("i4", stack.size(), 0.0));
        stack.add(new NoTerminal("FL", FL.getDirec(), 0.0));
        stack.add(new NoTerminal("i2", stack.size(), 0.0));
        stack.get(stack.size() - 1).copyValues(i1);
        stack.add(new NoTerminal("i3", stack.size(), 0.0));
        stack.add(new NoTerminal("exp", stack.size() - 4, 0.0));
        stack.add(new NoTerminal("P", stack.size() - 2, 0.0));
        index++;
    }

    public static void n31() {
        NoTerminal FL = stack.get(stack.size() - 1);
        NoTerminal i1 = stack.get(stack.size() - 2);
        FL.copyValues(i1);
        pop();
        pop();
    }

    public static void n32() {
        NoTerminal P = pop();
        stack.add(new NoTerminal("avance", stack.size(), 0.0));
        stack.add(new NoTerminal("ELO", P.getDirec(), 0.0));
        index++;
    }

    public static void n33() {
        NoTerminal P = stack.get(stack.size() - 1);
        P.setValor(cadena.darElemento(index).darValor());
        pop();
        index++;
    }

    public static void resultado() {
        NoTerminal resultado = pop();// quitar NoTerminal con resultado
        if (resultado.getRelacional()) {
            System.out.println("Resultado: " + resultado.getValorLogico());
        } else {
            System.out.println("Resultado: " + resultado.getValor());
        }
    }

    public static void procOR() {
        NoTerminal procOR = stack.get(stack.size() - 1);
        NoTerminal i4 = stack.get(stack.size() - 3);
        NoTerminal i5 = stack.get(stack.size() - 2);
        procOR.setRelacional(true);
        procOR.setValorLogico(i4.getValorLogico() || i5.getValorLogico());
        pop();
        pop();
        pop();
    }

    public static void procAND() {
        NoTerminal procAND = stack.get(stack.size() - 1);
        NoTerminal i4 = stack.get(stack.size() - 3);
        NoTerminal i5 = stack.get(stack.size() - 2);
        procAND.setRelacional(true);
        procAND.setValorLogico(i4.getValorLogico() && i5.getValorLogico());
        pop();
        pop();
        pop();
    }

    public static void pRelacion() {
        NoTerminal i2 = stack.get(stack.size() - 3);
        NoTerminal i3 = stack.get(stack.size() - 2);
        if (i2.getRelacional() && i3.getRelacional()) {
            pop();
            pop();
            pop();
            return;
        }
        throw new Error("expresión no relacional");
    }

    public static void pComparar() {
        NoTerminal pComparar = stack.get(stack.size() - 1);
        NoTerminal i2 = stack.get(stack.size() - 4);
        NoTerminal i3 = stack.get(stack.size() - 3);
        NoTerminal i4 = stack.get(stack.size() - 2);
        double _code = i4.getValor();
        if (_code == 1) { // <=
            pComparar.setValorLogico(i2.getValor() <= i3.getValor());
            pComparar.setRelacional(true);
        } else if (_code == 2) { // <
            pComparar.setValorLogico(i2.getValor() < i3.getValor());
            pComparar.setRelacional(true);
        } else if (_code == 3) { // >=
            pComparar.setValorLogico(i2.getValor() >= i3.getValor());
            pComparar.setRelacional(true);
        } else if (_code == 4) { // >
            pComparar.setValorLogico(i2.getValor() > i3.getValor());
            pComparar.setRelacional(true);
        } else if (_code == 5) { // ==
            pComparar.setValorLogico(i2.getValor() == i3.getValor());
            pComparar.setRelacional(true);
        } else if (_code == 6) { // !=
            pComparar.setValorLogico(i2.getValor() != i3.getValor());
            pComparar.setRelacional(true);
        }
        pop();
        pop();
        pop();
        pop();
    }

    public static void suma() {
        NoTerminal suma = stack.get(stack.size() - 1);
        NoTerminal i2 = stack.get(stack.size() - 3);
        NoTerminal i3 = stack.get(stack.size() - 2);
        suma.setValor(i2.getValor() + i3.getValor());
        pop();
        pop();
        pop();
    }

    public static void mul() {
        NoTerminal mul = stack.get(stack.size() - 1);
        NoTerminal i2 = stack.get(stack.size() - 3);
        NoTerminal i3 = stack.get(stack.size() - 2);
        mul.setValor(i2.getValor() * i3.getValor());
        pop();
        pop();
        pop();
    }

    public static void div() {
        NoTerminal div = stack.get(stack.size() - 1);
        NoTerminal i2 = stack.get(stack.size() - 3);
        NoTerminal i3 = stack.get(stack.size() - 2);
        div.setValor(i2.getValor() / i3.getValor());
        pop();
        pop();
        pop();
    }

    public static void resta() {
        NoTerminal resta = stack.get(stack.size() - 1);
        NoTerminal i2 = stack.get(stack.size() - 3);
        NoTerminal i3 = stack.get(stack.size() - 2);
        resta.setValor(i2.getValor() - i3.getValor());
        pop();
        pop();
        pop();
    }

    public static void exp() {
        NoTerminal exp = stack.get(stack.size() - 1);
        NoTerminal i2 = stack.get(stack.size() - 3);
        NoTerminal i3 = stack.get(stack.size() - 2);
        exp.setValor(Math.pow(i2.getValor(), i3.getValor()));
        pop();
        pop();
        pop();
    }

    public static void avance() {
        pop();
        index++;
    }

    public static NoTerminal pop() {
        NoTerminal nT = stack.get(stack.size() - 1);
        NoTerminal rNT = stack.get(nT.getDirec());
        rNT.copyValues(nT);
        stack.remove(stack.size() - 1);
        return nT;
    }

}
