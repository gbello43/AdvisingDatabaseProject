package seniordesign;


import java.util.Random;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class advisorRegistration extends javax.swing.JFrame {
    public static AdvisingDB db;
    public int id;
    /**
     * Creates new form advisorRegistration
     */
    public advisorRegistration() {
        initComponents();
        this.setLocationRelativeTo(null);
 
        Random rnd = new Random();
        int advisorID = rnd.nextInt(5000)+ 1000;
        id = advisorID;
        
        String id = Integer.toString(advisorID);
        advisorIDNumber.setText(id);
        
    } 
    // This is what im trying to make it work
    // i made a getAdvisorUser on AdvisingDB just check if i did it right - Carlito
    /*
     public void confirmEmail()
    {
        
        System.out.println("Confirmed");
        
        AdvisingDB reg = new AdvisingDB();
        int departmentID = jComboBoxMajor.getSelectedItem().getInt();
        
        reg.addAdvisorUser(Integer.parseInt(advisorIDNumber.getText()),firstNameText.getText(), departmentID , emailText.getText());
        //register (username,pass,isAdv,sID,aID)
        reg.register(usernameText.getText(), passwordText.getText(),true,0, Integer.parseInt(advisorIDNumber.getText()));
        /////////////////
        
        JOptionPane.showMessageDialog(null, "Thank You for Registering", "Welcome", JOptionPane.PLAIN_MESSAGE);
        
        Log_in lgi = new Log_in();
        lgi.setVisible(true);
        this.dispose();
            
            
    }
*/
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        FirstNameLabel = new javax.swing.JLabel();
        LastNameLabel = new javax.swing.JLabel();
        AdvisorIDLabel = new javax.swing.JLabel();
        advisorIDNumber = new javax.swing.JLabel();
        DepartmentLabel = new javax.swing.JLabel();
        EmailLabel = new javax.swing.JLabel();
        UsernameLabel = new javax.swing.JLabel();
        PasswordLabel = new javax.swing.JLabel();
        ConfirmPasswordLabel = new javax.swing.JLabel();
        firstNameText = new javax.swing.JTextField();
        lastNameText = new javax.swing.JTextField();
        jComboBoxMajor = new javax.swing.JComboBox<>();
        emailText = new javax.swing.JTextField();
        usernameText = new javax.swing.JTextField();
        passwordText = new javax.swing.JTextField();
        confirmPasswordText = new javax.swing.JTextField();
        RegisterButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(100, 14, 39));

        FirstNameLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        FirstNameLabel.setForeground(new java.awt.Color(234, 181, 67));
        FirstNameLabel.setText("First Name:");

        LastNameLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LastNameLabel.setForeground(new java.awt.Color(234, 181, 67));
        LastNameLabel.setText("Last Name:");

        AdvisorIDLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        AdvisorIDLabel.setForeground(new java.awt.Color(234, 181, 67));
        AdvisorIDLabel.setText("Advisor ID: ");

        advisorIDNumber.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        advisorIDNumber.setForeground(new java.awt.Color(234, 181, 67));

        DepartmentLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        DepartmentLabel.setForeground(new java.awt.Color(234, 181, 67));
        DepartmentLabel.setText("Department:");

        EmailLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        EmailLabel.setForeground(new java.awt.Color(234, 181, 67));
        EmailLabel.setText("Email:");

        UsernameLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        UsernameLabel.setForeground(new java.awt.Color(234, 181, 67));
        UsernameLabel.setText("Username:");

        PasswordLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PasswordLabel.setForeground(new java.awt.Color(234, 181, 67));
        PasswordLabel.setText("Password:");

        ConfirmPasswordLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ConfirmPasswordLabel.setForeground(new java.awt.Color(234, 181, 67));
        ConfirmPasswordLabel.setText("Confirm Password:");

        firstNameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNameTextActionPerformed(evt);
            }
        });

        lastNameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastNameTextActionPerformed(evt);
            }
        });

        jComboBoxMajor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Computer Science", "Mathematics", "Physics" }));

        emailText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTextActionPerformed(evt);
            }
        });

        usernameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameTextActionPerformed(evt);
            }
        });

        RegisterButton.setBackground(new java.awt.Color(100, 14, 39));
        RegisterButton.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        RegisterButton.setForeground(new java.awt.Color(234, 181, 67));
        RegisterButton.setText("Register");
        RegisterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterButtonActionPerformed(evt);
            }
        });

        cancelButton.setBackground(new java.awt.Color(100, 14, 39));
        cancelButton.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        cancelButton.setForeground(new java.awt.Color(234, 181, 67));
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(RegisterButton)
                        .addGap(34, 34, 34)
                        .addComponent(cancelButton))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(ConfirmPasswordLabel)
                            .addGap(18, 18, 18)
                            .addComponent(confirmPasswordText))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(AdvisorIDLabel)
                                .addComponent(FirstNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(LastNameLabel)
                                .addComponent(DepartmentLabel)
                                .addComponent(EmailLabel)
                                .addComponent(UsernameLabel)
                                .addComponent(PasswordLabel))
                            .addGap(47, 47, 47)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lastNameText)
                                .addComponent(firstNameText)
                                .addComponent(jComboBoxMajor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(emailText)
                                .addComponent(usernameText)
                                .addComponent(passwordText, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(advisorIDNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FirstNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(firstNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LastNameLabel)
                    .addComponent(lastNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AdvisorIDLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(advisorIDNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DepartmentLabel)
                    .addComponent(jComboBoxMajor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EmailLabel)
                    .addComponent(emailText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UsernameLabel)
                    .addComponent(usernameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PasswordLabel)
                    .addComponent(passwordText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ConfirmPasswordLabel)
                    .addComponent(confirmPasswordText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RegisterButton)
                    .addComponent(cancelButton))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(234, 181, 67));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("New Advisor");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 34, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void firstNameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNameTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstNameTextActionPerformed

    private void lastNameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastNameTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastNameTextActionPerformed

    private void usernameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameTextActionPerformed

    private void RegisterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterButtonActionPerformed
        // TODO add your handling code here:
        Random rnd = new Random();
        
        String username = usernameText.getText();
        String password = passwordText.getText();
        String email = emailText.getText();
        
        String name = firstNameText.getText() + " " + lastNameText.getText();
        
        Boolean isAdvisor = true;
        //id
        int id = Integer.parseInt(advisorIDNumber.getText());
        
        
        
    }//GEN-LAST:event_RegisterButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        Home_Page hp = new Home_Page();
        hp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void emailTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailTextActionPerformed

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
            java.util.logging.Logger.getLogger(advisorRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(advisorRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(advisorRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(advisorRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        db = new AdvisingDB();
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new advisorRegistration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AdvisorIDLabel;
    private javax.swing.JLabel ConfirmPasswordLabel;
    private javax.swing.JLabel DepartmentLabel;
    private javax.swing.JLabel EmailLabel;
    private javax.swing.JLabel FirstNameLabel;
    private javax.swing.JLabel LastNameLabel;
    private javax.swing.JLabel PasswordLabel;
    private javax.swing.JButton RegisterButton;
    private javax.swing.JLabel UsernameLabel;
    private javax.swing.JLabel advisorIDNumber;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField confirmPasswordText;
    private javax.swing.JTextField emailText;
    private javax.swing.JTextField firstNameText;
    private javax.swing.JComboBox<String> jComboBoxMajor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField lastNameText;
    private javax.swing.JTextField passwordText;
    private javax.swing.JTextField usernameText;
    // End of variables declaration//GEN-END:variables
}
