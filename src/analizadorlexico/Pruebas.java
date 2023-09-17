package analizadorlexico;

import analizadorlexico.Token.Tipos; //impotacion del enum Tipo
import com.jtattoo.plaf.aero.AeroLookAndFeel;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.UIManager;
import com.jtattoo.plaf.aero.*; 
import com.jtattoo.plaf.aluminium.AluminiumLookAndFeel;
import com.jtattoo.plaf.bernstein.BernsteinLookAndFeel;
import com.jtattoo.plaf.fast.FastLookAndFeel;
import com.jtattoo.plaf.hifi.HiFiLookAndFeel;
import com.jtattoo.plaf.luna.LunaLookAndFeel;
import com.jtattoo.plaf.mint.MintLookAndFeel;
import com.jtattoo.plaf.texture.TextureLookAndFeel;
import javax.swing.UIManager;

public class Pruebas {
    
    public static void main(String[] args) {
        
        /*
        TEMAS:
        AcrylLookAndFeel
        AeroLookAndFeel
        AluminiumLookAndFeel
        BernsteinLookAndFeel
        FastLookAndFeel
        HiFiLookAndFeel
        McWinLookAndFeel
        MintLookAndFeel
        NoireLookAndFeel
        SmartLookAndFeel
        LunaLookAndFeel
        TextureLookAndFeel
        McWinLookAndFeel
        SmartLookAndFeel
        AcrylLookAndFeel
        TextureLookAndFeel
        MintLookAndFeel
        AcrylLookAndFeel
        */
        
        try {
           // AeroLookAndFeel.setTheme("Green-Giant-Font");
            
            UIManager.setLookAndFeel(new TextureLookAndFeel());
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
        
        LEXICOGUI interfazLexico = new LEXICOGUI();
        
        interfazLexico.setVisible(true);
       
        String entrada = "11 + 22 - w - 33";
        
        ArrayList<Token> tokens = lex(entrada);
        
        Token enumerador = new Token();
        
        
        int numeros = 0;
        int operadores = 0;
        int constantes = 0;
        int variables = 0;
        int desconocidos = 0;
 
        
        for (Token token : tokens) {
            System.out.println(token.getTipo()+ " : " + token.getValor());
           
            
            if (token.getTipo() == enumerador.tipo.NUMERO) {
                numeros++;
            }else if (token.getTipo() == enumerador.tipo.OPERADOR) {
                operadores++;
            }else if (token.getTipo() == enumerador.tipo.CONSTANTE) {
                constantes++;
            }else if (token.getTipo() == enumerador.tipo.VARIABLE) {
                variables++;
            }else if (token.getTipo() == enumerador.tipo.DESCONOCIDO) {
                desconocidos++;
            }
           
        }
        
        System.out.println("Hay: \n" + numeros + " NUMEROS\n" + operadores +" OPERADORES\n"+ constantes + " CONSTANTE\n" + variables +" VARIABLES\n"+ desconocidos +" DESCONOCIDOS\n");
        
    }
    
    public static ArrayList<Token> lex(String entrada){
    
        final ArrayList<Token> tokens = new ArrayList<>();
        final StringTokenizer st = new StringTokenizer(entrada );
        
        while (st.hasMoreTokens()) {  
            String palabra = st.nextToken();
            boolean bandera = false;
            
            for (Tipos tokenTipo : Tipos.values()) {
                Pattern patron = Pattern.compile(tokenTipo.patron);
                Matcher busqueda = patron.matcher(palabra);
                
                if (busqueda.find()) {
                    Token token = new Token();
                    
                    token.setTipo(tokenTipo);
                    token.setValor(palabra);
                    tokens.add(token);
                    bandera = true;
                    
                }//Cierra if
                
            }// Cierra for
            if (!bandera) {
                throw new RuntimeException("Token Invalido");
            }
        }// Cierra while
        
        return tokens;
    }//cierra ArrayList
            
    
}
