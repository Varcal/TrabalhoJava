/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.ModeloController;
import controllers.ModeloTipoController;
import controllers.MontadoraController;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import models.Modelo;
import models.ModeloTipo;
import models.Montadora;

/**
 *
 * @author varcal
 */
public class FrmModeloCadastro extends javax.swing.JInternalFrame {

    private AcaoNaTela _acaoNaTela;
    JDesktopPane _internalPrincipal;
    ModeloTipoController _modeloTipoController;
    MontadoraController _montadoraController;
    ModeloController _modeloController;
    
    public FrmModeloCadastro(JDesktopPane internalPrincipal, AcaoNaTela acaoNaTela, Modelo modelo) {
        initComponents();
        this.setLocation(440, 200);
        _acaoNaTela = acaoNaTela;
        _internalPrincipal = internalPrincipal;
        carregarComboMontadora();
        carregarComboModeloTipo();
        escolherAcaoNaTela(acaoNaTela, modelo);
        _modeloTipoController = new ModeloTipoController();
        _montadoraController = new MontadoraController();
        _modeloController = new ModeloController();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCodigo = new javax.swing.JTextField();
        lblModelo = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblCodigo = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        chkAtivo = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        cbMontadora = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cbModeloTipo = new javax.swing.JComboBox<>();

        lblModelo.setText("Modelo:");

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

        lblCodigo.setText("Código:");

        chkAtivo.setText("Ativo");

        jLabel1.setText("Montadora:");

        cbMontadora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));

        jLabel2.setText("Tipo:");

        cbModeloTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(lblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGap(19, 19, 19)
                                            .addComponent(cbMontadora, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(chkAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(1, 1, 1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtModelo)
                            .addComponent(cbModeloTipo, 0, 244, Short.MAX_VALUE))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCodigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbMontadora, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbModeloTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(47, 47, 47))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.setVisible(false);
        FrmModeloDetalhes frm = new FrmModeloDetalhes(_internalPrincipal);
        _internalPrincipal.add(frm);
        frm.setVisible(true);
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
        
        FrmMontadoraDetalhes frm = new FrmMontadoraDetalhes(_internalPrincipal);
        _internalPrincipal.add(frm);
        frm.setVisible(true);
    }//GEN-LAST:event_btnSalvarActionPerformed
   
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbModeloTipo;
    private javax.swing.JComboBox<String> cbMontadora;
    private javax.swing.JCheckBox chkAtivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtModelo;
    // End of variables declaration//GEN-END:variables


    private void inserir(){
        try {
            int modeloTipoId = _modeloTipoController.retornaModeloTipoId(cbModeloTipo.getSelectedItem()+"");
            int montadoraId = _montadoraController.retornaMontadoraId((String)cbMontadora.getSelectedItem().toString()+"");     
            Modelo modelo = new Modelo(txtModelo.getText(), montadoraId, modeloTipoId);
            _modeloController.salvar(modelo);
            JOptionPane.showMessageDialog(null,"Novo modelo inserido com sucesso.","SUCESSO", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Não foi possível inserir novo modelo. Detalhes: "+ex.getMessage(),"ERRO", JOptionPane.ERROR_MESSAGE);
            this.dispose();
        }
        
    } 
    
    private void editar(){
        
        String montadora = (String)cbMontadora.getSelectedItem();
        String modeloTipo = (String)cbModeloTipo.getSelectedItem();
        
        try {
            int montadoraId = _montadoraController.retornaMontadoraId(montadora);
            int modeloTipoId = _modeloTipoController.retornaModeloTipoId(modeloTipo);
            
            Modelo modelo = new Modelo(Integer.parseInt(txtCodigo.getText()),txtModelo.getText(), montadoraId, modeloTipoId, chkAtivo.isSelected());
            _modeloController.salvar(modelo);
            JOptionPane.showMessageDialog(null,"Novo modelo alterado com sucesso.","SUCESSO", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Não foi possível alterar o modelo. Detalhes: "+ex.getMessage(),"ERRO", JOptionPane.ERROR_MESSAGE);
            this.dispose();
        }
    }    
    
    private void escolherAcaoNaTela(AcaoNaTela acaoNaTela, Modelo modelo) {
        
        txtCodigo.setEnabled(false);
        chkAtivo.setVisible(false);
        
        switch(acaoNaTela){
            case Inserir:
                this.setTitle("Cadastro de Modelos");
                txtModelo.setFocusable(true);
                break;
            case Detalhes:
                this.setTitle("Detalhes do Modelo");
                txtCodigo.setText(Integer.toString(modelo.getId()));
                txtModelo.setText(modelo.getNome());
                cbModeloTipo.setSelectedItem(modelo.ModeloTipo.getNome());
                cbMontadora.setSelectedItem(modelo.Montadora.getNome());
                chkAtivo.setSelected(modelo.isAtivo());
                txtModelo.setEnabled(false);
                btnSalvar.setVisible(false);                              
                chkAtivo.setVisible(true);
                chkAtivo.setEnabled(false);
                cbMontadora.setEnabled(false);
                cbModeloTipo.setEnabled(false);
                btnCancelar.setFocusable(true);
                
                break;
            case Editar:
                this.setTitle("Editar do Modelo");
                txtCodigo.setText(Integer.toString(modelo.getId()));
                txtModelo.setText(modelo.getNome());
                chkAtivo.setSelected(modelo.isAtivo());
                btnCancelar.setFocusable(true);
                cbModeloTipo.setSelectedItem(modelo.ModeloTipo.getNome());
                cbMontadora.setSelectedItem(modelo.Montadora.getNome());
                chkAtivo.setVisible(true);
                chkAtivo.setEnabled(true);
                break;
        }
    }
    
    private void carregarComboMontadora(){
        MontadoraController montadoraCtrl = new MontadoraController();
        
        try {
            ArrayList<Montadora> montadoras = montadoraCtrl.selecionarTodosAtivosInativos("Ativos", "");
            
            for(Montadora m : montadoras){
                cbMontadora.addItem(m.getNome());
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível carregar as montadoras", "ERRO", JOptionPane.ERROR_MESSAGE);
        }   
    }
    
    private void carregarComboModeloTipo(){
        ModeloTipoController modeloTipoCtrl = new ModeloTipoController();
        
        try {
            ArrayList<ModeloTipo> modeloTipoList = modeloTipoCtrl.selecionarTodosAtivosInativos("Ativos");
            
            for(ModeloTipo m : modeloTipoList){
                cbModeloTipo.addItem(m.getNome());
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível carregar os Tipos", "ERRO", JOptionPane.ERROR_MESSAGE);
        }   
    }
}
