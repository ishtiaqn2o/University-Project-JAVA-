import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


class combotst extends JFrame{
	private JComboBox com;
	//private	JButton submit;
public combotst(){
	super ("form");
	Container con = getContentPane();
        con.setLayout(null);
	 com = new JComboBox();
	//submit = new JButton("Submit");
	
	con.add(com);
      //  con.add(submit);
	
  setSize(500,500);
        setVisible(true);
	   com.setBounds(100,20,100,25);
	//submit.setBounds(100,50,100,25);
	
            
	     String dbName ="jdbc:mysql://localhost:3306/meal";
        String dbUserName = "root";
        String dbPassword = ""; 	
	  String result;
		    try {
			    Connection conn = null;
Class.forName("com.mysql.jdbc.Driver");
conn = DriverManager.getConnection(dbName ,dbUserName , dbPassword );
Statement st = conn.createStatement();
//  ResultSet rs = st.executeQuery("Select *from information'");
                       
                   
                        
    ResultSet rs =st.executeQuery("select * from information"); 
    while(rs.next()) {
	result = rs.getString(1);
        if (result != null) {
            result = result.trim();
        }
        com.addItem(result);
    } 
    rs.close();

}  catch (Exception ex) {
                        } 
		}
	
		
public static void main(String args[]){
	combotst c = new combotst();
	
	
	}


}