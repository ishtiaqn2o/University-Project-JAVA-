import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class Credit extends JFrame{
private JLabel credit;
private	JButton submit;
private JTextField  tcredit;
	
	public Credit(){
		super("Credit::");
		Container con =getContentPane();
		con.setLayout( new FlowLayout());
		credit=new JLabel("Credit");
		tcredit=new JTextField(10);
		submit = new JButton("Submit");
		
		con.add(credit);
		con.add(tcredit);
		con.add(submit);
		
		
		setSize(500,500);
		setVisible(true);
      
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		submit.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
String value1=tcredit.getText();
String dbName ="jdbc:mysql://localhost:3306/taslim";
        String dbUserName = "root";
        String dbPassword = ""; 	
try{
Connection con = null;
Class.forName("com.mysql.jdbc.Driver");
con = DriverManager.getConnection(dbName ,dbUserName , dbPassword );
Statement st = con.createStatement();
int i= st.executeUpdate("Insert into Cre(Credit) values('"+value1+"')");
JOptionPane.showMessageDialog(null,"Data is successfully inserted into the database." );
st.close();
con.close();
}
catch(Exception e){
System.out.println(e);
}
}
});
}
		
		
	
	public static void main(String args[]){
		
		Credit c1 =new Credit();
		
		}
	
	
	
	
	
	
	}