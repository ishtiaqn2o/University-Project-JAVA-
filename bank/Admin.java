import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Admin extends JFrame{
	private JMenuBar menubar;
	private JMenu newaccount,debit,credit,transection,balanceEnquiry,deleteAccount,logout;
private	 JMenuItem itnewaccount,itshowinfo,itdebit,itcredit,ittransection, itbalanceEnquiry,itdeleteAccount,ilogout,itupdate;
//private JButton logout;
	public Admin(){
		super ("hdkshfkshf");
		Container con =getContentPane();
		con.setLayout( new FlowLayout()); 
	 JMenuBar menubar = new JMenuBar(); 	
	newaccount= new JMenu("NewAccount");
		 itnewaccount = new JMenuItem("Open a new account");
		itshowinfo = new JMenuItem("Show UserInfo");
		itupdate = new JMenuItem("Update Account");
		debit	=new JMenu("  Debit  ");
		itdebit = new JMenuItem("Debit Ammount");		

		 //tnewaccount = new JMenuItem("Open");
		credit =new JMenu(" Credit  ");
		itcredit = new JMenuItem("Credit Ammount");
	
		transection	=new JMenu("AllTransaction");
		ittransection =new JMenuItem("Show Transection");
		
		balanceEnquiry	=new JMenu("BalanceEnquiry");
		itbalanceEnquiry= new JMenuItem("Show Balance");
		
		deleteAccount = new JMenu("DeleteAccount");
		itdeleteAccount  = new JMenuItem("Delete Account");	
//		logout =new JButton("Logout");
		logout= new JMenu("Logout");
		ilogout=new JMenuItem("Logout");
//con.add(logout);
		con.add(menubar);
		menubar.add(newaccount);
		newaccount.add( itnewaccount);
		newaccount.add(itupdate);
		newaccount.add(itshowinfo);
		 menubar.add(debit);
		 debit.add( itdebit);
		 menubar.add(credit);
		credit.add( itcredit);
		 menubar.add(transection);
		 
		 logout.setBounds(250,50,30,20);
		 
		 transection.add( ittransection);
		 menubar.add(balanceEnquiry);
		 balanceEnquiry.add( itbalanceEnquiry);
		 menubar.add(deleteAccount);
		deleteAccount.add( itdeleteAccount);
		menubar.add(logout);
		logout.add(ilogout);
		
		menubar.setVisible(true);
		
		InfoAction op=new InfoAction();
		itnewaccount.addActionListener(op);
		itshowinfo.addActionListener(new ShowInfoAction());
		itdebit.addActionListener(new DebitAction());
		itcredit.addActionListener(new CreditAction());
		ittransection.addActionListener(new AllTransactionAction());
		itbalanceEnquiry.addActionListener(new BalanceEnquiryAction());
		itdeleteAccount.addActionListener(new DeleteAction());
		itupdate.addActionListener(new UpdateAction());
		ilogout.addActionListener(new LogoutAction());
       // m_quitItem.addActionListener(new QuitAction());
       //this.pack();
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
		   class InfoAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
	    Information info=new Information();
		info.setVisible(true);
//this.setVisible(false);
		
        }	
}

 class UpdateAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
	    Update up=new   Update();
		up.setVisible(true);
//this.setVisible(false);
		
        }	
}

 class ShowInfoAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
	 ShowInfo s =new ShowInfo();
		
		s.setVisible(true);
//this.setVisible(false);
		
        }	
}



		   class DebitAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
	    Debit db=new Debit();
		db.setVisible(true);
//this.setVisible(false);
		
        }	
		}
				   class CreditAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
	    Credit db=new Credit();
		db.setVisible(true);
//this.setVisible(false);
		
        }	
		}
						   class DeleteAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
	    Delete db=new Delete();
		db.setVisible(true);
//this.setVisible(false);
		            //System.exit(0);  
		}	
	}
	 class LogoutAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
		Welcome wc = new Welcome();
		wc.setVisible(true);
	
		
        }	
		}
	 
	class AllTransactionAction  implements ActionListener {
        public void actionPerformed(ActionEvent e) {
	//AllTransaction b=new  AllTransaction();
		//b.setVisible(true);
               ShowTable t1 =new ShowTable();
		t1.setVisible(true);
		
        }	
	}
	
	class BalanceEnquiryAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
	    BalanceEnquiry b=new  BalanceEnquiry();
		b.setVisible(true);
//this.setVisible(false);
		            //System.exit(0);  
		
        }	
	}
	  public static void main(String[] args){
		  
		Admin c1 =new Admin();
	}
}
