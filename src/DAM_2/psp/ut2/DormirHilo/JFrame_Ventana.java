package DAM_2.psp.ut2.DormirHilo;

/**
 *
 * @author IMCG
 */

/*
 * Cuando ejecutamos una aplicación de ventana basada en un formulario
 * JFrame, la máquina virtual de Java crea tres hilos por defecto:
 *
 *  1. el principal, donde corre el método Main() que inicia la aplicación
 *  2. el conocido como GC (recolector de basura), donde corre el código que se
 *      encarga de optimizar los recursos de memoria
 *  3. el conocido como EDT (hilo despachador de eventos) de la AWT (paquete
 *      abstracto de herramientas de ventana), donde corre el código encargado
 *      de atender las solicitudes de dibujo del contenido de la ventana, y de
 *      atender a los eventos de ratón o teclado provocados por el usuario
 *      (como la ejecución del código programado para cuando el usuario hace
 *      click en un botón)
 *
 * Puesto que el hilo EDT puede llegar a ser el más ocupado de los tres con
 * diferencia, debe de ponerse especial cuidado en no sobrecargarlo demasiado.
 *
 * En esta aplicación queremos realizar una cuenta de 1 a 20, cuyo avance
 * se vaya reflejando en el JPanel que hemos colocado a modo de marcador. La
 * cuenta se pondrá en marcha cuando el usuario haga click en un botón.
 *
 * Obviamente, para reflejar ese avance es necesario repintar el JPanel a cada
 * nuevo valor (lo que se le solicita al hilo EDT -que es el encargado de ello,
 * mediante una llamada al método repaint() del JPanel).
 *
 * El primer botón intenta hacerlo sin poner más hilos en juego. No lo consigue.
 * Y no lo consigue porque precisamente el hilo que recibe las peticiones de
 * pintado, es justo el que las está enviando a cada nuevo valor de la cuenta.
 * Y claro, se satura. Sólo cuando finaliza la cuenta (justo en el 20), puede
 * atender por fin a la solicitud de dibujo del marcador.
 *
 * Por el contrario el segundo y tercer botón delega en un hilo auxiliar, tanto
 * la cuenta
 * como las peticiones de repintado del marcador. Además este hilo auxiliar,
 * en el caso del Botón 3
 * se duerme 1 décima de segundo por cuenta, para que EDT tenga una buen ocasión
 * de atender la petición de dibujo que le acaba de enviar. El resultado es el
 * esperado por fin
 */
public class JFrame_Ventana extends javax.swing.JFrame {

    JPanel_Marcador marcador;
    //marcador del formulario

    public JFrame_Ventana() {
        //constructor
        initComponents();
        marcador = new JPanel_Marcador();
        marcador.setLocation(5, 5);
        //asigna un nuevo marcador y lo posiciona en el formulario a 5 puntos
        //de los márgenes izquierdo y superior

        this.add(marcador);
        //agrega el marcador al formulario
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Sin hilos auxiliares");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Con un hilo auxiliar sin dormir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Marcador que muestra la cuenta de 1 a 20");

        jButton3.setText("Con un hilo auxiliar y dormido");
        jButton3.setActionCommand("Con un hilo auxiliar sin dormir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Borrar marcador");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(219, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jLabel1)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4)
                    .addComponent(jButton3))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

//código que se ejecuta cuando el usuario hace click en el primer botón
  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      for (int i = 1; i <= 500000; i++) {
          marcador.valor = i;
          //incrementa marcador
          marcador.repaint();
          //solicita el repintado del marcador
      }
  }//GEN-LAST:event_jButton1ActionPerformed

    //código que se ejecuta cuando el usuario hace click en el segundo botón
  private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      Thread thIzquierdo = new Hilo_Auxiliar(false, marcador);
      //crea un hilo pasándole como argumento el marcador
      thIzquierdo.start();
      //inicia el hilo
  }//GEN-LAST:event_jButton2ActionPerformed
//código que se ejecuta cuando el usuario hace click en el tercer botón
  private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      Thread thIzquierdo = new Hilo_Auxiliar(true, marcador);
      //crea un hilo pasándole como argumento el marcador
      thIzquierdo.start();
      //inicia el hilo
  }//GEN-LAST:event_jButton3ActionPerformed
  //código que se ejecuta cuando el usuario hace click en el botón derecho
  private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
      marcador.valor = 0;
      marcador.repaint();
      //repinta el marcador para borrarlo (si tuviera algo)
  }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new JFrame_Ventana().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
