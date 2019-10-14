import javax.swing.*;
import java.awt.*;

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
	
	public EmployeeListJFrame() {
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
	
	private void initEventHandler() {
		
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
		
		employeeTopPanel.add(orderPanel);
	}
	
	private void initDisplayButton() {
		displayButton = new JButton("Display");
		
		employeeTopPanel.add(displayButton);
	}
	
	private void initEmployeeCenterPanel() {
		employeeCenterPanel = new JPanel();
		EmployeeSystem es = new EmployeeSystem();
		Font font = new Font("Sans Serif", Font.PLAIN, 12);
		
		employeeTextArea = new JTextArea();
		employeeTextArea.setEditable(false);
		employeeTextArea.setFont(font);
		employeeTextArea.append(es.getHeader());
		employeeTextArea.append(es.getInfo());
		employeeCenterPanel.add(employeeTextArea);
		
		scroll = new JScrollPane(employeeTextArea);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		
		employeeCenterPanel.add(scroll);
	}
	

}
