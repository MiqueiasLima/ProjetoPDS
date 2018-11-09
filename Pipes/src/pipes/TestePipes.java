/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipes;
import View.View;
import java.util.Scanner;
/**
 *
 * @author Miqueias
 */
public class TestePipes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            ModeloPipes nome = new ModeloPipes();
            Scanner recebe = new Scanner(System.in);
            
          /*  System.out.println("Digite um nome:");
            nome.setNome(recebe.nextLine());
            
            
            String nome2 = nome.deixaMaisculo(nome.getNome()); 
                            System.out.println(nome2);
                   nome2 = nome.deixaMinusculo(nome2);
                            System.out.println(nome2);
                   nome2 = nome.inverte(nome2);
                            System.out.println(nome2);
                    nome2 = nome.tiraVogais(nome2);
                            System.out.println(nome2);
                     nome2 = nome.tiraConsoantes(nome2);
                               System.out.println(nome2);
     
            */
    
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
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View(nome).setVisible(true);
            }
        });
    
    
    }
}
