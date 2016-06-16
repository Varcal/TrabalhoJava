/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.MontadoraController;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Montadora;

/**
 *
 * @author varcal
 */
public class FrmMontadoraCadastro extends javax.swing.JInternalFrame {

    AcaoNaTela _acaoNaTela;
    JDesktopPane _internalPrincipal;
    MontadoraController _controller;
      
    /**
     * Creates new form FrmMontadoraCadastro
     */
    public FrmMontadoraCadastro(JDesktopPane internalPrincipal, AcaoNaTela acaoNaTela, Montadora montadora) {
        initComponents();
        this.setLocation(440, 200);
        _acaoNaTela = acaoNaTela;
        _internalPrincipal = internalPrincipal;        
        EscolherAcaoNaTela(acaoNaTela, montadora);
        _controller = new MontadoraController();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        chkAtivo = new javax.swing.JCheckBox();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        lblCodigo.setText("Código:");

        lblNome.setText("Nome:");

        chkAtivo.setText("Ativo");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chkAtivo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblCodigo)
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNome)
                                .addGap(24, 24, 24)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNome))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(chkAtivo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.setVisible(false);
        ChamarTelaDetalhes();
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        switch(_acaoNaTela){
            case Inserir:
                inserir();
            break;
            case Editar:
                editar();
            break;
        }
        
        ChamarTelaDetalhes();
    }//GEN-LAST:event_btnSalvarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JCheckBox chkAtivo;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblNome;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables

    private void inserir() {
               
        Montadora montadora = new Montadora(txtNome.getText().trim());
        try{
            _controller.salvar(montadora);
            JOptionPane.showMessageDialog(null, "Montadora cadastrada com sucesso.", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Não foi possível efetuar o cadastro. Detalhes: "+ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            this.dispose();
        }   
        
    }
    
    private void editar() {
        
        Montadora montadora = new Montadora(Integer.parseInt(txtCodigo.getText()), txtNome.getText().trim(), chkAtivo.isSelected());
        try{
            _controller.salvar(montadora);
            JOptionPane.showMessageDialog(null, "Montadora cadastrada com sucesso.", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Não foi possível efetuar o cadastro. Detalhes: "+ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            this.dispose();
        }   
        
    }
    
    private void EscolherAcaoNaTela(AcaoNaTela acaoNaTela, Montadora montadora) {
        
        txtCodigo.setEnabled(false);
        chkAtivo.setVisible(false);
 
        switch(acaoNaTela){
            case Inserir:
                this.setTitle("Cadastro de Montadoras");
                txtNome.setFocusable(true);
                break;
            case Detalhes:
                this.setTitle("Detalhes da Montadora");
                txtCodigo.setText(Integer.toString(montadora.getId()));
                txtNome.setText(montadora.getNome());
                chkAtivo.setSelected(montadora.isAtivo());
                txtNome.setEnabled(false);
                btnSalvar.setVisible(false);
                chkAtivo.setVisible(true);
                chkAtivo.setEnabled(false);              
                break;
            case Editar:
                this.setTitle("Editar do Montadora");
                txtCodigo.setText(Integer.toString(montadora.getId()));
                txtNome.setText(montadora.getNome());
                chkAtivo.setVisible(true);
                chkAtivo.setEnabled(true);
                chkAtivo.setSelected(montadora.isAtivo());
                break;
        }
    }
    
    private void ChamarTelaDetalhes() {
        FrmMontadoraDetalhes frm = new FrmMontadoraDetalhes(_internalPrincipal);
        _internalPrincipal.add(frm);
        frm.setVisible(true);
    }
}
