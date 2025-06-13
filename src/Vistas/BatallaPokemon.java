package Vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.SwingConstants;

import Clases.Ataque;
import Clases.Entrenador;
import Clases.Pokemon;
import Controladores.ControladorBatalla;
import Interfaces.BatallaInterface;

public class BatallaPokemon extends javax.swing.JFrame implements ActionListener, BatallaInterface {
    ControladorBatalla controlador;

    public BatallaPokemon() {
        initComponents();
    }

    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        BotonTerminal = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(816, 639));

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(800, 600));
        jPanel2.setLayout(null);

        jLabel1.setBackground(new java.awt.Color(192,192,192));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        // jLabel1.setText(pokemon1.getNombre());
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel1.setOpaque(true);
        jPanel2.add(jLabel1);
        jLabel1.setBounds(10, 420, 120, 30);

        jLabel2.setBackground(new java.awt.Color(192,192,192));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        // jLabel2.setText(pokemon2.getNombre());
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel2.setOpaque(true);
        jPanel2.add(jLabel2);
        jLabel2.setBounds(670, 180, 120, 30);

        jButton1.setBackground(new java.awt.Color(248,144,144));
        // jButton1.setText("<html>" + pokemon1.getAtaques().get(0).getNombreAtaque() + "<br>" + "daño:" +pokemon1.getAtaques().get(0).getPotencia() + "</html>");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(jButton1);
        jButton1.setBounds(370, 390, 130, 70);
        jButton1.addActionListener(this);
        jButton1.setActionCommand("0");

        jButton2.setBackground(new java.awt.Color(120,168,96));
        // jButton2.setText("<html>" + pokemon1.getAtaques().get(1).getNombreAtaque() + "<br>" +"daño:" + pokemon1.getAtaques().get(1).getPotencia() + "</html>");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(jButton2);
        jButton2.setBounds(370, 470, 130, 70);
        jButton2.addActionListener(this);
        jButton2.setActionCommand("1");

        jButton3.setBackground(new java.awt.Color(212,164,79));
        // jButton3.setText("<html>" + pokemon1.getAtaques().get(2).getNombreAtaque() + "<br>" +"daño:" + pokemon1.getAtaques().get(2).getPotencia() + "</html>");
        jButton3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(jButton3);
        jButton3.setBounds(510, 390, 130, 70);
        jButton3.addActionListener(this);
        jButton3.setActionCommand("2");

        jButton4.setBackground(new java.awt.Color(64,144,208));
        // jButton4.setText("<html>" + pokemon1.getAtaques().get(3).getNombreAtaque() + "<br>" +"daño:" + pokemon1.getAtaques().get(3).getPotencia() + "</html>");
        jButton4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(jButton4);
        jButton4.setBounds(510, 470, 130, 70);
        jButton4.addActionListener(this);
        jButton4.setActionCommand("3");
        jButton4.setEnabled(false);

        jButton5.setBackground(new java.awt.Color(248,144,144));
        // jButton5.setText("<html>" + pokemon2.getAtaques().get(0).getNombreAtaque() + "<br>" +"daño:" + pokemon2.getAtaques().get(0).getPotencia() + "</html>");
        jButton5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(jButton5);
        jButton5.setBounds(160, 130, 130, 70);
        jButton5.addActionListener(this);
        jButton5.setActionCommand("0");

        jButton6.setBackground(new java.awt.Color(120,168,96));
        // jButton6.setText("<html>" + pokemon2.getAtaques().get(1).getNombreAtaque() + "<br>" +"daño:" + pokemon2.getAtaques().get(1).getPotencia() + "</html>");
        jButton6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(jButton6);
        jButton6.setBounds(160, 210, 130, 70);
        jButton6.addActionListener(this);
        jButton6.setActionCommand("1");

        jButton7.setBackground(new java.awt.Color(212,164,79));
        // jButton7.setText("<html>" + pokemon2.getAtaques().get(2).getNombreAtaque() + "<br>" +"daño:" + pokemon2.getAtaques().get(2).getPotencia() + "</html>");
        jButton7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(jButton7);
        jButton7.setBounds(300, 130, 130, 70);
        jButton7.addActionListener(this);
        jButton7.setActionCommand("2");

        jButton8.setBackground(new java.awt.Color(64,144,208));
        // jButton8.setText("<html>" + pokemon2.getAtaques().get(3).getNombreAtaque() + "<br>" +"daño:" + pokemon2.getAtaques().get(3).getPotencia() + "</html>");
        jButton8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(jButton8);
        jButton8.setBounds(300, 210, 130, 70);
        jButton8.addActionListener(this);
        jButton8.setActionCommand("3");
        jButton8.setEnabled(false);

        BotonTerminal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logos/Cambiar a Terminal Resized.png"))); // NOI18N
        BotonTerminal.setBorderPainted(false);
        BotonTerminal.setContentAreaFilled(false);
        jPanel2.add(BotonTerminal);
        BotonTerminal.setBounds(630, 500, 160, 90);
        BotonTerminal.addActionListener(this);

        // jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenes2.get(pokemon1.getNombre())))); // NOI18N
        jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel4.setVerticalAlignment(SwingConstants.CENTER);
        jPanel2.add(jLabel4);
        jLabel4.setBounds(140,350,200,200);

        jLabel7.setBackground(new java.awt.Color(192,192,192));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel7.setOpaque(true);
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        // jLabel7.setText(Short.toString(pokemon2.getVida()));
        jPanel2.add(jLabel7);
        jLabel7.setBounds(670, 220, 120, 30);

        jLabel5.setBackground(new java.awt.Color(192,192,192));
        jLabel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setOpaque(true);
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        // jLabel5.setText(Short.toString(pokemon1.getVida()));
        jPanel2.add(jLabel5);
        jLabel5.setBounds(10, 460, 120, 30);

        // jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenes.get(pokemon2.getNombre())))); // NOI18N
        jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel3.setVerticalAlignment(SwingConstants.CENTER);
        jPanel2.add(jLabel3);
        jLabel3.setBounds(460, 120, 200, 200);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logos/FondoBatalla.png"))); // NOI18N
        jPanel2.add(jLabel6);
        jLabel6.setBounds(0, 0, 800, 600);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BatallaPokemon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BatallaPokemon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BatallaPokemon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BatallaPokemon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton BotonTerminal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration      
    
    public void Ocultarbotones() {
        /** Se define el turno actual con "controlador.get_turno", que en caso de ser turno del
         * jugador 1, habilita los botones de los 3 ataques normales del Pokemon, y después hay una
         * condición que si el contador en "controlador.get_contadorAtaque1()" es mayor o igual a 3,
         * se habilite el botón del ataque especial. */
        if (controlador.get_turno() == 1) {
            jButton1.setEnabled(true);
            jButton2.setEnabled(true);
            jButton3.setEnabled(true);
            if (controlador.get_contadorAtaque1() >= 3) {
                jButton4.setEnabled(true);
                // mensajes("Puedes usar el ataque especial de " + pokemon1.getNombre() + "!");
            } 
            else {
                jButton4.setEnabled(false);
            }
            /** Se deshabilitan los botones del jugador 2. */
            jButton5.setEnabled(false);
            jButton6.setEnabled(false); 
            jButton7.setEnabled(false);
            jButton8.setEnabled(false);
            // mensajes("Es el turno de " + entrenador1.getNombre_entrenador() + " para atacar con " + pokemon1.getNombre() + "!");   
        }
        else {
            /** Si el turno es del jugador 2, se hace lo contrario de lo anterior. */
            jButton1.setEnabled(false);
            jButton2.setEnabled(false);
            jButton3.setEnabled(false);
            jButton4.setEnabled(false);
            jButton5.setEnabled(true);
            jButton6.setEnabled(true);
            jButton7.setEnabled(true);
            if (controlador.get_contadorAtaque2() >= 3) {
                jButton8.setEnabled(true);
                // mensajes("Puedes usar el ataque especial de " + pokemon2.getNombre() + "!");
            }
            else {
                jButton8.setEnabled(false);
            }
            // mensajes("Es el turno de " + entrenador2.getNombre_entrenador() + " para atacar con " + pokemon2.getNombre() + "!");
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        /** Se asigna a cada botón su ataque, se llama al metodo "atacar" del controlador
         * y se toma el getActionCommand para saber cual botón se ha pulsado. */
        if (e.getSource() == jButton1 || e.getSource() == jButton2 || e.getSource() == jButton3 || e.getSource() == jButton4) {
            controlador.atacar( Integer.parseInt(e.getActionCommand()));
        } else if (e.getSource() == jButton5 || e.getSource() == jButton6 || e.getSource() == jButton7 || e.getSource() == jButton8) {
            controlador.atacar( Integer.parseInt(e.getActionCommand()));
        } else if (e.getSource() == BotonTerminal) {
            controlador.setESGUI(false);
            this.dispose();
            controlador.cambiarVista();
        }
    }

    @Override
    public void setControlador(ControladorBatalla controlador) {
        this.controlador = controlador;
    }

    /** Toma toda la información de la batalla y la muestra en los JLabels y los JButtons, y vuelve
     * visible la ventana. */
    @Override
    public void Iniciar(String nombre1, String nombre2, String Vida1, String Vida2, String AtatquePrimerEntrenador1,
            String AtatquePrimerEntrenador2, String AtatquePrimerEntrenador3, String AtatquePrimerEntrenador4,
            String AtatqueSegundoEntrenador1, String AtatqueSegundoEntrenador2, String AtatqueSegundoEntrenador3,
            String AtatqueSegundoEntrenador4, String imagen1, String imagen2) {
        this.controlador.setESGUI(true);
        jLabel1.setText(nombre1);
        jLabel2.setText(nombre2);
        jLabel5.setText(Vida1);
        jLabel7.setText(Vida2);
        jButton1.setText(AtatquePrimerEntrenador1);
        jButton2.setText(AtatquePrimerEntrenador2);
        jButton3.setText(AtatquePrimerEntrenador3);
        jButton4.setText(AtatquePrimerEntrenador4);
        jButton5.setText(AtatqueSegundoEntrenador1);
        jButton6.setText(AtatqueSegundoEntrenador2);
        jButton7.setText(AtatqueSegundoEntrenador3);
        jButton8.setText(AtatqueSegundoEntrenador4);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagen1)));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagen2)));
        this.setVisible(true);
    }

    public void actualizar(String vida) {
        if (controlador.get_turno() == 1) {
            jLabel5.setText(vida);
        } else {
            jLabel7.setText(vida);
        }
    }

    @Override
    public void Mensaje(String mensaje) {
        javax.swing.JOptionPane.showMessageDialog(this, mensaje, "Batalla Pokemon", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void Borrar() {
        this.dispose();
    }

}