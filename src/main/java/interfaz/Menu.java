package interfaz;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import matrices.OperadorMatrices;
import matrices.Matriz;
import java.util.ArrayList;
import javax.swing.JFrame;

public class Menu extends javax.swing.JFrame {
    
    private Matriz matrizA = new Matriz(3,3,"A");
    private Matriz matrizB = new Matriz(3,3,"B");
    private Matriz matrizC = new Matriz(3,3,"C");
    private Matriz matrizD = new Matriz(3,3,"D");
    private Matriz matrizE = new Matriz(3,3,"E");
    private Matriz matrizF = new Matriz(3,3,"F");
    private Matriz matrizG = new Matriz(3,3,"G");
    private Matriz matrizH = new Matriz(3,3,"H");
    
    float[][] matA = {
                        {1,-6,2},
                        {2,-2,-1},
                        {1,-3,-5},
                     };
    
    private MenuMatrices menuEditarMatrices;
    private OperadorMatrices manipuladorMatrices = new OperadorMatrices();
    
    enum TipoResultado
    {
        Matriz,
        Numero,
    }
    
    enum Procedimiento
    {
        SumaMatrices,
        MultiplicacionMatrizEscalar,
        MultiplicacionMatrices,
        InversaMatrizGJ,
        SolucionSistemaGJ,
        DeterminanteMatriz,
        SolucionSistemaCramer,
        TranspuestaMatriz,
    }
    
    private TipoResultado resultadoEsperado = TipoResultado.Matriz;
    private Procedimiento procedimientoSeleccionado = Procedimiento.SumaMatrices;
    
    /**
     * Creates new form MainMenu
     */
    public Menu() {
        initComponents();
        matrizA.asignarElementos(matA, 3,3);
        
        previsualizarMatriz(obtenerMatrizDeSeleccion(selectorMatriz));
        obtenerProcedimientoSeleccionado(selectorProcedimiento);
        mostrarArgumentosRelevantes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        editarMatrizBoton = new javax.swing.JButton();
        selectorMatriz = new javax.swing.JComboBox<>();
        selectorProcedimiento = new javax.swing.JComboBox<>();
        titulo1 = new javax.swing.JLabel();
        titulo2 = new javax.swing.JLabel();
        selectorMatriz1 = new javax.swing.JComboBox<>();
        selectorMatriz2 = new javax.swing.JComboBox<>();
        titulo3 = new javax.swing.JLabel();
        calcularBoton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        visualizadorMatriz_R = new javax.swing.JTextArea();
        selectorEscalar = new javax.swing.JSpinner();
        labelOperacion = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        visualizadorMatriz_E = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        titulo.setText("CALCULADORA MATRICES");

        editarMatrizBoton.setText("Editar");
        editarMatrizBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarMatrizBotonActionPerformed(evt);
            }
        });

        selectorMatriz.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D", "E", "F", "G", "H" }));
        selectorMatriz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectorMatrizActionPerformed(evt);
            }
        });

        selectorProcedimiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Suma de dos matrices", "Multiplicacion por Escalar", "Multiplicacion entre Matrices", "Inversa de Matriz por Gauss-Jordan", "Solucion Sistema de Ecuaciones por Gauss-Jordan", "Determinante de Matriz", "Solucion Sistema de Ecuaciones por Cramer", "Transpuesta de Matriz" }));
        selectorProcedimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectorProcedimientoActionPerformed(evt);
            }
        });

        titulo1.setText("SELECCIONE MATRIZ PARA EDITAR");

        titulo2.setText("ESCOGER OPERACION");

        selectorMatriz1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D", "E", "F", "G", "H" }));

        selectorMatriz2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D", "E", "F", "G", "H" }));

        titulo3.setText("RESULTADO");

        calcularBoton.setText("CALCULAR");
        calcularBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcularBotonActionPerformed(evt);
            }
        });

        visualizadorMatriz_R.setEditable(false);
        visualizadorMatriz_R.setColumns(20);
        visualizadorMatriz_R.setRows(5);
        jScrollPane1.setViewportView(visualizadorMatriz_R);

        selectorEscalar.setModel(new javax.swing.SpinnerNumberModel(0.0f, null, null, 1.0f));

        labelOperacion.setText("operacion");

        visualizadorMatriz_E.setEditable(false);
        visualizadorMatriz_E.setColumns(20);
        visualizadorMatriz_E.setRows(5);
        jScrollPane2.setViewportView(visualizadorMatriz_E);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addComponent(titulo1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(titulo3, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addComponent(titulo2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addComponent(calcularBoton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(selectorMatriz1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(labelOperacion)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(selectorMatriz2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(selectorEscalar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(selectorProcedimiento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(selectorMatriz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editarMatrizBoton)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titulo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectorMatriz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editarMatrizBoton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titulo2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectorProcedimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectorMatriz1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectorMatriz2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectorEscalar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelOperacion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(calcularBoton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titulo3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editarMatrizBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarMatrizBotonActionPerformed
        // TODO add your handling code here:
        presionarBoton_Editar();
    }//GEN-LAST:event_editarMatrizBotonActionPerformed

    private void calcularBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcularBotonActionPerformed
        // TODO add your handling code here:
        presionarBoton_Calcular();
    }//GEN-LAST:event_calcularBotonActionPerformed

    private void selectorProcedimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectorProcedimientoActionPerformed
        // TODO add your handling code here:
        obtenerProcedimientoSeleccionado(selectorProcedimiento);
        mostrarArgumentosRelevantes(); 
    }//GEN-LAST:event_selectorProcedimientoActionPerformed

    private void selectorMatrizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectorMatrizActionPerformed
        // TODO add your handling code here:
        previsualizarMatriz(obtenerMatrizDeSeleccion(selectorMatriz));
    }//GEN-LAST:event_selectorMatrizActionPerformed

    /**
     * @param args the command line arguments
     */
    public void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }
    
    private void mostrarArgumentosRelevantes()
    {
        switch(procedimientoSeleccionado)
        {
            case SumaMatrices:
                    labelOperacion.setText("+");
                    selectorMatriz1.setVisible(true);
                    selectorMatriz2.setVisible(true);
                    selectorEscalar.setVisible(false);
                    
                    calcularBoton.setVisible(true);
                break;
            case MultiplicacionMatrizEscalar:
                    labelOperacion.setText("*");
                    selectorMatriz1.setVisible(true);
                    selectorMatriz2.setVisible(false);
                    selectorEscalar.setVisible(true);
                    
                    calcularBoton.setVisible(true);
                break;
            case MultiplicacionMatrices:
                    labelOperacion.setText("*");
                    selectorMatriz1.setVisible(true);
                    selectorMatriz2.setVisible(true);
                    selectorEscalar.setVisible(false);
                    
                    calcularBoton.setVisible(true);
                break;
            case InversaMatrizGJ:
                    labelOperacion.setText("^-1");
                    selectorMatriz1.setVisible(true);
                    selectorMatriz2.setVisible(false);
                    selectorEscalar.setVisible(false);
                    
                    calcularBoton.setVisible(true);
                break;
            case SolucionSistemaGJ:
                    labelOperacion.setText("");
                    selectorMatriz1.setVisible(true);
                    selectorMatriz2.setVisible(false);
                    selectorEscalar.setVisible(false);
                    
                    calcularBoton.setVisible(true);
                break;
            case DeterminanteMatriz:
                    labelOperacion.setText("det");
                    selectorMatriz1.setVisible(true);
                    selectorMatriz2.setVisible(false);
                    selectorEscalar.setVisible(false);
                    
                    calcularBoton.setVisible(true);
                break;
            case SolucionSistemaCramer:
                    labelOperacion.setText("");
                    selectorMatriz1.setVisible(true);
                    selectorMatriz2.setVisible(false);
                    selectorEscalar.setVisible(false);
                    
                    calcularBoton.setVisible(true);
                break;
            case TranspuestaMatriz:
                    labelOperacion.setText("T");
                    selectorMatriz1.setVisible(true);
                    selectorMatriz2.setVisible(false);
                    selectorEscalar.setVisible(false);
                    
                    calcularBoton.setVisible(true);
                break;
            default:
                    labelOperacion.setText("");
                    selectorMatriz1.setVisible(false);
                    selectorMatriz2.setVisible(false);
                    selectorEscalar.setVisible(false);
                    
                    calcularBoton.setVisible(false);
                break;
        }
    }
    
    private Matriz obtenerMatrizDeSeleccion(javax.swing.JComboBox<String> seleccion)
    {
        //System.out.println(seleccion.getSelectedItem().toString());
        switch(seleccion.getSelectedItem().toString())
        {
            case "A":
                return this.matrizA;
            case "B":
                return this.matrizB;
            case "C":
                return this.matrizC;
            case "D":
                return this.matrizD;
            case "E":
                return this.matrizE;
            case "F":
                return this.matrizF;
            case "G":
                return this.matrizG;
            case "H":
                return this.matrizH;
            default:
                return null;
        }
    }
    
    private void obtenerProcedimientoSeleccionado(javax.swing.JComboBox<String> seleccion)
    {
        switch(seleccion.getSelectedItem().toString())
        {
            case "Suma de dos matrices":
                resultadoEsperado = TipoResultado.Matriz;
                procedimientoSeleccionado = Procedimiento.SumaMatrices;
                break;
            case "Multiplicacion por Escalar":
                resultadoEsperado = TipoResultado.Matriz;
                procedimientoSeleccionado = Procedimiento.MultiplicacionMatrizEscalar;
                break;
            case "Multiplicacion entre Matrices":
                resultadoEsperado = TipoResultado.Matriz;
                procedimientoSeleccionado = Procedimiento.MultiplicacionMatrices;
                break;
            case "Inversa de Matriz por Gauss-Jordan":
                resultadoEsperado = TipoResultado.Matriz;
                procedimientoSeleccionado = Procedimiento.InversaMatrizGJ;
                break;
            case "Solucion Sistema de Ecuaciones por Gauss-Jordan":
                resultadoEsperado = TipoResultado.Matriz;
                procedimientoSeleccionado = Procedimiento.SolucionSistemaGJ;
                break;
            case "Determinante de Matriz":
                resultadoEsperado = TipoResultado.Numero;
                procedimientoSeleccionado = Procedimiento.DeterminanteMatriz;
                break;
            case "Solucion Sistema de Ecuaciones por Cramer":
                resultadoEsperado = TipoResultado.Matriz;
                procedimientoSeleccionado = Procedimiento.SolucionSistemaCramer;
                break;
            case "Transpuesta de Matriz":
                resultadoEsperado = TipoResultado.Matriz;
                procedimientoSeleccionado = Procedimiento.TranspuestaMatriz;
                break;
            default:
                break;
        }
    }
    
    private Object realizarProcedimiento(Object[] parametros)
    {
        //System.out.println(seleccion.getSelectedItem().toString());
        switch(procedimientoSeleccionado)
        {
            case SumaMatrices:
                return manipuladorMatrices.sumaEntreMatrices((Matriz)parametros[0], (Matriz)parametros[1]);
            case MultiplicacionMatrizEscalar:
                return manipuladorMatrices.multiplicacionPorEscalar((Matriz)parametros[0], (float)parametros[2]);
            case MultiplicacionMatrices:
                return manipuladorMatrices.productoEntreMatrices((Matriz)parametros[0], (Matriz)parametros[1]);
            case InversaMatrizGJ:
                return manipuladorMatrices.calcularInversa_GJ((Matriz)parametros[0]);
            case SolucionSistemaGJ:
                return manipuladorMatrices.solucionarSistema_GJ((Matriz)parametros[0]);
            case DeterminanteMatriz:
                return manipuladorMatrices.calcularDeterminante((Matriz)parametros[0]);
            case SolucionSistemaCramer:
                return manipuladorMatrices.solucionarSistema_Cramer((Matriz)parametros[0]);
            case TranspuestaMatriz:
                return manipuladorMatrices.calcularTranspuesta((Matriz)parametros[0]);
            default:
                return null;
        }
    }
    
    public void guardarCambiosMatriz()
    {
        Matriz guardado = menuEditarMatrices.getMatriz();
        
        switch(guardado.getId())
        {
            case "A":
                matrizA = guardado;
                break;
            case "B":
                matrizB = guardado;
                break;
            case "C":
                matrizC = guardado;
                break;
            case "D":
                matrizD = guardado;
                break;
            case "E":
                matrizE = guardado;
                break;
            case "F":
                matrizF = guardado;
                break;
            case "G":
                matrizG = guardado;
                break;
            case "H":
                matrizH = guardado;
                break;
        }
        previsualizarMatriz(obtenerMatrizDeSeleccion(selectorMatriz));
    }
    
    private void presionarBoton_Editar()
    {
        Matriz matrizSeleccionada = obtenerMatrizDeSeleccion(selectorMatriz);
        
        menuEditarMatrices = new MenuMatrices(matrizSeleccionada, this);
        menuEditarMatrices.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        menuEditarMatrices.setVisible(true);
    }
    
    private void presionarBoton_Calcular()
    {
        Matriz matrizSeleccionada1 = obtenerMatrizDeSeleccion(selectorMatriz1);
        Matriz matrizSeleccionada2 = obtenerMatrizDeSeleccion(selectorMatriz2);
        
        Object[] parametros = new Object[3];
            parametros[0] = matrizSeleccionada1;
            parametros[1] = matrizSeleccionada2;
            parametros[2] = (float)selectorEscalar.getValue();
        
        obtenerProcedimientoSeleccionado(selectorProcedimiento);
        
        if (resultadoEsperado == TipoResultado.Matriz)
        {
            Matriz resultado = (Matriz)realizarProcedimiento(parametros);
            mostrarResultado_Matriz(resultado);
        }
        else if (resultadoEsperado == TipoResultado.Numero)
        {
            float resultado = (float)realizarProcedimiento(parametros);
            mostrarResultado_Numero(resultado);
        }
    }
    
    private void previsualizarMatriz(Matriz matriz)
    {
        visualizadorMatriz_E.setText("");
        ArrayList<String> visualizacion = matriz.mostrarElemento(-1, -1);
        for (int i = 0; i < visualizacion.size(); i++)
        {
            visualizadorMatriz_E.setText(visualizadorMatriz_E.getText() + visualizacion.get(i));
        }
    }
    
    private void mostrarResultado_Matriz(Matriz matriz)
    {
        visualizadorMatriz_R.setText("");
        ArrayList<String> visualizacion = matriz.mostrarElemento(-1, -1);
        for (int i = 0; i < visualizacion.size(); i++)
        {
            visualizadorMatriz_R.setText(visualizadorMatriz_R.getText() + visualizacion.get(i));
        }
    }
    
    private void mostrarResultado_Numero(float numero)
    {
        visualizadorMatriz_R.setText(""+numero);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton calcularBoton;
    private javax.swing.JButton editarMatrizBoton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelOperacion;
    private javax.swing.JSpinner selectorEscalar;
    private javax.swing.JComboBox<String> selectorMatriz;
    private javax.swing.JComboBox<String> selectorMatriz1;
    private javax.swing.JComboBox<String> selectorMatriz2;
    private javax.swing.JComboBox<String> selectorProcedimiento;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel titulo1;
    private javax.swing.JLabel titulo2;
    private javax.swing.JLabel titulo3;
    private javax.swing.JTextArea visualizadorMatriz_E;
    private javax.swing.JTextArea visualizadorMatriz_R;
    // End of variables declaration//GEN-END:variables
}
