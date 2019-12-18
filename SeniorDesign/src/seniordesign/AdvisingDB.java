package seniordesign;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AdvisingDB {
    private static Connection con = getConnection();

    private static PreparedStatement pstmt; //for updating table
    private static Statement stmt;                  //for retriving data
        
    public static void AdvisingDB()
    {
        
    }
    
    //Establish a connection with mySQL database
    public static Connection getConnection()
    {
        try{
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/advisingdb";
            String username = "root";
            String password = "root";
            Class.forName(driver);
            
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connected");
            return con;
            
        }catch(Exception e){System.out.println(e);}
        
        System.out.println("Failed to Connect");
        return null;
    }
    
    //add a column in the First position: ALTER TABLE students ADD COLUMN studentID INT FIRST;  
    //modify column with specific lastName: "UPDATE students SET studentID = " + id + " WHERE lastName = 'Martinez' " 
    //insert to table: "insert into userlogin values('gbello3', 'xyzzy', true);"
    //delete row: "DELETE FROM students WHERE lastName = 'Bello' "
    public static void deleteUser(String firstName)
    {
        
        //String query = "DELETE FROM userlogin";
        //String query = "DELETE FROM userlogin WHERE studentID = 202670022 ";
        String query = "UPDATE userlogin SET advisorID = 4037551 WHERE username = 'gbello3' ";
        try {
            
            pstmt = con.prepareStatement(query);
            
            pstmt.executeUpdate();
            pstmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(AdvisingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    
    public static void register(String username, String password, Boolean isAdvisor,int studentID, int advisorID)
    {
        

        try {
            //VALUES(String, String, Boolean, integer)
            //pstmt = con.prepareStatement("INSERT INTO userlogin VALUES(?,aes_encrypt(?, 'toro123'),?,?,?)");
            pstmt = con.prepareStatement("INSERT INTO userlogin VALUES('" + username+ "',md5('" + password + "'),"+ isAdvisor+ "," + studentID +"," + advisorID + ")");
            System.out.println("INSERT INTO userlogin VALUES('" + username+ "',md5('" + password + "'),"+ isAdvisor+ "," + studentID +"," + advisorID+ ")");
            
            pstmt.executeUpdate();  //update statement
            
            pstmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(AdvisingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public static void addUser(int studentID, String firstName, String lastName, String email, String major){
        
        try {
            //VALUES(Integer, String, String, String, String)
            pstmt = con.prepareStatement("INSERT INTO students VALUES(?,?,?,?,?)");
            
            pstmt.setInt(1,studentID);
            pstmt.setString(2,firstName);
            pstmt.setString(3,lastName);
            pstmt.setString(4,email);
            pstmt.setString(5, major);
            
            pstmt.executeUpdate();  //update statement
            pstmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(AdvisingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    // Advisor Registration
    public static void addAdvisorUser(int advisorID, String advisorName, int departmentID, String email){
        try {
            //VALUES(Integer, String, String, String, String)
            pstmt = con.prepareStatement("INSERT INTO advisor VALUES(?,?,?,?)");
            
            pstmt.setInt(1,advisorID);
            pstmt.setString(2,advisorName);
            pstmt.setInt(3,departmentID);
            pstmt.setString(4,email);
           
            
            pstmt.executeUpdate();  //update statement
            pstmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(AdvisingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ResultSet getAdvisorInfo(int id)
    {
        ResultSet rs;
        
        try {
            stmt = con.createStatement();
            String query = "SELECT * FROM advisors WHERE advisorID = " + id ;
            rs = stmt.executeQuery(query);
        
            //stmt.close();   //close statement everytime it is done
            if(rs.next())
            {
                return rs;
            }
                        
        } catch (SQLException ex) {
            Logger.getLogger(AdvisingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Advisor ID not found!", "Error", JOptionPane.ERROR_MESSAGE);

        return null;
    }
    //get advisors ID using username
    public static int getAdvisorID(String username)
    {
        ResultSet rs;
        int advisorID = 0;
        
        try {
            stmt = con.createStatement();
            String query = "SELECT advisorID FROM userlogin WHERE username = '" + username + "' " ;
            
            rs = stmt.executeQuery(query);
            if(rs.next())
            {
                advisorID = rs.getInt("advisorID");
                return advisorID;
            }
            //stmt.close();   //close statement everytime it is done

                        
        } catch (SQLException ex) {
            Logger.getLogger(AdvisingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return advisorID;
    }
    //method returns if person is an advisor
    public static boolean getIsAdvisor(String username)
    {
        ResultSet rs;
        boolean isAdvisor = false;
        try {
            stmt = con.createStatement();
            String query = "SELECT isAdvisor FROM userlogin WHERE username = '" + username + "' " ;
            
            rs = stmt.executeQuery(query);
            while(rs.next())
            {
                isAdvisor = rs.getBoolean("isadvisor");
                return isAdvisor;
            }
            //stmt.close();   //close statement everytime it is done

                        
        } catch (SQLException ex) {
            Logger.getLogger(AdvisingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isAdvisor;
    }
    //students classes taken/taking
    public static boolean hasAcademics(int id)
    {
        boolean hasAcad = false;
        ResultSet rs;
        
        try {
            stmt = con.createStatement();
            
            String query = "SELECT * FROM classes WHERE studentID = " + id + " ";
            

            rs = stmt.executeQuery(query);
           
            if(rs.next())
            {
                hasAcad = true;
                return hasAcad;
            }
            
        } catch (SQLException ex) {
            
            Logger.getLogger(AdvisingDB.class.getName()).log(Level.SEVERE, null, ex);
          
        }
        
        return hasAcad;
    }
    public static ResultSet studentAcademics(int id)
    {
        ResultSet rs;
        
        try {
            stmt = con.createStatement();
            
            String query = "SELECT * FROM classes WHERE studentID = " + id + " ";
            

            rs = stmt.executeQuery(query);
           
            if(rs.next())
            {
                return rs;
            }
           
            //stmt.close();   //close statement everytime it is done

            
        } catch (SQLException ex) {
            
            Logger.getLogger(AdvisingDB.class.getName()).log(Level.SEVERE, null, ex);
          
        }
        System.out.println("Failed to gather courses!");
        
        return null;
    }
    public static ResultSet getCourseDivision(int division)
    {
        ResultSet rs;
        
        try {
            stmt = con.createStatement();
            String query = "SELECT * FROM courses WHERE division = " + division ;
            
            rs = stmt.executeQuery(query);
            
            if(rs.next())
            {
                return rs;
            }
            
            //stmt.close();   //close statement everytime it is done

            
        } catch (SQLException ex) {
            Logger.getLogger(AdvisingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Failed to gather courses!");
        return null;
    }
    public static ResultSet getCourses()
    {
        ResultSet rs;
        
        try {
            stmt = con.createStatement();
            String query = "SELECT * FROM courses" ;
            
            rs = stmt.executeQuery(query);
            
            if(rs.next())
            {
                return rs;
            }
            
            //stmt.close();   //close statement everytime it is done

            
        } catch (SQLException ex) {
            Logger.getLogger(AdvisingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Failed to gather courses!");
        return null;
    }
    
    //get students information
    
    public ResultSet studentInfo(int id)
    {
        ResultSet rs;
        
        try {
            stmt = con.createStatement();
            String query = "SELECT * FROM students WHERE studentID = " + id ;
            rs = stmt.executeQuery(query);
        
            //stmt.close();   //close statement everytime it is done
            if(rs.next())
            {
                return rs;
            }
                        
        } catch (SQLException ex) {
            Logger.getLogger(AdvisingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Student ID not found!", "Error", JOptionPane.ERROR_MESSAGE);

        return null;
    }
    public int student(String username)
    {
        ResultSet rs;
        int id = 0;
        
        try {
            stmt = con.createStatement();
            String query = "SELECT * FROM userlogin WHERE username = '" + username + "' " ;
            
            rs = stmt.executeQuery(query);
            if(rs.next())
            {
                id = rs.getInt("studentID");
                return id;
            }
            //stmt.close();   //close statement everytime it is done

                        
        } catch (SQLException ex) {
            Logger.getLogger(AdvisingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    public boolean isAdvisor(String username)
    {
        ResultSet rs;
        boolean isAdvisor = false;
        try {
            stmt = con.createStatement();
            String querey = "SELECT isAdvisor FROM userlogin WHERE username = '" + username+ "' ";
            rs = stmt.executeQuery(querey);
            
            if(username == rs.getString("username"))
            {
                isAdvisor = rs.getBoolean("isadvisor");
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdvisingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return isAdvisor;
    }
    //check if username and password are in database
    public static boolean userLogin(String username, String password)
    {
        boolean verified = false;
                
        ResultSet rs;
        
        try {
            stmt = con.createStatement();
            String query = "SELECT * FROM userlogin WHERE userpass = md5('" + password + "')";
            rs = stmt.executeQuery(query);
        
            if(rs.next())
            {
                //int id = rs.getInt("studentID");
                  
                verified = true;
                stmt.close();
                return verified;
               
            }
            stmt.close();   //close statement everytime it is done
            
        } catch (SQLException ex) {
            Logger.getLogger(AdvisingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return verified;
    }
    
    //method for displaying all users in database
    public static void updateStudentClasses(int studentId, int courseID, String grade, String sem, String comments)
    {
        //if()    //if already present update info
            //else create new entry
        
        try {
            stmt = con.createStatement();
            
            if(alreadyOnClasses(studentId, courseID))
            {
                System.out.println("AlreadyOn");
                String query = "UPDATE classes SET grade = '" + grade + "', semester = '" + sem + "', comments = '" + comments + "' WHERE studentID = " + studentId + " AND courseID = " + courseID;
                System.out.println(query);
                stmt.executeUpdate(query);
                stmt.close();
                System.out.println("1");
                
            }
            else
            {
                System.out.println("newEntry");
                
                String query = "INSERT INTO classes VALUES(" + studentId + "," + courseID + ",'" + sem + "','" + grade + "','" + comments + "')";
                System.out.println(query);
                stmt.executeUpdate(query);
                stmt.close();
                System.out.println("2");
                
            }
            
            //stmt.close();   //close statement everytime it is done

            
        } catch (SQLException ex) {
            Logger.getLogger(AdvisingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static boolean alreadyOnClasses(int studentID, int courseID)
    {
        boolean alreadyOn = false;
        
        ResultSet rs;
        
        try {
            stmt = con.createStatement();
            
            //String query = "SELECT * FROM courses";
            String query = "SELECT * FROM classes WHERE studentID = " + studentID;
            rs = stmt.executeQuery(query);
            
            while(rs.next())
            {
                if(rs.getInt("courseID") == courseID)   //if already on classes return true else false
                {
                    alreadyOn = true;
                    return alreadyOn;
                }
            }
            //stmt.close();   //close statement everytime it is done

            
        } catch (SQLException ex) {
            Logger.getLogger(AdvisingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alreadyOn;
    }
    
    public static void displayInfo()
    {
        
        ArrayList<String> list = new ArrayList<String>();
        
        ResultSet rs;
        
        try {
            stmt = con.createStatement();
            String query = "SELECT * FROM students";
            rs = stmt.executeQuery(query);
        
            while(rs.next())
            {
                int id = rs.getInt("studentID");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String fullName = firstName + " " + lastName;
                
                list.add(fullName);
                
                System.out.println("Name: " + fullName + " ID: " + id);
                
            }
            stmt.close();   //close statement everytime it is done
            
        } catch (SQLException ex) {
            Logger.getLogger(AdvisingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
