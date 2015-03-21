import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


class EnterGivenAmount extends JFrame{
	 private JLabel title,date,givenamount,name;
	private JComboBox cname;
	private DateComboBox cdate;
	private	JButton submit;
	private JTextField tgivenamount;
public  EnterGivenAmount(){
	super ("form");
	Container con = getContentPane();
        con.setLayout(null);
	title = new JLabel("    ::     Enter Given Amount Of The User  ::");
	date = new JLabel("Date");
	cdate = new DateComboBox();
	name = new JLabel("Name");
	 cname= new JComboBox();
	givenamount = new JLabel("Amount");
	tgivenamount = new JTextField(10);
	submit = new JButton("Submit");
	con.add(title);
	con.add(date);
	con.add(cdate);
	con.add(name);
	con.add(cname);
	con.add(givenamount);
	con.add(tgivenamount);
       con.add(submit);
	
     
  setSize(600,400);
        setVisible(true);
	   title.setBounds(40, 20, 500, 25);
        date.setBounds(150, 20+25+20, 100, 25);
        cdate.setBounds(150+100+10, 20+25+20, 150, 25);
	name.setBounds(150, 20+25+20+25+20, 100, 25);
        cname.setBounds(150+100+10, 20+25+20+25+20, 150, 25);
        givenamount.setBounds(150,25+20+25+20+20+25+20,100,25);
        tgivenamount.setBounds(150+100+10,20+25+20+25+20+25+20,150,25);
        submit.setBounds(150+100+10, 20+25+20+25+20+25+20+25+20,100, 25);
	  
	  
	  
            
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
String val1=cdate.getSelectedItem().toString();
String val2=cname.getSelectedItem().toString();
		String val3=tgivenamount.getText();
		//int val4 = Integer.parseInt(val3);
//String val4=tbalance.getText();
if(val3.equals("")){
JOptionPane.showMessageDialog(null,"Plese Enter Meal");	
}


else{

String dbName ="jdbc:mysql://localhost:3306/meal";
        String dbUserName = "root";
        String dbPassword = ""; 	
try{
Connection con= null;
Class.forName("com.mysql.jdbc.Driver");
 con = DriverManager.getConnection(dbName ,dbUserName , dbPassword );
Statement st = con.createStatement();
int i= st.executeUpdate("INSERT INTO given_amount (date,name,amount) VALUES ('"+val1+"','"+val2+"','"+val3+"')");
	tgivenamount.setText("");
	
JOptionPane.showMessageDialog(null, "  you have enterted   " +val3+ "  cost for  " +val2+"   at the Date  "+val1+"");
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
	
		
public static void main(String args[]){
	EnterGivenAmount amount= new EnterGivenAmount();
	amount.setVisible(true);
	
	}


}