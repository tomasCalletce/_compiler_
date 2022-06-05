

public class Index {

    static String cad1 = "0123456789.";
    static String digitos="0123456789";
    static String cad="((25+3.2)*2)+7¬";
    static int indice=0;
    static char sim=' ';
    static Lexico lex1 = new Lexico();

 
    public static void main(String[] args) {

        analisisLexico();
        cad = lex1.cadenaLexico();

        lex1.mostrarLexico();
        System.out.println(" cadena"+ lex1.cadenaLexico());
        
        Recursivo.S(lex1);

        System.out.println("index Recursivo: " + Recursivo.index);
        System.out.println("index Lexico: " + lex1.darTamañoCadena());

    
    }

    
    

    public static void analisisLexico(){
        // Este analizador es sencillo determina solo constantes enteras y reales positivas
        // Trabaja los diferentes elementos en un ArrayList que trabaja con la clase Clexico
        // la cual define el ArrayList con la clase CElemento
        // Almacen los valores para poder hallar los resultados
        
        Elemento ele1; 
        
        int i=0;
        int ind=0;
        char tip=0;
        char sim1=cad.charAt(i);
        double val=0;
        
        while (sim1!='¬'){
            // determina si sim1 esta en la cadena de digitos cad1 que es global
            if (cad1.indexOf(sim1)!=-1){
                String num="";
                while(cad1.indexOf(sim1)!=-1){
                    num=num+sim1;
                    i++;
                    sim1=cad.charAt(i);
        
                }
                // en el String num se almacena el entero y se lo almacena en val como doble
                // DeterminarNumero(num);
                if (determinarNumero(num)){
                    val=Double.parseDouble(num);
                    tip='i';
                
                    // se tipifica el valor como i
                }
                else{
                    System.out.println("Se rechaza la secuencia");
                    System.exit(0);
                }
        
            }
            else {
               // si el simbolo de entrada no esta en cad1 lo tipifica como tal ej
               // +,-,* (,) etc.
                
               tip=(char)sim1;
               i++;
               sim1=cad.charAt(i);
              
               val=0;
              
            }
        
            // con los elementos establecidos anteriormente se crea el elemento y se lo
            // adicina a lex1 que es el objeto de la clase Clexico
            
            ele1=new Elemento(tip,val,ind);
            lex1.adicionarElemento(ele1);
            
            ind=ind+1;
            //System.out.print("indice ="+ind);
               
        }
        ele1=new Elemento('¬',0,ind);
        lex1.adicionarElemento(ele1);

    }
    
    public static boolean determinarNumero(String numero){
        // Este método recibe un número en string y determina mediante un autómata finito
        // si está o no correcto. El string es una cadena de dígitos y el punto.
        // Retorna un valor booleano.
        
           int estado=1,i=0;
           char simbolo;
           boolean b=true;
           while (i<numero.length()&&b) {
               simbolo = numero.charAt(i);
               switch (simbolo) {
                   case '0':case '1':case '2':case '3':case '4':case '5':case '6':  
                   case '7':case '8':case '9':    
                       switch (estado) {
                           case 1:
                              estado=2;
                              i++;
           
                              break;
                           case 2:
                              estado=2;
                              i++;
           
                              break;
                           case 3:
                              estado=4;
                              i++;
           
                              break;
                           case 4:
                               estado=4;
                              i++;
           
                              break;
                       
                       }
                       break;
                   case '.':    
                       switch (estado) {
                           case 1:case 3: case 4:
                              b=false;
                              break;
                           case 2:
                              estado=3;
                              i++;
           
                              break;
                           
                       
                       }
                       break;
                   default: b=false;
               }
           
       }
           return b;
       }
       
       

}