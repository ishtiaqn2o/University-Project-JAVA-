import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


class ShowDetail extends JFrame{
	private JLabel name,month,givenamount,ogivenamount,totalmeal,ototalmeal,mealrate,omealrate,amount,oamount,bar,
	restamount,orestamount;
	private JComboBox cname,cmonth,cyear;
	private static final String[] monthnames =
 { "Jul","Feb"};
 private static final String[] years =
 { "2012","2013","2014"};
 	private	JButton submit;
	//private	JButton submit;
public ShowDetail(){
	super ("form");
	Container con = getContentPane();
        con.setLayout(null);
	name =new JLabel("Member name");
	 cname= new JComboBox();
	 cyear= new JComboBox(years);
	month = new JLabel("month");
	givenamount = new JLabel("given amount");
	ogivenamount = new JLabel(".........");
	totalmeal= new JLabel("Total Meal");
	ototalmeal= new JLabel(".......");
	
	mealrate= new JLabel("Meal Rate");
	omealrate= new JLabel(".......");
		amount = new JLabel("Amount");
	oamount = new JLabel(".........");
	 cmonth= new JComboBox(monthnames);
	
	bar = new JLabel(".......................................................................");
	restamount = new JLabel("Rest Amount");
	orestamount = new JLabel(".........");
	
	 submit = new JButton("Show");
	con.add (name);
	con.add(cname);
    con.add(cmonth);
	con.add(month);
	con.add(submit);
	con.add(givenamount);
	con.add(ogivenamount);
	con.add(totalmeal);
	con.add(ototalmeal);
	con.add(mealrate);
	con.add(omealrate);
	con.add(amount);
	con.add(oamount);
	con.add(bar);
	con.add(restamount);
	con.add(orestamount);
	con.add(cyear);
	
  setSize(600,700);
        setVisible(true);
	name.setBounds(70,70,100,25);
	   cname.setBounds(70,100,170,25);
	month.setBounds(280,70,100,25);
	cmonth.setBounds(280,100,170,25);
	submit.setBounds(480,100,90,25);
	totalmeal.setBounds(70,180,100,25);
	 ototalmeal.setBounds(220,180,100,25);
	mealrate.setBounds(70,210,100,25);
        omealrate.setBounds(220,210,100,25);
	amount.setBounds(70,240,100,25);
        oamount.setBounds(220,240,100,25);
	givenamount.setBounds(70,270,100,25);
	ogivenamount.setBounds(220,270,100,25);
	bar.setBounds(70,285,300,25);
	restamount.setBounds(70,300,100,25);
        orestamount.setBounds(220,300,100,25);
	cyear.setBounds(280,130,170,25);
	
	
	
	     String dbName ="jdbc:mysql://localhost:3306/meal";
        String dbUserName = "root";
        String dbPassword = ""; 	
	  String result;
		    try {
			    Connection conn = null;
Class.forName("com.mysql.jdbc.Driver");
conn = DriverManager.getConnection(dbName ,dbUserName , dbPassword );
Statement st = conn.createStatement();
//  ResultSet rs = st.executeQuery("Select *from information'");
                       
                   
                        
    ResultSet rs =st.executeQuery("select * from information"); 
    while(rs.next()) {
	result = rs.getString(1);
        if (result != null) {
            result = result.trim();
        }
        cname.addItem(result);
    } 
    rs.close();

}  catch (Exception ex) {
                        } 
			
			

submit.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent ae){
//String tdate =cmonth.getSelectedItem().toString();

	String tdate =cmonth.getSelectedItem().toString();;
	String tname =cname.getSelectedItem().toString();;	
		String tyear =cyear.getSelectedItem().toString();;	
String val1,val2;
		String val3,val4;
	int sum =0; 
		int sum2 =0; 
		int amount;
		int restamount;
		 int total;
		int sum3 =0;
		int givenamount;
		String summeal,summembermeal;
		int cost =0;
		String sumcost,sumamount,sumgivenamount;
		String mealrate,sumrestamount;
String dbName ="jdbc:mysql://localhost:3306/meal";
        String dbUserName = "root";
        String dbPassword = ""; 	
		
		String q ="select * from usermeal where date  like '"+tdate+"%' and date  like '%"+tyear+"%' ";
		String s ="select * from cost where date  like '"+tdate+"%' and date  like '%"+tyear+"%'";
		String r="select * from usermeal where name ='"+tname+"' and date   like '"+tdate+"%' and date  like '%"+tyear+"%' ";
		String t="select * from given_amount where name ='"+tname+"' and   date   like '"+tdate+"%' and date  like '%"+tyear+"%' ";
		//('"+tdate+"')
try{
Connection con= null;
Class.forName("com.mysql.jdbc.Driver");
 con = DriverManager.getConnection(dbName ,dbUserName , dbPassword );
Statement st = con.createStatement();
  ResultSet rs= st.executeQuery(q);

	 while(rs.next())//totalmeal
			{
			val1=rs.getString("meal");
			sum= sum + Integer.parseInt(val1);	
			 summeal= Integer.toString(sum);
          	
			}
			ResultSet rs1= st.executeQuery(s);
	while(rs1.next())//totalcost
			{
			val2=rs1.getString("cost");
			cost= cost+ Integer.parseInt(val2);	
			 sumcost= Integer.toString(cost);
           
			}	
			
	
			total =cost/sum;
			mealrate = Integer.toString(total);
		omealrate.setText(mealrate);
			
			
	ResultSet rs2= st.executeQuery(r);
      while(rs2.next())//total meal of member
			{
			val3=rs2.getString("meal");
			sum2= sum2+ Integer.parseInt(val3);	
			 summembermeal= Integer.toString(sum2);
                ototalmeal.setText(summembermeal);		
				
				
			}	
			amount = (total*sum2);	
		 sumamount= Integer.toString(amount);
	oamount.setText(sumamount);
			
			
		ResultSet rs4= st.executeQuery(t);
      while(rs4.next())//total meal of member
			{
			val4=rs4.getString("amount");
			sum3= sum3+ Integer.parseInt(val4);	
			 sumgivenamount= Integer.toString(sum3);
             
			ogivenamount.setText(sumgivenamount);		
				
			}	
               // ogivenamount.setText(sumgivenamount);	
                restamount =sum3-amount;
		sumrestamount=	Integer.toString(restamount);
			 orestamount.setText(sumrestamount);	
		//  ogivenamount.setText(sumgivenamount);	
			
			
JOptionPane.showMessageDialog(null, "  you have enterted  cost amount   ");
st.close();
con.close();
}			
			
			
	catch(Exception e){
System.out.println(e);
}		
}
}
);
			
			
			
			
		}
	
		
public static void main(String args[]){
	ShowDetail c = new ShowDetail();
	
	
	}


}