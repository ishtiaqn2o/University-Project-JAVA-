import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class User extends JFrame{
	private JMenuBar menubar;
	private JMenu accountsummary,userprofile,cashwithdraw,transaction,balanceEnquiry,logout;
private	 JMenuItem itaccountsummary,ituserprofile,itcashwithdraw,ittransaction, itbalanceEnquiry,itdeleteAccount,ilogout,itSend,itReceive;
		private JLabel name,dbname,accnum,dbaccnum;
	
		//String user;
	
	
	
	
	
	public User(UserInfo user){
		super ("User");
		Container con =getContentPane();
		con.setLayout( new FlowLayout()); 
		
		
		
		name = new JLabel("Welcome     ");
		dbname = new JLabel("........");
		
		
		accnum =new JLabel("  Account number       ");
		accnum.setVisible(false);
		dbaccnum =new JLabel(".........");
		dbaccnum.setVisible(false);
		
		
	 JMenuBar menubar = new JMenuBar(); 	
	accountsummary= new JMenu("AccountSummary");
		itaccountsummary = new JMenuItem("Show Account Summary");
		
		userprofile=new JMenu("Profile");
		ituserprofile = new JMenuItem("Personal Information");		

		 //tnewaccount = new JMenuItem("Open");
		cashwithdraw =new JMenu("Cash Wirhdraw");
		itcashwithdraw = new JMenuItem("Withdraw Ammount");
	
		transaction	=new JMenu("transfer");
		ittransaction =new JMenuItem("Balance Transfer");
		itSend =new JMenuItem("Sending Report");
		itReceive=new JMenuItem("received report");
		
		balanceEnquiry	=new JMenu("BalanceEnquiry");
		itbalanceEnquiry= new JMenuItem("Show Balance");
		logout= new JMenu("Logout");
		ilogout=new JMenuItem("Logout");
		
		
		con.add(menubar);
		
		 menubar.add(userprofile);
                userprofile.add( ituserprofile);
		 menubar.add(accountsummary);
		accountsummary.add( itaccountsummary);
		 menubar.add(cashwithdraw);
		cashwithdraw.add( itcashwithdraw);
		 
		 menubar.add(transaction);
		 transaction.add( ittransaction);
		transaction.add( itSend);
		 transaction.add( itReceive);
		menubar.add(balanceEnquiry);
		 balanceEnquiry.add( itbalanceEnquiry);
		menubar.add(logout);
		logout.add(ilogout);
		
		
		menubar.setVisible(true);
		  



            dbname.setText(user.getName());
	    

	     dbaccnum.setText(user.getAccount());
		
		con.add(name);
		con.add(dbname);
		con.add(accnum);
		con.add(dbaccnum);
		 
		
	name.setBounds(150, 20+25+20+100, 100, 25);
        dbname.setBounds(150+100+10, 20+25+20+100, 150, 25);
	accnum.setBounds(150, 20+25+20+25, 100, 25);
        dbaccnum.setBounds(150+100+10, 20+25+20+25+100, 150, 25);
		
		AccountSummaryAction op=new AccountSummaryAction();
		itaccountsummary.addActionListener(op);
		ituserprofile.addActionListener(new Userprofile());
		itcashwithdraw.addActionListener(new CashWithdrawAction());
	ittransaction.addActionListener(new TransferAction());
	
	itSend.addActionListener(new SendAction());
	itReceive.addActionListener(new ReceiveAction());
		itbalanceEnquiry.addActionListener(new BalanceEnquiryAction());
		ilogout.addActionListener(new LogoutAction());
// m_quitItem.addActionListener(new QuitAction());
       //this.pack();
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
		   class AccountSummaryAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
	beans b3 = new beans();
		String val =dbaccnum.getText();
		b3.setAccount(val);
		ShowTransaction sh = new ShowTransaction(b3);
		sh.setVisible(true);
		
        }	
}
		   class Userprofile implements ActionListener {
        public void actionPerformed(ActionEvent e) {
	  String dbName ="jdbc:mysql://localhost:3306/ishti";
        String dbUserName = "root";
        String dbPassword = ""; 
        
       // String q="select * from transaction where accountnum = '"+tselAcc.getText()+"' ";
        String q="select * from information where accountnum = '"+dbaccnum.getText()+"' ";
		
		
//String q1="select * from information where accountnum = '"+tselAcc.getText()+"' ";
        try{
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(dbName,dbUserName,dbPassword);
                 
        Statement stm=con.createStatement(/*ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE*/);
         
        ResultSet rs=stm.executeQuery(q); 
	while(rs.next()){
			Bean3 b1 =new Bean3();
		b1.setName(rs.getString("name"));
		b1.setAddress(rs.getString("address"));
		
		b1.setEmail(rs.getString("email"));
		b1.setContact(rs.getString("contact"));
		
		b1.setAge(rs.getString("age"));
		b1.setGender(rs.getString("gender"));
		
		
		
		UserProfile u2=new UserProfile(b1);
		u2.setVisible(true);
		
	}
		
		
		
		
	
		/*while(rs.next())
			{
			
				val1=rs.getString("name");
				//val2=rs.getString("address");
				//val3=rs.getString("email");
				//val4=rs.getString("gender");
				//val5=rs.getString("age");
				//val6=rs.getString("contact");
			
                
			}*/
			rs.close();
			stm.close();
			con.close(); 
         
         
         
         
     }catch(Exception ev){
            System.out.println(ev);     
    }

		
		
		
		
		
		
	
		
        }	
		}
				   class CashWithdrawAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
		
		
		String acc=dbaccnum.getText();
		beans b2= new beans();
		b2.setAccount(acc);
		
	
		Withdraw db=new Withdraw(b2);
		//b2.setVisible(true);
//this.setVisible(false);
		
        }	
		}
		
		
		
		
		
				   class TransferAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
		
		String val1=	dbaccnum.getText();
		String val2=	dbname.getText();
		beans b4= new beans();
		b4.setName(val2);
		b4.setAccount(val1);
		String val3 = Balance();
		b4.setBalance(val3);
		
		TransferBalance s1 =new TransferBalance(b4);
		s1.setVisible(true);
		
	  //  UserBalanceEnquiry db=new UserBalanceEnquiry();
		//db.setVisible(true);
//this.setVisible(false);
		
        }	
		}
		
		 class SendAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
		beans b4= new beans();
		String val =dbaccnum.getText();
		b4.setAccount(val);
		SendReport sd = new SendReport(b4);
		sd.setVisible(true);
		 
        }	
		}
		
		
		 class ReceiveAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
		
	beans b5= new beans();
		String val =dbaccnum.getText();
		b5.setAccount(val);
		ReceiveReport sd = new ReceiveReport(b5);
		sd.setVisible(true);
		
        }	
		}
		
		
		
		
		
		
		
		
		
		
		 class LogoutAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
		Welcome wc = new Welcome();
		wc.setVisible(true);
	
		
        }	
		}
		
		
		
		
		
		
		
		
		
		
		
		
			   class BalanceEnquiryAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
		
		
		String val=	dbname.getText();
		beans b1= new beans();
		b1.setName(val);
		String val1 = Balance();
		b1.setBalance(val1);
		ShowBalance s1 =new ShowBalance(b1);
		
		s1.setVisible(true);
		
	  //  UserBalanceEnquiry db=new UserBalanceEnquiry();
		//db.setVisible(true);
//this.setVisible(false);
		
        }	
		}
		

		
		
		
		public String Balance(){
			
 String dbName ="jdbc:mysql://localhost:3306/ishti";
        String dbUserName = "root";
        String dbPassword = ""; 
        
       // String q="select * from transaction where accountnum = '"+tselAcc.getText()+"' ";
        String q="select * from transaction where accountnum = '"+dbaccnum.getText()+"' ";
			String sum2=null;
//String q1="select * from information where accountnum = '"+tselAcc.getText()+"' ";
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
	 sum2 = Integer.toString(total);
	//retbalance.setText(sum2);
                
			}
			rs.close();
			stm.close();
			con.close(); 
         
         
         
         
     }catch(Exception e){
            System.out.println(e);     
    }

			
		return sum2;
			
			
			
			
			
			
			}
		
		
		}
