/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import com.sun.org.apache.xerces.internal.xpointer.XPointerPart;
import controllers.ModeloController;
import controllers.MontadoraController;
import controllers.VeiculoController;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import models.Modelo;
import models.Veiculo;
import util.FormatarDecimal;
import util.LimitaDigitosNumericos;
import util.LimitarDigitosTexto;

/**
 *
 * @author varcal
 */
public class FrmVeiculoCadastro extends javax.swing.JInternalFrame {

    private final AcaoNaTela _acaoNaTela;
    JDesktopPane _internalPrincipal;
    ModeloController _modeloController;
    VeiculoController _veiculoController;
   
    
    public FrmVeiculoCadastro(JDesktopPane internalPrincipal, AcaoNaTela acaoNaTela, Veiculo veiculo) {
        initComponents();
        txtAno.setDocument(new LimitaDigitosNumericos(4));
        txtCor.setDocument(new LimitarDigitosTexto(20));
        txtValor.setDocument(new FormatarDecimal());
        
        this.setLocation(440, 100);
        _acaoNaTela = acaoNaTela;
        _internalPrincipal = internalPrincipal;        
        carregarComboModelo();
        escolherAcaoNaTela(acaoNaTela, veiculo);
        _modeloController = new ModeloController();
        _veiculoController = new VeiculoController();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblModelo = new javax.swing.JLabel();
        cbModelo = new javax.swing.JComboBox<>();
        txtCodigo = new javax.swing.JTextField();
        lblCodigo = new javax.swing.JLabel();
        lblAno = new javax.swing.JLabel();
        txtAno = new javax.swing.JTextField();
        lblCor = new javax.swing.JLabel();
        txtCor = new javax.swing.JTextField();
        lblPlaca = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JTextField();
        try{
            javax.swing.text.MaskFormatter data= new javax.swing.text.MaskFormatter("AAA-####");
            txtPlaca = new javax.swing.JFormattedTextField(data);
        }
        catch (Exception e){
        }
        lblValor = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        taDescricao = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        chkVendido = new javax.swing.JCheckBox();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblTipo = new javax.swing.JLabel();
        txtTipo = new javax.swing.JTextField();

        lblModelo.setText("Modelo:");

        cbModelo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o Modelo" }));
        cbModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbModeloActionPerformed(evt);
            }
        });

        lblCodigo.setText("Código:");

        lblAno.setText("Ano: ");

        lblCor.setText("Cor: ");

        lblPlaca.setText("Placa: ");

        lblValor.setText("Valor: ");

        txtValor.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        taDescricao.setColumns(20);
        taDescricao.setRows(5);
        jScrollPane1.setViewportView(taDescricao);

        jLabel5.setText("Descrição");

        chkVendido.setText("Vendido");

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

        lblTipo.setText("Tipo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chkVendido)
                        .addGap(189, 189, 189)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblModelo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblAno)
                                    .addComponent(lblCor, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCor, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                    .addComponent(txtAno))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblValor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPlaca)
                                    .addComponent(lblTipo))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTipo)
                        .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAno, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPlaca)
                    .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCor, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCor)
                    .addComponent(lblValor)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(chkVendido)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
       this.dispose();
       FrmVeiculoDetalhes frm = new FrmVeiculoDetalhes(_internalPrincipal);
       _internalPrincipal.add(frm);
       frm.setVisible(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        
        switch(_acaoNaTela){
            case Inserir:
                inserir();
                break;
            case Editar:
                alterar();
                break;
        }     
        
        FrmVeiculoDetalhes frm = new FrmVeiculoDetalhes(_internalPrincipal);
        _internalPrincipal.add(frm);
        frm.setVisible(true);
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void cbModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbModeloActionPerformed
        try {
            cbModelo = (JComboBox) evt.getSource();
            String nome = cbModelo.getSelectedItem().toString();
            Modelo modelo = _modeloController.buscarPorNome(nome);
            txtTipo.setText(modelo.ModeloTipo.getNome());
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbModeloActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbModelo;
    private javax.swing.JCheckBox chkVendido;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAno;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblCor;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblPlaca;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblValor;
    private javax.swing.JTextArea taDescricao;
    private javax.swing.JTextField txtAno;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCor;
    private javax.swing.JTextField txtPlaca;
    private javax.swing.JTextField txtTipo;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables

    private void carregarComboModelo(){
        ModeloController modeloCtrl = new ModeloController();
        
        try {
            ArrayList<Modelo> modelos = modeloCtrl.selecionarTodosAtivosInativos("Ativos", "");
            
            for(Modelo m : modelos){
                cbModelo.addItem(m.getNome());
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível carregar os modelos", "ERRO", JOptionPane.ERROR_MESSAGE);
        }   
    }

    private void escolherAcaoNaTela(AcaoNaTela acaoNaTela, Veiculo veiculo) {
        
        txtCodigo.setEnabled(false);
        txtTipo.setEnabled(false);
        chkVendido.setVisible(false);
        
        
        switch(acaoNaTela){
            case Inserir:
                this.setTitle("Cadastro de Veículos");
                
                break;
            case Detalhes:
                this.setTitle("Detalhes do Veículo");
                txtCodigo.setText(Integer.toString(veiculo.getId()));
                cbModelo.setSelectedItem(veiculo.getModelo().getNome());
                txtTipo.setText(veiculo.getModelo().ModeloTipo.getNome());
                txtAno.setText(veiculo.getAno());
                txtPlaca.setText(veiculo.getPlaca());
                txtCor.setText(veiculo.getCor());
                txtValor.setText(formatarValor(Float.toString(veiculo.getValor())));
                taDescricao.setText(veiculo.getDescricao());
                cbModelo.setEnabled(false);
                txtAno.setEnabled(false);
                txtPlaca.setEnabled(false);
                txtCor.setEnabled(false);
                txtValor.setEnabled(false);
                taDescricao.setEnabled(false);
                btnSalvar.setVisible(false);
                btnCancelar.setFocusable(true);
                
                break;
            case Editar:
                this.setTitle("Editar Veículo");
                txtCodigo.setText(Integer.toString(veiculo.getId()));
                cbModelo.setSelectedItem(veiculo.getModelo().getNome());
                txtTipo.setText(veiculo.getModelo().ModeloTipo.getNome());
                txtAno.setText(veiculo.getAno());
                txtPlaca.setText(veiculo.getPlaca());
                txtCor.setText(veiculo.getCor());
                txtValor.setText(formatarValor(Float.toString(veiculo.getValor())));              
                taDescricao.setText(veiculo.getDescricao());
                
                break;
        }
    }
    
    private void inserir(){
        try {
            String nome = cbModelo.getSelectedItem().toString();
            int modeloId = _modeloController.retornaId(nome);  
            float valor = Float.parseFloat(txtValor.getText().replace(".","").replace(",", "."));
            Veiculo veiculo = new Veiculo(modeloId,txtAno.getText(),txtCor.getText(),txtPlaca.getText(),valor,taDescricao.getText());
            _veiculoController.Salvar(veiculo);
            JOptionPane.showMessageDialog(null,"Novo veiculo inserido com sucesso.","SUCESSO", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Não foi possível inserir novo veiculo. Detalhes: "+ex.getMessage(),"ERRO", JOptionPane.ERROR_MESSAGE);
            this.dispose();
        }
    }
    
    private void alterar(){
        try {
            String nome = cbModelo.getSelectedItem().toString();
            int modeloId = _modeloController.retornaId(nome);  
            float valor = Float.parseFloat(txtValor.getText().replace(".","").replace(",", "."));
            Veiculo veiculo = new Veiculo(Integer.parseInt(txtCodigo.getText()),modeloId,txtAno.getText(),txtCor.getText(),txtPlaca.getText(),valor,taDescricao.getText());
            _veiculoController.Salvar(veiculo);
            JOptionPane.showMessageDialog(null,"Veículo alterado com sucesso.","SUCESSO", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Não foi possível alterar veiculo. Detalhes: "+ex.getMessage(),"ERRO", JOptionPane.ERROR_MESSAGE);
            this.dispose();
        }
    }
    
    private String formatarValor(String str){
        
                        
            if(str.charAt(str.length()-2)== '.'){
                str = str +"0";
            }
        
            return str;
    }
}
