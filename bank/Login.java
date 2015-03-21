import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener{
    JLabel jlb1,jlb2,jlb3;
    JComboBox jtf1;
    JPasswordField jpwf;
    JButton jb2;
	private static final String[] names =
 { "Admin"};
    public Login(){
        super(".:: Welcome To Our Shop ::.");
        Container con = getContentPane();
        con.setLayout(null);
        
        jlb3 = new JLabel("ID");
        jtf1 = new JComboBox(names);
        jlb1 = new JLabel("^_^ ADMIN  LOGIN ^_^");
        jlb2 = new JLabel("Password");
        jpwf = new JPasswordField(10);
        jb2 = new JButton("Login");
        
        con.add(jlb3);
        con.add(jtf1);
        con.add(jlb1);
        con.add(jlb2);
        con.add(jpwf);
        con.add(jb2);
        
        jb2.addActionListener(this);
        arrangeComponents();
        setSize(500,350);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
        
        private void arrangeComponents(){
            jlb3.setBounds(120,140,150,25);
            jtf1.setBounds(220,140,160,25);
            jlb1.setBounds(220,90,250,25);
            jlb2.setBounds(120,180,150,25);
            jpwf.setBounds(220,180,160,25);
            jb2.setBounds(250,220,70,25);            
            }
            
           public void actionPerformed(ActionEvent event){
                 String command = event.getActionCommand(); 
        String id = jtf1.getSelectedItem().toString();
        char p[] = jpwf.getPassword();
        String psw = new String(p);
        System.out.println(psw);
        if(command.equals( "Login")){
            //System.out.println(command);
            if( (id.equals( "Admin")) && (psw.equals( "123"))){
                //System.out.println("Login Successful !!!");
              // JOptionPane.showMessageDialog(null,"Login Successful To Admin!!!");
               Admin ap = new Admin();
               ap.setVisible(true);
               ap.setSize(500,500);
               this.setVisible(false);
            }
            else if((id.equals("salesman"))&&(psw.equals("456"))){
               // SellProduct sl = new SellProduct();
               // sl.setVisible(true);
                this.setVisible(false);
                
            }
                
            }else{
                //System.out.println("Wrong User Name/ password !!!");
                JOptionPane.showMessageDialog(null,"Wrong User Name/ password !!!");
            }
            
        }
                
                
                public static void main(String args[]){
                    Login l = new Login();
                    }
    
    
    }