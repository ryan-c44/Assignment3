import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.*;
public class EmployeeSystem {
	
	private ArrayList<Employee> employees = new ArrayList<Employee>();
	
	public void addEmployee(Employee e) {
		employees.add(e);
	}
	
	public void updateEmployee(String id, String firstName, String lastName, LocalDate dob, Gender gender, String position, EmployeeType employeeType) {
		Employee oldEmployee = findEmployeeById(id);
		
		if(firstName != null && !firstName.equals(oldEmployee.getFirstName())) {
			oldEmployee.setFirstName(firstName);
		}
		
		if(lastName != null && !lastName.equals(oldEmployee.getLastName())) {
			oldEmployee.setLastName(lastName);
		}
		
		if(gender != null && !gender.equals(oldEmployee.getGender())) {
			oldEmployee.setGender(gender);
		}
		
		if(position != null && !position.equals(oldEmployee.getPosition())) {
			oldEmployee.setPosition(position);
		}
		
		if(dob != null && !dob.equals(oldEmployee.getDob())) {
			oldEmployee.setDob(dob);
		}
		
		if(employeeType != null && !employeeType.equals(oldEmployee.getEmployeeType())) {
			oldEmployee.setEmployeeType(employeeType);
 		}
	}

	public Employee findEmployeeById(String id) {
		for(Employee employee : employees) {
			if(employee.getEmployeeID().equals(id)) {
				return employee;
			}
		}
		return null;
	}
	
	public String csvString(Employee e) {
		DateTimeFormatter dobFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String csv = e.getEmployeeID() + "," + e.getEmployeeType() + "," + e.getPosition() + "," + e.getFirstName() + "," + e.getLastName() + "," + e.getGender() + "," + e.getDob().format(dobFormat);
		return csv;
	} 
	
	public void writeCsv(String filename) {
		try {
			FileWriter fw = new FileWriter(filename);
			BufferedWriter writer = new BufferedWriter(fw);
			
			for(Employee employee : employees) {
				writer.write(csvString(employee));
				writer.newLine();
			}
			
			writer.close();
		}catch(IOException exception) {
			exception.printStackTrace();
		}
	}
	
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
		
		System.out.println("Total Employees: " + employees.size());
	}
	
	public String getHeader() {
		StringFormatter sf = (new StringFormatter())
				                .add(0, StringFormatter.Alignment.L, 25)
				                .add(1, StringFormatter.Alignment.L, 25)
				                .add(2, StringFormatter.Alignment.L, 25)
				                .add(3, StringFormatter.Alignment.L, 25)
				                .add(4, StringFormatter.Alignment.L, 25)
				                .add(5, StringFormatter.Alignment.L, 25)
				                .add(6, StringFormatter.Alignment.L, 25);
		
		String header = sf.format("ID", "First Name", "Last Name", "Gender", "DOB", "Position", "Employee Type");
		return header;
	}
	
	public String getInfo() {
		StringFormatter sf = (new StringFormatter())
                .add(0, StringFormatter.Alignment.L, 25)
                .add(1, StringFormatter.Alignment.L, 25)
                .add(2, StringFormatter.Alignment.L, 25)
                .add(3, StringFormatter.Alignment.L, 25)
                .add(4, StringFormatter.Alignment.L, 25)
                .add(5, StringFormatter.Alignment.L, 25)
                .add(6, StringFormatter.Alignment.L, 25);
		
		String info = "";
		
		for(Employee employee : employees) {
			info += sf.format(employee.getEmployeeID(), employee.getFirstName(), employee.getLastName(), employee.getGender().name(), employee.getDob().toString(), employee.getPosition(), employee.getEmployeeType().name());
		}
		return info;
	}
	
}
