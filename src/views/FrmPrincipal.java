/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

/**
 *
 * @author varcal
 */
public class FrmPrincipal extends javax.swing.JFrame{

    /**
     * Creates new form FrmPrincipal
     */
    public FrmPrincipal() {
        initComponents();
        menuSairClick();
        setExtendedState( MAXIMIZED_BOTH );        
    }

    private void menuSairClick() {
        menuSair.addMenuListener(
                new MenuListener() {
                    @Override
                    public void menuSelected(MenuEvent e) {
                        System.exit(0);
                    }
                    @Override
                    public void menuDeselected(MenuEvent e) {}
                    @Override
                    public void menuCanceled(MenuEvent e) {}
                }
        );
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        InternalPrincipal = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        menuCadastro = new javax.swing.JMenu();
        imCadastroMontadora = new javax.swing.JMenuItem();
        imCadastroModelo = new javax.swing.JMenuItem();
        imCadastroVeiculos = new javax.swing.JMenuItem();
        imCadastroUsuario = new javax.swing.JMenuItem();
        menuVenda = new javax.swing.JMenu();
        menuConsulta = new javax.swing.JMenu();
        imConsultaUsuarios = new javax.swing.JMenuItem();
        imConsultaMontadoras = new javax.swing.JMenuItem();
        imConsultaModelos = new javax.swing.JMenuItem();
        imConsultaVeiculos = new javax.swing.JMenuItem();
        menuSair = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        javax.swing.GroupLayout InternalPrincipalLayout = new javax.swing.GroupLayout(InternalPrincipal);
        InternalPrincipal.setLayout(InternalPrincipalLayout);
        InternalPrincipalLayout.setHorizontalGroup(
            InternalPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1260, Short.MAX_VALUE)
        );
        InternalPrincipalLayout.setVerticalGroup(
            InternalPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 845, Short.MAX_VALUE)
        );

        menuCadastro.setText("Cadastro ");

        imCadastroMontadora.setText("Cadastro Montadora");
        imCadastroMontadora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imCadastroMontadoraActionPerformed(evt);
            }
        });
        menuCadastro.add(imCadastroMontadora);

        imCadastroModelo.setText("Cadastro Modelo");
        imCadastroModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imCadastroModeloActionPerformed(evt);
            }
        });
        menuCadastro.add(imCadastroModelo);

        imCadastroVeiculos.setText("Cadastro Veículos");
        menuCadastro.add(imCadastroVeiculos);

        imCadastroUsuario.setText("Cadastro Usuário");
        menuCadastro.add(imCadastroUsuario);

        menuBar.add(menuCadastro);

        menuVenda.setText("Venda");
        menuBar.add(menuVenda);

        menuConsulta.setText("Consultas");

        imConsultaUsuarios.setText("Usuários");
        menuConsulta.add(imConsultaUsuarios);

        imConsultaMontadoras.setText("Montadoras");
        imConsultaMontadoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imConsultaMontadorasActionPerformed(evt);
            }
        });
        menuConsulta.add(imConsultaMontadoras);

        imConsultaModelos.setText("Modelos");
        imConsultaModelos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imConsultaModelosActionPerformed(evt);
            }
        });
        menuConsulta.add(imConsultaModelos);

        imConsultaVeiculos.setText("Veículos");
        menuConsulta.add(imConsultaVeiculos);

        menuBar.add(menuConsulta);

        menuSair.setText("Sair");
        menuBar.add(menuSair);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(InternalPrincipal)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(InternalPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void imCadastroModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imCadastroModeloActionPerformed
       FrmModeloCadastro frm = new FrmModeloCadastro(InternalPrincipal, AcaoNaTela.Inserir, null);
       InternalPrincipal.add(frm);
       frm.setVisible(true);
    }//GEN-LAST:event_imCadastroModeloActionPerformed

    private void imCadastroMontadoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imCadastroMontadoraActionPerformed
       FrmMontadoraCadastro frm = new FrmMontadoraCadastro(InternalPrincipal, AcaoNaTela.Inserir, null);
       InternalPrincipal.add(frm);
       frm.setVisible(true);
    }//GEN-LAST:event_imCadastroMontadoraActionPerformed

    private void imConsultaModelosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imConsultaModelosActionPerformed
        FrmModeloDetalhes frm = new FrmModeloDetalhes(InternalPrincipal);
        InternalPrincipal.add(frm);
        frm.setVisible(true);
    }//GEN-LAST:event_imConsultaModelosActionPerformed

    private void imConsultaMontadorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imConsultaMontadorasActionPerformed
        FrmMontadoraDetalhes frm = new FrmMontadoraDetalhes(InternalPrincipal);
        InternalPrincipal.add(frm);
        frm.setVisible(true);
    }//GEN-LAST:event_imConsultaMontadorasActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane InternalPrincipal;
    private javax.swing.JMenuItem imCadastroModelo;
    private javax.swing.JMenuItem imCadastroMontadora;
    private javax.swing.JMenuItem imCadastroUsuario;
    private javax.swing.JMenuItem imCadastroVeiculos;
    private javax.swing.JMenuItem imConsultaModelos;
    private javax.swing.JMenuItem imConsultaMontadoras;
    private javax.swing.JMenuItem imConsultaUsuarios;
    private javax.swing.JMenuItem imConsultaVeiculos;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuCadastro;
    private javax.swing.JMenu menuConsulta;
    private javax.swing.JMenu menuSair;
    private javax.swing.JMenu menuVenda;
    // End of variables declaration//GEN-END:variables

    
    
}
