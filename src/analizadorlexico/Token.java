package analizadorlexico;

public class Token {
    
    public String valor;
    public Tipos tipo;

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Tipos getTipo() {
        return tipo;
    }

    public void setTipo(Tipos tipo) {
        this.tipo = tipo;
    }

    enum Tipos{
        NUMERO ("[0-9]+"),
        OPERADOR ("[*|/|+|-]"),
        CONSTANTE("[\bpi\b\be\b]"),
        VARIABLE("[w,x,y,z]"),
        DESCONOCIDO ("[^w,x,y,z|pi|e|0-9|*|/|+|-]+");
        
        public final String patron;
        
        Tipos(String s){
            this.patron = s;
        
        }//Cierra constructor Tipos
    }//Cierra enum Tipos
    
}
