import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.*;

public class EmployeeJFrame extends JFrame {

	private JPanel employeePanel;
	private JPanel employeeTopPanel;
	private JPanel employeeCenterPanel;
	private JPanel employeeBottomPanel;
	private JTextField employeeIdTF;
	private JTextField positionTF;
	private JButton searchButton;
	private JButton addUpdateButton;
	private JTextField firstNameTF;
	private JTextField lastNameTF;
	private JTextField dobTF;
	private JRadioButton maleRB;
	private JRadioButton femaleRB;
	private JComboBox<EmployeeType> employeeTypeCB;
	private EmployeeSystem employeeSystem;
	
	public EmployeeJFrame() {
		initComponentGUI();
		initEventHandler();
	}
	
	public void setEmployeeSystem(EmployeeSystem employeeSystem) {
		this.employeeSystem = employeeSystem;
	}
	
	private void initComponentGUI() {
		initEmployeePanel();
		add(employeePanel);
		
	}
	
	private void initEmployeePanel() {
		employeePanel = new JPanel();
		
		BorderLayout layout = new BorderLayout();
		employeePanel.setLayout(layout);
		
		initEmployeeTopPanel();
		initEmployeeCenterPanel();
		initEmployeeBottomPanel();
		
		employeePanel.add(employeeTopPanel, BorderLayout.NORTH);
		employeePanel.add(employeeCenterPanel, BorderLayout.CENTER);
		employeePanel.add(employeeBottomPanel, BorderLayout.SOUTH);
	}
	
	private void initEmployeeTopPanel() {
		employeeTopPanel = new JPanel();
		
		FlowLayout layout = new FlowLayout();
		employeeTopPanel.setLayout(layout);
		
		employeeTopPanel.add(new JLabel("Employee ID"));

		employeeIdTF = new JTextField(20);
		employeeTopPanel.add(employeeIdTF);

		searchButton = new JButton("Search");
		employeeTopPanel.add(searchButton);
	}

	private void initEmployeeCenterPanel() {
		employeeCenterPanel = new JPanel();

		GridLayout layout = new GridLayout(0, 2);
		employeeCenterPanel.setLayout(layout);
		
		initFirstNameGUI();
		initLastNameGUI();
		initDobGUI();
		initGenderGUI();
		initEmployeeTypeGUI();
		initPositionGUI();
	}
	
	private void initFirstNameGUI() {
		employeeCenterPanel.add(new JLabel("First Name"));
		
		firstNameTF = new JTextField(20);
		employeeCenterPanel.add(firstNameTF);
	}
	
	private void initLastNameGUI() {
		employeeCenterPanel.add(new JLabel("Last Name"));
		
		lastNameTF = new JTextField(20);
		employeeCenterPanel.add(lastNameTF);
	}
	
	private void initPositionGUI() {
		employeeCenterPanel.add(new JLabel("Position"));
		
		positionTF = new JTextField(20);
		employeeCenterPanel.add(positionTF);
	}
	
	private void initDobGUI() {
		employeeCenterPanel.add(new JLabel("DOB (dd-MM-yyyy)"));
		dobTF = new JTextField(20);
		employeeCenterPanel.add(dobTF);
	}
	
	private void initGenderGUI() {
		maleRB = new JRadioButton("M");
		femaleRB = new JRadioButton("F");

		ButtonGroup genderBG = new ButtonGroup();
		genderBG.add(maleRB);
		genderBG.add(femaleRB);

		JPanel genderPanel = new JPanel();
		genderPanel.add(maleRB);
		genderPanel.add(femaleRB);

		employeeCenterPanel.add(new JLabel("Gender"));
		employeeCenterPanel.add(genderPanel);
	}

	private void initEmployeeBottomPanel() {
		employeeBottomPanel = new JPanel();

		FlowLayout layout = new FlowLayout();
		employeeBottomPanel.setLayout(layout);
		 
		addUpdateButton = new JButton("Add/Update Student");
		employeeBottomPanel.add(addUpdateButton);
	}
	
	private void initEmployeeTypeGUI() {
		EmployeeType[] employeeTypeOptions = { EmployeeType.ACADEMIC,
		EmployeeType.CONTRACTOR, EmployeeType.ADMIN };

		employeeTypeCB = new JComboBox<EmployeeType>(employeeTypeOptions);

		employeeCenterPanel.add(new JLabel("Student Type"));
		employeeCenterPanel.add(employeeTypeCB);
	}

	
	private void initEventHandler() {
		initSearchButtonHandler();
		initAddUpdateButtonHandler();
	}
	
	private void showMessage(String title, String message) {
		JOptionPane.showMessageDialog(this, message, title, JOptionPane.INFORMATION_MESSAGE);
	}
	
	private void displayEmployee(Employee employee) {
		DateTimeFormatter dobFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		firstNameTF.setText(employee.getFirstName());
		lastNameTF.setText(employee.getLastName());
		dobTF.setText(employee.getDob().format(dobFormat));
		
		if(employee.getGender().equals(Gender.M)) {
			maleRB.setSelected(true);
		}
		
		if(employee.getGender().equals(Gender.F)) {
			femaleRB.setSelected(true);
		}
		
		positionTF.setText(employee.getPosition());
		
		if(employee.getEmployeeType().equals(EmployeeType.ACADEMIC)) {
			employeeTypeCB.setSelectedIndex(0);
		} else if(employee.getEmployeeType().equals(EmployeeType.CONTRACTOR)) {
			employeeTypeCB.setSelectedIndex(1);
		} else if(employee.getEmployeeType().equals(EmployeeType.ADMIN)) {
			employeeTypeCB.setSelectedIndex(2);
		}
		
	}
	
	private void initSearchButtonHandler() {
		searchButton.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						String employeeID = employeeIdTF.getText();
						
						Employee employee = employeeSystem.findEmployeeById(employeeID);
						
						if(employee == null) {
							showMessage("Search result", "Employee not found");
						}else {
							displayEmployee(employee);
						}
					}
				}
			);
	}
	
	private void initAddUpdateButtonHandler() {
		addUpdateButton.addActionListener(
			   new ActionListener() {
				 @Override
				 public void actionPerformed(ActionEvent e) {
					 DateTimeFormatter dobFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
					 String employeeID = employeeIdTF.getText();
					 String firstName = firstNameTF.getText();
					 String lastName = lastNameTF.getText();
					 LocalDate dob = LocalDate.parse(dobTF.getText(), dobFormat);
					 String position = positionTF.getText();
					 Gender gender = null;
					 
					 if(maleRB.isSelected()) {
						gender = Gender.M; 
					 }
					 
					 if(femaleRB.isSelected()) {
						gender = Gender.F;
					 }
					 
				 EmployeeType employeeType = (EmployeeType) employeeTypeCB.getSelectedItem();
				 
				 Employee employee = new Employee(employeeID, employeeType, firstName, lastName, dob, gender, position);
				 employeeSystem.addEmployee(employee);
				 employeeSystem.writeCsv("C://Users//New//Desktop//A3.txt");
				
				 }
			}
		);
	} 
}	


