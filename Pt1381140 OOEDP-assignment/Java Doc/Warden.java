
//package pms.warden;
// import pms.admin.*;
 import java.awt.event.*;
 import javax.swing.*;
 import java.awt.*;
 import javax.swing.border.TitledBorder;
 import javax.swing.table.*;
 import java.sql.*;
 import java.io.*;
 /**
 * Class {@code Warden } represents a warden and all its attributes.
 *this page provides following functionalities :-
 * <blockquote><pre>
 *      Add a Warden.
 *		Find a Warden.
 *		Delete a Warden.
 *		Update Warden's Details.
 *		Genrate Reports of all Warden.     
 * </pre></blockquote>
 */
public class Warden extends JFrame implements ActionListener,KeyListener {
    private JButton btnAdd, btnCancel,btnClear, btnUploadMugshot,btnDelete, btnUpdate;
    private ButtonGroup gpSex;
    private JScrollPane jScrollPane1;
    private JLabel lblFirstName,lblHeader,lblHieght,lblId,lblAllocationnStatus,lblLastName;
	private JLabel lblMugshot,lblOrigin,lblPrisonersTable,lblStatus,lblRank,lblSex;
    private JPanel pnlButtons,pnlComponents,pnlPersonalInformation,pnlPrisonalInformation,pnlTable;
    private JRadioButton rbnFemale,rbnMale;
    private JTable tblUndertakings;
    private JTextField txtFirstName,txtHeight,txtId,txtAllocationStatus,txtLastName,txtOrigin,txtStatus,txtRank;
	private String firstName,lastName,sex,age,status,height,mugshotPath,origin,rank;
	private int id,allocationStatus=0;
	private JFileChooser chooser;
	private String header;
	private AdminPage adminPage;

    /**
     * Creates new form Warden
     */
    public Warden(AdminPage adminPage,String str){
		header=str;
		this.adminPage=adminPage;

        gpSex = new ButtonGroup();
        pnlComponents = new JPanel();
        pnlPersonalInformation = new JPanel();
        lblFirstName = new JLabel();
        txtFirstName = new JTextField();
        lblLastName = new JLabel();
        txtLastName = new JTextField();
        lblSex = new JLabel();
        rbnMale = new JRadioButton();
        rbnFemale = new JRadioButton();
        lblMugshot = new JLabel();
        lblStatus = new JLabel();
        txtStatus = new JTextField();
        lblOrigin = new JLabel();
        txtOrigin = new JTextField();
        lblHieght = new JLabel();
        txtHeight = new JTextField();
        btnUploadMugshot = new JButton();
        pnlPrisonalInformation = new JPanel();
        lblId = new JLabel();
        txtId = new JTextField();
        lblAllocationnStatus = new JLabel();
        txtAllocationStatus = new JTextField();
        lblRank = new JLabel();
        txtRank = new JTextField();
        pnlTable = new JPanel();
        jScrollPane1 = new JScrollPane();
        tblUndertakings = new JTable();
        lblPrisonersTable = new JLabel();
        lblHeader = new JLabel();
        pnlButtons = new JPanel();
        btnAdd = new JButton();
        btnUpdate = new JButton();
        btnDelete = new JButton();
        btnClear = new JButton();
        btnCancel = new JButton();
		chooser = new JFileChooser();
        initComponents();
    }
    private void initComponents() {
       GridBagConstraints gridBagConstraints; 

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 660));

        pnlComponents.setLayout(new GridLayout(2, 1));

        pnlPersonalInformation.setBorder(BorderFactory.createTitledBorder(null, "Personal Information", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Agency FB", 3, 24), new Color(72, 72, 74))); // NOI18N
        pnlPersonalInformation.setLayout(new GridBagLayout());
        lblFirstName.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        lblFirstName.setText("First Name");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 7;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.weighty = 0.04;
        pnlPersonalInformation.add(lblFirstName, gridBagConstraints);

        txtFirstName.setText("");
        txtFirstName.setPreferredSize(new Dimension(60, 20));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 7;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.weightx = 0.01;
        gridBagConstraints.weighty = 0.04;
        pnlPersonalInformation.add(txtFirstName, gridBagConstraints);

        lblLastName.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        lblLastName.setText("Last Name");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 7;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.weightx = 0.01;
        gridBagConstraints.weighty = 0.04;
        pnlPersonalInformation.add(lblLastName, gridBagConstraints);

        txtLastName.setText("");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 2;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.weighty = 0.04;
        pnlPersonalInformation.add(txtLastName, gridBagConstraints);

        lblSex.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        lblSex.setText("Sex");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 7;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.01;
        gridBagConstraints.weighty = 0.04;
        pnlPersonalInformation.add(lblSex, gridBagConstraints);

        rbnMale.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        rbnMale.setText("Male");
		gpSex.add(rbnMale);
		rbnMale.setSelected(true);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.weighty = 0.04;
        pnlPersonalInformation.add(rbnMale, gridBagConstraints);

        rbnFemale.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        rbnFemale.setText("Female");
		gpSex.add(rbnFemale);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.weighty = 0.04;
        gridBagConstraints.insets = new Insets(0, 0, 0, 28);
        pnlPersonalInformation.add(rbnFemale, gridBagConstraints);

        lblMugshot.setForeground(new Color(72, 72, 74));
        lblMugshot.setHorizontalAlignment(SwingConstants.CENTER);
        lblMugshot.setText("Upload image here");
        lblMugshot.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(72, 72, 74)));
        lblMugshot.setPreferredSize(new Dimension(150, 150));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 8;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.weighty = 0.04;
        gridBagConstraints.insets = new Insets(0, 2, 0, 16);
        pnlPersonalInformation.add(lblMugshot, gridBagConstraints);

        lblStatus.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        lblStatus.setText("Status");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 0.01;
        gridBagConstraints.weighty = 0.04;
        pnlPersonalInformation.add(lblStatus, gridBagConstraints);

        txtStatus.setText(" ");
        txtStatus.setPreferredSize(new Dimension(60, 20));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.01;
        gridBagConstraints.weighty = 0.14;
        pnlPersonalInformation.add(txtStatus, gridBagConstraints);

        lblOrigin.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        lblOrigin.setText("Origin");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 0.01;
        gridBagConstraints.weighty = 0.04;
        pnlPersonalInformation.add(lblOrigin, gridBagConstraints);

        txtOrigin.setPreferredSize(new Dimension(60, 20));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.01;
        gridBagConstraints.weighty = 0.04;
        pnlPersonalInformation.add(txtOrigin, gridBagConstraints);

        lblHieght.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        lblHieght.setHorizontalAlignment(SwingConstants.TRAILING);
        lblHieght.setText("Height");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        pnlPersonalInformation.add(lblHieght, gridBagConstraints);

        txtHeight.setPreferredSize(new Dimension(60, 20));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        pnlPersonalInformation.add(txtHeight, gridBagConstraints);

        btnUploadMugshot.setFont(new Font("Tahoma", 3, 12)); // NOI18N
        btnUploadMugshot.setText("Upload Mugshot");
		btnUploadMugshot.addActionListener(this);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = GridBagConstraints.NORTH;
        gridBagConstraints.insets = new Insets(5, 0, 0, 23);
        pnlPersonalInformation.add(btnUploadMugshot, gridBagConstraints);

        pnlComponents.add(pnlPersonalInformation);

        pnlPrisonalInformation.setBorder(BorderFactory.createTitledBorder(null, "Prisonal Information", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Agency FB", 3, 24), new Color(72, 72, 74))); // NOI18N
        pnlPrisonalInformation.setPreferredSize(new Dimension(60, 20));
        pnlPrisonalInformation.setLayout(new GridBagLayout());

        lblId.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        lblId.setHorizontalAlignment(SwingConstants.RIGHT);
        lblId.setText(" ID");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        pnlPrisonalInformation.add(lblId, gridBagConstraints);

        txtId.setMinimumSize(new Dimension(60, 20));
        txtId.setPreferredSize(new Dimension(60, 20));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 13, 0, 13);
        pnlPrisonalInformation.add(txtId, gridBagConstraints);

        lblAllocationnStatus.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        lblAllocationnStatus.setText("Allocation Stattus");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        pnlPrisonalInformation.add(lblAllocationnStatus, gridBagConstraints);

        txtAllocationStatus.setPreferredSize(new Dimension(60, 20));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(0, 13, 0, 13);
        pnlPrisonalInformation.add(txtAllocationStatus, gridBagConstraints);

        lblRank.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        lblRank.setText("Rank");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        pnlPrisonalInformation.add(lblRank, gridBagConstraints);

        txtRank.setPreferredSize(new Dimension(60, 20));
		txtRank.addKeyListener(this);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(0, 13, 0, 13);
        pnlPrisonalInformation.add(txtRank, gridBagConstraints);

        pnlTable.setBackground(new Color(72, 72, 74));
        pnlTable.setForeground(new Color(255, 255, 255));
        pnlTable.setMinimumSize(new Dimension(0, 0));
        pnlTable.setPreferredSize(new Dimension(500, 130));
        pnlTable.setLayout(new BorderLayout());

        tblUndertakings.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Serial No.", "Name", "Prisoner ID", "Security Class"
            }
        ));
        jScrollPane1.setViewportView(tblUndertakings);

        pnlTable.add(jScrollPane1, BorderLayout.CENTER);

        lblPrisonersTable.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        lblPrisonersTable.setForeground(new Color(255, 255, 255));
        lblPrisonersTable.setText("Undertaking Prisoners");
        lblPrisonersTable.setPreferredSize(new Dimension(105, 32));
        pnlTable.add(lblPrisonersTable, BorderLayout.PAGE_START);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 3;
        pnlPrisonalInformation.add(pnlTable, gridBagConstraints);

        pnlComponents.add(pnlPrisonalInformation);

        getContentPane().add(pnlComponents, BorderLayout.CENTER);

        lblHeader.setFont(new Font("Tahoma", 3, 24)); // NOI18N
        lblHeader.setForeground(new Color(72, 72, 74));
        lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
        lblHeader.setText("Add a Warden");
        lblHeader.setAlignmentY(5.0F);
        lblHeader.setPreferredSize(new Dimension(500, 100));
        getContentPane().add(lblHeader, BorderLayout.NORTH);

        pnlButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));

        btnAdd.setText("Submit");
		btnAdd.addActionListener(this);
        pnlButtons.add(btnAdd);

        btnUpdate.setText("Update");
        pnlButtons.add(btnUpdate);
		btnUpdate.addActionListener(this);
        btnDelete.setText("Delete");
        pnlButtons.add(btnDelete);
		btnDelete.addActionListener(this);

        btnClear.setText("Clear");
		btnClear.addActionListener(this);
        pnlButtons.add(btnClear);

        btnCancel.setText("Cancel");
		btnCancel.addActionListener(this);
        pnlButtons.add(btnCancel);

        getContentPane().add(pnlButtons, BorderLayout.PAGE_END);

		  txtStatus.setEditable(false);
		  txtId.setEditable(false);
		  txtAllocationStatus.setEditable(false);
		  btnUpdate.setEnabled(false);
		  btnDelete.setEnabled(false);
        pack();
		loadId();
    }
	/**
	* method that works is called internally when any Button is pressed
	* and then it call method asociated with button pressed.
	*/ 
	public void actionPerformed(ActionEvent e){
          firstName=txtFirstName.getText();
          lastName=txtLastName.getText();
		  if(!(txtId.getText().equals("")))
		  id=Integer.parseInt(txtId.getText());
		  if (rbnMale.isSelected())
		  {
			  sex=rbnMale.getText();
		  }
		  else 
		  sex=rbnFemale.getText();
		  origin=txtOrigin.getText();
		  height=txtHeight.getText();
		  status="Working";
		  rank=txtRank.getText();
			boolean flag=true;
		   if(e.getSource()==btnUploadMugshot){
			   uploadMugshot();
			   flag=false;
			}
		   if (e.getSource()==btnClear){
			   clear();
			   flag=false;
		   }
		   if(e.getSource()==btnCancel){
			   cancel();
			   flag=false;
		   }
		   if(flag && checkFieldValidation()){
				if(e.getSource()==btnAdd){
					int check=JOptionPane.showConfirmDialog(null,"Are you sure to Add the Warden", "Confirmation Dialogue", JOptionPane.YES_NO_OPTION);
					if(check==0)
					add();
				}
				if (e.getSource()==btnUpdate){
					int check=JOptionPane.showConfirmDialog(null,"Are you sure to Update the Warden's Details.", "Confirmation Dialogue", JOptionPane.YES_NO_OPTION);
					if(check==0)
					update();
				}
				if(e.getSource()==btnDelete){
					int check=JOptionPane.showConfirmDialog(null,"Are you sure to Delete the Warden", "Confirmation Dialogue", JOptionPane.YES_NO_OPTION);
					if(check==0)
				   delete();
				}
		   }  
      }

	  private void add(){

        try{			
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  //DSN oriented Connection
		   System.out.println("Divers loaded successfully in add() method at warden");
           Connection connect = DriverManager.getConnection("jdbc:odbc:PMS");
		   System.out.println("Connection established successfully in add at warden");
           Statement state = connect.createStatement();
           String sql = "insert into Warden_Details (First_Name,Last_Name,Sex,Origin,Height,Rank,Status,Allocation_Status,Mugshot) values ('" + firstName + "','" + lastName + "','" + sex + "','" + origin + "','" + height + "','" + rank + "','" + status + "'," + allocationStatus + ",'" + mugshotPath + "')";
           state.execute(sql);
		   JOptionPane.showMessageDialog(null, "Record added Successfully ");
		   System.out.println("Statement executed successfully in add() at warden");
           state.close();
           connect.close();
		   if(Integer.parseInt(rank)>4)
			   setPassword();
		}
        catch (Exception e) {
           System.out.print("error caught at add method inWarden"+e);
        }
		clear();
      }
	  private void update(){
		id=Integer.parseInt(txtId.getText());
        try{
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		   System.out.println("Divers loaded successfully in update at warden");		   
           Connection connect = DriverManager.getConnection("jdbc:odbc:PMS");
		   System.out.println("Connection established successfully in update() at warden");
           Statement state = connect.createStatement();
           String sql = "UPDATE Warden_Details set First_Name= '" + firstName + "', Last_Name= '" + lastName + "', Sex= '" + sex + "', Origin= '" + origin + "', Height= '" + height + "', Rank= '" + rank + "', Mugshot= '" + mugshotPath + "'  WHERE ID= "+id+"";           
		   state.executeUpdate(sql);
		   JOptionPane.showMessageDialog(null, "Record Updated Successfully");
		   System.out.println("Statement executed successfully in update at warden");
           state.close();
           connect.close();
		}
        catch (Exception e) {
           System.out.print("error caught at update method inWarden"+e);
        }
		if(Integer.parseInt(rank)>4)
			setPassword();
		clear();
      }


    public void find(ResultSet rs){	
	    btnAdd.setEnabled(false);
	   	btnUpdate.setEnabled(true);
		btnDelete.setEnabled(true);
	   try{
		txtId.setText(rs.getString("ID"));
		txtFirstName.setText(rs.getString("First_Name"));
		txtHeight.setText(rs.getString("Height"));
		
		txtLastName.setText(rs.getString("Last_Name"));
		txtOrigin.setText(rs.getString("Origin"));
		txtRank.setText(rs.getString("Rank"));
		txtAllocationStatus.setText(rs.getString("Allocation_Status"));
		txtStatus.setText(rs.getString("Status"));
		lblMugshot.setIcon(new ImageIcon(rs.getString("Mugshot")));
		loadPrisoners();
	   }catch (Exception e) {
           System.out.print("error caught at find method inWarden"+e);
        }
		setVisible(true);	
	}
	private void delete(){
		status="Deleted";
	    id=Integer.parseInt(txtId.getText());
        try{
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		   System.out.println("Divers loaded successfully in delete at warden");		   
           Connection connect = DriverManager.getConnection("jdbc:odbc:PMS");
		   System.out.println("Connection established successfully in delete at warden");
           Statement state = connect.createStatement();
           String sql = "UPDATE Warden_Details set Status= '"+ "Deleted" +"' WHERE ID= "+ id +"";
           state.execute(sql);
		   JOptionPane.showMessageDialog(null, "Record deleted Successfully indelete at warden");
		   System.out.println("Statement executed successfully");
           state.close();
           connect.close();
		   clear();
		}
        catch (Exception e) {
           System.out.print("error caught at delete() method inWarden"+e);
        }
      }
	private void clear(){

		txtId.setText("");
		txtFirstName.setText("");
		txtHeight.setText("");
		
		txtLastName.setText("");
		txtOrigin.setText("");

		txtStatus.setText("");
		txtAllocationStatus.setText("");
		txtRank.setText("");
		rbnMale.setSelected(true);
		lblMugshot.setIcon(null);
		lblMugshot.setText("Upload Mugshot here");
		int count=0;
		while(tblUndertakings.getValueAt(count,0)!=null){
			tblUndertakings.setValueAt(null,count,0);
			tblUndertakings.setValueAt(null,count,1);
			tblUndertakings.setValueAt(null,count,2);
			tblUndertakings.setValueAt(null,count,3);
			count++;
		}
	  }
	private void uploadMugshot(){
                int result = chooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION){
                mugshotPath = chooser.getSelectedFile().getPath();    
				lblMugshot.setText(null);
				lblMugshot.setIcon(new ImageIcon(mugshotPath));
				}
				}
    private void loadPrisoners(){
	       try{
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		   System.out.println("Divers loaded successfully");
           Connection connect = DriverManager.getConnection("jdbc:odbc:PMS");
		   System.out.println("Connection established successfully in loadprisoners at warden");
           Statement state = connect.createStatement();
		   		int  entity=(int)Integer.parseInt(txtId.getText());
		   	String sql2 = "select * from Prisoner_Details where Allocated_Warden_Id= "+ entity +" And Status= '" + "Incarcerated" +"'";
            ResultSet prisoners=state.executeQuery(sql2);
					int count=0;
            while(prisoners.next()){
				tblUndertakings.setValueAt(count+1,count,0);
				tblUndertakings.setValueAt(prisoners.getString("First_Name"),count,1);
				tblUndertakings.setValueAt(prisoners.getString("ID"),count,2);
				tblUndertakings.setValueAt(prisoners.getString("Security_Class"),count,3);	
				count++;
		    }  
		   System.out.println("Statement executed successfully in laod prisoners at warden");
           state.close();
           connect.close();
		}catch (Exception e) {
           System.out.print("error caught at loadPrisoners method inWarden"+e);
        }
	}
	public boolean checkFieldValidation(){
		  boolean flag=false;
		  if(txtFirstName.getText().equals(""))
			JOptionPane.showMessageDialog(null, "Fill the First Name field");
		  else if(txtLastName.getText().equals(""))
			JOptionPane.showMessageDialog(null, "Fill the Last Name Field");
		  else if(txtOrigin.getText().equals(""))
			JOptionPane.showMessageDialog(null, "Fill the Origin Field");
		  else if(txtHeight.getText().equals(""))
			JOptionPane.showMessageDialog(null, "Fill the Height Field");
		  else if(txtRank.getText().equals(""))
			JOptionPane.showMessageDialog(null, "Fill the Rank Field properly");
		  else if (mugshotPath=="")
			JOptionPane.showMessageDialog(null, "Please Selecte a mugshot from Upload Mugshot Coulmn");
		
		  else
			  flag=true;
		  return flag;
	  }
	  private void cancel(){
		  dispose();
		  adminPage.setVisible(true);
	  }
	private void setPassword(){
		
		String hold1 = JOptionPane.showInputDialog("Enter Your Login Password");
		String hold2 = JOptionPane.showInputDialog("Confirm Login Password");
		if(hold1.equals(hold2)){
			String password=hold1;
				try{
			
	           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  //DSN oriented Connection
			   System.out.println("Divers loaded successfully in setPassword at warden");
	
		       Connection connect = DriverManager.getConnection("jdbc:odbc:PMS");
			   System.out.println("Connection established successfully  in setPassword at warden");
	
		       Statement state = connect.createStatement();
		       String sql = "insert into Login_Data (ID,Password) values ('" + id + "','" + password + "')";
		       state.execute(sql);
			   JOptionPane.showMessageDialog(null, "Record added Successfully");
			   System.out.println("Statement executed successfully  in setPassword at warden");
		       state.close();
		       connect.close();
			}catch (Exception e) {
           System.out.print("error caught at setPassword method inWarden"+e);
		    }	  
	    }else{
		    JOptionPane.showMessageDialog(null, "Password Check Failed.");
			checkFieldValidation();
		}
	}
	private void loadId(){
			       try{
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		   System.out.println("Divers loaded successfully");
           Connection connect = DriverManager.getConnection("jdbc:odbc:PMS");
		   System.out.println("Connection established successfully  in loadId at warden");
           Statement state = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE ,ResultSet.CONCUR_READ_ONLY);
		   	String sql = "select ID from Warden_Details";
            ResultSet rs=state.executeQuery(sql);
					int count=0;
            if(rs.next()){
				rs.last();
				int hold=rs.getInt("ID");
				hold++;
				txtId.setText(hold+"");				
		    }else					
		   JOptionPane.showMessageDialog(null, "Record Found Successfully");
		   System.out.println("Statement executed successfully   in loadId at warden"); 
           state.close();
           connect.close();
		}catch (Exception e) {
           System.out.print("error caught at loadId method inWarden"+e);
        }
	
	}
  public void keyTyped ( KeyEvent e ){ }  
  
  public void keyPressed ( KeyEvent e){  
	int hold=e.getKeyCode();
	if((hold>=49&& hold<=53)|| hold==8);
	else{
		JOptionPane.showMessageDialog(null, "Enter a valid Rank Between 1-5.");
		txtRank.setText("");
	}
  }  
  public void keyReleased ( KeyEvent e ){ } 
}