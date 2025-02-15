import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class UserManagement {
	
	private EmployeeSystem employeeSystem;
	private ArrayList<Employee> employees = new ArrayList<Employee>();
	
	
	public Employee parseCsv(String csvString) {
		DateTimeFormatter dobFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String parts[] = csvString.split(",");
	
		String employeeID = parts[0];
		String firstName = parts[3];
		String lastName = parts[4];
		LocalDate dob = LocalDate.parse(parts[6], dobFormat);
		Gender gender = Gender.valueOf(parts[5]);
		String position = parts[2];
		EmployeeType employeeType = EmployeeType.valueOf(parts[1]);
	 
		Employee employee = new Employee(employeeID, employeeType, firstName, lastName, dob, gender, position);
		return employee;
	}
	
	public boolean isCsvValid(String csvString) {
		DateTimeFormatter dobFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		String parts[] = csvString.split(",");
		
		if(parts.length != 7) {
			return false;
		}
		
		for(String s : parts) {
			if(s.trim().isEmpty()) {
				return false;
			}
		}
		
		if(!parts[5].equals("M") && !parts[5].equals("F")) {
			return false;
		}
		
		try {
			LocalDate dob = LocalDate.parse(parts[6], dobFormat);
		} catch(Exception e) {
			return false;
		}
		
		return true;
	}
	
	public void readCsv(String filename) {
		try {
			File file = new File(filename);
			
			if(file.exists()) {
				FileReader fr = new FileReader(filename);
				BufferedReader reader = new BufferedReader(fr);
		
				String header = reader.readLine();
				System.out.println(header);
				
				while(true) {
					String csvString = reader.readLine();
					if(csvString == null) {
						reader.close();
						break;
					}
					if(isCsvValid(csvString)) {
						Employee employee = parseCsv(csvString);
						employees.add(employee);
						employeeSystem.addEmployee(employee);
					}
				}
			}
		}catch(Exception exception) {
			exception.printStackTrace();
		}
	}
	
	public void displayEmployees() {
		for(Employee employee : employees) {
			System.out.println(employee.toString());
		}
	}
	
}
