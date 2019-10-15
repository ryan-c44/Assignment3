import javax.swing.JFrame;

public class Main {
	
	public static void main(String[] args) {
		EmployeeSystem employeeSystem = new EmployeeSystem();
		
		employeeSystem.readCsv("/Users/ryancastles/Desktop/A3.txt");
		employeeSystem.displayEmployees();
	
		EmployeeJFrame ejf = new EmployeeJFrame();
		ejf.setEmployeeSystem(employeeSystem);
		
		ejf.setTitle("Employee Management System");
		ejf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ejf.pack();
		ejf.setVisible(true);
		
		 
		EmployeeListJFrame listFrame = new EmployeeListJFrame(employeeSystem);
		listFrame.setTitle("Employee List");
		listFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		listFrame.pack();
		listFrame.setVisible(true);
		
	}

}
