	
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class TransferBalance extends JFrame  {
	private JLabel title,accHolderName,availableBal,retaccnum,toaccnum,date,ammount;
	private DateComboBox tdate;
	private JLabel retname,retbalance;
	private JTextField texttoaccnum,tammount;
	private JButton transfer,reset,back;
	
public TransferBalance(beans name){
	
	super("TransferBalance");
	Container con =getContentPane();
	con.setLayout(null);
	//balance = new JLabel("");
	ammount =new JLabel("ammount");
	date =new JLabel("date");
	tdate = new DateComboBox();
	title =new JLabel("::Balance Transfer::");
	toaccnum =new JLabel("Send to:");
	texttoaccnum= new JTextField(10);
	tammount =new JTextField(10);
	accHolderName=new JLabel("Account Holder Name:");
	availableBal=new JLabel("Available Balance:");
	retaccnum= new JLabel(".......................");
	retaccnum.setVisible(false);
	retname=new JLabel("......");
	retbalance=new JLabel("............................");
	
	transfer=new JButton("Transfer");
	reset = new JButton("Reset");
	back =new JButton("<<Back");
	
	retname.setText(name.getName());
    retbalance.setText(name.getBalance());
	 retaccnum.setText(name.getAccount());
	
	con.add(transfer);
	con.add(reset);
	con.add(back);
	
	con.add(ammount);
	con.add(tammount);
	con.add(date);
	con.add(tdate);
	con.add(title);
	con.add(toaccnum);
	con.add(texttoaccnum);
	//con.add(tselAcc);
	con.add(accHolderName);
	con.add(retname);
	con.add(availableBal);
	con.add(retbalance);
	//con.add (balance);
	//con.add(checkBal);
	//con.add(cancel);
       con.add(retaccnum);
	  
	arrangeComponents();
		
		setSize(600,600);
		setVisible(true);
      
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	
	
	
	transfer.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent ae){
  String val1 = tdate.getSelectedItem().toString();
		 String val2=tammount.getText();
		   String val3 = retaccnum.getText();
		   String val4= texttoaccnum.getText();
		  String val5= title.getText();
		String val6 = texttoaccnum.getText();
String dbName ="jdbc:mysql://localhost:3306/ishti";
        String dbUserName = "root";
        String dbPassword = ""; 	
try{
Connection con= null;
Class.forName("com.mysql.jdbc.Driver");
 con = DriverManager.getConnection(dbName ,dbUserName , dbPassword );
Statement st = con.createStatement();
int i= st.executeUpdate("INSERT INTO  transaction (date,accountnum,debit,transferaccnum,type) VALUES ('"+val1+"','"+val3+"','"+val2+"','"+val6+"','"+val5+"')");
JOptionPane.showMessageDialog(null,"Data is successfully inserted into the database.");
st.close();
con.close();
}
catch(Exception e){
System.out.println(e);
}



try{
Connection con= null;
Class.forName("com.mysql.jdbc.Driver");
 con = DriverManager.getConnection(dbName ,dbUserName , dbPassword );
Statement st = con.createStatement();
int i= st.executeUpdate("INSERT INTO  transaction (date,accountnum,credit,transferaccnum,type) VALUES ('"+val1+"','"+val4+"','"+val2+"','"+val3+"','"+val5+"')");
JOptionPane.showMessageDialog(null,"Data is successfully inserted into the database.");
st.close();
con.close();
}
catch(Exception e){
System.out.println(e);
}
}
});
	

	}

	// starrt

		   
		   
	
                

     
	

	private void arrangeComponents(){
        title.setBounds(40, 20, 500, 25);
 
      //  tselAcc.setBounds(300, 20+25+20, 200, 25);
		
	accHolderName.setBounds(150, 20+25+20+25+20,300,25);
	retname.setBounds(300,20+25+20+25+20,250,25);
	availableBal.setBounds(150, 110+45,300,25);
	retbalance.setBounds(300,110+45,300,25);
	retaccnum.setBounds(300,130+45,300,25);	
        date.setBounds(150,110+45+45,120,25);
        tdate.setBounds(300,110+45+45,150,25);
        toaccnum.setBounds(150,110+45+45+45,120,25);
        texttoaccnum.setBounds(300,110+45+45+45,150,25);
	ammount.setBounds(150,110+45+45+45+45,120,25);
        tammount.setBounds(300,110+45+45+45+45,150,25);
		  transfer.setBounds(100,110+45+45+45+45+45,120,25);
	reset.setBounds(250,110+45+45+45+45+45,120,25);
        back.setBounds(400,110+45+45+45+45+45,120,25);
	//checkBal.setBounds(150+100+10,110+45+45,120,25);
	//cancel.setBounds(150+100+160,110+45+45,100,25);
	//transactiondetails.setBounds(40, 230, 300, 25);
	}
   
/*		
public static void main(String args[]){
		
		TransferBalance b1 =new TransferBalance();
		
	} 
	

	*/
	
	}

