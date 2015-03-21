import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class Delete extends JFrame{
	private JLabel title,delacc;
	private JTextField tdelacc;
	private JButton del,back;
	
	public Delete(){
		super();
		Container con=getContentPane();
		con.setLayout(null);
		title =new JLabel("::Delete Account::");
		delacc= new JLabel("Account Number:");
		tdelacc=new JTextField(10);
		del = new JButton("Delete");
		back=new JButton("<<Back");
		
		con.add(title);
		con.add(delacc);
		con.add(tdelacc);
		con.add(del);
		con.add(back);
		
		arrangeComponents();
		
		
		setSize(500,300);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//db connection
	del.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent ae){

String val1=tdelacc.getText();
		
if(val1.equals("")){
JOptionPane.showMessageDialog(null,"Plese Enter Account Number");	
}
else{
String dbName ="jdbc:mysql://localhost:3306/ishti";
        String dbUserName = "root";
        String dbPassword = ""; 	
try{
Connection con= null;
Class.forName("com.mysql.jdbc.Driver");
 con = DriverManager.getConnection(dbName ,dbUserName , dbPassword );
Statement st = con.createStatement();
int i= st.executeUpdate( " DELETE FROM ishti.information WHERE  information.accountnum = '"+val1+"'   ");
JOptionPane.showMessageDialog(null,"Data is successfully inserted into the database.");
st.close();
con.close();
}
catch(Exception e){
System.out.println(e);
}
}
}
});
  ///
		
		
		
		}
		
	 private void arrangeComponents(){
        title.setBounds(40, 20, 500, 25);
        delacc.setBounds(150, 20+25+20, 100, 25);
        tdelacc.setBounds(150+100+10, 20+25+20, 150, 25);
        del.setBounds(150, 20+25+20+25+20, 100, 25);
        back.setBounds(150+100+10, 20+25+20+25+20, 150, 25);
   
       
    }
	
	
	public static void main(String args[]){
		
           Delete dl=new Delete();
		
		
		
		}
	
	
	
	
	
	}