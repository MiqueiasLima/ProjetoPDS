/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Controller.ControllerCadastroDesempenho;
import Controller.ControllerCadastroTime;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextField;
import model.Facade;
import model.Observer;

/**
 *
 * @author Miqueias
 */
public class ViewCadastroTime extends javax.swing.JFrame implements Observer {

    /**
     * Creates new form viewCadastroTime
     */
    Facade modelo;
    ControllerCadastroTime controllerCadastroTime;
    
    
    public ViewCadastroTime(Facade modelo) {
        initComponents();
        this.modelo = modelo;
        this.setDefaultCloseOperation(ViewCadastroTime.DO_NOTHING_ON_CLOSE);
        this.setTitle("Cadastro de Time"); 
        this.setVisible(true);
         desativa();
         modelo.attach(this);
         
      
    }

    public void desativa(){
        btnInserirJogador.setEnabled(false);
    }
    
    public JButton getBtnCadastrar() {
        return btnCadastrar;
    }

    public void setBtnCadastrar(JButton btnCadastrar) {
        this.btnCadastrar = btnCadastrar;
    }

    public JButton getBtnFechar() {
        return btnFechar;
    }

    public void setBtnFechar(JButton btnFechar) {
        this.btnFechar = btnFechar;
    }

    public JButton getBtnInserirJogador() {
        return btnInserirJogador;
    }

    public void setBtnInserirJogador(JButton btnInserirJogador) {
        this.btnInserirJogador = btnInserirJogador;
    }

  
    public JComboBox<String> getjNomesTimes() {
        return jNomesTimes;
    }

    public void setjNomesTimes(JComboBox<String> jNomesTimes) {
        this.jNomesTimes = jNomesTimes;
    }

    public JTextField getTxtNomeTime() {
        return txtNomeTime;
    }

    public void setTxtNomeTime(JTextField txtNomeTime) {
        this.txtNomeTime = txtNomeTime;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNomeTime = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();
        btnInserirJogador = new javax.swing.JButton();
        jNomesTimes = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        btnFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Cadastro do Time");

        jLabel2.setText("Nome: ");

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnInserirJogador.setText("Inserir Jogador");
        btnInserirJogador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirJogadorActionPerformed(evt);
            }
        });

        jLabel3.setText("Selecionar Time");

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jNomesTimes, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNomeTime, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnInserirJogador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(btnFechar)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNomeTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCadastrar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInserirJogador)
                    .addComponent(jNomesTimes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addComponent(btnFechar)
                .addGap(52, 52, 52))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
            btnInserirJogador.setEnabled(true);
          
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
            dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnInserirJogadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirJogadorActionPerformed
            ViewCadastrarJogador vCj = new ViewCadastrarJogador(modelo);
            vCj.setDefaultCloseOperation(ViewCadastrarJogador.DO_NOTHING_ON_CLOSE);
            vCj.setTitle("Cadastrar Jogador");
            vCj.setVisible(true);
            
       // this.controllerCadastroTime.trataEvtn(evt);
            
   
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInserirJogadorActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnInserirJogador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JComboBox<String> jNomesTimes;
    private javax.swing.JTextField txtNomeTime;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update() {
        
    }
}
