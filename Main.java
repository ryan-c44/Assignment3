import javax.swing.JFrame;

public class Main {
	
	public static void main(String[] args) {
		UserManagement um = new UserManagement();
		EmployeeSystem employeeSystem = new EmployeeSystem();
		
		employeeSystem.readCsv("C://Users//New//Desktop//A3.txt");
		employeeSystem.displayEmployees();
	
		EmployeeJFrame ejf = new EmployeeJFrame();
		ejf.setEmployeeSystem(employeeSystem);
		
		ejf.setTitle("Employee Management System");
		ejf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ejf.pack();
		ejf.setVisible(true);

	}

}
