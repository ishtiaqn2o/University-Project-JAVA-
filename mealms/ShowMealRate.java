import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


class ShowMealRate extends JFrame{
	 private JLabel title,month,totalmeal,totalcost,ototalmeal,ototalcost,mealrate,omealrate ;
	
	private static final String[] monthnames =
 { "Jul","Feb"};
 private static final String[] years =
 { "2012","2013","2014"};
	private JComboBox cmonth,cyear;
	private	JButton submit;
	
public  ShowMealRate(){
	super ("Cost ");
	Container con = getContentPane();
        con.setLayout(null);
	title = new JLabel("    ::     SHOW MEAL RATE    ::");
	month = new JLabel("Month");
	//cdate = new DateComboBox();
	cmonth = new JComboBox(monthnames);
	 cyear= new JComboBox(years);
	totalmeal= new JLabel("Total Meal");
	ototalmeal= new JLabel(".......");
	
	totalcost= new JLabel("Total Cost");
	ototalcost= new JLabel("........");
	mealrate= new JLabel("Meal Rate");
	omealrate= new JLabel(".......");
	submit = new JButton("Submit");
	con.add(title);
	con.add(month);
	con.add(cmonth);
	con.add(totalmeal);
	con.add(ototalmeal);
	con.add(totalcost);
	con.add(ototalcost);
	con.add(mealrate);
	con.add(omealrate);
       con.add(submit);
	con.add(cyear);
     
  setSize(600,480);
        setVisible(true);
	   title.setBounds(40, 20, 500, 25);
      
	 month.setBounds(150, 20+25+20, 100, 25);
        cmonth.setBounds(150, 20+25+20+25, 150, 25);
	cyear.setBounds(150,120,150,25);
        totalmeal.setBounds(150,25+20+25+20+20+25+20+10,100,25);
        ototalmeal.setBounds(150+100+10,20+25+20+25+20+25+30,150,25);
          totalcost.setBounds(150,210,100,25);
        ototalcost.setBounds(150+100+10,210,150,25);
           mealrate.setBounds(150,255,100,25);
        omealrate.setBounds(150+100+10,255,150,25);
submit.setBounds(150+100+10, 290,100, 25);
	  


submit.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent ae){
//String tdate =cmonth.getSelectedItem().toString();

	String tdate =cmonth.getSelectedItem().toString();;
			String tyear =cyear.getSelectedItem().toString();;	
String val1,val2;
	int sum =0; 
		int total;
		String summeal;
		int cost =0;
		String sumcost;
		String mealrate;
String dbName ="jdbc:mysql://localhost:3306/meal";
        String dbUserName = "root";
        String dbPassword = ""; 	
		
		String q ="select * from usermeal where date  like '"+tdate+"%' and date  like '%"+tyear+"%'";
		String s ="select * from cost where date  like '"+tdate+"%' and date  like '%"+tyear+"%'";
		
		//('"+tdate+"')
try{
Connection con= null;
Class.forName("com.mysql.jdbc.Driver");
 con = DriverManager.getConnection(dbName ,dbUserName , dbPassword );
Statement st = con.createStatement();
  ResultSet rs= st.executeQuery(q);

	 while(rs.next())
			{
			val1=rs.getString("meal");
			sum= sum + Integer.parseInt(val1);	
			 summeal= Integer.toString(sum);
                ototalmeal.setText(summeal);		
			}
			ResultSet rs1= st.executeQuery(s);
	while(rs1.next())
			{
			val2=rs1.getString("cost");
			cost= cost+ Integer.parseInt(val2);	
			 sumcost= Integer.toString(cost);
                ototalcost.setText(sumcost);	
			}	
		
		total =cost/sum;
			mealrate = Integer.toString(total);
		omealrate.setText(mealrate);
		//ototalmeal.setText(val3);		
	
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
	ShowMealRate mealrate= new ShowMealRate();
	mealrate.setVisible(true);
	
	}


}