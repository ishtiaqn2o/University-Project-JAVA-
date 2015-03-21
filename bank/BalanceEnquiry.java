import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class BalanceEnquiry extends JFrame  implements ActionListener{
	private JLabel title,selAcc,accHolderName,availableBal,transactiondetails;
	
	private JLabel retname,retbalance;
	private JTextField tselAcc;
	private JButton checkBal,cancel;
	
public BalanceEnquiry(){
	
	super("Balance Enquiry");
	Container con =getContentPane();
	con.setLayout(null);
	//balance = new JLabel("");
	title =new JLabel("::Balance Enquiry::");
	selAcc =new JLabel("Select Account:");
	accHolderName=new JLabel("Account Holder Name:");
	availableBal=new JLabel("Available Balance:");
	transactiondetails= new JLabel("Transection Details:");
	retname=new JLabel("");
	retbalance=new JLabel("");
	tselAcc = new JTextField(10);
	checkBal =new JButton("Check");
	cancel = new JButton("Cancel");
	
	con.add(title);
	con.add(selAcc);
	con.add(tselAcc);
	con.add(accHolderName);
	con.add(retname);
	con.add(availableBal);
	con.add(retbalance);
	//con.add (balance);
	con.add(checkBal);
	con.add(cancel);
        con.add(transactiondetails);
	  
	arrangeComponents();
		
		setSize(600,600);
		setVisible(true);
      
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	 checkBal.addActionListener(this);

	}
	  		
            
           public void actionPerformed(ActionEvent event){
                String command = event.getActionCommand();
                
                    if(command.equals("Check")){
        String dbName ="jdbc:mysql://localhost:3306/ishti";
        String dbUserName = "root";
        String dbPassword = ""; 
        
       // String q="select * from transaction where accountnum = '"+tselAcc.getText()+"' ";
        String q="select * from transaction where accountnum = '"+tselAcc.getText()+"' ";
	String q1="select * from information where accountnum = '"+tselAcc.getText()+"' ";
        try{
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(dbName,dbUserName,dbPassword);
                 
        Statement stm=con.createStatement(/*ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE*/);
         
        ResultSet rs=stm.executeQuery(q); 
	
	String sumcredit;
	String sumdebit;
	int sum=0;
	int sumdebit1=0;
		
		
       while(rs.next())
			{
			
			sumcredit=rs.getString("credit");
			sum=sum+Integer.parseInt(sumcredit);
			sumdebit=rs.getString("debit");
			sumdebit1=sumdebit1+Integer.parseInt(sumdebit);
			//retname.setText(rs1.getString("name"));
				 int total=sum-sumdebit1;
	String sum2 = Integer.toString(total);
	retbalance.setText(sum2);
                
			}
			rs.close();
			stm.close();
			con.close(); 
         
         
         
         
     }catch(Exception e){
            System.out.println(e);     
    }
       try{
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(dbName,dbUserName,dbPassword);
                 
        Statement stm=con.createStatement(/*ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE*/);
         
     
	ResultSet rs1=stm.executeQuery(q1);
	       String nam;
	
       while(rs1.next())
			{
		
			 nam=rs1.getString("name");
				retname.setText(nam);	
                
			}
		
        rs1.close();
			//stm.close();
			//con.close(); 
         
         
     }catch(Exception e){
            System.out.println(e);     
    }
    
    
    
    
    
    
    }
        else{
		  JOptionPane.showMessageDialog(null," Not Found");
		
		}
   
	}
	private void arrangeComponents(){
        title.setBounds(40, 20, 500, 25);
        selAcc.setBounds(150, 20+25+20, 300, 25);
        tselAcc.setBounds(300, 20+25+20, 200, 25);
	accHolderName.setBounds(150, 20+25+20+25+20,300,25);
	retname.setBounds(300,20+25+20+25+20,250,25);
	availableBal.setBounds(150, 110+45,300,25);
	retbalance.setBounds(300,110+45,300,25);
	checkBal.setBounds(150+100+10,110+45+45,120,25);
	cancel.setBounds(150+100+160,110+45+45,100,25);
	transactiondetails.setBounds(40, 230, 300, 25);
   
	}
		
public static void main(String args[]){
		
		BalanceEnquiry b1 =new BalanceEnquiry();
		
		}
	
	
	
	
	}