/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp1;
import java.awt.Dimension;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author parth
 */
public class ForgetPassword extends javax.swing.JFrame {

    /**
     * Creates new form ForgetPassword
     */
    public ForgetPassword() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        SubmitFP = new javax.swing.JButton();
        FPEmail = new javax.swing.JTextField();
        BackToL = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Forget Password");

        jLabel1.setText("Enter recovery E-mail");

        SubmitFP.setText("Submit");
        SubmitFP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitFPActionPerformed(evt);
            }
        });

        FPEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FPEmailActionPerformed(evt);
            }
        });

        BackToL.setText("Back");
        BackToL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackToLActionPerformed(evt);
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
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(FPEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(SubmitFP))
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(BackToL)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(BackToL)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(FPEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(SubmitFP)
                .addContainerGap(200, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleDescription("Forget Password");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void SubmitFPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitFPActionPerformed
        // TODO add your handling code here:
        String strFP= FPEmail.getText();
        String tstr1=""; 
        try{
            FileWriter fwFP= new FileWriter("Data.txt",true);
            int i=0;
            /*while(i != strFP.length()){
                fwFP.write(strFP.charAt(i));
                i++;
        }
            fwFP.write("\r\n");*/
            FileReader frFP= new FileReader("Data.txt");
            BufferedReader brFP=new BufferedReader(frFP);
                    int count1=0;
                    while((i=frFP.read())!= -1){
                        tstr1+=(char)i;
                        i++;
                    }
                    String temp1="";
                    int location=0;
                    String str1[]=tstr1.split(" ",0);
                    String newPass;
                    for(i=0;i<str1.length;i+=2){
                            temp1=str1[i].trim();
                            location+=str1[i].length();
                            if(temp1.equals(strFP)){
                                System.out.print("Valid Username\nEnter new Password : ");
                                Scanner sc=new Scanner(System.in);
                                newPass=sc.nextLine();
                                int newLocation=location+newPass.length();
                                String str2=brFP.readLine();
                                String update=str2.substring(0,location)+newPass+str2.substring(newLocation);
                                fwFP.write(update);
                            }
                            else
                                count1++;
                    }
                    if(count1==(str1.length/2)+1)
                        System.out.println("User doesn't exist");
            brFP.close();
            frFP.close();
            fwFP.close();
            ForgetPassword fp=new ForgetPassword();
            fp.setVisible(false);
        }catch(Exception e){
                
        }
    }//GEN-LAST:event_SubmitFPActionPerformed

    private void FPEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FPEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FPEmailActionPerformed

    private void BackToLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackToLActionPerformed
        // TODO add your handling code here:
        dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_BackToLActionPerformed

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
            java.util.logging.Logger.getLogger(ForgetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForgetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForgetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForgetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ForgetPassword fp= new ForgetPassword();
                fp.setVisible(true);
                fp.setResizable(false);
                fp.setSize(new Dimension(517,454));
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackToL;
    private javax.swing.JTextField FPEmail;
    private javax.swing.JButton SubmitFP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
