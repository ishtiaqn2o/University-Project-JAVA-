import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Withdraw extends JFrame{
	private JLabel credit,title,retaccnum, date;
	private	JButton submit,back;
	private DateComboBox tdate;
private JTextField  tcredit;
	
	public Withdraw(beans acc){
		super("Deposit::");
		Container con =getContentPane();
		con.setLayout(null);
		date= new JLabel("Date:");
		tdate = new DateComboBox();
		credit=new JLabel("Amount :");
		retaccnum =new JLabel("........");
		retaccnum.setVisible(false);
		title = new JLabel("Withdraw Ammount");
		tcredit=new JTextField(10);
		submit = new JButton("Submit");
		back = new JButton("<<Back");
		con.add(title);
		con.add(retaccnum);
		con.add(tdate);
		con.add(date);
		con.add(credit);
		con.add(tcredit);
		con.add(submit);
		con.add(back);
		
		setSize(500,500);
		setVisible(true);
		
		retaccnum.setText(acc.getAccount());
      arrangeComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		submit.addActionListener(new withdrawAction());
		//back.addActionListener(new BackAction());
		}
		
		  private void arrangeComponents(){
        title.setBounds(40, 20, 500, 25);
        date.setBounds(150, 20+25+20, 100, 25);
	tdate.setBounds(150+100+10, 20+25+20, 125, 25);
	credit.setBounds(150, 20+25+20+25+20, 100, 25);
        tcredit.setBounds(150+100+10, 20+25+20+25+20, 150, 25);
       submit.setBounds(150,25+20+25+20+20+25+20,100,25);
        back.setBounds(150+100+10+10,20+25+20+25+20+25+20,100,25);
        
			  
		  }
		
	public class withdrawAction implements ActionListener{
			
			public void actionPerformed(ActionEvent event){
				
				String val1=tcredit.getText();
				String val2 =tdate.getSelectedItem().toString();
				String val3=retaccnum.getText();
String dbName ="jdbc:mysql://localhost:3306/ishti";
        String dbUserName = "root";
        String dbPassword = ""; 	
try{
Connection con = null;
Class.forName("com.mysql.jdbc.Driver");
con = DriverManager.getConnection(dbName ,dbUserName , dbPassword );
Statement st = con.createStatement();
int i= st.executeUpdate("INSERT INTO  transaction (date,debit,accountnum) VALUES ('"+val2+"','"+val1+"','"+val3+"')");
JOptionPane.showMessageDialog(null,"Data is successfully inserted into the database." );
st.close();
con.close();
}
catch(Exception e){
System.out.println(e);
}
				
			}
			
		
		
			}
			
			
			
			
		
		
			
		
		
		
	
	/*public static void main(String args[]){
		
		Withdraw w1 =new Withdraw();
		 
		
		}

	*/
	
	
	
	
	
	
	
}