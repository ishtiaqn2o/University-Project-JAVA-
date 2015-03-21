	
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class ShowBalance extends JFrame  {
	private JLabel title,accHolderName,availableBal,transactiondetails;
	
	private JLabel retname,retbalance;
	
	//private JButton checkBal,cancel;
	
public ShowBalance(beans name){
	
	super("Balance Enquiry");
	Container con =getContentPane();
	con.setLayout(null);
	//balance = new JLabel("");
	title =new JLabel("::Balance Enquiry::");
	//selAcc =new JLabel("Select Account:");
	accHolderName=new JLabel("Account Holder Name:");
	availableBal=new JLabel("Available Balance:");
	transactiondetails= new JLabel("Transection Details:");
	retname=new JLabel("......");
	retbalance=new JLabel("..........");
	//tselAcc = new JTextField(10);
	//checkBal =new JButton("Check");
	//cancel = new JButton("Cancel");
	
	retname.setText(name.getName());
    retbalance.setText(name.getBalance());
	
	
	
	con.add(title);
	//con.add(selAcc);
	//con.add(tselAcc);
	con.add(accHolderName);
	con.add(retname);
	con.add(availableBal);
	con.add(retbalance);
	//con.add (balance);
	//con.add(checkBal);
	//con.add(cancel);
       // con.add(transactiondetails);
	  
	arrangeComponents();
		
		setSize(600,600);
		setVisible(true);
      
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	

	}
	  		

	private void arrangeComponents(){
        title.setBounds(40, 20, 500, 25);
      //  selAcc.setBounds(150, 20+25+20, 300, 25);
      //  tselAcc.setBounds(300, 20+25+20, 200, 25);
	accHolderName.setBounds(150, 20+25+20+25+20,300,25);
	retname.setBounds(300,20+25+20+25+20,250,25);
	availableBal.setBounds(150, 110+45,300,25);
	retbalance.setBounds(300,110+45,300,25);
	//checkBal.setBounds(150+100+10,110+45+45,120,25);
	//cancel.setBounds(150+100+160,110+45+45,100,25);
	//transactiondetails.setBounds(40, 230, 300, 25);
	}
   
/*		
public static void main(String args[]){
		
		ShowBalance b1 =new ShowBalance();
		
	} 
	
	*/
	
	
	}

