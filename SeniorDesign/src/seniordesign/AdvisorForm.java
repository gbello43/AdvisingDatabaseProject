package seniordesign;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
public class AdvisorForm extends javax.swing.JFrame {
    public static int sID;
    public static int aID;
    /**
     * Creates new form AdvisorForm
     */
    public AdvisorForm() {
        initComponents();
        this.setLocationRelativeTo(null);

    }
public void displayInfo(int studentID, int advisorID)
    {
        sID = studentID;
        aID = advisorID;
        //DefaultTableModel table =table.getModel();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");  
        LocalDateTime now = LocalDateTime.now();  
        
        
        DefaultTableModel table = (DefaultTableModel) jTable1.getModel();
        DefaultTableModel table2 = (DefaultTableModel) jTable2.getModel();
        
        AdvisingDB db = new AdvisingDB();

        ResultSet student = db.studentInfo(studentID);//students info
        //ResultSet classes = db.studentAcademics(id);//students class information
        //ResultSet course = db.getCourses();//db.studentAcademics(id);
        ResultSet advisor = db.getAdvisorInfo(advisorID);
        
        try {
            //set top information of student
            StudentNameText.setText(student.getString("firstName") + " " + student.getString("lastName"));
            StudentIDText.setText(Integer.toString(studentID));
            MajorText.setText(student.getString("major"));  //get students major
            DateText.setText(dtf.format(now));
            AdvisorText.setText(advisor.getString("advisorName"));
            
            displayClassInformation(table, studentID);
            displayClassInformation(table2, studentID);
            /*
            boolean hasAcademics = db.hasAcademics(studentID);
            
            if(!hasAcademics){
                System.out.println("no classes");
            }
            else
            {
               /////////////LOWER DIVISION COURSES////////////////
                ResultSet classes = db.studentAcademics(studentID);//students class information
                int courseID = classes.getInt("courseID");

                for(int i = 0; i < table.getRowCount(); i++)
                    {
                        String cID = table.getValueAt(i, 2).toString();

                        int newID = Integer.parseInt(cID);

                        if(courseID == newID)
                        {
                            table.setValueAt(classes.getString("grade"),i,4);
                            table.setValueAt(classes.getString("semester"),i,6);
                            table.setValueAt(classes.getString("comments"),i,7);

                        }
                    }
                while(classes.next())
                {

                    courseID = classes.getInt("courseID");

                    for(int i = 0; i < table.getRowCount(); i++)
                    {
                        String cID = table.getValueAt(i, 2).toString();

                        int newID = Integer.parseInt(cID);

                        if(courseID == newID)
                        {
                            table.setValueAt(classes.getString("grade"),i,4);
                            table.setValueAt(classes.getString("semester"),i,6);
                            table.setValueAt(classes.getString("comments"),i,7);

                        }
                    }
                }
                //////////////UPPER DIVISION TABLE/////////////////
                
                for(int i = 0; i < table2.getRowCount(); i++)
                    {
                        String cID = table2.getValueAt(i, 2).toString();

                        int newID = Integer.parseInt(cID);

                        if(courseID == newID)
                        {
                            table2.setValueAt(classes.getString("grade"),i,4);
                            table2.setValueAt(classes.getString("semester"),i,6);
                            table2.setValueAt(classes.getString("comments"),i,7);

                        }
                    }
                while(classes.next())
                {

                    courseID = classes.getInt("courseID");

                    for(int i = 0; i < table2.getRowCount(); i++)
                    {
                        String cID = table.getValueAt(i, 2).toString();

                        int newID = Integer.parseInt(cID);

                        if(courseID == newID)
                        {
                            table2.setValueAt(classes.getString("grade"),i,4);
                            table2.setValueAt(classes.getString("semester"),i,6);
                            table2.setValueAt(classes.getString("comments"),i,7);

                        }
                    }
                }
                
            }      
            */
        
        } catch (SQLException ex) {
            Logger.getLogger(AdvisingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            
        
    }
    public void displayClassInformation(DefaultTableModel table, int studentID)
    {
        AdvisingDB db = new AdvisingDB();
        
        boolean hasAcademics = db.hasAcademics(studentID);
            

        try{
            if(!hasAcademics){
                System.out.println("no classes");
            }
            else
            {
               /////////////COURSES Taken/InProgress////////////////
                ResultSet classes = db.studentAcademics(studentID);//students class information
                int courseID = classes.getInt("courseID");

                for(int i = 0; i < table.getRowCount(); i++)
                    {
                        String cID = table.getValueAt(i, 2).toString();

                        int newID = Integer.parseInt(cID);

                        if(courseID == newID)
                        {
                            table.setValueAt(classes.getString("grade"),i,4);
                            table.setValueAt(classes.getString("semester"),i,6);
                            table.setValueAt(classes.getString("comments"),i,7);

                        }
                    }
                while(classes.next())
                {

                    courseID = classes.getInt("courseID");

                    for(int i = 0; i < table.getRowCount(); i++)
                    {
                        String cID = table.getValueAt(i, 2).toString();

                        int newID = Integer.parseInt(cID);

                        if(courseID == newID)
                        {
                            table.setValueAt(classes.getString("grade"),i,4);
                            table.setValueAt(classes.getString("semester"),i,6);
                            table.setValueAt(classes.getString("comments"),i,7);

                        }
                    }
                }
                
            }
        }catch(Exception e)
        {
            System.out.println(e);
        }
               
    }
    public void getCourses()
    {
        
        setLowerDivision();
        setUpperDivision();
    }
    public void setLowerDivision()
    {
    DefaultTableModel table = (DefaultTableModel) jTable1.getModel();
        
        Object[] row = new Object[8];
        
        
        AdvisingDB db = new AdvisingDB();
        ResultSet course = db.getCourseDivision(1);
       
        try {
            row[1] = getDept(course.getInt("departmentID"));
            row[2] = course.getInt("courseID"); //courseName
            row[3] = course.getString("courseName");
            row[5] = course.getInt("units");    //units
            
            table.addRow(row);
            
            while(course.next())
            {
                row[1] = getDept(course.getInt("departmentID"));

                row[2] = course.getInt("courseID"); //courseName
                row[3] = course.getString("courseName");
                row[5] = course.getInt("units");    //units
                
                table.addRow(row);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdvisingDB.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
        
        
        
    }
    public void setUpperDivision()
    {
    DefaultTableModel table = (DefaultTableModel) jTable2.getModel();
        
        Object[] row = new Object[8];
        
        
        AdvisingDB db = new AdvisingDB();
        ResultSet course = db.getCourseDivision(2);
       
        try {
            row[1] = getDept(course.getInt("departmentID"));
            row[2] = course.getInt("courseID"); //courseName
            row[3] = course.getString("courseName");
            row[5] = course.getInt("units");    //units
            
            table.addRow(row);
            
            while(course.next())
            {
                row[1] = getDept(course.getInt("departmentID"));

                row[2] = course.getInt("courseID"); //courseName
                row[3] = course.getString("courseName");
                row[5] = course.getInt("units");    //units
                
                table.addRow(row);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdvisingDB.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    public void setElectives()
    {}
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

        jPanel1 = new javax.swing.JPanel();
        StudentNameLabel = new javax.swing.JLabel();
        StudentIDLabel = new javax.swing.JLabel();
        AdvisorLabel = new javax.swing.JLabel();
        MajorLabel = new javax.swing.JLabel();
        StudentNameText = new javax.swing.JLabel();
        StudentIDText = new javax.swing.JLabel();
        MajorText = new javax.swing.JLabel();
        AdvisorText = new javax.swing.JLabel();
        DateLabel = new javax.swing.JLabel();
        DateText = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        UpdateButton = new javax.swing.JButton();
        BackButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(234, 181, 67));
        jPanel1.setForeground(new java.awt.Color(234, 181, 67));

        StudentNameLabel.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        StudentNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        StudentNameLabel.setText("Student Name:");

        StudentIDLabel.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        StudentIDLabel.setForeground(new java.awt.Color(255, 255, 255));
        StudentIDLabel.setText("Student ID:");

        AdvisorLabel.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        AdvisorLabel.setForeground(new java.awt.Color(255, 255, 255));
        AdvisorLabel.setText("Advisor: ");

        MajorLabel.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        MajorLabel.setForeground(new java.awt.Color(255, 255, 255));
        MajorLabel.setText("Major:");

        StudentNameText.setBackground(new java.awt.Color(255, 255, 255));
        StudentNameText.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        StudentNameText.setForeground(new java.awt.Color(255, 255, 255));

        StudentIDText.setBackground(new java.awt.Color(255, 255, 255));
        StudentIDText.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        StudentIDText.setForeground(new java.awt.Color(255, 255, 255));

        MajorText.setBackground(new java.awt.Color(255, 255, 255));
        MajorText.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        MajorText.setForeground(new java.awt.Color(255, 255, 255));

        AdvisorText.setBackground(new java.awt.Color(255, 255, 255));
        AdvisorText.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        AdvisorText.setForeground(new java.awt.Color(255, 255, 255));

        DateLabel.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        DateLabel.setForeground(new java.awt.Color(255, 255, 255));
        DateLabel.setText("Date: ");

        DateText.setBackground(new java.awt.Color(255, 255, 255));
        DateText.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        DateText.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Advisement");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(252, 252, 252)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(StudentIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(StudentNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(StudentIDText, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(StudentNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(AdvisorLabel)
                                .addGap(18, 18, 18)
                                .addComponent(AdvisorText, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(DateLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DateText, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(MajorLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(MajorText, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(52, 52, 52))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(StudentIDLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(MajorLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(AdvisorLabel))
                                .addComponent(StudentNameLabel))
                            .addComponent(StudentNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MajorText, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AdvisorText, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DateLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(DateText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(StudentIDText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(23, 23, 23))
        );

        jPanel2.setBackground(new java.awt.Color(100, 14, 39));

        UpdateButton.setBackground(new java.awt.Color(100, 14, 39));
        UpdateButton.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        UpdateButton.setForeground(new java.awt.Color(234, 181, 67));
        UpdateButton.setText("UPDATE");
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });

        BackButton.setBackground(new java.awt.Color(100, 14, 39));
        BackButton.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        BackButton.setForeground(new java.awt.Color(234, 181, 67));
        BackButton.setText("BACK");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("A. Lower Division Requierments (40 units)");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Edit", "Dept.", "CourseID", "Course Name", "Grade", "Units", "Sem/Year", "Comments"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, true, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(5);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(5);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(5);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(5);
        }

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("B. Upper Division Requierments (36 units)");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Edit", "Dept.", "CourseID", "Course Name", "Grade", "Units", "Sem/Year", "Comments"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, true, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(5);
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(5);
            jTable2.getColumnModel().getColumn(2).setPreferredWidth(5);
            jTable2.getColumnModel().getColumn(5).setPreferredWidth(5);
        }

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("C. Electives: Select two from the following (6 units)");

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Edit", "Dept.", "CourseID", "Course Name", "Grade", "Units", "Sem/Year", "Comments"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, true, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTable3);
        if (jTable3.getColumnModel().getColumnCount() > 0) {
            jTable3.getColumnModel().getColumn(0).setPreferredWidth(5);
            jTable3.getColumnModel().getColumn(1).setPreferredWidth(5);
            jTable3.getColumnModel().getColumn(2).setPreferredWidth(5);
            jTable3.getColumnModel().getColumn(5).setPreferredWidth(5);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel3);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("IP :  In Progress");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("*  : Substitute");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 773, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(95, 95, 95)
                .addComponent(UpdateButton)
                .addGap(87, 87, 87)
                .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(UpdateButton)
                        .addComponent(BackButton))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        // TODO add your handling code here:
        Home_Page home = new Home_Page();
        home.advisorInfo(aID);
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackButtonActionPerformed

    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed
        // TODO add your handling code here:
        //setClasses();
        DefaultTableModel L_D_table = (DefaultTableModel) jTable1.getModel();
        DefaultTableModel U_D_table = (DefaultTableModel) jTable2.getModel();
        //DefaultTableModel E_table = (DefaultTableModel) jTable1.getModel();
        setClasses(L_D_table);
        setClasses(U_D_table);
        //db.updateStudentClasses(studentID, courseID, grade, semester, comments);
        
        JOptionPane.showMessageDialog(null, "Classes Updated", "UPDATE", JOptionPane.PLAIN_MESSAGE);

    }//GEN-LAST:event_UpdateButtonActionPerformed
    public void setClasses(DefaultTableModel table)
    {
        //DefaultTableModel table = (DefaultTableModel) jTable1.getModel();
        AdvisingDB db = new AdvisingDB();

        System.out.println("Row count: " + table.getRowCount());
        
        int count = 0;
        
        for(int i = 0; i < table.getRowCount(); i++)
        {
            
            System.out.println("Row: " + count + ", value: " + table.getValueAt(i,0) + ", i= " + i);

            if(table.getValueAt(i,0) == null)
            {
                System.out.println("null");
            }
            else if((boolean)table.getValueAt(i, 0))     //ERROR ERROR ERROR ERROR ERROR
            {
                System.out.println("Row: " + count);
                int courseID = (int) table.getValueAt(i, 2);
                String grade = (String) table.getValueAt(i, 4);
                String semester = (String) table.getValueAt(i,6);
                String comments = (String) table.getValueAt(i,7);
                
                System.out.println("id: " + sID + " CID: " + courseID + " S: " + semester + " G: " + grade + " C: " + comments);

                db.updateStudentClasses(sID, courseID,grade, semester, comments);
            }
            count++;
        }
    }
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
            java.util.logging.Logger.getLogger(AdvisorForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdvisorForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdvisorForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdvisorForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdvisorForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AdvisorLabel;
    private javax.swing.JLabel AdvisorText;
    private javax.swing.JButton BackButton;
    private javax.swing.JLabel DateLabel;
    private javax.swing.JLabel DateText;
    private javax.swing.JLabel MajorLabel;
    private javax.swing.JLabel MajorText;
    private javax.swing.JLabel StudentIDLabel;
    private javax.swing.JLabel StudentIDText;
    private javax.swing.JLabel StudentNameLabel;
    private javax.swing.JLabel StudentNameText;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    // End of variables declaration//GEN-END:variables
}
