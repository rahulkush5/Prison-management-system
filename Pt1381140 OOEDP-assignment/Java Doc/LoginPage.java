//package pms.login;
//import pms.admin.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 import java.sql.*;
	/**
	* class {@code Login Page } is the gate way of prison manage ment system.
	*/
public class LoginPage extends JFrame implements ActionListener {
	public LoginPage(String s){
		super(s);
	}
    private JLabel lblHeader,lblUserId,lblUserPassword,lblIDStatus,lblPasswordStatus;
	private ImageIcon icon1;
	private JButton btnLogin,btnClear,btnCancel;
	private JTextField txtId,txtPassword;
	private String id,password;
	private Connection connect;
	/*
	* Constructor {@code LoginPage()} is the only Constructerof class. and it creates login page.
	*/
	public LoginPage(){
        setPreferredSize(new Dimension(1366, 768));
		setLayout(null);
	    icon1 = new ImageIcon("images/xyz.jpg");
		lblHeader=new JLabel(icon1);
		lblHeader.setBounds(300,50,790,72);
		add(lblHeader);
		lblUserId=new JLabel("Login ID");
		lblUserId.setBounds(500,300,100,30);
		lblUserId.setFont(new Font("Times New Roman",3,20));
		add(lblUserId);
		lblUserId.setForeground(new Color(255,255,255));
	
		lblUserPassword=new JLabel("Password");
		lblUserPassword.setBounds(500,350,100,30);
		lblUserPassword.setForeground(new Color(255,255,255));
		lblUserPassword.setFont(new Font("Times New Roman",3,20));
		add(lblUserPassword);

		txtId=new JTextField();
		txtId.setBounds(650,300,100,30);
		txtId.setForeground(new Color(72,72,74));
		add(txtId);

		lblIDStatus=new JLabel();
		lblIDStatus.setBounds(800,300,500,30);
		lblIDStatus.setForeground(new Color(255,0,0));
		add(lblIDStatus);

		txtPassword= new JTextField();
		txtPassword.setBounds(650,350,100,30);
		txtPassword.setForeground(new Color(72,72,74));
		add(txtPassword);

		lblPasswordStatus=new JLabel();
		lblPasswordStatus.setBounds(800,350,500,30);
		lblPasswordStatus.setForeground(new Color(255,0,0));
		add(lblPasswordStatus);

		btnLogin=new JButton("Login");
		btnLogin.setBounds(500,450,100,30);
		btnLogin.setForeground(new Color(255,255,255));
		btnLogin.setBackground(new Color(72,72,74));
		btnLogin.setOpaque(true);
		btnLogin.addActionListener(this);
		add(btnLogin);
		
		btnClear=new JButton("Clear");
		btnClear.setBounds(620,450,100,30);
		btnClear.setForeground(new Color(255,255,255));
		btnClear.setBackground(new Color(72,72,74));
		btnClear.addActionListener(this);
		btnClear.setOpaque(true);
		add(btnClear);

		btnCancel=new JButton("Cancel");
		btnCancel.setBounds(740,450,100,30);
		btnCancel.setForeground(new Color(255,255,255));
		btnCancel.setBackground(new Color(72,72,74));
		btnCancel.addActionListener(this);
		btnCancel.setOpaque(true);
		add(btnCancel);

		setLayout(null);
		getContentPane().setBackground(new Color(72,72,74));

		pack();

		try{Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		   System.out.println("Divers loaded successfully");
            connect = DriverManager.getConnection("jdbc:odbc:PMS");
		   System.out.println("Connection established successfully");	
            
		   }catch(Exception e){}
		setVisible(true);
		setResizable(false);	
	}
	/*
	* Main Method is the Gate way of my application.
	*/
	public static void main(String[] args) 
	{
		LoginPage v=new LoginPage();
		System.out.println("Login Successfilly");
	}
	/**
	* method that works is called internally when any Button is pressed
	* and then it call method asociated with button pressed.
	*/
	public void actionPerformed(ActionEvent e){
		id=txtId.getText();
		password=txtPassword.getText();
		lblPasswordStatus.setText("");
		lblIDStatus.setText("");
		if(e.getSource()==btnLogin)
			checkLogin();
		if(e.getSource()==btnClear)
			clear();
		if(e.getSource()==btnCancel)
			cancel();
	}
	private void checkLogin(){
		try{

			Statement state = connect.createStatement();
			String sql = "select Password from Login_Data where ID= '"+ id +"'";		   		
            ResultSet rs=state.executeQuery(sql);
			if(rs.next()){
				if(password.equals(rs.getString("Password"))){
					clear();
					new AdminPage(this).setVisible(true);
					this.setVisible(false);

				}else{
					lblPasswordStatus.setText("!You have entered a wrong password");
					txtId.setText("");
					txtPassword.setText("");
				}	
			}else{
				lblIDStatus.setText("!You have entered a Invalid ID");
				txtId.setText("");
				txtPassword.setText("");
			}
		}catch(Exception e){
			System.out.println("Exception in check Login method at Login page"+e);		
		}
	}
	private void clear(){			
				txtId.setText("");
				txtPassword.setText("");
			}
	private void cancel(){
		try{
			connect.close();		            
		}catch(Exception e){}
		System.exit(0);
	}
}  