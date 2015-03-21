import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class Credit extends JFrame{
	private JLabel title, credit, date,accnumber;
	private	JButton submit;
	private DateComboBox abc;
private JTextField  tdate, tcredit,taccnumber;
	
	public Credit(){
		super("Credit::");
		Container con =getContentPane();
		con.setLayout( null);
		accnumber=new JLabel("Account Number:");
		taccnumber=new JTextField(10);
		title=new JLabel("::Credit Account::");
		credit=new JLabel("Credit:");
		date=new JLabel("Date:");
		tdate=new JTextField(10);
		tcredit=new JTextField(10);
		submit = new JButton("Submit");
		abc=new DateComboBox();
		
		
		con.add(title);
		con.add(date);
		con.add(tdate);
		con.add(accnumber);
		con.add(taccnumber);
                con.add(credit);
		con.add(tcredit);
		con.add(submit);
		con.add(abc);
		
		arrangeComponents();
		
		setSize(600,400);
		setVisible(true);
      
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
	
	//db connection
	submit.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent ae){
String val1=abc.getSelectedItem().toString();
String val2=taccnumber.getText();
String val3=tcredit.getText();
		
		
		
if(val2.equals("")){
JOptionPane.showMessageDialog(null,"Plese Enter Account Number");	
}		

else if(val3.equals("")){
JOptionPane.showMessageDialog(null,"Plese Enter Ammount");	
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
int i= st.executeUpdate("INSERT INTO  transaction (date,accountnum,credit) VALUES ('"+val1+"','"+val2+"','"+val3+"')");
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
        date.setBounds(150, 20+25+20, 100, 25);
	abc.setBounds(150+100+10, 20+25+20, 125, 25);
	accnumber.setBounds(150, 20+25+20+25+20, 100, 25);
        taccnumber.setBounds(150+100+10, 20+25+20+25+20, 150, 25);
        credit.setBounds(150,25+20+25+20+20+25+20,100,25);
        tcredit.setBounds(150+100+10,20+25+20+25+20+25+20,150,25);
        submit.setBounds(150+100+10, 20+25+20+25+20+25+20+25+20,100, 25);
			  
		  }
	
	public static void main(String args[]){
		
		Credit c1 =new Credit();
		
		}
	
	
	
	
	
	}