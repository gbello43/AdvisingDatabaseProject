package seniordesign;


//import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class StudentForm extends javax.swing.JFrame {

    /**
     * Creates new form StudentForm
     */
    public static int ID;
    
    public StudentForm() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    public void displayStudentInfo(int id)
    {
        //DefaultTableModel table =table.getModel();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");  
        LocalDateTime now = LocalDateTime.now();  
        
        
        DefaultTableModel table = (DefaultTableModel) CourseTable.getModel();
        
        
        AdvisingDB db = new AdvisingDB();
        System.out.println("Before");
        ResultSet student = db.studentInfo(id);//students info
        System.out.println("After");
        
       // ResultSet course = db.getCourses();//db.studentAcademics(id);
       
        try {
            //set top information of student
            StudentNameText.setText(student.getString("firstName") + " " + student.getString("lastName"));
            StudentIDText.setText(Integer.toString(id));
            MajorText.setText(student.getString("major"));  //get students major
            DateText.setText(dtf.format(now));
            
            int rows = table.getRowCount();
            boolean hasAcademics = db.hasAcademics(id);
            
            if(!hasAcademics){
                System.out.println("no classes");
            }
            else{
               
                ResultSet classes = db.studentAcademics(id);//students class information
                int courseID = classes.getInt("courseID");
                
                for(int i = 0; i < rows; i++)
                    {
                        String cID = table.getValueAt(i, 2).toString();

                        int newID = Integer.parseInt(cID);

                        if(courseID == newID)
                        {
                            table.setValueAt(classes.getString("grade"),i,5);
                            table.setValueAt(classes.getString("semester"),i,6);
                            table.setValueAt(classes.getString("comments"),i,8);

                        }
                    }
                while(classes.next())
                {

                    courseID = classes.getInt("courseID");

                    for(int i = 0; i < rows; i++)
                    {
                        String cID = table.getValueAt(i, 2).toString();

                        int newID = Integer.parseInt(cID);

                        if(courseID == newID)
                        {
                            table.setValueAt(classes.getString("grade"),i,5);
                            table.setValueAt(classes.getString("semester"),i,6);
                            table.setValueAt(classes.getString("comments"),i,8);

                        }
                    }
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AdvisingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void getCourses()
    {
        DefaultTableModel table = (DefaultTableModel) CourseTable.getModel();
        Object[] row = new Object[9];
        
        
        AdvisingDB db = new AdvisingDB();
        
        ResultSet course = db.getCourses();
       
        try {
            
            row[1] = getDept(course.getInt("departmentID"));
            row[2] = course.getInt("courseID"); //courseID
            row[3] = course.getString("courseName");    //courseName
            row[4] = course.getInt("units");    //units
            //row[3] = "";//course.getString("grade");   //grade
            //row[4] = course.getString("semester");  //Semester
            row[7] = course.getInt("preReqID"); //preReqID
            //row[6] = course.getString("comments"); //comments


            table.addRow(row);
            
            while(course.next())
            {
                row[1] = getDept(course.getInt("departmentID"));
                row[2] = course.getInt("courseID"); //courseName
                row[3] = course.getString("courseName");
                row[4] = course.getInt("units");    //units
                //row[3] = "";//course.getString("grade");   //grade
                //row[4] = course.getString("semester");  //Semester
                row[7] = course.getInt("preReqID"); //preReqID
                //row[6] = course.getString("comments"); //comments
                
                table.addRow(row);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdvisingDB.class.getName()).log(Level.SEVERE, null, ex);
        } 
       //setLowerDivision();
       //setUpperDivision();
    }
    
    public String getDept(int department)
    {
        String dept = "";
        
        switch(department)
        {
            case 1: //Computer Science
                dept = "CSC";
                break;
            case 2:
                dept = "MAT";
                break;
            case 3:
                dept = "PHY";
                break;
            default:
                break;
        }
        return dept;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jPanel1 = new javax.swing.JPanel();
        StudentIDLabel = new javax.swing.JLabel();
        StudentNameLabel = new javax.swing.JLabel();
        AdvisorNameLabel = new javax.swing.JLabel();
        StudentNameText = new javax.swing.JLabel();
        StudentIDText = new javax.swing.JLabel();
        MajorLabel = new javax.swing.JLabel();
        MajorText = new javax.swing.JLabel();
        DateText = new javax.swing.JLabel();
        DateLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        CourseTable = new javax.swing.JTable();
        BackButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(767, 4766));

        jPanel1.setBackground(new java.awt.Color(234, 181, 67));
        jPanel1.setForeground(new java.awt.Color(234, 181, 67));
        jPanel1.setPreferredSize(new java.awt.Dimension(240, 110));

        StudentIDLabel.setBackground(new java.awt.Color(255, 255, 255));
        StudentIDLabel.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        StudentIDLabel.setForeground(new java.awt.Color(255, 255, 255));
        StudentIDLabel.setText("Student ID:");

        StudentNameLabel.setBackground(new java.awt.Color(255, 255, 255));
        StudentNameLabel.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        StudentNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        StudentNameLabel.setText("Student Name:");

        AdvisorNameLabel.setBackground(new java.awt.Color(255, 255, 255));
        AdvisorNameLabel.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        AdvisorNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        AdvisorNameLabel.setText("ACADEMICS");

        StudentNameText.setBackground(new java.awt.Color(255, 255, 255));
        StudentNameText.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        StudentNameText.setForeground(new java.awt.Color(255, 255, 255));

        StudentIDText.setBackground(new java.awt.Color(255, 255, 255));
        StudentIDText.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        StudentIDText.setForeground(new java.awt.Color(255, 255, 255));

        MajorLabel.setBackground(new java.awt.Color(255, 255, 255));
        MajorLabel.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        MajorLabel.setForeground(new java.awt.Color(255, 255, 255));
        MajorLabel.setText("Major: ");

        MajorText.setBackground(new java.awt.Color(255, 255, 255));
        MajorText.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        MajorText.setForeground(new java.awt.Color(255, 255, 255));

        DateText.setBackground(new java.awt.Color(255, 255, 255));
        DateText.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        DateText.setForeground(new java.awt.Color(255, 255, 255));

        DateLabel.setBackground(new java.awt.Color(255, 255, 255));
        DateLabel.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        DateLabel.setForeground(new java.awt.Color(255, 255, 255));
        DateLabel.setText("Date:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(StudentIDLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StudentNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(StudentIDText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(StudentNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DateLabel)
                    .addComponent(MajorLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DateText, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MajorText, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(265, 265, 265)
                .addComponent(AdvisorNameLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(AdvisorNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(StudentNameLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StudentNameText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MajorLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MajorText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DateText, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(StudentIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(StudentIDText, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(DateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(100, 14, 39));

        CourseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Take", "Dept.", "Course ID", "Course Name", "Units", "Grade", "Sem/Yearl", "Pre-Req/Options", "Comments"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(CourseTable);
        if (CourseTable.getColumnModel().getColumnCount() > 0) {
            CourseTable.getColumnModel().getColumn(0).setPreferredWidth(5);
            CourseTable.getColumnModel().getColumn(1).setPreferredWidth(5);
            CourseTable.getColumnModel().getColumn(2).setPreferredWidth(5);
            CourseTable.getColumnModel().getColumn(4).setPreferredWidth(5);
            CourseTable.getColumnModel().getColumn(5).setPreferredWidth(5);
        }

        BackButton.setBackground(new java.awt.Color(100, 14, 39));
        BackButton.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        BackButton.setForeground(new java.awt.Color(234, 181, 67));
        BackButton.setText("LOGOUT");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("IP : In Progress");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("* : Substitute");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(107, 107, 107)
                .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(BackButton))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        // TODO add your handling code here:
        Log_in login = new Log_in();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackButtonActionPerformed

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
            java.util.logging.Logger.getLogger(StudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentForm().setVisible(true);
                //displayStudentInfo();
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AdvisorNameLabel;
    private javax.swing.JButton BackButton;
    private javax.swing.JTable CourseTable;
    private javax.swing.JLabel DateLabel;
    private javax.swing.JLabel DateText;
    private javax.swing.JLabel MajorLabel;
    private javax.swing.JLabel MajorText;
    private javax.swing.JLabel StudentIDLabel;
    private javax.swing.JLabel StudentIDText;
    private javax.swing.JLabel StudentNameLabel;
    private javax.swing.JLabel StudentNameText;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
