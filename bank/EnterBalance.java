import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class EnterBalance extends JFrame{
	
	private JLabel title,name,dbname,accnum,dbaccnum,dateformat,date,credit,balance;
	private JTextField tcredit,tbalance;
		private	JButton submit;
private DateComboBox tdate;
	
	public EnterBalance(UserInfo user){
		
		super("enter balance ");
           Container con =getContentPane();
		con.setLayout(null);
		
		title =new JLabel("hfghddfh");
		name = new JLabel("Welcome");
		dbname = new JLabel("........");
		accnum =new JLabel("Account number");
		dbaccnum =new JLabel(".........");
		dateformat =new JLabel("MM/DD/YY");
		date =new JLabel("date");
		credit = new JLabel("credit");
		//balance =new JLabel("balance");
		
		tdate = new DateComboBox();
		tcredit =new JTextField(10);
		//tbalance =new JTextField(10);
		
		submit = new JButton("submit");
		
		
			   dbname.setText(user.getName());
	     dbaccnum.setText(user.getAccount());
		

		
		con.add(title);
		con.add(name);
		con.add(dbname);
		con.add(accnum);
		con.add(dbaccnum);
		con.add(dateformat);
		con.add(date);
		con.add(tdate);
		con.add(credit);
		con.add(tcredit);
		//con.add(balance);
		//con.add(tbalance);
		con.add(submit);
				
		setSize(600,500);
		setVisible(true);
      
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
	arrangeComponents();
	}
			
		  private void arrangeComponents(){
        title.setBounds(40, 20, 500, 25);
        name.setBounds(150, 20+25+20, 100, 25);
        dbname.setBounds(150+100+10, 20+25+20, 150, 25);
	accnum.setBounds(150, 20+25+20+25, 100, 25);
        dbaccnum.setBounds(150+100+10, 20+25+20+25, 150, 25);
        date.setBounds(150,25+20+25+20+20+25+20,100,25);
        tdate.setBounds(150+100+10,20+25+20+25+20+25+20,150,25);
	  dateformat.setBounds(150+100+10,20+25+20+25+20+25,150,25);	
	credit.setBounds(150,25+20+25+20+20+25+20+25+20,100,25);
			   tcredit.setBounds(150+100+10,25+20+25+20+20+25+20+25+20,150,25);

//balance.setBounds(150,25+20+25+20+20+25+20+25+20+25+20,100,25);
			   //tbalance.setBounds(150+100+10,25+20+25+20+20+25+20+25+20+25+20,150,25);

			  
        submit.setBounds(150+100+10, 25+20+25+20+20+25+20+25+20+25+20+25+20,100, 25);
			  
			  
			  
			  
			  
			  
			  	//db connection
	submit.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent ae){
String val1=tdate.getSelectedItem().toString();
String val2=dbaccnum.getText();
		String val3=tcredit.getText();
//String val4=tbalance.getText();
if(val3.equals("")){
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
			  
			  
		  }
		
	  }
		
		/*public static void main(String args[]){
		
EnterBalance c1 =new EnterBalance();
		
		}
		
	
	
	
	
	
	}*/
	
	
	
	
	
	
	
	
	
	
