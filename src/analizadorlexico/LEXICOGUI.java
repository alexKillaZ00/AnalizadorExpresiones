
package analizadorlexico;

import java.util.ArrayList;

public class LEXICOGUI extends javax.swing.JFrame {

    public LEXICOGUI() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtEntrada = new javax.swing.JTextField();
        bAnalizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResultados = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEntradaActionPerformed(evt);
            }
        });
        jPanel1.add(txtEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 300, 37));

        bAnalizar.setBackground(new java.awt.Color(102, 255, 255));
        bAnalizar.setText("Analizar");
        bAnalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAnalizarActionPerformed(evt);
            }
        });
        jPanel1.add(bAnalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, 150, 34));

        txtResultados.setBackground(new java.awt.Color(255, 255, 153));
        txtResultados.setColumns(20);
        txtResultados.setRows(5);
        jScrollPane1.setViewportView(txtResultados);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 300, 170));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("RESULTADOS");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bAnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAnalizarActionPerformed

        txtResultados.setText("");
        String expresion = txtEntrada.getText();
        
        Pruebas prueba = new Pruebas();
        Token enumerador = new Token();
        
        int numero = 0;
        int operador = 0; 
        int constante = 0;
        int variable = 0;
        int desc = 0;
        
        ArrayList<Token> tokens = Pruebas.lex(expresion);

        for (Token token : tokens) {
            txtResultados.append("Tipo: " + token.getTipo() + " Valor: " + token.getValor()+"\n");
            
            if (token.getTipo() == enumerador.tipo.NUMERO) {
                numero++;
            }else if (token.getTipo() == enumerador.tipo.OPERADOR) {
                operador++;
            }else if (token.getTipo() == enumerador.tipo.CONSTANTE) {
                constante++;
            }else if (token.getTipo() == enumerador.tipo.VARIABLE) {
                variable++;
            }else if (token.getTipo() == enumerador.tipo.DESCONOCIDO) {
                desc++;
            }
        }
    
        txtResultados.append(numero + " NUMEROS\n" + 
                operador +" OPERADORES\n"+ 
                constante + " CONSTANTE\n" + 
                variable +" VARIABLES\n"+ 
                desc +" DESCONOCIDOS\n");
        
                
    }//GEN-LAST:event_bAnalizarActionPerformed

    private void txtEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEntradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEntradaActionPerformed




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAnalizar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtEntrada;
    private javax.swing.JTextArea txtResultados;
    // End of variables declaration//GEN-END:variables


}


