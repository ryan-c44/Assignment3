import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeListJFrame extends JFrame {
	
	private EmployeeSystem employeeSystem;
	private JPanel employeePanel;
	private JPanel employeeTopPanel;
	private JPanel orderPanel;
	private JRadioButton ascendingRB;
	private JRadioButton descendingRB;
	private JComboBox<String> sortByCB;
	private JButton displayButton;
	private JPanel employeeCenterPanel;
	private JTextArea employeeTextArea;
	private JScrollPane scroll;
	
	public EmployeeListJFrame(EmployeeSystem es) {
		employeeSystem = es;
		initComponentGUI();
		initEventHandler();
	}
	
	private void initComponentGUI() {
		initEmployeePanel();
		add(employeePanel);
	}
	
	private void initEventHandler() {
		initDisplayButtonHandler();
	}
	
	private void initEmployeePanel() {
		employeePanel = new JPanel();
		
		BorderLayout layout = new BorderLayout();
		employeePanel.setLayout(layout);
		
		initEmployeeTopPanel();
		initEmployeeCenterPanel(); 
	
		employeePanel.add(employeeTopPanel, BorderLayout.NORTH);
		employeePanel.add(employeeCenterPanel, BorderLayout.CENTER);

	}
	
	private void initEmployeeTopPanel() {
		employeeTopPanel = new JPanel();
		
		FlowLayout layout = new FlowLayout();
		employeeTopPanel.setLayout(layout);
		
		employeeTopPanel.add(new JLabel("Sorted by"));
		initSortByAttribute();
		initAscendDescendRB();
		initDisplayButton();
	}
	
	private void initSortByAttribute() {
		String[] employeeAttributeOptions = { "ID", "First Name", "Last Name", "Gender", "DOB", "Position", "Employee Type" };
		
		sortByCB = new JComboBox<String>(employeeAttributeOptions);
		employeeTopPanel.add(sortByCB);
	}
	
	private void initAscendDescendRB() {
		ascendingRB = new JRadioButton("ascending");
		descendingRB = new JRadioButton("descending");
		
		ButtonGroup orderBG = new ButtonGroup();
		orderBG.add(ascendingRB);
		orderBG.add(descendingRB);
		
		orderPanel = new JPanel();
		orderPanel.add(ascendingRB);
		orderPanel.add(descendingRB);
		
		ascendingRB.setSelected(true);
		
		employeeTopPanel.add(orderPanel);
	}
	
	private void initDisplayButton() {
		displayButton = new JButton("Display");
		
		employeeTopPanel.add(displayButton);
	}
	
	private void initEmployeeCenterPanel() {
		employeeCenterPanel = new JPanel();
		Font font = new Font("Courier", Font.PLAIN, 12);
		
		employeeTextArea = new JTextArea(20, 70);
		employeeTextArea.setEditable(false);
		employeeTextArea.setFont(font);
		employeeTextArea.append(employeeSystem.getHeader());
		employeeTextArea.append(employeeSystem.getInfo());
		employeeCenterPanel.add(employeeTextArea);
		
		scroll = new JScrollPane(employeeTextArea);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		employeeCenterPanel.add(scroll);
	}
	
	private void initDisplayButtonHandler() {
		displayButton.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {

						String sortByString = (String) sortByCB.getSelectedItem();
						
						if(ascendingRB.isSelected() && sortByString.equals("First Name")) {
							employeeSystem.sortEmployeesFirstName();
							employeeTextArea.setText("");
							employeeTextArea.append(employeeSystem.getHeader());
							employeeTextArea.append(employeeSystem.getInfo());
						}
						
						if(ascendingRB.isSelected() && sortByString.equals("Last Name")) {
							employeeSystem.sortEmployeesLastName();
							employeeTextArea.setText("");
							employeeTextArea.append(employeeSystem.getHeader());
							employeeTextArea.append(employeeSystem.getInfo());
						}
						
						if(ascendingRB.isSelected() && sortByString.equals("DOB")) {
							employeeSystem.sortEmployeesDOB();
							employeeTextArea.setText("");
							employeeTextArea.append(employeeSystem.getHeader());
							employeeTextArea.append(employeeSystem.getInfo());
						}
						
						if(ascendingRB.isSelected() && sortByString.equals("ID")) {
							employeeSystem.sortEmployeesID();
							employeeTextArea.setText("");
							employeeTextArea.append(employeeSystem.getHeader());
							employeeTextArea.append(employeeSystem.getInfo());
						}
						
						if(ascendingRB.isSelected() && sortByString.equals("Position")) {
							employeeSystem.sortEmployeesPosition();
							employeeTextArea.setText("");
							employeeTextArea.append(employeeSystem.getHeader());
							employeeTextArea.append(employeeSystem.getInfo());
						}
						
						if(ascendingRB.isSelected() && sortByString.equals("Employee Type")) {
							employeeSystem.sortEmployeesEmployeeType();
							employeeTextArea.setText("");
							employeeTextArea.append(employeeSystem.getHeader());
							employeeTextArea.append(employeeSystem.getInfo());
						}
						
						if(ascendingRB.isSelected() && sortByString.equals("Gender")) {
							employeeSystem.sortEmployeesGender();
							employeeTextArea.setText("");
							employeeTextArea.append(employeeSystem.getHeader());
							employeeTextArea.append(employeeSystem.getInfo());
						}
						
						if(descendingRB.isSelected() && sortByString.equals("First Name")) {
							employeeSystem.sortEmployeesFirstNameDescend();
							employeeTextArea.setText("");
							employeeTextArea.append(employeeSystem.getHeader());
							employeeTextArea.append(employeeSystem.getInfo());
						}
						
						if(descendingRB.isSelected() && sortByString.equals("Last Name")) {
							employeeSystem.sortEmployeesLastNameDescend();
							employeeTextArea.setText("");
							employeeTextArea.append(employeeSystem.getHeader());
							employeeTextArea.append(employeeSystem.getInfo());
						}
						
						if(descendingRB.isSelected() && sortByString.equals("DOB")) {
							employeeSystem.sortEmployeesDOBDescend();
							employeeTextArea.setText("");
							employeeTextArea.append(employeeSystem.getHeader());
							employeeTextArea.append(employeeSystem.getInfo());
						}
						
						if(descendingRB.isSelected() && sortByString.equals("ID")) {
							employeeSystem.sortEmployeesIDDescend();
							employeeTextArea.setText("");
							employeeTextArea.append(employeeSystem.getHeader());
							employeeTextArea.append(employeeSystem.getInfo());
						}
						
						if(descendingRB.isSelected() && sortByString.equals("Position")) {
							employeeSystem.sortEmployeesPositionDescend();
							employeeTextArea.setText("");
							employeeTextArea.append(employeeSystem.getHeader());
							employeeTextArea.append(employeeSystem.getInfo());
						}
						
						if(descendingRB.isSelected() && sortByString.equals("Employee Type")) {
							employeeSystem.sortEmployeesEmployeeTypeDescend();
							employeeTextArea.setText("");
							employeeTextArea.append(employeeSystem.getHeader());
							employeeTextArea.append(employeeSystem.getInfo());
						}
						
						if(descendingRB.isSelected() && sortByString.equals("Gender")) {
							employeeSystem.sortEmployeesGenderDescend();
							employeeTextArea.setText("");
							employeeTextArea.append(employeeSystem.getHeader());
							employeeTextArea.append(employeeSystem.getInfo());
						}
		
					}
				}
			);
		}
	}
