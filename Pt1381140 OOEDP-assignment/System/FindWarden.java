/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package pms.warden;
//import pms.admin.*;


import java.util.logging.Logger;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

/**
 *
 * @author rahul
 */
public class FindWarden extends JFrame implements ActionListener,KeyListener{

	private JButton btnCancel,btnFind;

    private JLabel lblHeader,lblRadioButtonHeader, lblText;
    private JPanel pnlComponents;
    private JRadioButton rbnFirstName,rbnId;
    private JRadioButton rbnLastName;
    private JTextField txtEntity;
	private ButtonGroup gpFind; 
	private int entity;
	private AdminPage adminPage;
	private String header;



    /**
     * Creates new form FindWarden
     */
    public FindWarden(AdminPage adminPage,String header) {
		this.adminPage=adminPage;
		this.header=header;
        lblHeader = new JLabel();
        pnlComponents = new JPanel();
        lblText = new JLabel();
        btnFind = new JButton();
        btnCancel = new JButton();
        rbnId = new JRadioButton();
        rbnFirstName = new JRadioButton();
        rbnLastName = new JRadioButton();
        lblRadioButtonHeader = new JLabel();
        txtEntity = new JTextField();
		gpFind=new ButtonGroup();

        initComponents();
    }

    private void initComponents() {
        GridBagConstraints gridBagConstraints;

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(500, 69));
        setPreferredSize(new Dimension(600, 250));
        setResizable(false);

        lblHeader.setBackground(new Color(102, 102, 102));
        lblHeader.setFont(new Font("Tahoma", 1, 24)); // NOI18N
        lblHeader.setForeground(new Color(72, 72, 74));
        lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
        lblHeader.setText(header);
        lblHeader.setPreferredSize(new Dimension(600, 80));
        getContentPane().add(lblHeader, BorderLayout.PAGE_START);
        lblHeader.getAccessibleContext().setAccessibleName("lblHeader\n");

        pnlComponents.setLayout(new GridBagLayout());

        lblText.setFont(new Font("Tahoma", 1, 14)); // NOI18N
        lblText.setForeground(new Color(72, 72, 74));
        lblText.setText("Enter Entity");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        pnlComponents.add(lblText, gridBagConstraints);

        btnFind.setFont(new Font("Tahoma", 2, 14)); // NOI18N
        btnFind.setForeground(new Color(72, 72, 74));
        btnFind.setText("Find");
		btnFind.addActionListener(this);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        pnlComponents.add(btnFind, gridBagConstraints);

        btnCancel.setFont(new Font("Tahoma", 2, 14)); // NOI18N
        btnCancel.setForeground(new Color(72, 72, 74));
        btnCancel.setText("Cancel");
		btnCancel.addActionListener(this);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        pnlComponents.add(btnCancel, gridBagConstraints);

        gpFind.add(rbnId);
        rbnId.setFont(new Font("Tahoma", 2, 11)); // NOI18N
        rbnId.setForeground(new Color(72, 72, 74));
        rbnId.setText("Warden  ID");
		rbnId.setSelected(true);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        pnlComponents.add(rbnId, gridBagConstraints);

        gpFind.add(rbnFirstName);
        rbnFirstName.setFont(new Font("Tahoma", 2, 11)); // NOI18N
        rbnFirstName.setForeground(new Color(72, 72, 74));
        rbnFirstName.setText("Warden's First Name");
		rbnFirstName.setEnabled(false);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        pnlComponents.add(rbnFirstName, gridBagConstraints);

        gpFind.add(rbnLastName);
        rbnLastName.setFont(new Font("Tahoma", 2, 11)); // NOI18N
        rbnLastName.setForeground(new Color(72, 72, 74));
        rbnLastName.setText("Warden's Last Name");
		rbnLastName.setEnabled(false);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        pnlComponents.add(rbnLastName, gridBagConstraints);

        lblRadioButtonHeader.setFont(new Font("Tahoma", 1, 14)); // NOI18N
        lblRadioButtonHeader.setForeground(new Color(72, 72, 74));
        lblRadioButtonHeader.setText("Select Entity Type");
        lblRadioButtonHeader.setPreferredSize(new Dimension(150, 25));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        pnlComponents.add(lblRadioButtonHeader, gridBagConstraints);


        txtEntity.setPreferredSize(new Dimension(120, 25));
		txtEntity.addKeyListener(this);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        pnlComponents.add(txtEntity, gridBagConstraints);

        getContentPane().add(pnlComponents, BorderLayout.CENTER);

        pack();
		setVisible(true);
		}
		public void actionPerformed(ActionEvent ae){
          if(ae.getSource()==btnFind){ 
			System.out.println(!(txtEntity.getText().equals("")));
		    if(!(txtEntity.getText().equals(""))){
				entity=(int)Integer.parseInt(txtEntity.getText());
				find(entity);    
			}
          }else
			  dispose();
		}

		boolean find(int entity){
		  boolean flag=false;
        try{
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		   System.out.println("Divers loaded successfully in find() at findWarden");
           Connection connect = DriverManager.getConnection("jdbc:odbc:PMS");
		   System.out.println("Connection established successfully in find() at findWarden");
           Statement state = connect.createStatement();
           String sql1 = "select * from Warden_Details where ID= "+ entity +"";
           ResultSet rs1=state.executeQuery(sql1);

		   if(rs1.next())
                {

		   JOptionPane.showMessageDialog(null, "Record Found Successfully");

					Warden w=new Warden(adminPage,"Warden Details");			
					w.find(rs1);//,rs2);
		   System.out.println("Statement executed successfully in find() at findWarden");
		   dispose();
                }else
			      JOptionPane.showMessageDialog(null, "Record is not Found ");
           state.close();
           connect.close();
		}catch (Exception e) {
           System.out.print(e);
        }
		return flag;
      }
	  public void keyTyped ( KeyEvent e ){ }  
  
	public void keyPressed ( KeyEvent e){  
		int hold=e.getKeyCode();
		if((hold>=48&& hold<=57)|| hold==8|| hold==10);
		else{
			JOptionPane.showMessageDialog(null, "Enter a valid warden ID.");
			txtEntity.setText("");
		}
	}  
	 public void keyReleased ( KeyEvent e ){ } 
}
