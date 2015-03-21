import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Debit extends JFrame{
	private JLabel title, debit, date,accnumber;
	private	JButton submit;
private JTextField  tdebit, tdate,taccnumber;
	private DateComboBox dcb;
	public Debit(){
		super("Debit::");
		Container con =getContentPane();
		con.setLayout(null);
		 dcb= new DateComboBox();
		
		title=new JLabel("::Debit Account::");
		debit=new JLabel("Debit:");
		date=new JLabel("Date:");
		tdate=new JTextField(10);
		tdebit=new JTextField(10);
		submit = new JButton("Submit");
		accnumber =new JLabel("Account Number");
		taccnumber= new JTextField(10);
		
		con.add(title);
		con.add(date);
		con.add(tdate);
		con.add(accnumber);
		con.add(taccnumber);
		con.add(debit);
		con.add(tdebit);
		con.add(submit);
		con.add(dcb);
	
		arrangeComponents();
		
		setSize(600,400);
		setVisible(true);
      
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);submit.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent ae){
String val1=dcb.getSelectedItem().toString();
String val2=taccnumber.getText();
String val3=tdebit.getText();

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
int i= st.executeUpdate("INSERT INTO  transaction (date,accountnum,debit) VALUES ('"+val1+"','"+val2+"','"+val3+"')");
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
  

		
		
		}
		
		  private void arrangeComponents(){
              title.setBounds(40, 20, 500, 25);
        date.setBounds(150, 20+25+20, 100, 25);
        dcb.setBounds(150+100+10, 20+25+20, 150, 25);
	accnumber.setBounds(150, 20+25+20+25+20, 100, 25);
        taccnumber.setBounds(150+100+10, 20+25+20+25+20, 150, 25);
        debit.setBounds(150,25+20+25+20+20+25+20,100,25);
        tdebit.setBounds(150+100+10,20+25+20+25+20+25+20,150,25);
        submit.setBounds(150+100+10, 20+25+20+25+20+25+20+25+20,100, 25);
       
    }
		
		
	
public static void main(String args[]){
		
		Debit c1 =new Debit();
		
		}
	
	
	
	
	
	
	}