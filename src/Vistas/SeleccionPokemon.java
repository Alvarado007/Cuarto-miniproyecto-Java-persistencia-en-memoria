/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Equipo Hogar
 */
package Vistas;

import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Clases.Entrenador;
import Clases.Pokemon;
import Controladores.ControladorSeleccion;
import Interfaces.SeleccionPokemonInterface;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeleccionPokemon extends javax.swing.JFrame implements ActionListener,SeleccionPokemonInterface {
    // Entrenador entrenador1;
    // Entrenador entrenador2;
    ControladorSeleccion controlador;
    Pokemon PokemonGuardado;
    int ContadorEntrenadorTotal;

    /**
     * Creates new form SeleccionPokemon
     */
    public SeleccionPokemon() {
        initComponents();
        // this.Ganador();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListEntrenador2 = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        ListEntrenador1 = new javax.swing.JList<>();
        LabelDeImagenEntrenador1 = new javax.swing.JLabel();
        LabelDeImagenEntrenador2 = new javax.swing.JLabel();
        LabelNombreEntrenador1 = new javax.swing.JLabel();
        LabelNombreEntrenador2 = new javax.swing.JLabel();
        BotonContinuarSeleccionPokemon = new javax.swing.JButton();
        LabelFondoSeleccionPokemon = new javax.swing.JLabel();
        BotonTerminal = new javax.swing.JButton();
        BotonGuardarPartida = new javax.swing.JButton();
        BotonVerMovimientos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(12, 28, 108));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(816, 639));

        jPanel1.setLayout(null);

        ListEntrenador2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ListEntrenador2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ListEntrenador2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(ListEntrenador2);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(510, 340, 220, 100);

        ListEntrenador1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ListEntrenador1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(ListEntrenador1);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(70, 340, 220, 100);

        LabelDeImagenEntrenador1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logos/Ash.jpeg"))); // NOI18N
        LabelDeImagenEntrenador1.setBackground(new java.awt.Color(255, 255, 255));
        LabelDeImagenEntrenador1.setOpaque(true);
        jPanel1.add(LabelDeImagenEntrenador1);
        LabelDeImagenEntrenador1.setBounds(80, 120, 200, 200);

        LabelDeImagenEntrenador2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logos/Giovanni.jpeg"))); // NOI18N
        LabelDeImagenEntrenador2.setBackground(new java.awt.Color(255, 255, 255));
        LabelDeImagenEntrenador2.setOpaque(true);
        jPanel1.add(LabelDeImagenEntrenador2);
        LabelDeImagenEntrenador2.setBounds(520, 120, 200, 200);

        LabelNombreEntrenador1.setBackground(new java.awt.Color(255, 255, 255));
        LabelNombreEntrenador1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        LabelNombreEntrenador1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelNombreEntrenador1.setOpaque(true);
        jPanel1.add(LabelNombreEntrenador1);
        LabelNombreEntrenador1.setBounds(30, 20, 300, 80);

        LabelNombreEntrenador2.setBackground(new java.awt.Color(255, 255, 255));
        LabelNombreEntrenador2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        LabelNombreEntrenador2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelNombreEntrenador2.setOpaque(true);
        jPanel1.add(LabelNombreEntrenador2);
        LabelNombreEntrenador2.setBounds(470, 20, 300, 80);

        BotonContinuarSeleccionPokemon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logos/Continuar Entrenadores Logo Resized.png"))); // NOI18N
        BotonContinuarSeleccionPokemon.setBorderPainted(false);
        BotonContinuarSeleccionPokemon.setContentAreaFilled(false);
        BotonContinuarSeleccionPokemon.setPreferredSize(new java.awt.Dimension(123, 57));
        BotonContinuarSeleccionPokemon.addActionListener(this);
        jPanel1.add(BotonContinuarSeleccionPokemon);
        BotonContinuarSeleccionPokemon.setBounds(160, 480, 480, 100);

        BotonTerminal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logos/Cambiar a Terminal Resized.png"))); // NOI18N
        BotonTerminal.setBorderPainted(false);
        BotonTerminal.setContentAreaFilled(false);
        jPanel1.add(BotonTerminal);
        BotonTerminal.setBounds(630, 500, 160, 90);
        BotonTerminal.addActionListener(this);

        BotonGuardarPartida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logos/Guardar Partida.png"))); // NOI18N
        BotonGuardarPartida.setBorderPainted(false);
        BotonGuardarPartida.setContentAreaFilled(false);
        jPanel1.add(BotonGuardarPartida);
        BotonGuardarPartida.setBounds(20, 500, 160, 90);
        BotonGuardarPartida.addActionListener(this);

        BotonVerMovimientos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logos/Ver Movimientos.png"))); // NOI18N
        BotonVerMovimientos.setBorderPainted(false);
        BotonVerMovimientos.setContentAreaFilled(false);
        jPanel1.add(BotonVerMovimientos);
        BotonVerMovimientos.setBounds(330, 270, 140, 29);
        BotonVerMovimientos.addActionListener(this);

        area = new JTextArea(15, 40);
        area.setWrapStyleWord(true);
        area.setLineWrap(true);
        area.setEditable(false);

        scroll = new JScrollPane(area);
        scroll.setPreferredSize(new java.awt.Dimension(500, 300));

        LabelFondoSeleccionPokemon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logos/Pikachu Fondo Resized.jpeg"))); // NOI18N
        jPanel1.add(LabelFondoSeleccionPokemon);
        LabelFondoSeleccionPokemon.setBounds(0, 0, 800, 600);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(SeleccionPokemon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SeleccionPokemon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SeleccionPokemon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SeleccionPokemon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
    }

    // Variables declaration - do not modify
    private javax.swing.JButton BotonContinuarSeleccionPokemon;
    private javax.swing.JLabel LabelDeImagenEntrenador1;
    private javax.swing.JLabel LabelDeImagenEntrenador2;
    private javax.swing.JLabel LabelFondoSeleccionPokemon;
    private javax.swing.JLabel LabelNombreEntrenador1;
    private javax.swing.JLabel LabelNombreEntrenador2;
    private javax.swing.JList<Pokemon> ListEntrenador1;
    private javax.swing.JList<Pokemon> ListEntrenador2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton BotonTerminal;
    private javax.swing.JButton BotonGuardarPartida;
    private javax.swing.JButton BotonVerMovimientos;
    private JScrollPane scroll;
    private JTextArea area ;

    // End of variables declaration
    @Override
    public void actionPerformed(ActionEvent e) {
        controlador.setESGUI(true);
        /** Al presionar "BotonTerminal", cambia el valor de "ESGUI" a "false", cierra la ventana actual
         * y llama al metodo "cambiarVista" del controlador. */
        if (e.getSource() == BotonTerminal) {
            controlador.setESGUI(false);
            this.dispose();
            controlador.cambiarVista();
        }
        else if (e.getSource() == BotonContinuarSeleccionPokemon) {
            /** Cambia el valor de "ESGUI" a "true", llama al metodo "InicioBatalla" del controlador,
             * que toma los valores seleccionados (pokemones) de los JList, y cierra la ventana actual,
             * pero se crea la excepción en caso de que se presione el botón de continuar sin ninguno
             * haber seleccionado ningun Pokemon o que solo uno haya seleccionado un Pokemon. */
            try {
                controlador.setESGUI(true);
                controlador.InicioBatalla(ListEntrenador1.getSelectedValue(), ListEntrenador2.getSelectedValue());
                this.dispose();
            }
            catch (NullPointerException ex) {
                Mensaje("Por favor, seleccione un Pokémon de cada entrenador antes de continuar.");
            }
        }
        else if (e.getSource() == BotonGuardarPartida) {
            controlador.IniciarGuardado();
        }
        else if (e.getSource() == BotonVerMovimientos) {
            controlador.Vermovimientos();
        }
    }

    @Override
    public void setControlador(ControladorSeleccion controlador) {
        this.controlador = controlador;
    }

    /** El metodo "Iniciar" toma los nombres de los entrenadores y sus respectivos equipos,
     * después en los JLabel se muestran esos nombres, y en los JList se muestran los pokemones
     * de cada entrenador, y finalmente se muestra la ventana. */
    @Override
    public void Iniciar(String nombreEntrenador1, String nombreEntrenador2, Pokemon[] pokemonesEntrenador1, Pokemon[] pokemonesEntrenador2) {
        LabelNombreEntrenador1.setText(nombreEntrenador1);
        LabelNombreEntrenador2.setText(nombreEntrenador2);
        ListEntrenador1.setListData(pokemonesEntrenador1);
        ListEntrenador2.setListData(pokemonesEntrenador2);
        this.setVisible(true);
    }
    public void ocultarbotones() {
        
    }

    @Override
    public void Mensaje(String mensaje) {
        /** Se realiza "area.setText(mensaje)" para mostrar el mensaje en el JTextArea,
         * y se muestra la ventana con el "JOptionPane.showMessageDialog", que recibe el scroll en
         * caso que el mensaje sea muy largo, el mensaje mismo y el tipo de mensaje. */
        area.setText(mensaje);
        JOptionPane.showMessageDialog(null,scroll, mensaje, JOptionPane.INFORMATION_MESSAGE);
    }

}
