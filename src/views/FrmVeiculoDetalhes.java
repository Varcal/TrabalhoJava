/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.MontadoraController;
import controllers.VeiculoController;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Montadora;
import models.Veiculo;

/**
 *
 * @author varcal
 */
public class FrmVeiculoDetalhes extends javax.swing.JInternalFrame {

    JDesktopPane _internalPrincipal;
    VeiculoController _veiculoController;
    MontadoraController _montadoraController;
    
    public FrmVeiculoDetalhes(JDesktopPane internalPrincipal) {
        initComponents();
         this.setLocation(280, 100);
        _internalPrincipal = internalPrincipal;
        _veiculoController = new VeiculoController();
        _montadoraController = new MontadoraController();
        carregarComboMontadora();
        carregarTabela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlVeiculo = new javax.swing.JPanel();
        btnAlterar = new javax.swing.JButton();
        btnDetalhes = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        cbMontadora = new javax.swing.JComboBox<>();
        btnPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        gridVeiculos = new javax.swing.JTable();

        setTitle("Detalhes Veículos");
        setPreferredSize(new java.awt.Dimension(800, 544));

        pnlVeiculo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlVeiculo.setPreferredSize(new java.awt.Dimension(473, 93));

        btnAlterar.setText("Alterar");
        btnAlterar.setPreferredSize(new java.awt.Dimension(57, 23));
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnDetalhes.setText("Detalhes");
        btnDetalhes.setPreferredSize(new java.awt.Dimension(57, 23));
        btnDetalhes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalhesActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.setPreferredSize(new java.awt.Dimension(57, 23));
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnFechar.setText("Fechar");
        btnFechar.setPreferredSize(new java.awt.Dimension(57, 23));
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlVeiculoLayout = new javax.swing.GroupLayout(pnlVeiculo);
        pnlVeiculo.setLayout(pnlVeiculoLayout);
        pnlVeiculoLayout.setHorizontalGroup(
            pnlVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVeiculoLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDetalhes, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(263, Short.MAX_VALUE))
        );
        pnlVeiculoLayout.setVerticalGroup(
            pnlVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVeiculoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                    .addComponent(btnDetalhes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnFechar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        cbMontadora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos" }));

        btnPesquisar.setText("...");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        gridVeiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Modelo", "Marca", "Cor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        gridVeiculos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(gridVeiculos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlVeiculo, javax.swing.GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(cbMontadora, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbMontadora, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
       
        ArrayList<Veiculo> veiculos = new ArrayList<>();
        
        try {
            String montadora = cbMontadora.getSelectedItem().toString();
            
            if(montadora == "Todos"){
                veiculos = _veiculoController.selecionarTodos();
            }else{
                int montadoraId = _montadoraController.retornaMontadoraId(montadora);
                veiculos = _veiculoController.selecionarTodos(montadoraId);
            }
                     
            while (gridVeiculos.getModel().getRowCount() > 0) {  
                ((DefaultTableModel) gridVeiculos.getModel()).removeRow(0);  
            }    
            
            if(veiculos.isEmpty()){
                JOptionPane.showMessageDialog(null, "Nenhum veículo encontrado para essa pesquisa", "INFORMAÇÔES", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
                
            carregarTabela(veiculos);
            
        } catch (SQLException ex) {
            
        }
        
       
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        chamarFormVeiculoCadastro(AcaoNaTela.Inserir,null);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        int linhaSelecionada  = gridVeiculos.getSelectedRow();
        
        if(linhaSelecionada < 0){
            JOptionPane.showMessageDialog(null, "Nenhum veículo foi selecionado.", "INFORMAÇÔES", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        int id =  (Integer)gridVeiculos.getValueAt(linhaSelecionada, 0);
       
        Veiculo veiculo = null;
        try {
            veiculo = _veiculoController.buscarPorId(id);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Ocorreu um erro ao tentar visualizar um veículo.", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        chamarFormVeiculoCadastro(AcaoNaTela.Editar, veiculo);
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnDetalhesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalhesActionPerformed
        int linhaSelecionada  = gridVeiculos.getSelectedRow();
        
        if(linhaSelecionada < 0){
            JOptionPane.showMessageDialog(null, "Nenhum veículo foi selecionado.", "INFORMAÇÔES", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        int id =  (Integer)gridVeiculos.getValueAt(linhaSelecionada, 0);
       
        Veiculo veiculo = null;
        try {
            veiculo = _veiculoController.buscarPorId(id);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Ocorreu um erro ao tentar visualizar um model.", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        chamarFormVeiculoCadastro(AcaoNaTela.Detalhes, veiculo);
    }//GEN-LAST:event_btnDetalhesActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
         int linhaSelecionada  = gridVeiculos.getSelectedRow();
        
        if(linhaSelecionada < 0){
            JOptionPane.showMessageDialog(null, "Nenhum veículo foi selecionado.", "INFORMAÇÔES", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        int id =  (Integer)gridVeiculos.getValueAt(linhaSelecionada, 0);
       
        Veiculo veiculo = null;
        try {
            veiculo = _veiculoController.buscarPorId(id);
            veiculo.desativar();
            int result = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir?", "PERGUNTA", JOptionPane.YES_NO_CANCEL_OPTION);      
            if(result == JOptionPane.YES_NO_OPTION){
                _veiculoController.excluir(veiculo);               
                removerLinha(linhaSelecionada);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Ocorreu um erro ao tentar visualizar o veículo.", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnDetalhes;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JComboBox<String> cbMontadora;
    private javax.swing.JTable gridVeiculos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlVeiculo;
    // End of variables declaration//GEN-END:variables
 
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
    
    private void carregarTabela(){
             
        try{
            ArrayList<Veiculo> veiculos  = _veiculoController.selecionarTodos();
                     
            if(veiculos == null){
                JOptionPane.showMessageDialog(null, "Nenhum veículo cadastrado", "INFORMAÇÕES", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            
            DefaultTableModel table = (DefaultTableModel) gridVeiculos.getModel();
            
            for(Veiculo v: veiculos){
                table.addRow(new Object[]{v.getId(), v.getModelo().getNome(), v.getModelo().Montadora.getNome(), v.getCor()});
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Não foi possível carregas as informações Detalhes: "+ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void carregarTabela(ArrayList<Veiculo> veiculos){
                        
            if(veiculos == null){
                JOptionPane.showMessageDialog(null, "Nenhum veículo cadastrado", "INFORMAÇÕES", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            
            DefaultTableModel table = (DefaultTableModel) gridVeiculos.getModel();
            
            for(Veiculo v: veiculos){
                table.addRow(new Object[]{v.getId(), v.getModelo().getNome(), v.getModelo().Montadora.getNome(), v.getCor()});
            }                      
    }
    
    private void chamarFormVeiculoCadastro(AcaoNaTela acao, Veiculo veiculo) {
        FrmVeiculoCadastro frm = new FrmVeiculoCadastro(_internalPrincipal, acao, veiculo);
        this.dispose();
        _internalPrincipal.add(frm);
        frm.setVisible(true);
    }
    
     private void removerLinha(int linhaSelecionada){
        DefaultTableModel table = (DefaultTableModel) gridVeiculos.getModel();       
        table.removeRow(linhaSelecionada);
    }
}
